package com.mh.mhglide40demo.glide;

import com.bumptech.glide.annotation.GlideExtension;
import com.bumptech.glide.annotation.GlideOption;
import com.bumptech.glide.request.RequestOptions;
import com.mh.mhglide40demo.transform.GrayscaleTransformation;

/**
 * Created by Administrator on 2017/10/3.
 * 好东西省去写options的一些操作
 * 这是请求时候的操作
 */
@GlideExtension
public class GrayGlideExtension {


    /**
     * 将构造方法设为私有，作为工具类使用
     */
    private GrayGlideExtension() {
    }

    /**
     * 1.自己新增的方法的第一个参数必须是RequestOptions options
     * 2.方法必须是静态的
     * @param options
     */
    @GlideOption
    public static void gray(RequestOptions options) {
        options
                .fitCenter()
                .transform(new GrayscaleTransformation());
    }
}
