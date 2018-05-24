package freedoms.androidframework.tools.fokhttp.log;

import java.io.IOException;

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
		long startTime=System.currentTimeMillis();
		long endTime=0;
		Request request=chain.request();
		Response response=null;
		FLog.debug("=============请求信息=============");
		FLog.debug("请求地址："+request.url().toString());
		FLog.debug("请求方式："+request.method());
		FLog.debug("请求头："+request.headers().toString());
		FLog.debug("请求杂项："+chain.connection());
		FLog.debug("================================");
		try {
			response=chain.proceed(request);
			endTime=System.currentTimeMillis();
			FLog.debug("=============响应信息=============");
			FLog.debug("请求地址："+response.request().url().toString());
			FLog.debug("响应头："+response.headers().toString());
			FLog.debug("请求时间："+(endTime-startTime)+"ms");
			FLog.debug("响应内容："+response.body().string());
			FLog.debug("================================");
		}catch (IOException e){
			FLog.debug("=============请求异常=============");
			FLog.debug("请求地址："+response.request().url().toString());
			FLog.debug("响应头："+response.headers().toString());
			FLog.debug("请求时间："+(endTime-startTime)+"ms");
			FLog.debug("请求异常："+e.getMessage());
			FLog.debug("================================");
			e.printStackTrace();
		}
		return response;
	}
}
