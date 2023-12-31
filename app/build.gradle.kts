plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id ("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.dictionarymvvm"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.dictionarymvvm"
        minSdk = 21
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
     buildFeatures{
             viewBinding=true
         }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")


    implementation ("com.github.kirich1409:viewbindingpropertydelegate-full:1.5.9")

    implementation ("androidx.fragment:fragment-ktx:1.6.1")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:1.6.1")

    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:4.10.0")

    implementation ("androidx.room:room-runtime:2.5.2")
    //noinspection KaptUsageInsteadOfKsp
    kapt ("androidx.room:room-compiler:2.5.2")
    implementation ("androidx.recyclerview:recyclerview:1.3.1")

    implementation ("com.google.dagger:hilt-android:2.44")
    kapt ("com.google.dagger:hilt-compiler:2.44")
    implementation ("androidx.activity:activity-ktx:1.8.0")

    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    implementation ("androidx.fragment:fragment-ktx:1.6.1")

}

kapt {
    correctErrorTypes=true
}