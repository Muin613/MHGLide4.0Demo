package com.mh.mhglide40demo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.mh.mhglide40demo.glide.GlideApp;
import com.mh.mhglide40demo.glide.GlideUtils;
import com.mh.mhglide40demo.transform.GrayscaleTransformation;

public class MainActivity extends AppCompatActivity {

    public final static String httpsImg = "https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png";
    public final static String img = "http://img.hb.aicdn.com/a061451ddef37fb3d17a1887c07c81ef5e64c197117f5-mUxd15_fw658";
    public final static String gif = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1506936935546&di=2e6164654e75556bbcc8ce5c7f654be0&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F010e945730174232f8758627cd0125.gif";
    private ImageView view, view1, view2, view3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
//        load();
        loadGlideApp();
    }


    private void load() {
//        加载原始的图片
        GlideUtils.loadOriginalImg(this, img, view);
//        对图片进行处变化
        GlideUtils.loadImgByTransform(this, img, new GrayscaleTransformation(), view1);
//        带网络占位图的gif图
        GlideUtils.loadGif(this, img, gif, view2);
//        对请求 options进行操作
        GlideUtils.loadImgWithRequestOpitons(this, img, view3);
        Glide.with(this).asFile().load(gif).into(view);
    }

    private void loadGlideApp() {
//        带有缓存策略的
//        GlideApp.with(this).load(img).diskCacheStrategy(DiskCacheStrategy.ALL).into(view3);
//        带缓存带网络占位带gif
//        GlideApp.with(this).load(img).thumbnail(GlideApp.with(this).load(gif).diskCacheStrategy(DiskCacheStrategy.ALL)).diskCacheStrategy(DiskCacheStrategy.ALL).into(view1);
//        通过target进行图片加载
//        GlideAppUtils.load(this,img,view2);
//        通过注解 进行变化 其实改变的是requestbuilder和options去改变请求后的位图
//        GlideApp.with(this).asMyBitmap().load(img).gray().into(new SimpleTarget<Bitmap>() {
//            @Override
//            public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
//                view2.setImageBitmap(resource);
//            }
//        });
//        加载https的图片
        GlideApp.with(this).load(httpsImg).into(view);
//        这个glide可以监听所有图片的加载进度但必须使用GlideProgressListener去一个个加载进去
        GlideApp.with(this).asGif().load(gif).into(view1);
//        下载图片下载我设置到缓存中去

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                GlideUtils.loadImage(MainActivity.this,img);
//            }
//        }).start();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    void init() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    void initViews() {
        view = (ImageView) findViewById(R.id.img_view);
        view1 = (ImageView) findViewById(R.id.img_view1);
        view2 = (ImageView) findViewById(R.id.img_view2);
        view3 = (ImageView) findViewById(R.id.img_view3);

    }


//
//    这里是对recyclerview的特殊用法
//    recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//@Override
//public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
//    super.onScrollStateChanged(recyclerView, newState);
//    switch (newState) {
//        case RecyclerView.SCROLL_STATE_DRAGGING: 滑动时候
//            GlideApp.with(context).resumeRequests();
//            break;
//        case RecyclerView.SCROLL_STATE_SETTLING:  滑动结束时候
//            GlideApp.with(context).pauseRequests();
//            break;
//        case RecyclerView.SCROLL_STATE_IDLE: 静止的时候
//            GlideApp.with(context).resumeRequests();
//            break;
//    }
//}
//});
//
//
//
}
