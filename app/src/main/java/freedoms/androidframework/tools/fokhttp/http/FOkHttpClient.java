package freedoms.androidframework.tools.fokhttp.http;

import android.os.Build;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import freedoms.androidframework.tools.app.FApp;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import freedoms.androidframework.base.FBaseRequest;

/**
 * @Class FOkHttpClient
 * @Auther freedoms
 * @Date 2018/5/24
 * @Decription
 **/

public class FOkHttpClient implements IFOkHttpClient {

	private static FOkHttpClient instance;

	private static OkHttpClient client;


	private FOkHttpClient() {

	}

	public static FOkHttpClient getInstance() {
		if (instance == null) {
			synchronized (FOkHttpClient.class) {
				if (instance == null) {
					instance = new FOkHttpClient();
					client = new OkHttpClient.Builder().addInterceptor(new FOkHttpLogInterceptor())
							.connectTimeout(1000, TimeUnit.SECONDS)
							.writeTimeout(1000,TimeUnit.SECONDS)
							.readTimeout(1000,TimeUnit.SECONDS).build();

				}
			}
		}
		return instance;
	}

	@Override
	public void getWithJSON(String url, final FRequestCallBack callBack) {
		final Request getRequest = new Request.Builder().url(url).removeHeader("User-Agent").addHeader("User-Agent",getUserAgent(okhttp3.internal.Version.userAgent())).build();
		Call call = client.newCall(getRequest);
		call.enqueue(new Callback() {
			@Override
			public void onFailure(Call call, IOException e) {
				callBack.onFailure(call, e);
			}

			@Override
			public void onResponse(Call call, Response response) throws IOException {
				callBack.onResponse(call, response);
			}
		});
	}

	@Override
	public void postWithJSON(String url, FBaseRequest request, final FRequestCallBack callBack) {
		RequestBody requestBody = RequestBody.create(MEDIA_TYPE_JSON, requestToJson(request));
		final Request postRequest = new Request.Builder().url(url).post(requestBody).removeHeader("User-Agent").addHeader("User-Agent",getUserAgent(okhttp3.internal.Version.userAgent())).build();
		Call call = client.newCall(postRequest);
		call.enqueue(new Callback() {
			@Override
			public void onFailure(Call call, IOException e) {
				callBack.onFailure(call, e);
			}

			@Override
			public void onResponse(Call call, Response response) throws IOException {
				callBack.onResponse(call, response);
			}
		});
	}

	@Override
	public void putWithJSON(String url, FBaseRequest request, final FRequestCallBack callBack) {
		RequestBody requestBody=RequestBody.create(MEDIA_TYPE_JSON,requestToJson(request));
		final Request putRequest=new Request.Builder().url(url).put(requestBody).removeHeader("User-Agent").addHeader("User-Agent",getUserAgent(okhttp3.internal.Version.userAgent())).build();
		Call call=client.newCall(putRequest);
		call.enqueue(new Callback() {
			@Override
			public void onFailure(Call call, IOException e) {
				callBack.onFailure(call,e);
			}

			@Override
			public void onResponse(Call call, Response response) throws IOException {
				callBack.onResponse(call,response);
			}
		});
	}

	@Override
	public void deleteWithJSON(String url, FBaseRequest request, final FRequestCallBack callBack) {
		RequestBody requestBody=RequestBody.create(MEDIA_TYPE_JSON,requestToJson(request));
		final Request deleteRequest=new Request.Builder().url(url).delete(requestBody).removeHeader("User-Agent").addHeader("User-Agent",getUserAgent(okhttp3.internal.Version.userAgent())).build();
		Call call=client.newCall(deleteRequest);
		call.enqueue(new Callback() {
			@Override
			public void onFailure(Call call, IOException e) {
				callBack.onFailure(call,e);
			}

			@Override
			public void onResponse(Call call, Response response) throws IOException {
				callBack.onResponse(call,response);
			}
		});
	}

	@Override
	public void postWithFile(String url, String file, FRequestCallBack callBack) {

	}

	private String requestToJson(FBaseRequest request) {
		return new Gson().toJson(request);
	}

	private Object jsonToResponse(String json,Class clazz) {
		return new Gson().fromJson(json,clazz);
	}


	private String getUserAgent(String okhttpUserAgent) {
		String userAgent = "";
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
			try {
				userAgent = System.getProperty("http.agent");
			} catch (Exception e) {
				userAgent = System.getProperty("http.agent");
			}
		} else {
			userAgent = System.getProperty("http.agent");
		}
		String[] string=userAgent.split("\\(");
		String string2= FApp.getClientVersion()+" "+okhttpUserAgent+" "+"("+string[1];
		StringBuffer sb = new StringBuffer();
		for (int i = 0, length = string2.length(); i < length; i++) {
			char c = string2.charAt(i);
			if (c <= '\u001f' || c >= '\u007f') {
				sb.append(String.format("\\u%04x", (int) c));
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}
}
