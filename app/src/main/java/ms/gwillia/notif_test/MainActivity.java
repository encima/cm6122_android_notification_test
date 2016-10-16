package ms.gwillia.notif_test;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Calendar c = Calendar.getInstance();
        c.set(Calendar.MINUTE, c.get(Calendar.MINUTE)+1);
        
        AlarmManager alarmManager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);

        NotifBroadcastReceiver NotifBroadcastReceiver = new NotifBroadcastReceiver();
        IntentFilter filter = new IntentFilter("ALARM_ACTION");
        registerReceiver(NotifBroadcastReceiver, filter);

        Intent intent = new Intent("ALARM_ACTION");
        intent.putExtra("test", "action test");
        PendingIntent operation = PendingIntent.getBroadcast(this, 0, intent, 0);

        alarmManager.set(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), operation);
    }
}
