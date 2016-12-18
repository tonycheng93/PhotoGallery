package com.sky.photogallery.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

/**
 * 项目名称：PhotoGallery
 * 类描述：
 * 创建人：tonycheng
 * 创建时间：2016/12/17 20:51
 * 邮箱：tonycheng93@outlook.com
 * 修改人：
 * 修改时间：
 * 修改备注：
 */

public abstract class SingleFragmentActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public abstract Fragment createFragment();
}
