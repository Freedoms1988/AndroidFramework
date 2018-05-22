package freedoms.androidframework.tools.fokhttp.log;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @Class FOkHttpLogInterceptor
 * @Auther freedoms
 * @Date 2018/5/22
 * @Decription
 **/
public class FOkHttpLogInterceptor implements Interceptor {

	@Override
	public Response intercept(Chain chain) {
		long startTime=System.currentTimeMillis();
		long endTime=0;
		Request request=chain.request();
		Response response=null;
		Log.d("freedoms","=============请求信息=============");
		Log.d("freedoms","请求地址："+request.url().toString());
		Log.d("freedoms","请求头："+request.headers().toString());
		Log.d("freedoms","请求杂项："+chain.connection());
		Log.d("freedoms","=================================");
		try {
			response=chain.proceed(request);
			endTime=System.currentTimeMillis();
			Log.d("freedoms","=============响应信息=============");
			Log.d("freedoms","请求地址："+response.request().url().toString());
			Log.d("freedoms","响应头："+response.headers().toString());
			Log.d("freedoms","请求时间："+(endTime-startTime)+"ms");
			Log.d("freedoms","响应内容："+response.body().string());
			Log.d("freedoms","=================================");
		}catch (IOException e){
			Log.d("freedoms","=============请求异常=============");
			Log.d("freedoms","请求地址："+response.request().url().toString());
			Log.d("freedoms","请求认证头："+response.headers().toString());
			Log.d("freedoms","请求时间："+(endTime-startTime)+"ms");
			Log.d("freedoms","请求异常："+e.getMessage());
			Log.d("freedoms","=================================");
			e.printStackTrace();
		}
		return response;
	}
}
