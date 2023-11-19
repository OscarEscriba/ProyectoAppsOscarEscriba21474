package com.example.proyectoappsoscarescrib21474

// FileManager.kt
import android.content.Context
import java.io.FileNotFoundException

object FileManager {

    private const val FILE_NAME = "tasks.txt"

    fun writeTask(context: Context, task: String) {
        context.openFileOutput(FILE_NAME, Context.MODE_APPEND).use {
            it.write("$task\n".toByteArray())
        }
    }

    fun writeTasks(context: Context, tasks: List<String>) {
        context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE).use {
            for (task in tasks) {
                it.write("$task\n".toByteArray())
            }
        }
    }

    fun readTasks(context: Context): List<String> {
        return try {
            context.openFileInput(FILE_NAME).bufferedReader().readLines()
        } catch (e: FileNotFoundException) {
            emptyList()
        }
    }
}
