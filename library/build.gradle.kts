import com.vanniktech.maven.publish.SonatypeHost
import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl
import java.net.URL

object This {
    const val longName = "UTF-8 - Angelos Project™"
    const val longDescription = "Native UTF-8 for Angelos Project™."
    const val url = "https://github.com/angelos-project/angelos-project-utf"
}

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.vanniktech.mavenPublish)
    alias(libs.plugins.dokka)
    alias(libs.plugins.kover)
}

group = "org.angproj.utf"
version = "0.2.0"

kotlin {
    explicitApi()
    jvmToolchain(libs.versions.jvm.toolchain.get().toInt())

    jvm()
    js {
        browser()
        nodejs()
    }
    // WASM and similar
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
        nodejs()
    }
    @OptIn(ExperimentalWasmDsl::class)
    wasmWasi { nodejs() }
    // Android
    androidTarget {
        /*@OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }*/
        publishLibraryVariants("release")
    }
    androidNativeArm32()
    androidNativeArm64()
    androidNativeX64()
    androidNativeX86()
    // Linux
    linuxArm64()
    linuxX64()
    // macOS
    macosArm64()
    macosX64()
    // MingW
    mingwX64()
    // iOS
    iosArm64()
    iosX64()
    iosSimulatorArm64()
    // tvOS
    tvosArm64()
    tvosX64()
    tvosSimulatorArm64()
    // watchOS
    watchosArm32()
    watchosArm64()
    watchosDeviceArm64()
    watchosSimulatorArm64()

    sourceSets {
        commonMain.dependencies {
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
        jvmTest.dependencies {
            implementation(libs.kotlin.mockito)
        }
    }
}

android {
    namespace = group.toString()
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
    compileOptions {
        //sourceCompatibility = JavaVersion.VERSION_11
        //targetCompatibility = JavaVersion.VERSION_11
    }
}

mavenPublishing {
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

    //signAllPublications()

    /**
     * The temporary artifact setup, final is coming later at some point.
     * DO NOT USE FOR SONATYPE NEXUS
     * */
    coordinates(group.toString(), rootProject.name, version.toString())
    //coordinates(group.toString(), version.toString())

    pom {
        name.set(This.longName)
        description.set(This.longDescription)
        inceptionYear.set("2024")
        url.set(This.url)

        licenses {
            license {
                name.set("MIT License")
                url.set("https://opensource.org/licenses/MIT")
                distribution.set("repo")
            }
        }
        developers {
            developer {
                name.set("Kristoffer Paulsson")
                email.set("kristoffer.paulsson@talenten.se")
                url.set("https://github.com/kristoffer-paulsson")
            }
        }
        scm {
            url.set(This.url)
            connection.set("scm:git:git://github.com/angelos-project/angelos-project-utf.git")
            developerConnection.set("scm:git:ssh://github.com:angelos-project/angelos-project-utf.git")
        }
    }
}

tasks.dokkaHtml {
    dokkaSourceSets {
        named("commonMain"){
            moduleName.set(This.longName)
            includes.from("Module.md")
            sourceLink {
                localDirectory.set(file("src/commonMain/kotlin"))
                remoteUrl.set(URL(This.url + "/tree/master/src/commonMain/kotlin"))
                remoteLineSuffix.set("#L")
            }
        }
    }
}

kover {
    reports {
        total {
            xml.onCheck.set(true)
            html.onCheck.set(true)
        }
    }
}
