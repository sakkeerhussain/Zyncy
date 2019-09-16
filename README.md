# RemoteFileSyncCacheAndroid
This is a library for remote file(Images for the time being) sync to Android application and cache it in memory to prevent fetching the same again from remote for further requests.


## TODO items

1. Implement caching.
2. Prevent second request to a cached url should read from cache.
2. Prevent second request to one url which is in progress should share the previous request.
4. Create a custom image view for loading image directly.