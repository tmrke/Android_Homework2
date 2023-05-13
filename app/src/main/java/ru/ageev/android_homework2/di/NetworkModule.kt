package ru.ageev.android_homework2.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.create
import ru.ageev.android_homework2.data.PrefsStorage
import ru.ageev.android_homework2.data.remote.NanopostApiService
import ru.ageev.android_homework2.data.remote.NanopostAuthApiService
import javax.inject.Qualifier

import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkModule {

    companion object {
        private const val BASE_URL = "https://nanopost.evolitist.com/"

        @Qualifier
        annotation class AuthClient     // создание своего маркера/аннотации

        @Provides                       // запрос на авторизацию
        @Singleton
        @AuthClient
        fun provideAuthRetrofit(
            httpClient: OkHttpClient,
            json: Converter.Factory
        ): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(httpClient)
                .addConverterFactory(json)
                .build()
        }


        @Provides
        fun provideJsonConvertor(): Converter.Factory {
            return Json {
                ignoreUnknownKeys = true
            }.asConverterFactory("application/json".toMediaType())
        }

        @Singleton
        @Provides
        fun provideNanopostAuthApiService(
            @AuthClient retrofit: Retrofit
        ): NanopostAuthApiService {
            return retrofit.create()
        }

        @Provides
        @Singleton
        fun provideNanopostApiService(
            retrofit: Retrofit
        ): NanopostApiService {
            return retrofit.create()
        }


        @Provides
        @Singleton
        fun provideAuthInterceptor(     //Редактор запросов. После формирования запроса, Interceptor добавляет к нему заголовки например
            prefsStorage: PrefsStorage
        ): Interceptor {
            return Interceptor { chain ->
                val request = chain.request().newBuilder()
                prefsStorage.token?.let { token ->
                    request.addHeader(              //TODO проверить токен
                        "Authorization",
                        "Bearer ${prefsStorage.token}"
                    )
                }

                chain.proceed(request.build())
            }
        }


        @Provides
        @Singleton
        fun provideHttpClient(
            authInterceptor: Interceptor,
            @ApplicationContext context: Context,
        ): OkHttpClient {
            return OkHttpClient()
                .newBuilder()
                .addInterceptor(authInterceptor)
                .addInterceptor(ChuckerInterceptor(context))
                .build()
        }

        @Provides
        @Singleton
        fun provideRetrofit(
            json: Converter.Factory,
            @ApplicationContext context: Context,
        ): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(
                    OkHttpClient()
                        .newBuilder()
                        .addInterceptor(ChuckerInterceptor(context))
                        .build()
                )
                .addConverterFactory(json)
                .build()
        }
    }
}