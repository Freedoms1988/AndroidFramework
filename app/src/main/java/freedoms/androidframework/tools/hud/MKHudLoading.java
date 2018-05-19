package freedoms.androidframework.tools.hud;

import android.content.Context;
import android.text.TextUtils;

import com.kaopiz.kprogresshud.KProgressHUD;

public class MKHudLoading {
    private static MKHudLoading mkHudLoding;

    private KProgressHUD kProgressHUD;

    public boolean isShow;

    public static MKHudLoading getInstance(){
        if (mkHudLoding==null){
            mkHudLoding=new MKHudLoading();
        }
        return mkHudLoding;
    }

    public void showHud(Context context, String message, boolean isCancel) {
        try {
            kProgressHUD=KProgressHUD.create(context, KProgressHUD.Style.SPIN_INDETERMINATE).setAnimationSpeed(1).setDimAmount(0);
            if (!TextUtils.isEmpty(message)) {
                kProgressHUD.setLabel(message).setCancellable(isCancel);
            }
            isShow = true;
            kProgressHUD.show();
        }catch (Exception e){

        }

    }

    public void dismissHud(){
        if (kProgressHUD!=null){
            if (kProgressHUD.isShowing()){
                isShow=false;
                kProgressHUD.dismiss();
            }
        }
    }

    public void showLoading(Context context){
        showHud(context,"",false);
    }

    public void dismissLoading(){
        dismissHud();
    }
}
