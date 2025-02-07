plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-parcelize") // Parcelize support
    id("com.google.devtools.ksp") // KSP support
    id("com.google.dagger.hilt.android") // Hilt support
    id("kotlin-kapt") // KAPT support
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
    viewBinding{
        enable=true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    implementation(libs.retrofit) // Retrofit para hacer llamadas a la API
    implementation(libs.converter.gson) // Gson para parsear JSON
    implementation(libs.androidx.lifecycle.runtime.ktx) // Lifecycle + Coroutine support
    implementation(libs.androidx.lifecycle.viewmodel.ktx) // ViewModel with Coroutines
    implementation(libs.kotlinx.coroutines.core) // Coroutines core
    implementation(libs.kotlinx.coroutines.android) // Coroutines Android
    implementation(libs.androidx.room.runtime) // Runtime de Room
    implementation(libs.androidx.room.ktx) // Extensiones para Coroutines
    ksp(libs.androidx.room.compiler) // Alternativa moderna "Kotlin"
    annotationProcessor(libs.androidx.room.compiler) // Procesador "Java"
    implementation(libs.picasso) // Picasso for image loading
    implementation(libs.hilt.android) // Hilt for dependency injection
    kapt(libs.hilt.android.compiler) // Kapt for Hilt

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}