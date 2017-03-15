package freedoms.androidframework.module.login.view;

/**
 * Created by freedoms on 2017/3/13.
 */

public interface ILoginView {
    void loginSuccess();
    void loginFailure();
    String getUsername();
    String getPassword();
    void clearUsername();
    void clearPassword();
}