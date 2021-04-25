object Dependencies {
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val kotlinStandardLibrary = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    const val ktxCore = "androidx.core:core-ktx:${Versions.ktxCore}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val material = "com.google.android.material:material:${Versions.material}"

    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    const val daggerAndroid = "com.google.dagger:dagger-android:${Versions.dagger}"
    const val daggerAndroidSupport = "com.google.dagger:dagger-android-support:${Versions.dagger}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    const val daggerAndroidProcessor = "com.google.dagger:dagger-android-processor:${Versions.dagger}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val okhttp3LoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp3}"
    const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"

    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleExtensions}"

    const val navigationFragment = "androidx.navigation:navigation-fragment:${Versions.navigation}"
    const val navigationUi = "androidx.navigation:navigation-ui:${Versions.navigation}"
    const val navigationSafeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"
}

object TestDependencies {
    const val junit = "junit:junit:${TestVersions.junit}"
    const val extJunit = "androidx.test.ext:junit:${TestVersions.extJunit}"
    const val espresso = "androidx.test.espresso:espresso-core:${TestVersions.espresso}"

}