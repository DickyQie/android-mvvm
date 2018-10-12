package com.zhangqie.mvplogin.base;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Toast;

import com.zhangqie.mvplogin.presenter.BasePresenter;

/**
 * Created by zhangqie on 2018/10/11
 * Describe:
 */
public abstract class BaseActivity<D extends ViewDataBinding,V,T extends BasePresenter<V>> extends AppCompatActivity{


    protected D viewDataBinding;
    protected T p;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewDataBinding = DataBindingUtil.setContentView(this, setMainLayout());
        p = createPresenter();
        p.attachView((V)this);
        initView();
        initBeforeData();
    }


    protected abstract T createPresenter();

    /***
     * 初始化布局
     */
    protected abstract int setMainLayout();

    /**
     * 初始化View
     */
    protected abstract void initView();

    /**
     * 初始化先前数据
     */
    protected abstract void initBeforeData();

    /***
     * 跳转Activity
     * @param mClass
     */
    protected void openActivity(Class<?> mClass) {
        openIntent(new Intent(this, mClass));
    }



    /**
     * 弹出toast 显示时长short
     *
     * @param msg
     */
    protected void showToastShort(String msg) {
        if (!TextUtils.isEmpty(msg)) {
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }
    }
    protected void showToastShort(int msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


    protected void openIntent(Intent intent) {
        startActivity(intent);
    }

    protected void openForResultActivity(Intent intent, int requestCode){
        startActivityForResult(intent,requestCode);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (p != null){
            p.detachView();
        }

    }

}
