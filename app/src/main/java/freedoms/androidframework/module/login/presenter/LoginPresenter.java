package freedoms.androidframework.module.login.presenter;

import freedoms.androidframework.module.login.model.action.ILoginAction;
import freedoms.androidframework.module.login.model.action.LoginAction;
import freedoms.androidframework.module.login.view.ILoginView;

/**
 * Created by freedoms on 2017/3/13.
 */

public class LoginPresenter {
    private ILoginAction mLoginAction;
    private ILoginView mLoginView;

    public LoginPresenter(ILoginView iLoginView){
        this.mLoginView=iLoginView;
        mLoginAction=new LoginAction(iLoginView);
    }

    public void login(){
        mLoginAction.login(this.mLoginView);
        System.out.println("执行登录");
    }

    public void clearUsername(){
        mLoginAction.clearUsername();
    }

    public void clearPassword(){
        mLoginAction.clearPassword();
    }

}