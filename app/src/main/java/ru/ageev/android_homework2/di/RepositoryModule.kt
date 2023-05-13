package ru.ageev.android_homework2.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.ageev.android_homework2.data.remote.repository.PostRepository
import ru.ageev.android_homework2.data.remote.repository.PostRepositoryImpl
import ru.ageev.android_homework2.data.remote.repository.ProfileRepository
import ru.ageev.android_homework2.data.remote.repository.ProfileRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindProfileRepository(impl: ProfileRepositoryImpl): ProfileRepository

    @Binds
    @Singleton
    abstract fun bindPostRepository(impl: PostRepositoryImpl): PostRepository
}