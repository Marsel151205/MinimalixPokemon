plugins {
    id("com.android.library")
    id(Plugins.kotlinAndroid)
    kotlin(Plugins.kapt)
    id(Plugins.hilt )
}

android {
    namespace = "com.example.presentation"
    compileSdk = Config.targetAndCompileSdk

    defaultConfig {
        minSdk = Config.minSdk
        targetSdk = Config.targetAndCompileSdk

        testInstrumentationRunner = Config.testInstrumentationRunner
        consumerProguardFiles("consumer-rules.pro")
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

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    // Core
    implementation(Dependencies.Core.core)

    // AppCompat
    implementation(Dependencies.UIComponents.appCompat)

    // Material
    implementation(Dependencies.UIComponents.material)

    // ConstraintLayout
    implementation(Dependencies.UIComponents.constraintLayout)

    // NavComponents
    implementation(Dependencies.NavComponents.navigationFragment)
    implementation(Dependencies.NavComponents.navigationUI)

    // Lifecycle
    implementation(Dependencies.Lifecycle.liveData)
    implementation(Dependencies.Lifecycle.viewModel)
    implementation(Dependencies.Lifecycle.viewModelCompose)

    // Coil
    implementation(Dependencies.Coil.coil)

    // Domain
    implementation(project(":domain"))


    // ViewBindingPropertyDelegate
    implementation(Dependencies.ViewBindingPropertyDelegate.viewBindingPropertyDelegate)

    // Hilt
    implementation(Dependencies.Hilt.hilt)
    kapt(Dependencies.Hilt.compiler)

    // Coroutines
    implementation(Dependencies.Coroutines.coroutineAndroid)
    implementation(Dependencies.Coroutines.coroutineCore)

    // Data
    implementation(project(":data"))
}