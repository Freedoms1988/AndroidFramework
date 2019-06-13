package freedoms.androidframework.module.login.model.listener;


import android.view.View;

import freedoms.androidframework.R;
import freedoms.androidframework.module.login.presenter.LoginPresenter;
import freedoms.androidframework.module.login.iview.ILoginView;
import freedoms.androidframework.tools.log.FLog;

/**
 * @Class LoginOnClickListener
 * @Auther freedoms
 * @Date 2018/5/23
 * @Decription
 **/

public class LoginOnClickListener implements View.OnClickListener{

    private LoginPresenter loginPresenter;

    public LoginOnClickListener(ILoginView loginView){
        loginPresenter=new LoginPresenter(loginView);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.loginBTN:
                loginPresenter.login();
                FLog.getInstance().debug("收到点击事件");
        }

    }

}
