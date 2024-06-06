# AnimalApi

## Descripción

AnimalApi es una aplicación Android desarrollada en Kotlin que permite a los usuarios explorar información sobre diferentes animales. La aplicación obtiene datos de una API y presenta esta información de manera estructurada y visualmente atractiva. Los usuarios pueden buscar animales específicos y ver detalles como su hábitat, dieta, características, y más.

## Características

- Búsqueda de animales por nombre.
- Visualización de detalles específicos de cada animal.
- Interfaz de usuario amigable y responsiva.
- Integración con una API externa para la obtención de datos.

## Instalación

### Prerrequisitos

Antes de comenzar, asegúrate de tener instalados los siguientes programas en tu sistema:

- [Android Studio](https://developer.android.com/studio)
- [JDK 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)

### Instrucciones

1. Clona este repositorio en tu máquina local:

   ```bash
   git clone https://github.com/tu_usuario/AnimalApi.git
   ```

2. Abre Android Studio y selecciona "Open an existing project". Navega hasta el directorio donde clonaste el repositorio y selecciónalo.

3. Android Studio debería descargar automáticamente todas las dependencias necesarias. Si no es así, sincroniza el proyecto con Gradle manualmente desde el menú "File" -> "Sync Project with Gradle Files".

4. Conecta tu dispositivo Android al ordenador o utiliza un emulador de Android configurado.

5. Ejecuta la aplicación haciendo clic en el botón "Run" (el ícono de reproducción) en Android Studio.

## Uso

Una vez instalada la aplicación, puedes:

1. Abrir la aplicación desde tu dispositivo Android.
2. Utilizar la barra de búsqueda para encontrar información sobre animales específicos.
3. Explorar la información detallada de cada animal haciendo clic en los resultados de la búsqueda.

## Despliegue en la Play Store

### Prerrequisitos

- Cuenta de desarrollador en Google Play ([Regístrate aquí](https://play.google.com/apps/publish/signup/)).

### Instrucciones

1. **Generar un APK firmado**:

   - Abre tu proyecto en Android Studio.
   - Ve a "Build" -> "Generate Signed Bundle / APK".
   - Selecciona "APK" y haz clic en "Next".
   - Crea una nueva clave (o selecciona una existente) y llena los campos necesarios.
   - Elige "release" como variante de compilación y haz clic en "Finish".

2. **Subir el APK a la Play Store**:

   - Inicia sesión en tu [Consola de Google Play](https://play.google.com/apps/publish/).
   - Crea una nueva aplicación y proporciona la información requerida (nombre de la aplicación, descripción, capturas de pantalla, etc.).
   - En la sección "Release management" -> "App releases", selecciona "Manage production" -> "Create release".
   - Sube el APK firmado que generaste previamente.
   - Revisa y completa los formularios de contenido y cumplimiento.
   - Envía la aplicación para revisión.
