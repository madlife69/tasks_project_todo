package com.example.tasks_project.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@Database(entities = [Task::class], version = 1)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
    class Callback @Inject constructor(
        private val database: Provider<TaskDatabase>,
         private val applicationScope: CoroutineScope

    ) : RoomDatabase.Callback(){
        override fun onCreate(db: SupportSQLiteDatabase){
            super.onCreate(db)

            val dao = database.get().taskDao()
            applicationScope.launch {
                dao.insert("wash the dishes")
                dao.insert("clean your room")
                dao.insert("clean your room")
                dao.insert("clean your room")
                dao.insert("clean your room")

            }



        }
    }


}