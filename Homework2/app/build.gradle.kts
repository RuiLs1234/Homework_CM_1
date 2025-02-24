plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp") version "1.9.0-1.0.13" apply true
}

android {
    namespace = "com.example.homework"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.homework"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.0"
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    val composeBom = platform("androidx.compose:compose-bom:2024.04.00")
    implementation(composeBom)
    implementation("androidx.room:room-runtime:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1") // For coroutine support
    ksp("androidx.room:room-compiler:2.6.1") // Use ksp instead of kapt
    androidTestImplementation(composeBom)
    implementation("androidx.activity:activity-compose:1.8.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")
    implementation("androidx.compose.runtime:runtime-livedata")
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.ui:ui-tooling-preview")
    debugImplementation("androidx.compose.ui:ui-tooling")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.navigation:navigation-compose:2.7.4")
    implementation("androidx.compose.ui:ui:1.5.0") // For Compose UI

    testImplementation("junit:junit:4.13.2") // For local unit tests
    androidTestImplementation("androidx.test.ext:junit:1.1.5") // For Android instrumented tests
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1") // For Espresso UI tests
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.5.0") // For Compose tests
}
