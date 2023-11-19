package com.example.proyectoappsoscarescrib21474

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectoappsoscarescrib21474.databinding.ActivityPantalla1Binding
import com.google.android.material.bottomnavigation.BottomNavigationView

class Pantalla1 : AppCompatActivity() {
    private lateinit var binding: ActivityPantalla1Binding
    private lateinit var editTextTask: EditText
    private lateinit var btnAddTask: Button
    private lateinit var recyclerViewTasks: RecyclerView

    private lateinit var taskAdapter: TaskAdapter
    private var tasks = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPantalla1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Home())
        editTextTask = findViewById(R.id.editTextTask)
        btnAddTask = findViewById(R.id.btnAddTask)
        recyclerViewTasks = findViewById(R.id.recyclerViewTasks)
        //--------los eventos onclik para ir cambiando   entre cada una de las siguientes partes del menu------------
        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.Home -> replaceFragment(Home())
                R.id.calculadora ->replaceFragment(calculadora())
                R.id.mas -> replaceFragment(mas())
                else -> {
                }
            }
            true
        }
        //--------- Finaliza el metodo para cambiar los fragments----------------------------------
        taskAdapter = TaskAdapter(tasks) { position ->
            // Eliminar tarea al hacer clic en el botón de eliminar
            tasks.removeAt(position)
            taskAdapter.notifyDataSetChanged()

            // Actualizar el almacenamiento interno después de la eliminación
            FileManager.writeTasks(this, tasks)
        }
        recyclerViewTasks.layoutManager = LinearLayoutManager(this)
        recyclerViewTasks.adapter = taskAdapter
        // Cargar tareas almacenadas
        tasks.addAll(FileManager.readTasks(this))
        taskAdapter.notifyDataSetChanged()

        btnAddTask.setOnClickListener {
            val taskName = editTextTask.text.toString()
            if (taskName.isNotBlank()) {
                tasks.add(taskName)
                taskAdapter.notifyDataSetChanged()

                // Limpiar el EditText después de agregar una tarea
                editTextTask.text.clear()

                // Guardar tarea en el almacenamiento interno
                FileManager.writeTask(this, taskName)
            }
        }
    }
    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }
}