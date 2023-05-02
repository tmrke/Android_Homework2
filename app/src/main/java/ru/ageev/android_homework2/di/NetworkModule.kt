package ru.ageev.android_homework2.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.get
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttp
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
        annotation class AuthClient

        @Provides
        @Singleton
        @AuthClient
        fun provideAuthRetrofit(                //иконка показывает, что этот метод куда то инжектится
            httpClient: OkHttpClient,      // показывает, что сюда что то инжектится
            json: Converter.Factory
        ): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(httpClient)
                .addConverterFactory(json)
                .build()
        }

        // TODO  Json { ignoreUnknownKeys = true } ошибка с imagesCount, если не добавить

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
                request.addHeader(
                    "Authorization",
                    "Bearer ${prefsStorage.token}"
                )
                chain.proceed(request.build())
            }
        }

        @Provides
        @Singleton
        fun provideHttpClient(
            authInterceptor: Interceptor
        ): OkHttpClient {
            return OkHttpClient()
                .newBuilder()
                .addInterceptor(authInterceptor)
                .build()
        }

        @Provides
        @Singleton
        fun provideRetrofit(                //иконка показывает, что этот метод куда то инжектится
            json: Converter.Factory
        ): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(json)
                .build()
        }
    }
}