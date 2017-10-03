package com.mh.mhglide40demo.glide;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.GenericTransitionOptions;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.mh.mhglide40demo.R;

import java.io.File;
import java.util.concurrent.ExecutionException;

/**
 * Created by Administrator on 2017/10/2.
 */

public class GlideUtils {
    private static final String TAG = "MH_GLIDE_4.1_TAG";

    public static void loadOriginalImg(Activity activity, String url, ImageView img) {
        Glide.with(activity).load(url).into(img);
    }

    public static void loadImgByTransform(Activity activity, String url, BitmapTransformation transformer, ImageView img) {
        RequestOptions options = new RequestOptions().transform(transformer);
        Glide.with(activity).load(url)
                .apply(options).into(img);
    }

    public static void loadImgWithRequestOpitons(Activity activity, String url, ImageView img) {
        RequestOptions options = new RequestOptions();
//        options.placeholder(R.mipmap.ic_launcher);//加载中的占位图
//        options.error(R.mipmap.ic_launcher_round);//错误时的占位图

//                options.centerCrop();//适应某一边，伸缩图片，去切某一边多余的
//        options.centerInside();//以最长的边放进去，然后缩放
//        options.circleCrop();//切圆
//        options.fitCenter();//有点像centerinside
//        DrawableTransitionOptions.withCrossFade()  渐变
        TransitionOptions t = new TransitionOptions() {
        };
        t.transition(R.anim.rotate);//定义加载的动画
        Glide.with(activity).load(url)
//                .apply(options)
                .transition(t).into(img);
    }

    public static void loadImg(Activity act, String img, ImageView view) {
//       RequestOptions options=new RequestOptions();
//       options.diskCacheStrategy(DiskCacheStrategy.NONE);//有5中一种resource  auto  none  all data
       Glide.with(act).load(img).into(view);
    }


    public static void loadGif(Activity act, String imgURL1, String imgURL2, ImageView img) {
        Glide.with(act).load(imgURL2).thumbnail(Glide.with(act).load(imgURL1)).listener(new RequestListener<Drawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                Log.i(TAG, "onLoadFailed: ");
                return false;
            }

            @Override
            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                Log.i(TAG, "onResourceReady: ");
                return false;
            }
        }).into(img);
    }

    public static void loadImage(Activity act,String img){
        FutureTarget<File> down=Glide.with(act).load(img).downloadOnly(500,500);
        try {
            File  f=down.get();
            System.out.println(f.getAbsolutePath());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
