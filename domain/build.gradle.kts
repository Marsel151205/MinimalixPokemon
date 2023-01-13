plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies{

    // Inject
    api("javax.inject:javax.inject:1")

    // Common
    api(project(":common"))

    // Coroutines
    api(Dependencies.Coroutines.coroutineAndroid)
    api(Dependencies.Coroutines.coroutineCore)
    api(Dependencies.Coroutines.coroutineCoreJVM)
}