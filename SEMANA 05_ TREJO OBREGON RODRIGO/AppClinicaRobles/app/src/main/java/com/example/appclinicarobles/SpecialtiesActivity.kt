package com.example.appclinicarobles


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appclinicarobles.adapter.SpecialtyAdapter
import com.example.appclinicarobles.databinding.ActivitySpecialtiesBinding
import com.example.appclinicarobles.model.Specialty

class SpecialtiesActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySpecialtiesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySpecialtiesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nombrePaciente = intent.getStringExtra("nombrePaciente")
        title = "Bienvenido, $nombrePaciente"

        val specialties = listOf(
            Specialty("Traumatología", "Dr. Alberto García Cerna\nDr. Cruz Medina Martínez", "8:00 AM - 4:00 PM", R.drawable.ic_specialty_trauma),
            Specialty("Cardiología", "Dr. Roberto Chavesta Bernal", "9:00 AM - 1:00 PM", R.drawable.ic_specialty_cardio),
            Specialty("Cirugía Cardiovascular", "Dr. Romel Zamudio Silva", "10:00 AM - 2:00 PM", R.drawable.ic_specialty_cardiovascular),
            Specialty("Cirugía General", "Dr. Beto Miranda Sevillano\nDr. Pool Jara Pesantes", "8:00 AM - 3:00 PM", R.drawable.ic_specialty_cirugia),
            Specialty("Dermatología", "Dr. Jaime Vega Chávez\nDr. Italo Vegas Jaramillo", "9:00 AM - 5:00 PM", R.drawable.ic_specialty_derma),
            Specialty("Endocrinología", "Dr. Juan Pinto Sánchez", "7:00 AM - 12:00 PM", R.drawable.ic_specialty_endo),
            Specialty("Gastroenterología", "Dra. Kelly Casanova Lau", "10:00 AM - 4:00 PM", R.drawable.ic_specialty_gastro),
            Specialty("Ginecología", "Dr. José Luis Espinoza Decena\nDra. Yulissa Paredes Padilla", "8:30 AM - 1:30 PM", R.drawable.ic_specialty_gine),
            Specialty("Medicina Física", "Dr. Luis Vásquez", "8:00 AM - 12:00 PM", R.drawable.ic_specialty_medicinafisica),
            Specialty("Medicina General", "Dr. Elwis Laveriano Hoyos\nDra. María Cristina Saavedra", "8:00 AM - 6:00 PM", R.drawable.ic_specialty_general),
            Specialty("Medicina Interna", "Dr. Luis Cabrera Cipirán\nDra. Rosa Casimiro Lau", "9:00 AM - 3:00 PM", R.drawable.ic_specialty_interna),
            Specialty("Neumología", "Dra. Yessica Montoya Caldas\nDr. Walter Centurión Jaramillo", "10:00 AM - 4:00 PM", R.drawable.ic_specialty_neumo),
            Specialty("Neurocirugía", "Dr. Willy Caballero Grados", "11:00 AM - 2:00 PM", R.drawable.ic_specialty_neurocirugia),
            Specialty("Neurología", "Dr. Rosnel Valdivieso Velarde", "9:30 AM - 1:30 PM", R.drawable.ic_specialty_neuro),
            Specialty("Nutrición", "Lic. Carmela Carbajal", "8:00 AM - 2:00 PM", R.drawable.ic_specialty_nutri),
            Specialty("Odontología", "Dr. Pedro Cipriano Alegre\nDra. Carolina Acuña Calderón", "10:00 AM - 6:00 PM", R.drawable.ic_specialty_odon),
            Specialty("Cirugía Maxilofacial", "Dr. Julio Robles Zanelli", "9:00 AM - 1:00 PM", R.drawable.ic_specialty_maxilo),
            Specialty("Otorrino", "Dr. Jorge Bonilla Vargas", "8:00 AM - 3:00 PM", R.drawable.ic_specialty_endo),
            Specialty("Oftalmología", "Dra. Anita Vico Arroyo", "10:00 AM - 2:00 PM", R.drawable.ic_specialty_oftalmo),
            Specialty("Pediatría", "Dr. Marcos Vásquez Tantas\nDr. Jaime Cabrera Pereda", "9:00 AM - 6:00 PM", R.drawable.ic_specialty_pedia),
            Specialty("Psicología", "Lic. Astrid Manrique Marrón\nLic. Luz Vásquez Burgos", "8:30 AM - 5:00 PM", R.drawable.ic_specialty_psico),
            Specialty("Psiquiatría", "Dra. Celmira Lázaro Loyola", "8:00 AM - 12:00 PM", R.drawable.ic_specialty_psiqui),
            Specialty("Reumatología", "Dr. Frank Ocaña Vásquez", "9:00 AM - 1:00 PM", R.drawable.ic_specialty_reuma),
            Specialty("Urología", "Dr. Carlos Morales Flores\nDr. Luis Pascual Plasencia", "10:00 AM - 3:00 PM", R.drawable.ic_specialty_uro)
        )


        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = SpecialtyAdapter(specialties) { specialty ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("specialty", specialty)
            startActivity(intent)
        }
    }
}
