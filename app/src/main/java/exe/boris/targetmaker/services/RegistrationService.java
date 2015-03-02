package exe.boris.targetmaker.services;

/**
 * Created by boris on 19.02.15.
 */

import android.os.AsyncTask;
import android.text.TextUtils;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import exe.boris.targetmaker.presenter.OnLoginFinishedListener;
import exe.boris.targetmaker.presenter.OnRegistrationFinishedListener;
import exe.boris.targetmaker.view.NetworkInformation;

public class RegistrationService {

    private static String url = " ";

    public void register(String username, String email, String password, String confPassword, OnRegistrationFinishedListener listener) throws IOException, JSONException {
        boolean error = false;
        if (TextUtils.isEmpty(username)) {
            error = true;
            listener.onUsernameError();
        }
        if (TextUtils.isEmpty(email)) {
            error = true;
            listener.onEmailError();
        }
        if (TextUtils.isEmpty(password)) {
            error = true;
            listener.onPasswordError();
        }
        if (TextUtils.isEmpty(confPassword)) {
            error = true;
            listener.onConfirmPassError();
        }
        if (!password.equals(confPassword)) {
            error = true;
            listener.onConfirmPassErr();
        }
        if (!NetworkInformation.checkInternetConnection(listener.getContext())) {
            error = true;
            listener.onNetworkConnectionError();
        }
        if (!error) {
            /*HttpClient client = new DefaultHttpClient();
            HttpPost post = new HttpPost(url);
            StringEntity stringEntity = new StringEntity(createJSONObject(username, email, password).toString());
            post.setEntity(stringEntity);
            HttpResponse response = client.execute(post);*/
            listener.onSuccess();
        }
    }

    public JSONObject createJSONObject(String username, String email, String password) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", username);
        jsonObject.putOpt("email", email);
        jsonObject.put("password", password);
        return jsonObject;
    }
}

