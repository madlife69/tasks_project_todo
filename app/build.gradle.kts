import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")

}

android {
    namespace = "com.example.tasks_project"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.tasks_project"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }




}

dependencies {
    implementation("androidx.core:core-ktx:1.10.1")
   // implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.mlkit:entity-extraction:16.0.0-beta4")
    implementation("com.google.ar.sceneform:filament-android:1.17.1")
    implementation("androidx.room:room-common:2.5.2")
    annotationProcessor("androidx.room:room-compiler:2.5.2")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.1")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.1")
    implementation("androidx.room:room-ktx:2.5.2")
    // Add the following test dependencies
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test:rules:1.5.0")


    implementation ("com.google.dagger:dagger:2.44")
    implementation ("org.jetbrains.kotlin:kotlin-stdlib:1.8.22")
    implementation ("com.google.dagger:hilt-android:2.44")
    androidTestImplementation("junit:junit:4.13.2")

//    configurations.all {
//        resolutionStrategy {
//            // Force specific versions for certain dependencies
//            force ("com.google.dagger:dagger:2.44")
//            force ("org.jetbrains.kotlin:kotlin-stdlib:1.8.22")
//            force ("com.google.dagger:hilt-android:2.44")
//            force ("junit:junit:4.13.2")
//        }
//    }
    implementation ("androidx.databinding:databinding-runtime:8.1.1")
    implementation ("androidx.datastore:datastore-preferences:1.0.0-alpha02")

}
