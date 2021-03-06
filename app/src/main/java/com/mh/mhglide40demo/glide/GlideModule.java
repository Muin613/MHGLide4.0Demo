package com.mh.mhglide40demo.glide;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import com.bumptech.glide.load.engine.cache.ExternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.module.AppGlideModule;
import com.mh.mhglide40demo.GlideProgressListener;

import java.io.InputStream;

/**
 * 混淆：
 * -keep public class * implements com.bumptech.glide.module.GlideModule
 * -keep public class * extends com.bumptech.glide.AppGlideModule
 * -keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
 * *[] $VALUES;
 * public *;
 * }
 * <p>
 * # for DexGuard only
 * -keepresourcexmlelements manifest/application/meta-data@value=GlideModule
 * Created by Administrator on 2017/10/2.
 */
@com.bumptech.glide.annotation.GlideModule
public class GlideModule extends AppGlideModule {
    @Override
    public void registerComponents(Context context, Glide glide, Registry registry) {
        super.registerComponents(context, glide, registry);
        registry.replace(GlideUrl.class, InputStream.class, new OkHttpUrlLoader.Factory(GlideProgressListener.getGlideOkHttpClient()));


    }

    //
    @Override
    public boolean isManifestParsingEnabled() {
        return false;
    }

    //自定义缓存设置
    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        //配置内存缓存大小 10MB
        builder.setMemoryCache(new LruResourceCache(10 * 1024 * 1024));
        //配置图片池大小   20MB
        builder.setBitmapPool(new LruBitmapPool(20 * 1024 * 1024));
        builder.setDiskCache(new ExternalCacheDiskCacheFactory(context, "munin613_mh", 240 * 1024 * 1024));
//        super.applyOptions(context, builder);
    }
}
