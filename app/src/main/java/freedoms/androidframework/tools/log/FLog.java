package freedoms.androidframework.tools.log;

import android.util.Log;

/**
 * @Class FLog
 * @Auther freedoms
 * @Date 2018/5/22
 * @Decription
 **/
public class FLog {

	public static void debug(String string){
		Log.d("freedoms",string);
	}

	public static void error(String string){
		Log.e("freedoms",string);
	}

	public static void info(String string){
		Log.i("freedoms",string);
	}

	public static void verbose(String string){
		Log.v("freedoms",string);
	}

	public static void warn(String string){
		Log.w("freedoms",string);
	}

}
