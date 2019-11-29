# Zyncy for Android
This is a library will help to load remote files(Images for the time being) sync to Android application and cache it in memory to prevent fetching the same again from remote for further requests.


## How to use

### Integrate the library

1. Add the bintray repository in your root gradle file
```
    repositories {
        ...
        ...

        maven {
            url  "https://dl.bintray.com/sakkeerhussain/Zyncy"
        }
    }
    
```

2. Add this line in the app level gradle file
```
    implementation 'com.sakkeer.zyncy:zyncy:0.1'
```

### Load image to your image views

1. Load image to your image views

```
Zyncy.loadImage(url)
        .toTarget(testImageView)
```

2. Set placeholder image to your image views till the image loads
```
Zyncy.loadImage(url)
        .placeholder(R.drawable.placeholder)
        .toTarget(testImageView)
```

3. Set error image to your image views once any error occured while loading image
```
Zyncy.loadImage(url)
        .errorImage(R.drawable.error_image)
        .toTarget(testImageView)
```

4. Set any header to be sent along with the request to server
```
Zyncy.loadImage(url)
        .addHeader("Authorization", "token goes here")
        .toTarget(testImageView)
```

5. All the configurations mentioned above together

```
Zyncy.loadImage(url)
        .addHeader("Authorization", "token goes here")
        .placeholder(R.drawable.placeholder)
        .errorImage(R.drawable.error_image)
        .toTarget(testImageView)
```


### Add the custom image view in your layouts

1. Load image to custom view

```
<com.sakkeer.zyncy.ui.view.RemoteImageViewImpl
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:src="@drawable/place_holder"
            
            app:url="https//www.test.com/image.png"
            app:error_image="@drawable/error_image"/>
```


## TODO items

~~1. Implement caching.~~

~~2. Prevent second request to a cached url should read from cache.~~

~~3. Prevent second request to one url which is in progress should share the previous request.~~

~~4. Create a custom image view for loading image directly.~~

5. Complete Unit test cases.
