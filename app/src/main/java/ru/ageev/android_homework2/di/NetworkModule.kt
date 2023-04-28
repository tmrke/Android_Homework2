package ru.ageev.android_homework2.di

import android.provider.MediaStore.Audio.Media
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.create
import ru.ageev.android_homework2.data.remote.NanopostApiService
import ru.ageev.android_homework2.data.remote.repository.ProfileRepository
import ru.ageev.android_homework2.data.remote.repository.ProfileRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkModule {

    companion object {
        private const val BASE_URL = "https://nanopost.evolitist.com/"
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        val json = Json{ignoreUnknownKeys = true}
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
    }

    @Provides
    @Singleton
    fun provideNanopostApiService(retrofit: Retrofit): NanopostApiService {
        return retrofit.create()
    }

}