package com.example.mypowerreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver {
    private static final String ACTION_CUSTOM_BROADCAST =
            BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM";

    @Override
    public void onReceive(Context context, Intent intent) {
        //Get action from the intent
        String intentAction = intent.getAction();

        //Check that the intent action is not null
        if (intentAction != null) {

            //Initialize toast message variable with it default value
            String toastMsg = context.getString(R.string.unknown_action_toast);
            //Assign different toast messages according to the intentAction
            switch (intentAction) {
                case Intent.ACTION_POWER_CONNECTED:
                    toastMsg = context.getString(R.string.power_connet_toast);
                    break;
                case Intent.ACTION_POWER_DISCONNECTED:
                    toastMsg = context.getString(R.string.power_disc_toast);
                    break;
                case Intent.ACTION_HEADSET_PLUG:
                    //Assign different toast messages according to the headset state
                    switch (intent.getIntExtra("state", -1)) {
                        case 0:
                            toastMsg = context.getString(R.string.head_unplug_toast);
                            break;
                        case 1:
                            toastMsg = context.getString(R.string.head_plug_toast);
                            break;
                    }
                    break;
                case ACTION_CUSTOM_BROADCAST:
                    toastMsg = context.getString(R.string.custom_broad_toast);
                    break;
            }

            //display the toast
            Toast.makeText(context, toastMsg, Toast.LENGTH_LONG).show();
        }
    }
}
