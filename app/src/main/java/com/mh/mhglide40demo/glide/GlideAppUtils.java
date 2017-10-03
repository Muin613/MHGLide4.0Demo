package com.mh.mhglide40demo.glide;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.request.target.ImageViewTarget;
import com.bumptech.glide.request.transition.Transition;

/**
 * Created by Administrator on 2017/10/2.
 */

public class GlideAppUtils {

    public static void load(Activity ac, String url, ImageView view) {
        GlideApp.with(ac).load(url).into(new ImageViewTarget<Drawable>(view) {
            @Override
            protected void setResource(@Nullable Drawable resource) {
                view.setImageDrawable(resource);
            }

            @Override
            public void onResourceReady(Drawable resource, @Nullable Transition<? super Drawable> transition) {


                int width = resource.getIntrinsicWidth();
                int height = resource.getIntrinsicHeight();
                Bitmap source = Bitmap.createBitmap(width, height,
                        resource.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
                Canvas canvas = new Canvas(source);
                resource.setBounds(0, 0, width, height);
                resource.draw(canvas);
                Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
                paint.setStrokeWidth(2);
                paint.setTextSize(70);
                paint.setColor(Color.RED);
                canvas.drawText("hello", width / 2-"hello".length()/2, height / 2, paint);
                super.onResourceReady(new BitmapDrawable(source), transition);


            }
        });
    }


}
