# ColoringView

This is just view with flood fill ability. You can set image from drawable resource or just Bitmap, then set paint color and that is it.

![Preview](https://raw.githubusercontent.com/coulCod/ColoringView/3e9805e0298973032700d54f969ca7b7ddb03cd7/preview/preview.gif)!

# Usage
##In Layout
``` xml
  <com.seotm.coloringview.ColoringView
        android:id="@+id/coloringView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:imageSrc="@drawable/girls"
        app:paintColor="#3F51B5"
        />
```
# Add ColoringView to your project
Gradle:
``` java
compile 'com.seotm.coloringview:coloringview:1.0'
 ```
