package freedoms.androidframework.module.login.model.listener;

import android.view.View;

import freedoms.androidframework.R;
import freedoms.androidframework.module.login.presenter.LoginPresenter;
import freedoms.androidframework.module.login.view.ILoginView;

/**
 * Created by freedoms on 2017/3/14.
 */

public class ClearOnClickListener implements View.OnClickListener {

    private LoginPresenter loginPresenter;

    public ClearOnClickListener(ILoginView loginView){
        loginPresenter=new LoginPresenter(loginView);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.clearusernameBTN:
                this.loginPresenter.clearUsername();
                break;
            case R.id.clearpasswdBTN:
                this.loginPresenter.clearPassword();
                break;
        }

    }
}
