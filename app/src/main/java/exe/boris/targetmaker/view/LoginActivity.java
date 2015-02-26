package exe.boris.targetmaker.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import exe.boris.targetmaker.R;
import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;

/**
 * Created by boris on 02.02.15.
 */
@ContentView(R.layout.login_form)
public class LoginActivity extends RoboActivity {

    @InjectView(R.id.username_log) TextView username;
    @InjectView(R.id.pass_log) TextView password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void loginBtnHandler(View view) throws FileNotFoundException, JSONException {
        if (isFieldsFilled() && isFieldsValid()) {
            String un = username.getText().toString();
            String pass = password.getText().toString();
            String date = CurrentDate.createCurrentDate();
            Log.v("now", date);
            //UserLogin userLogin = new UserLogin();
            //userLogin.execute();
            startActivity(new Intent(this, MainActivity.class));
        }

    }

    public boolean isFieldsValid() throws FileNotFoundException, JSONException {
        JSONObject jsonObject = new Reader().readFromFile();
        if ((username.getText().toString().compareTo(getUserNameFromJSON(jsonObject))) != 0) {
            return false;
        }
        if ((password.getText().toString().compareTo(getPasswordFromJSON(jsonObject))) != 0) {
            return false;
        }
        return true;
    }

    public boolean isFieldsFilled() {
        if (username.getText().toString().length() == 0) {
            username.requestFocus();
            return false;
        }

        if (password.getText().length() == 0) {
            password.requestFocus();
            return false;
        }
        return true;
    }

    public void startRegistrationForm(View v) {
        startActivity(new Intent(this, RegistrationActivity.class));
    }

    public String getUserNameFromJSON(JSONObject jsonObject) throws JSONException {
        return jsonObject.getString("username");
    }

    public String getPasswordFromJSON(JSONObject jsonObject) throws JSONException {
        return jsonObject.getString("password");
    }

    public class Reader {

        String fileName = "registration.txt";

        protected JSONObject readFromFile() throws FileNotFoundException {
            File sdCard = Environment.getExternalStorageDirectory();
            File dir = new File(sdCard.getAbsolutePath(), "/");
            File file = new File(dir, fileName);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            JSONObject jsonObject = null;
            try {
                while ((line = br.readLine()) != null) {
                    stringBuilder.append(line);
                    stringBuilder.append("/n");
                }
                br.close();
                jsonObject = new JSONObject(stringBuilder.toString());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jsonObject;
        }
    }
}
