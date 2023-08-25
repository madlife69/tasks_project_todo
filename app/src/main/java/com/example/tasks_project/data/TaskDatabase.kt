package com.example.tasks_project.data

import android.app.Application
import androidx.room.Database
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject
import javax.inject.Provider

@Database(entities = [Task::class], version = 1)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
    class Callback @Inject constructor(
        private val database: Provider<TaskDatabase>
            @ApplicationScope private val applicationScope: CoroutineScope

    ) : RoomDatabase.Callback(){
        override fun onCreate(db: SupportSQLiteDatabase){
            super.onCreate(db)

            val dao = database.get().taskDao()
            applicationScope.Launch{
                dao.insert(Task("wash the dishes"))
            }

        }
    }


}