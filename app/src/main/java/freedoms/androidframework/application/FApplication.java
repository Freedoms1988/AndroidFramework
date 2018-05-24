package freedoms.androidframework.application;

import android.app.Application;

/**
 * @Class FApplication
 * @Auther freedoms
 * @Date 2018/5/23
 * @Decription
 **/
public class FApplication extends Application {

	public volatile static FApplication instance;

	public static FApplication getInstance(){
		if (instance==null){
			synchronized (FApplication.class){
				if (instance==null){
					instance=new FApplication();
				}
			}
		}
		return instance;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		instance=this;
	}

}
