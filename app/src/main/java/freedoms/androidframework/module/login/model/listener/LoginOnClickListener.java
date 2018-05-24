package freedoms.androidframework.module.login.model.listener;


import android.view.View;

import freedoms.androidframework.R;
import freedoms.androidframework.module.login.presenter.LoginPresenter;
import freedoms.androidframework.module.login.iview.ILoginView;
import freedoms.androidframework.tools.log.FLog;

/**
 * Created by freedoms on 2017/3/13.
 */

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
                FLog.debug("收到点击事件");
        }

    }

}
