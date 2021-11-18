object AndroidConfig {
    const val versionCode = 1
    const val versionName = "1.0.0"
    const val minSdkVersion = 21
    private const val compileSdkVersion = 31
    const val targetSdkVersion = compileSdkVersion
    const val buildToolsVersion = "31.0.0"
    const val applicationId = "com.lunn.hsumvvm"
    const val testRunner = "androidx.test.runner.AndroidJUnitRunner"
}

interface BuildType {

    companion object {
        const val RELEASE = "release"
        const val DEBUG = "debug"
    }

    val isMinifyEnabled: Boolean
}

object BuildTypeDebug : BuildType {
    override val isMinifyEnabled = false
}

object BuildTypeRelease : BuildType {
    override val isMinifyEnabled = false
}

