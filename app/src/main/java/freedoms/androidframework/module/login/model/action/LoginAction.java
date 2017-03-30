package freedoms.androidframework.module.login.model.action;

import android.os.Message;

import java.io.IOException;

import freedoms.androidframework.module.login.model.handler.ClearHandler;
import freedoms.androidframework.module.login.model.handler.LoginHandler;
import freedoms.androidframework.module.login.view.ILoginView;
import freedoms.androidframework.tools.fokhttp.FOkHttpClient;
import freedoms.androidframework.tools.fokhttp.FRequestCallBack;
import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by freedoms on 2017/3/13.
 */

public class LoginAction implements ILoginAction {

    private LoginHandler loginHandler;
    private ClearHandler clearHandler;

    public LoginAction(ILoginView iLoginView){
        this.loginHandler=new LoginHandler(iLoginView);
        this.clearHandler=new ClearHandler(iLoginView);
    }

    @Override
    public void login(ILoginView iLoginView) {
        FOkHttpClient.getInstance().getWithJSON("https://www.baidu.com",new FRequestCallBack(){
            @Override
            public void onFailure(Call call, IOException e) {
                Message msg=new Message();
                msg.what=LoginHandler.LOGIN_FAILURE;
                loginHandler.sendMessage(msg);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Message msg=new Message();
                msg.what=LoginHandler.LOGIN_SUCCESS;
                loginHandler.sendMessage(msg);
            }
        });
    }

    @Override
    public void clearUsername() {
        Message message=new Message();
        message.what=ClearHandler.CLEAR_USERNAME;
        clearHandler.sendMessage(message);
        System.out.println("清理用户名");
    }

    @Override
    public void clearPassword() {
        Message message=new Message();
        message.what=ClearHandler.CLEAR_PASSWORD;
        clearHandler.sendMessage(message);
        System.out.println("清理密码");
    }
}
