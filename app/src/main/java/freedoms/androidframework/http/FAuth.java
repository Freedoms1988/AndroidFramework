package freedoms.androidframework.http;

import android.content.Context;
import android.util.Base64;

import com.google.gson.Gson;

import org.cryptonode.jncryptor.AES256JNCryptor;
import org.cryptonode.jncryptor.CryptorException;
import org.cryptonode.jncryptor.JNCryptor;

import java.util.HashMap;
import java.util.Map;

import freedoms.androidframework.cache.FSharePreferences;
import freedoms.androidframework.common.Contant;

/**
 * Created by freedoms on 16/2/2.
 */
public class FAuth {

    public static String buildAuth(Context context,String uri) throws CryptorException{
        Map<String, String> auth = new HashMap<String, String>();
        auth.put("user", (String) FSharePreferences.get(context, "user", "0"));
        auth.put("udid", (String) FSharePreferences.get(context,"udid","0"));
        auth.put("uri", uri);
        Gson gson=new Gson();
        String authjson = gson.toJson(auth);
        JNCryptor cryptor = new AES256JNCryptor();
        byte[] cipher = cryptor.encryptData(authjson.getBytes(), Contant.FAPPSECRET.toCharArray());
        String safe_hash = Base64.encodeToString(cipher, Base64.NO_WRAP);
        return Contant.FAPPKEY + ":" + safe_hash;
    }
}
