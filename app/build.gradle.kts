plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.android.kotlin)
    alias(libs.plugins.kapt)
    alias(libs.plugins.parcelize)
    alias(libs.plugins.hilt.android)
}

apply {
    from("$rootDir/base-module.gradle")
}

android {
    namespace = "com.example.jetnewsapp"
    compileSdk = AndroidConfig.compileSDK

    defaultConfig {
        applicationId = AndroidConfig.applicationId
        minSdk = AndroidConfig.minSDK
        targetSdk = AndroidConfig.targetSDK
        versionCode = AndroidConfig.versionCode
        versionName = AndroidConfig.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = AndroidConfig.javaVersion
        targetCompatibility = AndroidConfig.javaVersion
    }
    kotlinOptions {
        jvmTarget = AndroidConfig.jvmTarget
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(platform("androidx.compose:compose-bom:2023.10.01"))
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.10.01"))

    implementation(project(Modules.coreDesignSystem))
    implementation(project(Modules.corePreferences))
    implementation(project(Modules.coreNetwork))
    implementation(project(Modules.coreDatabase))

    implementation(project(Modules.featureHome))
    implementation(project(Modules.featureBookmark))

    implementation(libs.core)
}

