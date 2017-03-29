package freedoms.androidframework.module.demo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import java.io.IOException;

import freedoms.androidframework.R;
import freedoms.androidframework.base.FBaseActivity;
import freedoms.androidframework.base.FBaseRequest;
import freedoms.androidframework.module.demo.view.IDemoView;
import freedoms.androidframework.tools.fokhttp.FOkHttpClient;
import freedoms.androidframework.tools.fokhttp.FRequestCallBack;
import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by freedoms on 2017/3/16.
 */

public class DemoActivity extends FBaseActivity implements IDemoView{
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.demolayout);



		findViewById(R.id.getBTN).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				FOkHttpClient.getInstance().getWithJSON("http://www.baidu.com", new FRequestCallBack() {
					@Override
					public void onFailure(Call call, IOException e) {
						System.out.println("请求错误"+e.toString());
					}

					@Override
					public void onResponse(Call call, Response response) throws IOException {
						System.out.println("请求状态"+response.code());
					}
				});
			}
		});

		findViewById(R.id.postBTN).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				FBaseRequest request=new FBaseRequest();

				FOkHttpClient.getInstance().postWithJSON("http://www.baidu.com",request,new FRequestCallBack(){
					@Override
					public void onFailure(Call call, IOException e) {
						System.out.println("请求错误"+e.toString());
					}

					@Override
					public void onResponse(Call call, Response response) throws IOException {
						System.out.println("请求状态"+response.code());
					}
				});
			}
		});

		findViewById(R.id.putBTN).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				FBaseRequest request=new FBaseRequest();
				FOkHttpClient.getInstance().putWithJSON("http://www.baidu.com", request, new FRequestCallBack() {
					@Override
					public void onFailure(Call call, IOException e) {
						System.out.println("请求错误"+e.toString());
					}

					@Override
					public void onResponse(Call call, Response response) throws IOException {
						System.out.println("请求状态"+response.code());
					}
				});
			}
		});

		findViewById(R.id.deleteBTN).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				FBaseRequest request=new FBaseRequest();
				FOkHttpClient.getInstance().deleteWithJSON("http://www.baidu.com", request, new FRequestCallBack() {
					@Override
					public void onFailure(Call call, IOException e) {
						System.out.println("请求错误"+e.toString());
					}

					@Override
					public void onResponse(Call call, Response response) throws IOException {
						System.out.println("请求状态"+response.code());
					}
				});
			}
		});
	}

	@Override
	public void sendGetRequest() {

	}

	@Override
	public void sendPostRequest() {

	}

	@Override
	public void sendPutRequest() {

	}

	@Override
	public void sendDeleteRequest() {

	}
}
