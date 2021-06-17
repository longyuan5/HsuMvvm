//kotlin版本
object Kotlin {
    const val standardVersion = "1.5.10"
    const val coroutinesVersion = "1.5.0"
    const val ktxVersion = "1.5.0"
}


//全局build.gradle 依赖配置
object GlobalBuildGradle {

    private object Versions {
        const val gradleVersion = "6.8.3"
        const val gradleBuildToolsVersion = "4.2.1"
    }

    const val androidGradleBuildToolsPlugin = "com.android.tools.build:gradle:${Versions.gradleBuildToolsVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.standardVersion}"
    const val hiltGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:${Libraries.OpenVersions.hilt}"
    const val navigationSafeArgsGradlePlugin = "androidx.navigation:navigation-safe-args-gradle-plugin::${Libraries.OpenVersions.navigation}"
}


// 第三方库依赖
object Libraries {

    object OpenVersions {
        const val hilt = "2.28-alpha"
        const val navigation = "2.3.4"
    }

    private object Versions {

        //android X
        const val appCompat = "1.2.0"
        const val constraintLayout = "2.0.2"
        const val material = "1.1.0"
        const val annotations = "1.1.0"
        const val dynamicAnimation = "1.1.0"

        // JetPack
        const val lifecycle = "2.3.0"
        const val paging = "3.0.0-alpha02"
        const val room = "2.2.5"
        const val workManager = "2.4.0-rc01"
        const val startup = "1.0.0"
        const val dataStore = "1.0.0-alpha06"

        //第三方
        const val glide = "4.12.0"
        const val gson = "2.8.6"
        const val rxJava = "3.0.11"
        const val okHttp = "3.14.9"
        const val retrofit = "2.9.0"
        const val dagger = "2.33"
    }

    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Kotlin.standardVersion}"
    const val kotlinCoroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Kotlin.coroutinesVersion}"
    const val kotlinCoroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Kotlin.coroutinesVersion}"
    const val ktxCore = "androidx.core:core-ktx:${Kotlin.ktxVersion}"

    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val dynamicAnimation = "androidx.dynamicanimation:dynamicanimation:${Versions.dynamicAnimation}"
    const val androidAnnotations = "androidx.annotation:annotation:${Versions.annotations}"

    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val viewModelSaveState = "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.lifecycle}"
    const val lifecycleService = "androidx.lifecycle:lifecycle-service:${Versions.lifecycle}"
    const val lifecycleJava8 = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycle}"
    const val lifecycleProcess = "androidx.lifecycle:lifecycle-process:${Versions.lifecycle}"
    const val lifecycleRxJava = "androidx.lifecycle:lifecycle-reactivestreams-ktx:${Versions.lifecycle}"
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${OpenVersions.navigation}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${OpenVersions.navigation}"
    const val navigationDynamic = "androidx.navigation:navigation-dynamic-features-fragment:${OpenVersions.navigation}"
    const val paging = "androidx.paging:paging-runtime:${Versions.paging}"
    const val room = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val roomGuava = "androidx.room:room-guava:${Versions.room}"
    const val workManager = "androidx.work:work-runtime:${Versions.workManager}"
    const val workManagerGcm = "androidx.work:work-gcm:${Versions.workManager}"
    const val startup = "androidx.startup:startup-runtime:${Versions.startup}"
    const val hiltAndroid = "com.google.dagger:hilt-android:${OpenVersions.hilt}"
    const val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:${OpenVersions.hilt}"

    const val gson = "com.google.code.gson:gson:${Versions.gson}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    const val okHttpLogInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
    const val glideOkHttp3Integration = "com.github.bumptech.glide:okhttp3-integration:${Versions.glide}"
    const val glideRecyclerViewIntegration = "com.github.bumptech.glide:recyclerview-integration:${Versions.glide}"
    const val glideTransformations = "jp.wasabeef:glide-transformations:4.0.0"
    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"

}

//测试库依赖
object TestLibraries {
    private object Versions {
        const val junit = "4.13.2"
        const val mockk = "1.10.0"
        const val robolectric = "4.4"
        const val kluent = "1.14"
        const val testRunner = "1.1.0"
        const val testRules = "1.1.0"
        const val espressoCore = "3.2.0"
        const val espressoIntents = "3.1.0"
        const val testExtJunit = "1.1.1"
    }

    const val junit = "junit:junit:${Versions.junit}"
    const val mockk = "io.mockk:mockk:${Versions.mockk}"
    const val robolectric = "org.robolectric:robolectric:${Versions.robolectric}"
    const val kluent = "org.amshove.kluent:kluent:${Versions.kluent}"
    const val testRunner = "androidx.test:runner:${Versions.testRunner}"
    const val testRules = "androidx.test:rules:${Versions.testRules}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    const val espressoIntents = "androidx.test.espresso:espresso-intents:${Versions.espressoIntents}"
    const val testExtJunit = "androidx.test.ext:junit:${Versions.testExtJunit}"
}

//开发调试库依赖
object DevLibraries {
    private object Versions {
        const val leakCanary = "2.5"
    }

    const val leakCanary = "com.squareup.leakcanary:leakcanary-android:${Versions.leakCanary}"
}