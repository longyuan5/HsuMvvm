plugins {
    id(GradlePluginId.ANDROID_LIBRARY)
    id(GradlePluginId.KOTLIN_ANDROID)
    id(GradlePluginId.KOTLIN_KAPT)
}

android {
    compileSdk = AndroidConfig.compileSdkVersion
    buildToolsVersion = AndroidConfig.buildToolsVersion

    defaultConfig {
        minSdk = AndroidConfig.minSdkVersion
        targetSdk = AndroidConfig.targetSdkVersion
        testInstrumentationRunner = AndroidConfig.testRunner
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName(BuildType.RELEASE) {
            isMinifyEnabled = BuildTypeRelease.isMinifyEnabled
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
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

    // Architecture
    api(Libraries.kotlinStdLib)
    api(Libraries.ktxCore)
    api(Libraries.kotlinCoroutinesAndroid)
    api(Libraries.appCompat)
    api(Libraries.constraintLayout)
    api(Libraries.material)
    api(Libraries.viewModelKtx)
    api(Libraries.liveDataKtx)
    api(Libraries.lifecycleRuntimeKtx)

    // network
    api(Libraries.retrofit)
    implementation(Libraries.retrofitConverterGson)
    implementation(Libraries.okHttpLogInterceptor)


    // image
//    api(Libraries.glide)
//    kapt(Libraries.glideCompiler)

    // Persistence
//    api(Libraries.room)
//    kapt(Libraries.roomCompiler)

    //ioc
//    implementation(Libraries.hiltAndroid)
//    kapt(Libraries.hiltAndroidCompiler)




    // Test
    //    testImplementation(TestLibraries.junit4)
    //    androidTestImplementation(TestLibraries.testExtJunit)
    //    androidTestImplementation(TestLibraries.espressoCore)

}
