package freedoms.androidframework.module.login.presenter;

import freedoms.androidframework.module.login.model.action.ILoginAction;
import freedoms.androidframework.module.login.model.action.LoginAction;
import freedoms.androidframework.module.login.iview.ILoginView;
import freedoms.androidframework.tools.log.FLog;

/**
 * @Class LoginOnClickListener
 * @Auther freedoms
 * @Date 2018/5/23
 * @Decription
 **/

public class LoginPresenter {
    private ILoginAction mLoginAction;
    private ILoginView mLoginView;

    public LoginPresenter(ILoginView iLoginView){
        this.mLoginView=iLoginView;
        this.mLoginAction=new LoginAction(iLoginView);
    }

    public void login(){
        mLoginView.showHudLoading();
        mLoginAction.login(this.mLoginView);
        FLog.getInstance().debug("执行登录");
    }

    public void clearUsername(){
        mLoginAction.clearUsername();
    }

    public void clearPassword(){
        mLoginAction.clearPassword();
    }

}
