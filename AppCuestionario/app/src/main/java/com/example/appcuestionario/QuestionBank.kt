package com.example.appcuestionario

object QuestionBank {
    fun getQuestions(): ArrayList<Question> {
        return arrayListOf(
            Question(
                "¿Cuál es el lenguaje base para Android Studio?",
                listOf("Java", "Kotlin", "Swift", "Python"),
                1 // Kotlin (segunda opción)
            ),
            Question(
                "¿Android Studio es un IDE?",
                listOf("Sí", "No", "A veces", "Solo para Java"),
                0 // Sí (primera opción)
            ),
            Question(
                "¿Qué archivo define la interfaz de usuario en Android?",
                listOf("MainActivity.kt", "AndroidManifest.xml", "activity_main.xml", "build.gradle"),
                2 // activity_main.xml (tercera opción)
            ),
            Question(
                "¿Cuál es la función de un Intent en Android?",
                listOf("Diseñar interfaces", "Gestionar actividades", "Navegar entre pantallas", "Guardar datos"),
                2 // Navegar entre pantallas (tercera opción)
            ),
            Question(
                "¿Qué método se llama al iniciar una actividad?",
                listOf("onPause()", "onCreate()", "onStop()", "onDestroy()"),
                1 // onCreate() (segunda opción)
            ),
            Question(
                "¿Qué componente se usa para mostrar listas en Android?",
                listOf("RecyclerView", "Button", "TextView", "ConstraintLayout"),
                0 // RecyclerView (primera opción)
            ),
            Question(
                "¿Qué lenguaje NO se usa comúnmente para desarrollo Android?",
                listOf("Java", "Kotlin", "Swift", "C++"),
                2 // Swift (tercera opción)
            ),
            Question(
                "¿Cuál es el archivo donde se definen los permisos de la app?",
                listOf("build.gradle", "AndroidManifest.xml", "proguard-rules.pro", "strings.xml"),
                1 // AndroidManifest.xml (segunda opción)
            ),
            Question(
                "¿Qué es un Fragment en Android?",
                listOf("Una pequeña parte de la UI", "Un tipo de Activity", "Un recurso XML", "Un servicio de fondo"),
                0 // Una pequeña parte de la UI (primera opción)
            ),
            Question(
                "¿Qué significa APK?",
                listOf("Android Package Kit", "Application Programming Kit", "Android Program Kernel", "App Package Key"),
                0 // Android Package Kit (primera opción)
            ),
            Question(
                "¿Qué patrón de diseño es común en Android para separar lógica y UI?",
                listOf("MVC", "MVVM", "Singleton", "Observer"),
                1 // MVVM (segunda opción)
            ),
            Question(
                "¿Cómo se llama el archivo donde defines las dependencias del proyecto?",
                listOf("settings.gradle", "build.gradle", "AndroidManifest.xml", "gradle.properties"),
                1 // build.gradle (segunda opción)
            ),
            Question(
                "¿Qué clase se utiliza para lanzar una nueva actividad?",
                listOf("Intent", "ActivityManager", "Bundle", "View"),
                0 // Intent (primera opción)
            ),
            Question(
                "¿Qué método se usa para guardar datos en SharedPreferences?",
                listOf("putString()", "saveData()", "write()", "setStringValue()"),
                0 // putString() (primera opción)
            ),
            Question(
                "¿Qué función tiene el método onResume() en un Activity?",
                listOf("Se llama cuando la actividad se destruye", "Se llama cuando la actividad vuelve a estar visible", "Se llama al iniciar la aplicación", "Se llama al pausar la actividad"),
                1 // Se llama cuando la actividad vuelve a estar visible (segunda opción)
            ),
            Question(
                "¿Cuál es la función del ConstraintLayout?",
                listOf("Gestionar recursos", "Crear layouts flexibles y responsivos", "Mostrar texto", "Controlar la navegación"),
                1 // Crear layouts flexibles y responsivos (segunda opción)
            ),
            Question(
                "¿Qué hace el método findViewById()?",
                listOf("Buscar un recurso en la web", "Obtener referencia a un elemento UI", "Crear un nuevo botón", "Lanzar una nueva actividad"),
                1 // Obtener referencia a un elemento UI (segunda opción)
            ),
            Question(
                "¿Cuál es el límite máximo de tamaño para un APK en Google Play?",
                listOf("100 MB", "50 MB", "150 MB", "200 MB"),
                0 // 100 MB (primera opción)
            ),
            Question(
                "¿Qué es un Service en Android?",
                listOf("Una interfaz de usuario", "Un componente que realiza tareas en segundo plano", "Un tipo de Activity", "Un recurso XML"),
                1 // Un componente que realiza tareas en segundo plano (segunda opción)
            ),
            Question(
                "¿Qué herramienta permite la depuración remota de apps Android?",
                listOf("ADB", "SQLite", "Git", "Gradle"),
                0 // ADB (primera opción)
            )
        )
    }
}
