package ru.ageev.nanopost.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.ageev.nanopost.data.repository.ImageRepository
import ru.ageev.nanopost.data.repository.ImageRepositoryImpl
import ru.ageev.nanopost.data.repository.PostRepository
import ru.ageev.nanopost.data.repository.PostRepositoryImpl
import ru.ageev.nanopost.data.repository.ProfileRepository
import ru.ageev.nanopost.data.repository.ProfileRepositoryImpl
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

    @Binds
    @Singleton
    abstract fun bindImageRepository(impl: ImageRepositoryImpl): ImageRepository
}