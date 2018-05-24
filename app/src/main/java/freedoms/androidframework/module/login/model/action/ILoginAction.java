package freedoms.androidframework.module.login.model.action;

import freedoms.androidframework.module.login.iview.ILoginView;

/**
 * @interface ILoginAction
 * @Auther freedoms
 * @Date 2018/5/23
 * @Decription
 **/

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
