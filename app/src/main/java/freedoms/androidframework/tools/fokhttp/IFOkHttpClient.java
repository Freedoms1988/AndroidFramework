package freedoms.androidframework.tools.fokhttp;

import freedoms.androidframework.base.FBaseRequest;

/**
 * Created by freedoms on 2017/3/16.
 */

public interface IFOkHttpClient {
	void getWithJSON(String url,FRequestCallBack callBack);

	void postWithJSON(String url, FBaseRequest request,FRequestCallBack callBack);

	void putWithJSON(String url, FBaseRequest request,FRequestCallBack callBack);

	void deleteWithJSON(String url, FBaseRequest request,FRequestCallBack callBack);

	void postWithFile(String url,String file,FRequestCallBack callBack);

}
