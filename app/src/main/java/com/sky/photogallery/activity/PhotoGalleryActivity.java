package com.sky.photogallery.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.sky.photogallery.fragment.PhotoGalleryFragment;

/**
 * 项目名称：PhotoGallery
 * 类描述：
 * 创建人：tonycheng
 * 创建时间：2016/12/17 20:55
 * 邮箱：tonycheng93@outlook.com
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

public class PhotoGalleryActivity extends SingleFragmentActivity {
    @Override
    public Fragment createFragment() {
        return PhotoGalleryFragment.newInstance();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
