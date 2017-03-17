package freedoms.androidframework.tools.fokhttp;


import com.google.gson.Gson;

import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import freedoms.androidframework.base.FBaseRequest;

/**
 * Created by freedoms on 2017/3/16.
 */

public class FOkHttpClient implements IFOkHttpClient {

	private static FOkHttpClient instance;

	private static OkHttpClient client;

	private static final MediaType JSON = MediaType.parse("applaction/json;charset=utf-8");

	private static final MediaType MARKDOWN = MediaType.parse("text/x-markdown; charset=utf-8");

	private static final MediaType IMAGE = MediaType.parse("image/png");

	private FOkHttpClient() {
	}

	public static FOkHttpClient getInstance() {
		if (instance == null) {
			synchronized (FOkHttpClient.class) {
				if (instance == null) {
					instance = new FOkHttpClient();
					client = new OkHttpClient();
				}
			}
		}
		return instance;
	}

	@Override
	public void getWithJSON(String url, final FRequestCallBack callBack) {
		final Request getRequest = new Request.Builder().url(url).build();
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
		RequestBody requestBody = RequestBody.create(JSON, requestToJson(request));
		final Request postRequest = new Request.Builder().url(url).post(requestBody).build();
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
		RequestBody requestBody=RequestBody.create(JSON,requestToJson(request));
		final Request putRequest=new Request.Builder().url(url).put(requestBody).build();
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
		RequestBody requestBody=RequestBody.create(JSON,requestToJson(request));
		final Request deleteRequest=new Request.Builder().url(url).delete(requestBody).build();
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

}