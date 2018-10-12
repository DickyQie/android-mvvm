package com.zhangqie.mvplogin;

import android.view.View;

import com.zhangqie.mvplogin.base.BaseActivity;
import com.zhangqie.mvplogin.databinding.LoginMainBinding;
import com.zhangqie.mvplogin.presenter.LoginPresenter;
import com.zhangqie.mvplogin.view.IView;

public class LoginActivity extends BaseActivity<LoginMainBinding,IView,LoginPresenter> implements IView {

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected int setMainLayout() {
        return R.layout.login_main;
    }

    @Override
    protected void initView() {
        viewDataBinding.setOnClick(new OnViewClick());
    }

    @Override
    protected void initBeforeData() {

    }

    @Override
    public void showLoading(String msg) {
        showToastShort(msg);
    }

    public class OnViewClick {
        public void OnClickCommand(View view) {
            switch (view.getId()) {
                case R.id.btn_login:
                    p.showLogin(viewDataBinding.etName.getText().toString(),viewDataBinding.etPwd.getText().toString());
                    break;
            }
        }
    }
}
