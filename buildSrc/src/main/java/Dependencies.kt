object Dependencies {
    const val gradle = "com.android.tools.build:gradle:${Versions.gradle}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val kotlinStandardLibrary = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"

    const val ktxCore = "androidx.core:core-ktx:${Versions.ktxCore}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val material = "com.google.android.material:material:${Versions.material}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val okhttp3LoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp3}"
    const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"

    const val daggerHiltGradle = "com.google.dagger:hilt-android-gradle-plugin:${Versions.daggerHilt}"
    const val daggerHilt = "com.google.dagger:hilt-android:${Versions.daggerHilt}"
    const val daggerHiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.daggerHilt}"
    const val hiltLifecycleViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hiltLifecycleViewModel}"
    const val hiltCompiler = "androidx.hilt:hilt-compiler:${Versions.hiltCompiler}"

    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleExtensions}"
    const val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleExtensions}"

    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    const val navigationSafeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"
    const val paging = "androidx.paging:paging-runtime:${Versions.paging}"

    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
}

object TestDependencies {
    const val junit = "junit:junit:${TestVersions.junit}"
    const val extJunit = "androidx.test.ext:junit:${TestVersions.extJunit}"
    const val espresso = "androidx.test.espresso:espresso-core:${TestVersions.espresso}"

}