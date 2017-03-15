package freedoms.androidframework.module.login.model.handler;

import android.os.Handler;
import android.os.Message;

import freedoms.androidframework.module.login.view.ILoginView;

/**
 * Created by freedoms on 2017/3/14.
 */

public class LoginHandler extends Handler {

    public static final int LOGIN_SUCCESS=0;
    public static final int LOGIN_FAILURE=1;

    private ILoginView iLoginView;

    public LoginHandler(ILoginView iLoginView){
        this.iLoginView=iLoginView;
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        switch (msg.what){
            case LOGIN_SUCCESS:
                iLoginView.loginSuccess();
                break;
            case LOGIN_FAILURE:
                iLoginView.loginFailure();
                break;
        }
    }
}
