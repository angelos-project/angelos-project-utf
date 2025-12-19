plugins {
    alias(libs.plugins.kotlinMultiplatform)
    application
}

group = "org.angproj.utf"
version = "1.0-SNAPSHOT"

application {
    mainClass.set("org.angproj.utf.UtfInfoGenerator")
}

kotlin {
    jvmToolchain(libs.versions.jvm.toolchain.get().toInt())

    jvm()

    sourceSets {
        jvmMain.dependencies {
            api(project(":library"))
            api(project(":shared"))
        }
        jvmTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}