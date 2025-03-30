plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.example.comp1786_logbook2_and_3"
    compileSdk = 34
    defaultConfig {
        applicationId = "com.example.comp1786_logbook2_and_3"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        viewBinding = true
        compose = true  // Enable Compose
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.14"  // Compatible with Kotlin 1.9.0
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    implementation("androidx.room:room-runtime:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")
    ksp("androidx.room:room-compiler:2.6.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.cardview:cardview:1.0.0")

    // Jetpack Compose dependencies
    implementation("androidx.activity:activity-compose:1.9.2")  // For Compose in Activities
    implementation("androidx.compose.material3:material3:1.3.0")  // Material 3 components
    implementation("androidx.compose.ui:ui:1.7.0")  // Core Compose UI
    implementation("androidx.compose.runtime:runtime:1.7.0")  // Compose runtime
    implementation("androidx.compose.foundation:foundation:1.7.0")  // Foundation (layouts, etc.)
    debugImplementation("androidx.compose.ui:ui-tooling:1.7.0")  // Preview tooling
    implementation("androidx.compose.ui:ui-tooling-preview:1.7.0")  // Compose previews
}