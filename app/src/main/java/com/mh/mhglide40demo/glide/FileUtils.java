package com.mh.mhglide40demo.glide;

import java.io.File;

/**
 * Created by Administrator on 2017/10/3.
 */

public class FileUtils {
//
//    数据库
//    new File("/data/data/"
//                + context.getPackageName() + "/databases")
//    缓存
//    context.getCacheDir()
//
//    sp
//    new File("/data/data/"
//                + context.getPackageName() + "/shared_prefs")
//
    //获取指定文件夹的大小或者文件的大小
    public static long getFileSize(File f) throws Exception {
        long size = 0;
        if (f.isDirectory()) {
            File fList[] = f.listFiles();
            for (int i = 0; i < fList.length; i++) {
                if (fList[i].isDirectory()) {
                    size = size + getFileSize(fList[i]);
                } else {
                    size = size + fList[i].length();
                }
            }
        } else size = f.length();
        return size;
    }

//删文件或者删文件夹 包括自己（deleteOwn  是否要删掉自己）
    private static void deleteFilesByDirectory(File file, boolean deleteOwn) {
        if (file == null)
            return;
        if (file.isDirectory())
            if (file.exists()) {
                for (File item : file.listFiles()) {
                    item.delete();
                }
            }
        if(deleteOwn)
            file.delete();

    }
}
