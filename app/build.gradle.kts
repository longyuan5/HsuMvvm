plugins {
    id(GradlePluginId.ANDROID_APPLICATION)
    id(GradlePluginId.KOTLIN_ANDROID)
    id(GradlePluginId.KOTLIN_KAPT)
}

android {
    compileSdk = AndroidConfig.compileSdkVersion
    buildToolsVersion = AndroidConfig.buildToolsVersion
    defaultConfig {
        applicationId = AndroidConfig.applicationId
        minSdk = AndroidConfig.minSdkVersion
        targetSdk = AndroidConfig.targetSdkVersion
        versionCode = AndroidConfig.versionCode
        versionName = AndroidConfig.versionName
        testInstrumentationRunner = AndroidConfig.testRunner
        multiDexEnabled = true
    }
    buildTypes {
        getByName(BuildType.RELEASE) {
            isMinifyEnabled = BuildTypeRelease.isMinifyEnabled
            isShrinkResources = BuildTypeRelease.isShrinkResources
            isDebuggable = BuildTypeRelease.isDebuggable
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }

        getByName(BuildType.DEBUG) {
            isMinifyEnabled = BuildTypeDebug.isMinifyEnabled
            isShrinkResources = BuildTypeDebug.isShrinkResources
            isDebuggable = BuildTypeDebug.isDebuggable
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        viewBinding = true

    }

    lint {

    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_11)
        targetCompatibility(JavaVersion.VERSION_11)
    }
}



dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    api(project(ModuleDependency.BUSINESS))


    // Test
    //    testImplementation(TestLibraries.junit4)
    //    androidTestImplementation(TestLibraries.testExtJunit)
    //    androidTestImplementation(TestLibraries.espressoCore)
}
