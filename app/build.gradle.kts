plugins {
    id(Plugins.application)
    id("org.jetbrains.kotlin.android")
    kotlin(Plugins.kapt)
    id(Plugins.hilt)
}

android {
    namespace = Config.namespace
    compileSdk = Config.targetAndCompileSdk

    defaultConfig {
        applicationId = Config.namespace
        minSdk = Config.minSdk
        targetSdk = Config.targetAndCompileSdk
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = Config.testInstrumentationRunner
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

    // Hilt
    implementation(Dependencies.Hilt.hilt)
    kapt(Dependencies.Hilt.compiler)

    // Retrofit
    implementation(Dependencies.Retrofit.retrofit)

    // OkHttp
    implementation(Dependencies.OkHttp.okHttp)
    implementation(Dependencies.OkHttp.bom)
    implementation(Dependencies.OkHttp.loggingInterceptor)

    // ViewBindingPropertyDelegate
    implementation(Dependencies.ViewBindingPropertyDelegate.viewBindingPropertyDelegate)

    // NavComponents
    implementation(Dependencies.NavComponents.navigationFragment)
    implementation(Dependencies.NavComponents.navigationUI)

    // Lifecycle
    implementation(Dependencies.Lifecycle.liveData)
    implementation(Dependencies.Lifecycle.viewModel)
    implementation(Dependencies.Lifecycle.viewModelCompose)

    // Coil
    implementation(Dependencies.Coil.coil)

    // GsonConverter
    implementation(Dependencies.GsonConverter.gsonConverter)

    // Coroutine
    implementation(Dependencies.Coroutines.coroutineAndroid)
    implementation(Dependencies.Coroutines.coroutineCore)
}