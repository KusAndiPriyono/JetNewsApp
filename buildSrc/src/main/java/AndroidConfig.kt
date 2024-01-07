import org.gradle.api.JavaVersion

object AndroidConfig {

    const val minSDK = 27
    const val targetSDK = 33
    const val compileSDK = 34
    const val versionCode = 1
    const val versionName = "1.0"
    const val applicationId = "com.example.jetnewsapp"

    val javaVersion = JavaVersion.VERSION_17
    const val jvmTarget = "17"
}