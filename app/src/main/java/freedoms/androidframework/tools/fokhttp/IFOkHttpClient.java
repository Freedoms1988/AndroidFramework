package freedoms.androidframework.tools.fokhttp;

import freedoms.androidframework.base.FBaseRequest;

/**
 * Created by freedoms on 2017/3/16.
 */

public interface IFOkHttpClient {
	/*
	查询
	 */
	void getWithJSON(String url,FRequestCallBack callBack);
	/*
	提交
	 */
	void postWithJSON(String url, FBaseRequest request,FRequestCallBack callBack);
	/*
	修改
	 */
	void putWithJSON(String url, FBaseRequest request,FRequestCallBack callBack);
	/*
	删除
	 */
	void deleteWithJSON(String url, FBaseRequest request,FRequestCallBack callBack);
	/*
	上传
	 */
	void postWithFile(String url,String file,FRequestCallBack callBack);

}
