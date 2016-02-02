package freedoms.androidframework.base;

import android.content.Context;

import org.cryptonode.jncryptor.CryptorException;
import org.xutils.http.RequestParams;

import freedoms.androidframework.http.FAuth;

/**
 * Created by freedoms on 16/2/2.
 */
public class FBaseRequestParam extends RequestParams{

    public FBaseRequestParam(Context context,String url) throws CryptorException{
        super(url);
        addHeader("AUTH_KEY", FAuth.buildAuth(context,url));
    }
}
