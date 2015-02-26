package exe.boris.targetmaker.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ConnectionReceiver extends BroadcastReceiver {
    public ConnectionReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (!(NetworkInformation.checkInternetConnection(context))) {
            Toast.makeText(context, "No internet connection", Toast.LENGTH_LONG).show();
        }
    }
}
