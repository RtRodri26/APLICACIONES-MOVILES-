package com.example.recetasexpress

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu

class CategoriesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)

        val categoriesButton = findViewById<android.widget.Button>(R.id.categories_button)
        categoriesButton.setOnClickListener {
            showPopupMenu(it)
        }
    }

    private fun showPopupMenu(view: android.view.View) {
        val popupMenu = PopupMenu(this, view)
        menuInflater.inflate(R.menu.menu_categories, popupMenu.menu)
        popupMenu.show()
    }
}
