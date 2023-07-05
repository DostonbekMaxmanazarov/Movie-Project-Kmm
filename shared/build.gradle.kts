plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization") version "1.8.21"
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    listOf(iosX64(), iosArm64(), iosSimulatorArm64())
        .forEach { target ->
            target.binaries.framework {
                baseName = "shared"
            }
        }

    val ktorVersion = "2.3.1"
    val koinVersion = "3.3.2"
    val napierVersion = "2.6.1"
    val coroutinesVersion = "1.6.4"

    sourceSets {
        val androidMain by getting {
            dependencies {
                // koin dependency
                api("io.insert-koin:koin-android:$koinVersion")

                // ktor dependency
                implementation("io.ktor:ktor-client-android:$ktorVersion")
            }
        }
        val commonMain by getting {
            dependencies {
                // coroutines dependency
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")

                // ktor dependency
                implementation("io.ktor:ktor-client-core:$ktorVersion")
                implementation("io.ktor:ktor-client-logging:$ktorVersion")
                implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
                implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")

                // koin dependency
                api("io.insert-koin:koin-core:$koinVersion")

                // napier dependency
                implementation("io.github.aakira:napier:$napierVersion")
            }
        }
        val iosMain by getting {
            dependencies {
                // ktor dependency
                implementation("io.ktor:ktor-client-darwin:$ktorVersion")
            }
        }
    }
}

android {
    namespace = "uz.apexsoftuz.movieskmm"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
    }
}