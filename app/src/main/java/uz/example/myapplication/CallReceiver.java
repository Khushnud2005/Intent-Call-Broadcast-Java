package uz.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.widget.Toast;
import java.util.Objects;

public class CallReceiver extends BroadcastReceiver {
    public String phoneNumber;
    @Override
    public void onReceive(Context context, Intent intent) {

        if (Objects.equals(intent.getStringExtra(TelephonyManager.EXTRA_STATE), TelephonyManager.EXTRA_STATE_OFFHOOK)){
            Toast.makeText(context,"Phone call is stared...",Toast.LENGTH_LONG).show();
        }else if (Objects.equals(intent.getStringExtra(TelephonyManager.EXTRA_STATE), TelephonyManager.EXTRA_STATE_IDLE)){
            Toast.makeText(context,"Phone call is ended...",Toast.LENGTH_LONG).show();
        }else if (intent.getStringExtra(TelephonyManager.EXTRA_STATE).equals(TelephonyManager.EXTRA_STATE_RINGING)){
            phoneNumber = intent.getExtras().getString("incoming_number");
            if (phoneNumber !=null){
                Toast.makeText(context,"Incoming Call..."+phoneNumber,Toast.LENGTH_LONG).show();
            }
        }

    }
}
