plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.app_demo"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.app_demo"
        minSdk = 24
        targetSdk = 34
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
//    Start exercise 9
    implementation ("androidx.appcompat:appcompat:1.3.0")
    implementation ("com.squareup.picasso:picasso:2.71828")
//    End exercise 9

//    Start ex12
    implementation ("androidx.recyclerview:recyclerview:1.2.1")
//    End ex12

//    Start ex13
    implementation("androidx.recyclerview:recyclerview:1.2.1")
//    def room_version = "2.5.0"
    implementation ("androidx.room:room-runtime:2.5.0")
    implementation(libs.annotation)
    implementation(libs.slice.builders)
    annotationProcessor ("androidx.room:room-compiler:2.5.0")
//    End ex13
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
//    Start ex16
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("androidx.recyclerview:recyclerview:1.2.1")
    implementation ("androidx.cardview:cardview:1.0.0")
    implementation ("com.google.android.material:material:1.4.0")
//    End ex16

}