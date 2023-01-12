// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(Plugins.application) version Version.applicationAndKotlinAndroid apply false
    id("com.android.library") version Version.applicationAndKotlinAndroid apply false
    id("org.jetbrains.kotlin.android") version "1.7.20" apply false

    // Hilt
    id(Plugins.hilt) version Version.hilt apply false
    id("org.jetbrains.kotlin.jvm") version "1.7.20" apply false
}