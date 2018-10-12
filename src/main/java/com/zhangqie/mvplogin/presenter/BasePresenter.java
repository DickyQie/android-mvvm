package com.zhangqie.mvplogin.presenter;



import java.lang.ref.WeakReference;

public abstract class BasePresenter<T> implements IPresenter<T> {

    WeakReference<T> weakReference;

    public void attachView(T view) {
        weakReference=new WeakReference<T>(view);
    }

    public void detachView() {
        if(weakReference!=null)
        {
            weakReference.clear();
            weakReference=null;

        }
    }

    public T getView() {
        return weakReference.get();
    }
}
