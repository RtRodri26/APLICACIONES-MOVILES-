
# 📱 **Aplicación de Inicio de Sesión y Registro** 

Una aplicación sencilla para autenticación de usuarios, permitiendo que se registren, inicien sesión y accedan a una pantalla principal protegida.

## 📝 **Descripción**

### 1. **Inicio de sesión**
- Los usuarios pueden autenticarse usando su **correo electrónico** y **contraseña**.
- El estado del usuario se observa mediante **LiveData** y se maneja con un **ViewModel** para separar la lógica de la vista.
- Si el usuario ya está registrado, accede directamente a la **pantalla principal**. 

### 2. **Registro**
- Ofrece un formulario donde el usuario puede ingresar:
  - **Nombre**
  - **Correo electrónico**
  - **Contraseña**
- El formulario valida los datos antes de permitir el registro.
- Al registrarse, los datos del usuario (nombre y correo) se almacenan en **Firebase Firestore** y el usuario puede iniciar sesión de inmediato.
- Tras iniciar sesión correctamente, el usuario es dirigido a la **actividad principal**, donde se muestra su nombre y un mensaje de bienvenida.
- Esta pantalla también ofrece la opción de **cerrar sesión**.
- El acceso a esta pantalla está restringido solo a **usuarios autenticados**.

### 3. **Actualización en Firebase**
- Cuando un usuario se registra, sus datos como **nombre** y **correo** se almacenan automáticamente en **Firebase Authentication**.
- También se actualizan en **Firebase Firestore**, asegurando que la información del usuario esté disponible para futuras interacciones.

---

## ⚙️ **Tecnologías Usadas**
- **Kotlin**: Lenguaje de programación para la lógica de la app.
- **Firebase**:
  - **Firebase Authentication** para manejar el inicio de sesión y registro de usuarios.
  - **Firebase Firestore** para almacenar los datos del usuario.
- **LiveData** y **ViewModel** para la gestión del ciclo de vida y la separación de la lógica de la UI.
- **Android Studio** como entorno de desarrollo.

---

## 🚀 **Instrucciones de Uso**

1. **Clona el repositorio**:
   ```bash
   git clone https://github.com/tu-usuario/loginapp.git
   ```

2. **Configura Firebase**:
   - Ve a la [consola de Firebase](https://console.firebase.google.com/).
   - Crea un nuevo proyecto y agrega tu aplicación Android.
   - Descarga el archivo `google-services.json` y agrégalo a tu proyecto en `app/`.

3. **Agrega las dependencias de Firebase**:
   - Asegúrate de agregar las dependencias necesarias en el archivo `build.gradle` de tu módulo.

4. **Ejecuta la aplicación**:
   - Conecta tu dispositivo Android o usa un emulador.
   - Ejecuta la aplicación desde Android Studio.

---

## 🔐 **Seguridad**
- Los datos de los usuarios están protegidos y se gestionan a través de **Firebase Authentication**, que garantiza que solo los usuarios autenticados accedan a las funciones protegidas.

---

## 📸 **Pantallas de la Aplicación**

### Pantalla de **Inicio de Sesión**:
![Pantalla de inicio de sesión](file-SwbrYzCQ8ubeSkKscBTRwx.png)

### Pantalla de **Registro**:
![Pantalla de registro](file-3r6RF2Kvwj9BYGkiECdLCc.png)

### Pantalla de **Bienvenida**:
![Pantalla de bienvenida](file-U3umV18P8pe5i3eZhKwEvu.png)

### Pantalla de **Cierre de sesión**:
![Pantalla de cierre de sesión](file-KnXjo1fNeu4AqST6GE4a3D.png)

---

## 📣 **Contribuciones**
Si deseas contribuir a este proyecto, por favor sigue los siguientes pasos:

1. **Fork** este repositorio.
2. Crea una nueva rama (`git checkout -b feature/nueva-funcionalidad`).
3. Realiza tus cambios y haz **commit** (`git commit -am 'Agrega nueva funcionalidad'`).
4. Haz **push** a la rama (`git push origin feature/nueva-funcionalidad`).
5. Abre un **pull request**.

---

## 📝 **Licencia**
Este proyecto está bajo la licencia MIT. Para más detalles, consulta el archivo `LICENSE`.
