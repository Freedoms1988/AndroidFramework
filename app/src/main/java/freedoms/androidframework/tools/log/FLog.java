package freedoms.androidframework.tools.log;

import android.util.Log;

/**
 * @Class FLog
 * @Auther freedoms
 * @Date 2018/5/22
 * @Decription
 **/
public class FLog implements IFlog{

	private static FLog instance;

	private FLog(){

	}

	public static FLog getInstance(){
		if (instance==null){
			synchronized (FLog.class){
				instance=new FLog();
			}
		}
		return instance;
	}

	public void debug(String string){
		Log.d("freedoms",string);
	}

	public void error(String string){
		Log.e("freedoms",string);
	}

	public void info(String string){
		Log.i("freedoms",string);
	}

	public void verbose(String string){
		Log.v("freedoms",string);
	}

	public void warn(String string){
		Log.w("freedoms",string);
	}

}
