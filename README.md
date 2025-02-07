# **Plantilla para Proyectos MVVM con room y retrofit**

**Este repositorio contiene una plantilla para proyectos Android desarrollados en Kotlin utilizando la arquitectura MVVM (Model-View-ViewModel). El objetivo de esta plantilla es permitirte hacer un git clone y disponer de todo lo necesario para comenzar un proyecto Android completamente configurado, estructurado y listo para usar. Solo necesitarás personalizarlo según tus necesidades y comenzar a desarrollar**. 
A continuación, se describe la estructura del proyecto, la configuración y las dependencias utilizadas.

---

## **Estructura del Proyecto**

El proyecto sigue la arquitectura **MVVM** y está organizado de la siguiente manera:

```
app/
├── src/
│   ├── main/
│   │   ├── java/com/kodeleku/mvvm_movies/
│   │   │   ├── data/
│   │   │   │   ├── local/          # Room Database, DAOs, Entities
│   │   │   │   ├── remote/         # Retrofit API interfaces, servicios
│   │   │   │   ├── repository/     # Repositorios que combinan datos locales y remotos
│   │   │   ├── di/                 # Módulos de inyección de dependencias (Hilt/Dagger)
│   │   │   ├── model/              # Modelos de datos (API, Room, Dominio)
│   │   │   ├── ui/                 # Actividades, Fragmentos, ViewModels
│   │   │   │   ├── viewmodel/      # ViewModels
│   │   │   │   ├── views/          # Actividades y Fragmentos
│   │   │   │   ├── adapters/       # Adapters y ViewHolders para RecyclerView
│   │   │   ├── utils/              # Utilidades y extensiones
│   │   ├── res/                    # Recursos (layouts, drawables, strings, etc.)
│   │   ├── AndroidManifest.xml     # Configuración de la aplicación
├── build.gradle                    # Configuración del módulo app
```

---

## **Configuración del Proyecto**

### **build.gradle (Module: app)**

```java
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-parcelize") // Soporte para Parcelize
    id("com.google.devtools.ksp") // Soporte para KSP
    id("com.google.dagger.hilt.android") // Soporte para Hilt
    id("kotlin-kapt") // Soporte para kapt (necesario para Hilt)
}

android {
    namespace = "com.kodeleku.mvvm_movies"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.kodeleku.mvvm_movies"
        minSdk = 31
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    viewBinding {
        enable = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    implementation(libs.retrofit) // Retrofit para llamadas a la API
    implementation(libs.converter.gson) // Gson para parsear JSON
    implementation(libs.androidx.lifecycle.runtime.ktx) // Lifecycle + Coroutine support
    implementation(libs.androidx.lifecycle.viewmodel.ktx) // ViewModel con Coroutines
    implementation(libs.kotlinx.coroutines.core) // Coroutines core
    implementation(libs.kotlinx.coroutines.android) // Coroutines Android
    implementation(libs.androidx.room.runtime) // Runtime de Room
    implementation(libs.androidx.room.ktx) // Extensiones para Coroutines
    ksp(libs.androidx.room.compiler) // KSP para Room
    annotationProcessor(libs.androidx.room.compiler) // Procesador de anotaciones para Room
    implementation(libs.picasso) // Picasso para carga de imágenes
    // Dependencias de Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)
    
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
```

---

### **build.gradle (Project: projectName)**

```java
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    id("com.google.devtools.ksp") version "2.0.21-1.0.27" apply false
    id("com.google.dagger.hilt.android") version "2.51" apply false // Plugin de Hilt

}
```

---

### **libs.versions.toml**

```toml
[versions]
agp = "8.6.0"
kotlin = "2.1.0"
coreKtx = "1.15.0"
junit = "4.13.2"
junitVersion = "1.2.1"
espressoCore = "3.6.1"
appcompat = "1.7.0"
kotlinxCoroutinesCore = "1.10.1"
lifecycleRuntimeKtx = "2.8.7"
material = "1.12.0"
activity = "1.10.0"
constraintlayout = "2.2.0"
picasso = "2.71828"
retrofit = "2.11.0"
roomRuntime = "2.6.1"
hilt = "2.51"
```

---

### **AndroidManifest.xml**

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools">
    <uses-permission android:name="android.permission.INTERNET"/>
    <application
        android:allowBackup="true"
        android:dataExtractionRules="@xml/data_extraction_rules"
        android:fullBackupContent="@xml/backup_rules"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/Theme.appName"
        tools:targetApi="31">
        <activity
            android:name=".MainActivity"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>
</manifest>
```

---

## **Dependencias Principales**

- **Retrofit**: Para realizar llamadas a APIs REST.
- **Room**: Para manejar la base de datos local.
- **Coroutines**: Para manejar operaciones asíncronas.
- **LiveData**: Para observar cambios en los datos y actualizar la UI automáticamente.
- **Picasso**: Para cargar imágenes desde URLs.
- **ViewBinding**: Para manejar la UI de manera más eficiente.
- **Hilt**: Para la inyección de dependencias.

---

## **Cómo Ejecutar el Proyecto**

1. Clona el repositorio.
2. Abre el proyecto en Android Studio.
3. Sincroniza el proyecto con Gradle.
4. Ejecuta la aplicación en un emulador o dispositivo físico.

---

## **Buenas Prácticas**

- **MVVM**: Separar la lógica de la UI de la lógica de negocio.
- **Coroutines**: Usar coroutines para operaciones asíncronas.
- **LiveData**: Observar cambios en los datos y actualizar la UI automáticamente.
- **Inyección de Dependencias**: Usar Hilt o Dagger para gestionar dependencias.

---

## **Contribuciones**

Si deseas contribuir a este proyecto, por favor sigue las siguientes pautas:
1. Haz un fork del repositorio.
2. Crea una rama para tu feature (`git checkout -b feature/nueva-funcionalidad`).
3. Realiza tus cambios y haz commit (`git commit -m 'Añadir nueva funcionalidad'`).
4. Haz push a la rama (`git push origin feature/nueva-funcionalidad`).
5. Abre un Pull Request.

---

¡Gracias por revisar este proyecto! Si tienes alguna pregunta o sugerencia, no dudes en contactarme.

---

