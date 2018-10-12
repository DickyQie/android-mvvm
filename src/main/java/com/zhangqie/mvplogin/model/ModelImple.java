package com.zhangqie.mvplogin.model;

/**
 * Created by zhangqie on 2018/10/11
 * Describe:
 */
public class ModelImple implements Model {

    @Override
    public void login(String name, String pwd, IOnSetListenter iOnSetListenter) {
        if (name.isEmpty()){
            iOnSetListenter.onError("输入用户名为空");
            return;
        }
        if (pwd.isEmpty()){
            iOnSetListenter.onError("输入密码为空");
        }
        if (name.equals("zhangqie") && pwd.equals("123456")){
            iOnSetListenter.onSccess("登录成功");
        }else {
            iOnSetListenter.onSccess("登录失败");
        }
    }
}
