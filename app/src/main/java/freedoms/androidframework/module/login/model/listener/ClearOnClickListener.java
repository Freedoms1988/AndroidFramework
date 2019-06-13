package freedoms.androidframework.module.login.model.listener;

import android.view.View;

import freedoms.androidframework.R;
import freedoms.androidframework.module.login.presenter.LoginPresenter;
import freedoms.androidframework.module.login.iview.ILoginView;

/**
 * @Class ClearOnClickListener
 * @Auther freedoms
 * @Date 2018/5/23
 * @Decription
 **/

public class ClearOnClickListener implements View.OnClickListener {

    private LoginPresenter loginPresenter;

    public ClearOnClickListener(ILoginView loginView){
        loginPresenter=new LoginPresenter(loginView);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.clearusernameBTN:
                loginPresenter.clearUsername();
                break;
            case R.id.clearpasswdBTN:
                loginPresenter.clearPassword();
                break;
        }

    }
}
