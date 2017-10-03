package com.mh.mhglide40demo;

/**
 * Created by Administrator on 2017/10/3.
 */

public interface IMHProgressListener {

    void update(long total,long current,boolean exhausted);
}
