plugins {
    alias(libs.plugins.kotlinMultiplatform)
}

group = "org.angproj.utf"
version = "1.0-SNAPSHOT"

kotlin {
    jvmToolchain(libs.versions.jvm.toolchain.get().toInt())

    jvm()

    sourceSets {
        jvmMain.dependencies {
        }
        jvmTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}