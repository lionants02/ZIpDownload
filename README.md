# ZIpDownload"

[![Build Status](https://travis-ci.org/lionants02/ZIpDownload.svg?branch=master)](https://travis-ci.org/lionants02/ZIpDownload.ini) [![Release](https://jitpack.io/v/lionants02/ZIpDownload.svg)](https://jitpack.io/#lionants02/ZIpDownload)  
[![ktlint](https://img.shields.io/badge/code%20style-%E2%9D%A4-FF4081.svg)](https://ktlint.github.io/)

เพิ่ม JitPack repository ที่ build script
```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

เพิ่ม dependency
```
dependencies {
    implementation "com.github.lionants02:ZIpDownload:$latestVersion"
}
```

ใช้
```kotlin
    val zd = ZIpDownload(URL("https://github.com/ffc-nectec/AirSyncLauncher/releases/download/0.0.1/t1.zip")) {
        println(it / (1024L * 1024L))
    }
    zd.download(File("downloadToFolder"))
```
