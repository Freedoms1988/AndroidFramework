package freedoms.androidframework.tools.app;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import freedoms.androidframework.application.FApplication;

/**
 * @Class FApp
 * @Auther freedoms
 * @Date 2018/5/24
 * @Decription
 **/
public class FApp {

	public static String getClientVersion(){
		PackageManager pm = FApplication.getInstance().getApplicationContext().getPackageManager();
		String versionName=null;
		try {
			PackageInfo pi = pm.getPackageInfo(FApplication.getInstance().getApplicationContext().getPackageName(), 0);
			versionName=pi.versionName;
		} catch (PackageManager.NameNotFoundException e) {
			e.printStackTrace();
		}
		return versionName;
	}
}
