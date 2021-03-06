plugins {
    id(GradlePluginId.ANDROID_LIBRARY)
    id(GradlePluginId.KOTLIN_ANDROID)
    id(GradlePluginId.KOTLIN_KAPT)
    id(GradlePluginId.HILT_PLUGIN)
}

android {
    compileSdkVersion(AndroidConfig.compileSdkVersion)
    buildToolsVersion(AndroidConfig.buildToolsVersion)

    defaultConfig {
        minSdkVersion(AndroidConfig.minSdkVersion)
        targetSdkVersion(AndroidConfig.targetSdkVersion)
        versionCode = AndroidConfig.versionCode
        versionName = AndroidConfig.versionName
        testInstrumentationRunner = AndroidConfig.testRunner
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }
}



dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    // Architecture
    api(Libraries.kotlinStdLib)
    api(Libraries.ktxCore)
    api(Libraries.appCompat)
    api(Libraries.constraintLayout)
    api(Libraries.material)
    api(Libraries.viewModelKtx)
    api(Libraries.liveDataKtx)

    // network
    api(Libraries.retrofit)
    implementation(Libraries.retrofitConverterGson)
    implementation(Libraries.okHttpLogInterceptor)

    // image
    api(Libraries.glide)
    kapt(Libraries.glideCompiler)

    // Persistence
    api(Libraries.room)
    kapt(Libraries.roomCompiler)

    //ioc
    implementation(Libraries.hiltAndroid)
    kapt(Libraries.hiltAndroidCompiler)




    // Test
    //    testImplementation(TestLibraries.junit4)
    //    androidTestImplementation(TestLibraries.testExtJunit)
    //    androidTestImplementation(TestLibraries.espressoCore)

}
