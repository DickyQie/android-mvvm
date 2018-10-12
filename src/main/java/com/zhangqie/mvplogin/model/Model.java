package com.zhangqie.mvplogin.model;

/**
 * Created by zhangqie on 2018/10/11
 * Describe:
 */
public interface Model {

    void login(String name,String pwd,IOnSetListenter iOnSetListenter);

    interface IOnSetListenter{

        void onError(String error);

        void onSccess(String repsonce);
    }

}
