package freedoms.androidframework.tools.fokhttp.http;

import freedoms.androidframework.base.FBaseRequest;
import okhttp3.MediaType;

/**
 * @interface IFOkHttpClient
 * @Auther freedoms
 * @Date 2018/5/24
 * @Decription
 **/
public interface IFOkHttpClient {

	MediaType MEDIA_TYPE_JSON = MediaType.parse("applaction/json;charset=utf-8");

	MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("text/x-markdown;charset=utf-8");

	MediaType MEDIA_TYPE_PNG = MediaType.parse("image/png");

	MediaType MEDIA_TYPE_JPEG = MediaType.parse("image/jpeg");

	MediaType MEDIA_TYPE_GIF = MediaType.parse("image/gif");

	MediaType MEDIA_TYPE_PLAIN = MediaType.parse("text/plain");

	MediaType MEDIA_TYPE_XHTML = MediaType.parse("application/xhtml+xml");

	MediaType MEDIA_TYPE_XML = MediaType.parse("application/xml");

	MediaType MEDIA_TYPE_ATOM_XML = MediaType.parse("application/atom+xml");

	MediaType MEDIA_TYPE_PDF = MediaType.parse("application/pdf");

	MediaType MEDIA_TYPE_WORD = MediaType.parse("application/msword");

	MediaType MEDIA_TYPE_STREAM = MediaType.parse("application/octet-stream");
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
