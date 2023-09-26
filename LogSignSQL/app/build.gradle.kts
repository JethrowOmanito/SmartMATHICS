import com.android.build.api.dsl.Packaging


plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.logsignsql"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.logsignsql"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }


    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }

    }
    buildFeatures{
        viewBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    defaultConfig {
        multiDexEnabled =true
    }

    fun Packaging.() {
        resources {
            excludes.add("META-INF/*.kotlin_module")
        }
    }
    afterEvaluate {
        tasks.withType(JavaCompile::class) {
            options.compilerArgs.add("-Xlint:unchecked")
            options.compilerArgs.add("-Xlint:deprecation")
        }
    }







}

dependencies {

    constraints {
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.8.0") {
            because("kotlin-stdlib-jdk7 is now a part of kotlin-stdlib")
        }
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.8.0") {
            because("kotlin-stdlib-jdk8 is now a part of kotlin-stdlib")
        }
    }

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.firebase:firebase-database:20.2.2")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation ("com.google.android.material:material:1.9.0")
    implementation ("androidx.navigation:navigation-runtime:2.7.3")
    implementation ("androidx.navigation:navigation-fragment:2.7.3")
    implementation ("androidx.navigation:navigation-ui:2.7.3")
    implementation ("androidx.cardview:cardview:1.0.0")



}