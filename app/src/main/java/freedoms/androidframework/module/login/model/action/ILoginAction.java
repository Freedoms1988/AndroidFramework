package freedoms.androidframework.module.login.model.action;

import freedoms.androidframework.module.login.iview.ILoginView;

/**
 * Created by freedoms on 2017/3/13.
 */

public interface ILoginAction {
    /**
     * 登录
     */
    void login(ILoginView iLoginView);

    /**
     * 清理用户名
     */
    void clearUsername();

    /**
     * 清理密码
     */
    void clearPassword();
}
