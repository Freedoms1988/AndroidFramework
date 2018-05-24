package freedoms.androidframework.tools.fokhttp.log;

import java.io.IOException;

import okhttp3.Request;
import okhttp3.Response;

/**
 * @interface IFOkHttpLog
 * @Auther freedoms
 * @Date 2018/5/24
 * @Decription
 **/

public interface IFOkHttpLog {

	void httpHeaderLog(Request request);

	void httpResponseSuccessLog(Response response);

	void httpResponseFailureLog(Response response,IOException e);

}
