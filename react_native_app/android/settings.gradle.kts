import groovy.lang.Closure

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "MyAndroidHostLib"
include(":app")
include(":testLib")
includeBuild("../node_modules/@react-native/gradle-plugin")
// include aar files from /Users/kornisaranimitr/Documents/project/maui-integration/MauiFlutterBinding/Android.Binding/jars/binding-release.aar

apply(from = file("../node_modules/@react-native-community/cli-platform-android/native_modules.gradle")); (extra["applyNativeModulesSettingsGradle"] as Closure<*>).call(settings)