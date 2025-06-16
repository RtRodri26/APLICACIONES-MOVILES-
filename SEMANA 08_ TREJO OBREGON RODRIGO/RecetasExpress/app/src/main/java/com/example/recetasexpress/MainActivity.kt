package com.example.recetasexpress

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Toolbar
        setSupportActionBar(findViewById(R.id.toolbar))

        // RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = RecipeAdapter(getRecipes())
        recyclerView.adapter = adapter

        // Habilitar menú contextual en RecyclerView
        registerForContextMenu(recyclerView)

        // Botón para mostrar menú emergente
        val btnCategorias = findViewById<Button>(R.id.btnCategorias)
        btnCategorias.setOnClickListener {
            showPopupMenu(it)
        }
    }

    // Menú de opciones (AppBar)
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_filter -> {
                // Acción de filtrar
                true
            }
            R.id.action_add_recipe -> {
                startActivity(Intent(this, RecipeDetailActivity::class.java))
                true
            }
            R.id.action_settings -> {
                // Acción de configuración
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    // Simulador de recetas
    private fun getRecipes(): List<String> {
        return listOf("Receta 1", "Receta 2", "Receta 3")
    }

    // Crear menú contextual (pulsación larga)
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.menu_recipe_detail, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_save_favorite -> {
                // Guardar en favoritos
                true
            }
            R.id.action_share -> {
                // Compartir receta
                true
            }
            R.id.action_view_more -> {
                // Ver más
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }

    // Mostrar menú emergente (popup)
    private fun showPopupMenu(view: View) {
        val popupMenu = PopupMenu(this, view)
        popupMenu.menuInflater.inflate(R.menu.menu_categories, popupMenu.menu)
        popupMenu.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.action_desserts -> {
                    // Acción para postres
                    true
                }
                R.id.action_healthy -> {
                    // Acción para saludables
                    true
                }
                R.id.action_quick -> {
                    // Acción para rápidas
                    true
                }
                else -> false
            }
        }
        popupMenu.show()
    }
}
