package com.example.tasks_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.Component

@Component
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}