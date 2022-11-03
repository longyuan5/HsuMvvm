object AndroidConfig {
    const val versionCode = 1
    private const val majorVersion = 1
    private const val minorVersion = 1
    private const val patchVersion = 0
    const val versionName = "$majorVersion.$minorVersion.$patchVersion"
    const val minSdkVersion = 24
    const val compileSdkVersion = 33
    const val targetSdkVersion = compileSdkVersion
    const val buildToolsVersion = "33.0.0"
    const val applicationId = "com.lunn.hsumvvm"
    const val testRunner = "androidx.test.runner.AndroidJUnitRunner"
}

interface BuildType {

    companion object {
        const val RELEASE = "release"
        const val DEBUG = "debug"
    }

    val isMinifyEnabled: Boolean
    val isShrinkResources: Boolean
    val isDebuggable: Boolean

}

object BuildTypeDebug : BuildType {
    override val isMinifyEnabled = false
    override val isShrinkResources = false
    override val isDebuggable = true
}

object BuildTypeRelease : BuildType {
    override val isMinifyEnabled = true
    override val isShrinkResources = true
    override val isDebuggable = false
}

