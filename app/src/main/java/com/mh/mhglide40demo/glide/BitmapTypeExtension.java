package com.mh.mhglide40demo.glide;

import android.graphics.Bitmap;

import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.annotation.GlideExtension;
import com.bumptech.glide.annotation.GlideType;
import com.bumptech.glide.request.RequestOptions;

/**
 * Created by Administrator on 2017/10/3.
 * 也是请求时候的配置只是进行请求的数据转化为什么样的形式
 */
@GlideExtension
public class BitmapTypeExtension {
    private BitmapTypeExtension() {
    }

    private static final RequestOptions DECODE_TYPE = GlideOptions.decodeTypeOf(Bitmap.class).lock();

    @GlideType(Bitmap.class)
    public static void asMyBitmap(RequestBuilder<Bitmap> requestBuilder) {
        requestBuilder
                .apply(DECODE_TYPE);
    }
}
