plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

@Suppress("UnstableApiUsage")
android {
    namespace = AndroidConfig.NAMESPACE
    compileSdk = AndroidConfig.COMPILE_SDK

    defaultConfig {
        applicationId = AndroidConfig.NAMESPACE
        minSdk = AndroidConfig.MIN_SDK
        targetSdk = AndroidConfig.TARGET_SDK
        versionCode = AndroidConfig.VERSION_CODE
        versionName = AndroidConfig.VERSION_NAME

        testInstrumentationRunner = AndroidConfig.TEST_INSTRUMENTATION_RUNNER
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = BuildTypes.RELEASE_MINIFY_ENABLED
            proguardFiles(getDefaultProguardFile(BuildTypes.PROGUARD_DEFAULT), BuildTypes.PROGUARD_RULES)
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
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.COMPOSE
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // Kotlin: Standard library with JDK 8 extensions
    implementation(Dependencies.KOTLIN_STDLIB)

    // AndroidX Core: Core AndroidX extensions (KTX)
    implementation(Dependencies.ANDROIDX_CORE_KTX)

    // AndroidX Lifecycle: Lifecycle-aware components with Kotlin extensions (KTX)
    implementation(Dependencies.ANDROIDX_LIFECYCLE_KTX)

    // Unit Test: JUnit 4 testing framework for Java and Kotlin projects
    testImplementation(Dependencies.JUNIT)
    // AndroidX Test: JUnit extensions for Android, specifically designed for integration with AndroidX libraries
    androidTestImplementation(Dependencies.ANDROIDX_TEST_EXT_JUNIT)
    // Espresso: UI testing framework for Android, designed to work well with AndroidX Test
    androidTestImplementation(Dependencies.ESPRESSO_CORE)

    // Jetpack Compose: Declarative UI toolkit for Android
    // Activity Compose: Integration of Jetpack Compose with Android Activities
    implementation(Dependencies.ANDROIDX_ACTIVITY_COMPOSE)
    // Compose UI: Core UI toolkit and runtime for Jetpack Compose
    implementation(Dependencies.COMPOSE_UI)
    // Compose UI Tooling Preview: Preview and interactive mode support for Jetpack Compose
    implementation(Dependencies.COMPOSE_UI_TOOLING_PREVIEW)
    // Compose Material: Material Design components and theming for Jetpack Compose
    implementation(Dependencies.COMPOSE_MATERIAL)
    // Compose UI Test: Testing support for Jetpack Compose UI, compatible with JUnit 4
    androidTestImplementation(Dependencies.COMPOSE_UI_TEST_JUNIT4)
    // Compose UI Tooling: Debugging and development tools for Jetpack Compose UI, available in debug builds
    debugImplementation(Dependencies.COMPOSE_UI_TOOLING)
    // Compose UI Test Manifest: Manifest metadata support for Jetpack Compose UI testing, available in debug builds
    debugImplementation(Dependencies.COMPOSE_UI_TEST_MANIFEST)
}