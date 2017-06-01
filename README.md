# BlurredImageView
Blurred ImageView for your android designs. 

This project uses [Manabu-GT EtsyBlur](https://github.com/Manabu-GT/EtsyBlur) project for applying fast blur on ImageViews in your android application. While Manabu-GT is used for bluring Bitmaps that project provides easy integration with bluring ImageViews in your Android App this library gives you a super simple integrations with blurred ImageViews.

EtsyBlur
===========

EtsyBlur is an Android library that allows developers to easily add a glass-like effect 
implemented in the [Etsy][1] app.

<img src="https://raw.github.com/Manabu-GT/EtsyBlur/master/art/readme_demo.gif" width=244 height=415 alt="Quick Demo">


Requirements
-------------
API Level 8 (Froyo) and above.

Setup
------
The library is pushed to Maven Central as an AAR, so you just need to add the followings to your ***build.gradle*** file:

```groovy
dependencies {
    compile 'ru.egslava:blurredview:1.0'
}

android {
    defaultConfig {
        renderscriptTargetApi 22
        renderscriptSupportMode true
    }
}
```

Usage
------
```java
<ru.egslava.blurredview.BlurredImageView
    ...
    android:src="@drawable/..."
    app:radius="0.3"
    app:keepOriginal="true"
    app:downSampling="2" />
```
 - radius - "blureness" [0..1]
 - keepOriginal - (default false). if set to false you can't make image sharper if you change radius to less value. If it set to false every time you change radius it will blur already blured image. If `keepOriginal` set to true it will blur original instead of blurred image. Of course to keep original you need more memory so if you need to have just statially blurred image just keep it with default value.

License
----------

```
 Copyright 2015 Viacheslav Egorenkov

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.

```

[1]: https://play.google.com/store/apps/details?id=com.etsy.android
