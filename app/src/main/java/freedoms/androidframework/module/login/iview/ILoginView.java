package freedoms.androidframework.module.login.iview;

import freedoms.androidframework.base.IView;

/**
 * @interface ILoginView
 * @Auther freedoms
 * @Date 2018/5/23
 * @Decription
 **/


public interface ILoginView extends IView{
    void loginSuccess();
    void loginFailure();
    String getUsername();
    String getPassword();
    void clearUsername();
    void clearPassword();
}
