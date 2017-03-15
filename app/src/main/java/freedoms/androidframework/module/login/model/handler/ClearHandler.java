package freedoms.androidframework.module.login.model.handler;

import android.os.Handler;
import android.os.Message;

import freedoms.androidframework.module.login.view.ILoginView;

/**
 * Created by freedoms on 2017/3/15.
 */

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
                this.iLoginView.clearUsername();
                break;
            case CLEAR_PASSWORD:
                this.iLoginView.clearPassword();
                break;
        }
    }
}
