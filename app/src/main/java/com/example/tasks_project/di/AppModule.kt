package com.example.tasks_project.di

import android.app.Application
import android.content.pm.ApplicationInfo
import androidx.room.Room
import com.example.tasks_project.data.TaskDatabase
import com.google.android.datatransport.runtime.dagger.Component
import com.google.android.datatransport.runtime.dagger.Module
import com.google.android.datatransport.runtime.dagger.Provides
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Qualifier
import javax.inject.Singleton


@Module
@Component
object AppModule {
    @Provides
    @Singleton
    fun provideDatabase(
        app: Application,
        callback: TaskDatabase.Callback

    )= Room.databaseBuilder(app,TaskDatabase::class.java,"task_database")
        .fallbackToDestructiveMigration()
        .addCallback(callback)
        .build()
    @Provides
    fun provideTaskDao(db: TaskDatabase) = db.taskDao()

    @ApplicationScope
    @Provides
    @Singleton
    fun provideApplicationScope() = CoroutineScope(SupervisorJob())


    @Retention(AnnotationRetention.RUNTIME)
    @Qualifier
    annotation class ApplicationScope

}