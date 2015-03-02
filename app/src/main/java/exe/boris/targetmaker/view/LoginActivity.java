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
import exe.boris.targetmaker.presenter.LoginPresenter;
import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;

/**
 * Created by boris on 02.02.15.
 */
@ContentView(R.layout.login_form)
public class LoginActivity extends RoboActivity implements LoginView {

    @InjectView(R.id.username_log) TextView username;
    @InjectView(R.id.pass_log) TextView password;
    LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new LoginPresenter(this);
    }

    public void loginBtnHandler(View view) throws FileNotFoundException, JSONException {
        /*if (isFieldsFilled() && isFieldsValid()) {
            String un = username.getText().toString();
            String pass = password.getText().toString();
            String date = CurrentDate.createCurrentDate();
            Log.v("now", date);
            startActivity(new Intent(this, MainActivity.class));*/
            //presenter.validateLogin(un, pass);
    }

    public void startRegistrationForm(View v) {
        presenter.onStartActivity();
    }

    @Override
    public void setUsernameError() {
        username.setError("");
    }

    @Override
    public void setPasswordError() {
        password.setError("");
    }

    @Override
    public void navigateToMainActivity() {
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public void navigateToRegistrationActivity() {
        startActivity(new Intent(this, RegistrationActivity.class));
    }
}
