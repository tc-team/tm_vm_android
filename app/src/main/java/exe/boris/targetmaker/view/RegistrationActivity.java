package exe.boris.targetmaker.view;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Environment;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import exe.boris.targetmaker.R;
import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;

/**
 * Created by boris on 02.02.15.
 */

@ContentView(R.layout.registration_form)
public class RegistrationActivity extends RoboActivity {

    public final static String url = "";

    @InjectView(R.id.pass_confirm)
    TextView passConfirm;
    @InjectView(R.id.username)
    TextView username;
    @InjectView(R.id.password)
    TextView password;
    @InjectView(R.id.email)
    TextView email;

   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);}*/

    public void registrationBtnHandler(View v) throws JSONException {
        if(isFieldsValidate()) {
            String un = username.getText().toString();
            String eMail = email.getText().toString();
            String pass = password.getText().toString();
            String passConf = passConfirm.getText().toString();
            Writer writer = new Writer();
            writer.execute(un, eMail, pass);
            //Log.v("test", this.createJSONObject(un, eMail, pass).toString());
            //CreateUser user = new CreateUser();
            //user.execute(url, un, eMail, pass);
            Toast toast = Toast.makeText(this, "Confirmation message was sent to your email. Go to your mail to complete registration", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            startActivity(new Intent(this, LoginActivity.class));
        }
    }

    public boolean isFieldsValidate() {
        if (username.getText().toString().length() == 0 ) {
            username.requestFocus();
            return false;
        }

        if (email.getText().toString().length() == 0) {
            email.requestFocus();
            return false;
        }

        if (password.getText().toString().length() == 0) {
            password.requestFocus();
            return false;
        }

        if (passConfirm.getText().toString().length() == 0) {
            passConfirm.requestFocus();
            return false;
        }

        if(!(passConfirm.getText().toString().equals(password.getText().toString()))) {
            passConfirm.requestFocus();
            return false;
        }
        return true;
    }

    public JSONObject createJSONObject (String username, String email, String password) throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", username);
        jsonObject.put("email", email);
        jsonObject.put("password", password);
        return jsonObject;
    }

    public class Writer extends AsyncTask<String, Void, Void> {

        public String fileName = "registration.txt";

        @Override
        protected Void doInBackground(String... params) {
            try {
                writeToFile(params[0], params[1], params[2]);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        protected void writeToFile(String userName, String email, String password) throws IOException, JSONException {
            File sdCard = Environment.getExternalStorageDirectory();
            File dir = new File(sdCard.getAbsolutePath() + "/");
            File file = new File(dir, fileName);
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(createJSONObject(userName, email, password).toString().getBytes());
            fos.close();
        }
    }
}