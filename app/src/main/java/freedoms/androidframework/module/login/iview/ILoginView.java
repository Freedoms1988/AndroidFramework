package freedoms.androidframework.module.login.iview;

import freedoms.androidframework.base.IView;

/**
 * Created by freedoms on 2017/3/13.
 */

public interface ILoginView extends IView{
    void loginSuccess();
    void loginFailure();
    String getUsername();
    String getPassword();
    void clearUsername();
    void clearPassword();
}
