# RemoteFileSyncCacheAndroid
This is a library for remote file(Images for the time being) sync to Android application and cache it in memory to prevent fetching the same again from remote for further requests.


## How to use

### Load image to your image views

1. Load image to your image views

```
FileSync.loadImage(url)
        .toTarget(testImageView)
```

2. Set placeholder image to your image views till the image loads
```
FileSync.loadImage(url)
        .placeholder(R.drawable.placeholder)
        .toTarget(testImageView)
```

3. Set error image to your image views once any error occured while loading image
```
FileSync.loadImage(url)
        .errorImage(R.drawable.error_image)
        .toTarget(testImageView)
```

4. Set any header to be sent along with the request to server
```
FileSync.loadImage(url)
        .addHeader("Authorization", "token goes here")
        .toTarget(testImageView)
```

5. All the configurations mentioned above together

```
FileSync.loadImage(url)
        .addHeader("Authorization", "token goes here")
        .placeholder(R.drawable.placeholder)
        .errorImage(R.drawable.error_image)
        .toTarget(testImageView)
```

**In complete section starts**
### Add the custom image view in your layouts

1. Load image to custome view

```
<com.filesync.views.FileSyncImageView
            android:layout_width="match_parebt"
            android:layout_height="match_parebt"
            app:src="https//www.test.com/image.png" />
```
**In complete section ends**

## TODO items

~~1. Implement caching.~~
~~2. Prevent second request to a cached url should read from cache.~~
~~3. Prevent second request to one url which is in progress should share the previous request.~~
4. Create a custom image view for loading image directly.
5. Complete Unit test cases.
