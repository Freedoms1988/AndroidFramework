package freedoms.androidframework.tools.hud;

import android.content.Context;
import android.text.TextUtils;

import com.kaopiz.kprogresshud.KProgressHUD;

/**
 * @Class FHudLoading
 * @Auther freedoms
 * @Date 2018/5/24
 * @Decription
 **/

public class FHudLoading implements IFHudLoading{
    private static FHudLoading instance;

    private KProgressHUD kProgressHUD;

    public static FHudLoading getInstance(){
        if (instance==null){
            instance=new FHudLoading();
        }
        return instance;
    }

    public void showLoading(Context context){
        showHud(context,"",false);
    }

    public void dismissLoading(){
        dismissHud();
    }

    public void showHud(Context context, String message, boolean isCancel) {
        try {
            kProgressHUD=KProgressHUD.create(context, KProgressHUD.Style.SPIN_INDETERMINATE).setAnimationSpeed(1).setDimAmount(0);
            if (!TextUtils.isEmpty(message)) {
                kProgressHUD.setLabel(message).setCancellable(isCancel);
            }
            if (!kProgressHUD.isShowing()){
                kProgressHUD.show();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void dismissHud(){
        if (kProgressHUD!=null){
            if (kProgressHUD.isShowing()){
                kProgressHUD.dismiss();
            }
        }
    }
}
