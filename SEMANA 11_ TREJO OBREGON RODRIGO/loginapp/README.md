
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

---

## 🔐 **Seguridad**
- Los datos de los usuarios están protegidos y se gestionan a través de **Firebase Authentication**, que garantiza que solo los usuarios autenticados accedan a las funciones protegidas.

---

## 📸 **Pantallas de la Aplicación**

### Pantalla de **Inicio de Sesión**:

<img width="208" height="462" alt="Image" src="https://github.com/user-attachments/assets/653910a1-4c9a-47d2-90f7-656eccf0ce45" />

### Pantalla de **Registro**:
<img width="211" height="460" alt="Image" src="https://github.com/user-attachments/assets/0866f4e6-cd9c-478d-afa7-86ecf33c6099" />

### Pantalla de **Bienvenida y Cierre de sesión**:
<img width="203" height="461" alt="Image" src="https://github.com/user-attachments/assets/6a993d59-5997-4dfc-8603-23cc9254ceee" />

---


