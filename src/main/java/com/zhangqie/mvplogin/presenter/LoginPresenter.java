package com.zhangqie.mvplogin.presenter;

import com.zhangqie.mvplogin.model.Model;
import com.zhangqie.mvplogin.model.ModelImple;
import com.zhangqie.mvplogin.view.IView;

/**
 * Created by zhangqie on 2018/10/11
 * Describe:
 */
public class LoginPresenter extends BasePresenter<IView> {


    public Model model;

    private IView iView;

    public LoginPresenter() {
        this.model = new ModelImple();
    }

    public void showLogin(String name, String pwd) {

        iView = getView();
        model.login(name, pwd, new Model.IOnSetListenter() {

            @Override
            public void onSccess(String repsonce) {
                iView.showLoading(repsonce);
            }

            @Override
            public void onError(String error) {
                iView.showLoading(error);
            }
        });

    }

}
