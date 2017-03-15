package freedoms.mymvpframework.module.login.model.action;

import android.os.Message;

import freedoms.mymvpframework.module.login.model.handler.ClearHandler;
import freedoms.mymvpframework.module.login.model.handler.LoginHandler;
import freedoms.mymvpframework.module.login.view.ILoginView;

/**
 * Created by freedoms on 2017/3/13.
 */

public class LoginAction implements ILoginAction {

    private LoginHandler loginHandler;
    private ClearHandler clearHandler;

    public LoginAction(ILoginView iLoginView){
        loginHandler=new LoginHandler(iLoginView);
        clearHandler=new ClearHandler(iLoginView);
    }

    @Override
    public void login(ILoginView iLoginView) {
        new LoginThread(loginHandler,iLoginView.getUsername(),iLoginView.getPassword()).start();
        System.out.println("启动线程");
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



    class LoginThread extends Thread{

        private String mUsername;
        private String mPassword;
        private LoginHandler loginHandler;

        public LoginThread(LoginHandler loginHandler,String username,String password){
            this.loginHandler=loginHandler;
            this.mUsername=username;
            this.mPassword=password;
        }

        @Override
        public void run() {
            super.run();
            try {
                System.out.println("用户名："+this.mUsername+"  密码："+this.mPassword);
                sleep(2000);
                System.out.println("线程执行完成");
                Message msg=new Message();
                msg.what=LoginHandler.LOGIN_SUCCESS;
                this.loginHandler.sendMessage(msg);
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }
}
