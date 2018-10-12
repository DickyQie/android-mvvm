package com.zhangqie.mvplogin.presenter;

/***
 *
 * @param <V>
 */
public interface IPresenter<V> {

    void attachView(V view);

    void detachView();

}
