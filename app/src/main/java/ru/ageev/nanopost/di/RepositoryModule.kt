package ru.ageev.nanopost.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.ageev.nanopost.domain.repository.ImageRepository
import ru.ageev.nanopost.domain.repository.ImageRepositoryImpl
import ru.ageev.nanopost.domain.repository.PostRepository
import ru.ageev.nanopost.domain.repository.PostRepositoryImpl
import ru.ageev.nanopost.domain.repository.ProfileRepository
import ru.ageev.nanopost.domain.repository.ProfileRepositoryImpl
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