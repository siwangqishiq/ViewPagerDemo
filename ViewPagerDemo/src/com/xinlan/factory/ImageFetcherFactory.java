package com.xinlan.factory;

import com.xinlan.components.ImageCache;
import com.xinlan.components.ImageFetcher;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;

public class ImageFetcherFactory {
	public static final String IMAGE_CACHE_DIR = "cache";

	public static ImageFetcher genFetcher(FragmentActivity context) {
		final DisplayMetrics displayMetrics = new DisplayMetrics();
		context.getWindowManager().getDefaultDisplay()
				.getMetrics(displayMetrics);
		int height = displayMetrics.heightPixels;
		int width = displayMetrics.widthPixels;
		final int longest = (height > width ? height : width) / 2;
		ImageCache.ImageCacheParams cacheParams = new ImageCache.ImageCacheParams(
				context, IMAGE_CACHE_DIR);
		cacheParams.setMemCacheSizePercent(context, 0.25f); // 设置一级缓存大小
		ImageFetcher mImageFetcher = new ImageFetcher(context, longest);
		mImageFetcher.addImageCache(context.getSupportFragmentManager(),
				cacheParams);
		mImageFetcher.setImageFadeIn(false);
		return mImageFetcher;
	}
}// end class
