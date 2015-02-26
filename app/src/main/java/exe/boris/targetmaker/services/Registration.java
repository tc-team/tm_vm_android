package exe.boris.targetmaker.services;

/**
 * Created by boris on 19.02.15.
 */

import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class Registration extends AsyncTask<String, Void, Void> {

    @Override
    protected Void doInBackground(String... params) {
        try {
            makeHttpRequest(params[0], params[1], params[2], params[3]);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected void makeHttpRequest(String url, String username, String email, String password) throws IOException, JSONException {
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);
        StringEntity stringEntity = new StringEntity(createJSONObject(username, email, password).toString());
        post.setEntity(stringEntity);
        HttpResponse response = client.execute(post);
    }

    public JSONObject createJSONObject(String username, String email, String password) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", username);
        jsonObject.putOpt("email", email);
        jsonObject.put("password", password);
        return jsonObject;
    }
}

