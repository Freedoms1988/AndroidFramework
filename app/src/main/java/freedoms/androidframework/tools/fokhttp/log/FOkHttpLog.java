package freedoms.androidframework.tools.fokhttp.log;

import java.io.IOException;

import freedoms.androidframework.tools.log.FLog;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @Class FOkHttpLog
 * @Auther freedoms
 * @Date 2018/5/24
 * @Decription
 **/

public class FOkHttpLog implements IFOkHttpLog{

	private volatile static FOkHttpLog instance;

	private FOkHttpLog(){

	}

	public static FOkHttpLog getInstance(){
		if(instance==null){
			synchronized (FOkHttpLog.class){
				if (instance==null){
					instance=new FOkHttpLog();
				}
			}
		}
		return instance;
	}

	public void httpHeaderLog(Request request){
		FLog fLog=FLog.getInstance();
		fLog.debug("=============请求信息=============");
		fLog.debug("请求地址："+request.url().toString());
		fLog.debug("请求方式："+request.method());
		fLog.debug("请求头："+request.headers().toString());
		fLog.debug("================================");
	}

	public void httpResponseSuccessLog(Response response){
		try {
			FLog fLog=FLog.getInstance();
			fLog.debug("=============响应信息=============");
			fLog.debug("请求地址："+response.request().url().toString());
			fLog.debug("响应头："+response.headers().toString());
			fLog.debug("响应码："+response.code());
			fLog.debug("响应内容："+response.body().string());
			fLog.debug("================================");
		}catch (IOException e){
			e.printStackTrace();
		}

	}

	public void httpResponseFailureLog(Response response,IOException e){
		FLog fLog=FLog.getInstance();
		fLog.debug("=============请求异常=============");
		fLog.debug("请求地址："+response.request().url().toString());
		fLog.debug("响应头："+response.headers().toString());
		fLog.debug("响应码："+response.code());
		fLog.debug("请求异常："+e.getMessage());
		fLog.debug("================================");
	}
}
