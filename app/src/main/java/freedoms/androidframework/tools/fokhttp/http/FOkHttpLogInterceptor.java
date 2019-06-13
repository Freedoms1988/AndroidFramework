package freedoms.androidframework.tools.fokhttp.http;

import java.io.IOException;

import freedoms.androidframework.tools.fokhttp.log.FOkHttpLog;
import freedoms.androidframework.tools.log.FLog;
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
		Request request=chain.request();
		Response response=null;
		FOkHttpLog.getInstance().httpHeaderLog(request);
		try {
			response=chain.proceed(request);
			FOkHttpLog.getInstance().httpResponseSuccessLog(response);
		}catch (IOException e){
			FOkHttpLog.getInstance().httpResponseFailureLog(response,e);
			e.printStackTrace();
		}
		return response;
	}
}
