// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    val kotlin_version by extra("1.4.31")
    repositories {
        maven { setUrl ("https://maven.aliyun.com/repository/google") }
        maven { setUrl ("https://maven.aliyun.com/repository/central") }
        maven { setUrl ("https://maven.aliyun.com/repository/public") }
        maven { setUrl ("https://www.jitpack.io") }
    }
    dependencies {
        classpath(GlobalBuildGradle.androidGradleBuildToolsPlugin)
        classpath(GlobalBuildGradle.kotlinGradlePlugin)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        maven { setUrl ("https://maven.aliyun.com/repository/google") }
        maven { setUrl ("https://maven.aliyun.com/repository/central") }
        maven { setUrl ("https://maven.aliyun.com/repository/public") }
        maven { setUrl ("https://www.jitpack.io") }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
