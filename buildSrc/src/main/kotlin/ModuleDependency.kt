import kotlin.reflect.full.memberProperties


object ModuleDependency {
    const val APP = ":app"
    const val FEATURE_ALBUM = ":feature_album"
    const val FEATURE_PROFILE = ":feature_profile"
    const val FEATURE_FAVOURITE = ":feature_favourite"
    const val LIBRARY_TEST_UTILS = ":library_test_utils"

    private fun getAllModules() = ModuleDependency::class.memberProperties
        .filter { it.isConst }
        .map { it.getter.call().toString() }
        .toSet()

    fun getFeatureModules(): Set<String> {
        val featurePrefix = ":feature_"
        return getAllModules()
            .filter { it.startsWith(featurePrefix) }
            .toSet()
    }
}
