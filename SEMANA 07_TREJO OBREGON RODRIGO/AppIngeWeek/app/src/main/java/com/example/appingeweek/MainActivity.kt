package com.example.appingeweek
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        menuInflater.inflate(R.menu.bottom_nav_menu, bottomNavigationView.menu)

        // Set default fragment
        if (savedInstanceState == null) {
            loadFragment(AgendaFragment())
        }
        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_agenda -> loadFragment(AgendaFragment())
                R.id.nav_competencia -> loadFragment(CompetenciaFragment())
                R.id.nav_seminarios -> loadFragment(SeminariosFragment())
                R.id.nav_ubicaciones -> loadFragment(UbicacionesFragment())
                else -> false
            }
        }
    }

    private fun loadFragment(fragment: Fragment): Boolean {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
        return true
    }
}
