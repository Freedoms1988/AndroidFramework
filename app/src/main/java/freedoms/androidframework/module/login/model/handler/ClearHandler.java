package freedoms.androidframework.module.login.model.handler;

import android.os.Handler;
import android.os.Message;

import freedoms.androidframework.module.login.iview.ILoginView;

/**
 * @Class ClearHandler
 * @Auther freedoms
 * @Date 2018/5/23
 * @Decription
 **/

public class ClearHandler extends Handler {

    public static final int CLEAR_USERNAME=0;
    public static final int CLEAR_PASSWORD=1;

    private ILoginView iLoginView;

    public ClearHandler(ILoginView iLoginView){
        this.iLoginView=iLoginView;
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        switch (msg.what){
            case CLEAR_USERNAME:
                iLoginView.clearUsername();
                break;
            case CLEAR_PASSWORD:
                iLoginView.clearPassword();
                break;
        }
    }
}
