plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "uz.apexsoftuz.movieskmm.android"
    compileSdk = 33
    defaultConfig {
        applicationId = "uz.apexsoftuz.movieskmm.android"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.7"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("androidx.compose.ui:ui:1.4.3")
    implementation("androidx.compose.ui:ui-tooling:1.4.3")
    implementation("androidx.compose.ui:ui-tooling-preview:1.4.3")
    implementation("androidx.compose.foundation:foundation:1.4.3")
    implementation("androidx.compose.material:material:1.4.3")
    implementation("androidx.activity:activity-compose:1.7.1")

    // coil dependency
    val coilVersion = "2.4.0"
    implementation("io.coil-kt:coil-compose:$coilVersion")

    // compose navigation dependency
    val navigationVersion = "2.5.3"
    implementation("androidx.navigation:navigation-compose:$navigationVersion")

    // koin dependency
    val koinVersion = "3.4.5"
    implementation("io.insert-koin:koin-androidx-compose:$koinVersion")

    // system ui controller dependency
    val accompanistVersion = "0.28.0"
    implementation("com.google.accompanist:accompanist-systemuicontroller:$accompanistVersion")
}