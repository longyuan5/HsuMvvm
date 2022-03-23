import kotlin.reflect.full.memberProperties


object ModuleDependency {
    const val APP = ":app"
    const val COMMON = ":common"
    const val BUSINESS = ":business"
    const val FEATURE_HOME = ":feature_home"
    const val FEATURE_PROFILE = ":feature_profile"
    const val FEATURE_FAVOURITE = ":feature_favourite"
    const val FEATURE_ME = ":feature_me"
    const val LIBRARY_TEST_UTILS = ":library_test_utils"

    private fun getAllModules(): Set<String> =
        ModuleDependency::class.memberProperties.filter { it.isConst }
            .map { it.getter.call().toString() }.toSet()

    fun getFeatureModules(): Set<String> {
        val featurePrefix = ":feature_"
        return getAllModules().filter { it.startsWith(featurePrefix) }.toSet()
    }
}
