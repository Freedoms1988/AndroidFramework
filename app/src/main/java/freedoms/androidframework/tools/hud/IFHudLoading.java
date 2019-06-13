package freedoms.androidframework.tools.hud;

import android.content.Context;

/**
 * @Class IFHudLoading
 * @Auther freedoms
 * @Date 2018/5/24
 * @Decription
 **/
public interface IFHudLoading {

	void showLoading(Context context);

	void dismissLoading();

	void showHud(Context context, String message, boolean isCancel);

	void dismissHud();
}
