package exe.boris.targetmaker.view;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
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
import exe.boris.targetmaker.presenter.RegistrationPresenter;
import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;

/**
 * Created by boris on 02.02.15.
 */

@ContentView(R.layout.registration_form)
public class RegistrationActivity extends RoboActivity implements RegistrationView {

    public final static String url = " ";

    @InjectView(R.id.pass_confirm)
    TextView passConfirm;
    @InjectView(R.id.username)
    TextView username;
    @InjectView(R.id.password)
    TextView password;
    @InjectView(R.id.email)
    TextView email;
    RegistrationPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new RegistrationPresenter(this);
   }

    public void registrationBtnHandler(View v) throws JSONException {
            String un = username.getText().toString();
            String eMail = email.getText().toString();
            String pass = password.getText().toString();
            String passConf = passConfirm.getText().toString();
            //Writer writer = new Writer();
            //writer.execute(un, eMail, pass);
            //startActivity(new Intent(this, LoginActivity.class));*/
            presenter.validateRegistration(un, eMail, pass, passConf);
    }


    @Override
    public void setUsernameError() {
        username.setError("");
    }

    @Override
    public void setEmailError() {
        email.setError("");
    }

    @Override
    public void setPasswordError() {
        password.setError("");
    }

    @Override
    public void setConfirmPassError() {
        passConfirm.setError("");
    }

    @Override
    public void showToast() {
        Toast toast = Toast.makeText(this, "Confirmation message was sent to your email. Go to your mail to complete registration", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    @Override
    public void navigateToActivity() {
        startActivity(new Intent(this, LoginActivity.class));
    }

    @Override
    public Context getCurrentContext() {
        return getApplicationContext();
    }

    @Override
    public void setNetworkConnectionError() {
        Toast.makeText(getApplicationContext(), "No internet connection", Toast.LENGTH_LONG).show();
    }
}