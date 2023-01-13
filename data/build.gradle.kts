plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.data"
    compileSdk = Config.targetAndCompileSdk

    defaultConfig {
        minSdk = Config.minSdk
        targetSdk = Config.targetAndCompileSdk

        testInstrumentationRunner = Config.testInstrumentationRunner
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        debug {
            buildConfigField("String","BASE_URL", "\"https://pokeapi.co/api/v2/\"")
            buildConfigField("String", "EntryPoint", "\"pokemon\"")
        }
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
}

dependencies {

    // Core
    implementation(Dependencies.Core.core)

    // Retrofit
    implementation(Dependencies.Retrofit.retrofit)

    // OkHttp
    implementation(Dependencies.OkHttp.okHttp)
    implementation(Dependencies.OkHttp.bom)
    implementation(Dependencies.OkHttp.loggingInterceptor)

    // GsonConverter
    implementation(Dependencies.GsonConverter.gsonConverter)

    // Domain
    implementation(project(":domain"))

}