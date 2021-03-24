
plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinKapt)
}

android {
    compileSdkVersion(AndroidSdk.compileSdkVersion)
    buildToolsVersion(AndroidSdk.buildToolsVersion)
    defaultConfig {
        applicationId = AndroidSdk.applicationId
        minSdkVersion(AndroidSdk.minSdkVersion)
        targetSdkVersion(AndroidSdk.targetSdkVersion)
        versionCode = AndroidSdk.versionCode
        versionName = AndroidSdk.versionName
        testInstrumentationRunner = AndroidConfig.testRunner
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }
}



dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    // Architecture
    implementation(Libraries.kotlinStdLib)
    implementation(Libraries.ktxCore)
    implementation(Libraries.appCompat)
    implementation(Libraries.constraintLayout)
    implementation(Libraries.material)
    implementation(Libraries.viewModel)
    implementation(Libraries.liveData)

    // Retrofit
    implementation(Libraries.retrofit)
    implementation(Libraries.retrofitGson)

    // Persistence
    implementation(Libraries.room)
    kapt(Libraries.roomCompiler)

    // Test
//    testImplementation(TestLibraries.junit4)
//    androidTestImplementation(TestLibraries.testExtJunit)
//    androidTestImplementation(TestLibraries.espressoCore)
}
