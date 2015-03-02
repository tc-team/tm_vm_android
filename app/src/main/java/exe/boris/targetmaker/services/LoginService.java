package exe.boris.targetmaker.services;

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

/**
 * Created by boris on 19.02.15.
 */
 public class LoginService {

    private static String url = " ";

        public void login(String username, String password, OnLoginFinishedListener listener) throws IOException, JSONException {
            boolean error = true;
            if (TextUtils.isEmpty(username)) {
                error = true;
                listener.onUsernameError();
            }
            if (TextUtils.isEmpty(password)) {
                error = true;
                listener.onPasswordError();
            }
            if (!error) {
                HttpClient client = new DefaultHttpClient();
                HttpPost post = new HttpPost(url);
                StringEntity se = new StringEntity(createJSONObject(username, password).toString());
                post.setEntity(se);
                HttpResponse response = client.execute(post);
                listener.onSucces();
            }
        }

        public JSONObject createJSONObject(String username, String password) throws JSONException {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("username", username);
            jsonObject.put("password", password);
            return jsonObject;
        }
 }
