package freedoms.androidframework.http;

import android.content.Context;

import com.google.gson.Gson;

import org.cryptonode.jncryptor.CryptorException;
import org.xutils.common.Callback;
import org.xutils.http.HttpMethod;
import org.xutils.http.app.ResponseParser;
import org.xutils.http.request.UriRequest;
import org.xutils.x;

import java.lang.reflect.Type;
import java.util.Map;

import freedoms.androidframework.base.FBaseRequestParam;

/**
 * Created by freedoms on 16/2/2.
 */
public class FHttp {
    /**
     * 发送get请求
     *
     * @param <T>
     */
    public static <T> Callback.Cancelable Get(Context context,String url, Map<String, String> map, Callback.CommonCallback<T> callback){
        Callback.Cancelable cancelable=null;
        try {
            FBaseRequestParam params = new FBaseRequestParam(context,url);
            if (null != map) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    params.addQueryStringParameter(entry.getKey(), entry.getValue());
                }
            }
           cancelable = x.http().get(params, callback);
        }catch (CryptorException e){
            e.printStackTrace();
        }
        return cancelable;
    }

    /**
     * 发送Post请求
     *
     * @param url 请求地址
     * @param map 请求body参数
     * @param callback 请求响应回调
     * @param <T>
     * @return
     */
    public static <T> Callback.Cancelable Post(Context context,String url, Map<String, String> map, Callback.CommonCallback<T> callback){
        Callback.Cancelable cancelable=null;
        try {
            FBaseRequestParam params = new FBaseRequestParam(context,url);
            if (null != map) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    params.addParameter(entry.getKey(), entry.getValue());
                }
            }
            cancelable = x.http().post(params, callback);
        }catch (CryptorException e){
            e.printStackTrace();
        }

        return cancelable;
    }

    /**
     * 发送Put请求
     *
     * @param url 请求地址
     * @param map 请求body参数
     * @param callback 请求响应回调
     * @param <T>
     * @return
     */
    public static <T> Callback.Cancelable Put(Context context,String url,Map<String,String> map,Callback.CommonCallback<T> callback){
        Callback.Cancelable cancelable=null;
        try {
            FBaseRequestParam params = new FBaseRequestParam(context,url);
            if (null != map){
                for (Map.Entry<String,String> entry:map.entrySet()) {
                    params.addParameter(entry.getKey(), entry.getValue());
                }
            }
            cancelable = x.http().request(HttpMethod.PUT, params, callback);
        }catch (CryptorException e){
            e.printStackTrace();
        }
        return  cancelable;
    }

    /**
     * 发送Delete请求
     *
     * @param url 请求地址
     * @param map 请求body参数
     * @param callback 请求响应回调
     * @param <T>
     * @return
     */
    public static <T> Callback.Cancelable Delete(Context context,String url,Map<String,String> map,Callback.CommonCallback<T> callback){
        Callback.Cancelable cancelable=null;
        try {
            FBaseRequestParam params = new FBaseRequestParam(context,url);
            if (null != map){
                for (Map.Entry<String,String> entry:map.entrySet()){
                    params.addParameter(entry.getKey(),entry.getValue());
                }
            }
            cancelable = x.http().request(HttpMethod.DELETE, params, callback);
        }catch (CryptorException e){
            e.printStackTrace();
        }
        return  cancelable;
    }

    /**
     * 上传文件
     *
     * @param url 上传文件地址
     * @param map 上传文件参数
     * @param callback 请求响应回调
     * @param <T>
     * @return
     */
    public static <T> Callback.Cancelable UpLoadFile(Context context,String url, Map<String, Object> map, Callback.CommonCallback<T> callback){
        Callback.Cancelable cancelable=null;
        try {
            FBaseRequestParam params = new FBaseRequestParam(context,url);
            if (null != map) {
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    params.addParameter(entry.getKey(), entry.getValue());
                }
            }
            params.setMultipart(true);
            cancelable = x.http().get(params, callback);
        }catch (CryptorException e){
            e.printStackTrace();
        }
        return cancelable;
    }

    /**
     * 下载文件
     *
     * @param url 下载文件路径
     * @param filepath 本地保存路径
     * @param callback 请求响应回调
     * @param <T>
     * @return
     */
    public static <T> Callback.Cancelable DownLoadFile(Context context,String url, String filepath, Callback.CommonCallback<T> callback){
        Callback.Cancelable cancelable=null;
        try {
            FBaseRequestParam params = new FBaseRequestParam(context,url);
            //设置断点续传params.setAutoResume(true);
            params.setSaveFilePath(filepath);
            cancelable = x.http().get(params, callback);
        }catch (CryptorException e){
            e.printStackTrace();
        }
        return cancelable;
    }

    /**
     * 请求回调
     * @param <ResultType>
     */
    public static class RequestCallBack<ResultType> implements Callback.CommonCallback<ResultType> {
        @Override
        public void onSuccess(ResultType result) {
            //可以根据公司的需求进行统一的请求成功的逻辑处理
        }

        @Override
        public void onError(Throwable ex, boolean isOnCallback) {
            //可以根据公司的需求进行统一的请求网络失败的逻辑处理
        }

        @Override
        public void onCancelled(CancelledException cex) {

        }

        @Override
        public void onFinished() {

        }
    }

    /**
     * 多媒体文件上传及下载进度回调
     * @param <ResultType>
     */
    public static class RequestProgressCallBack<ResultType> implements Callback.ProgressCallback<ResultType>{
        @Override
        public void onSuccess(ResultType resultType) {

        }

        @Override
        public void onCancelled(CancelledException e) {

        }

        @Override
        public void onError(Throwable throwable, boolean b) {

        }

        @Override
        public void onLoading(long l, long l1, boolean b) {

        }

        @Override
        public void onStarted() {

        }

        @Override
        public void onWaiting() {

        }

        @Override
        public void onFinished() {

        }
    }

    public class JsonResponseParser implements ResponseParser {
        //检查服务器返回的响应头信息
        @Override
        public void checkResponse(UriRequest request) throws Throwable {

        }

        /**
         * 转换result为resultType类型的对象
         *
         * @param resultType  返回值类型(可能带有泛型信息)
         * @param resultClass 返回值类型
         * @param result      字符串数据
         * @return
         * @throws Throwable
         */
        @Override
        public Object parse(Type resultType, Class<?> resultClass, String result) throws Throwable {
            return new Gson().fromJson(result, resultClass);
        }
    }
}
