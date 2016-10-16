package ms.gwillia.notif_test;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

/**
 * Created by encima on 16/10/2016.
 */

public class NotifBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        android.support.v4.app.NotificationCompat.Builder builder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Beanie Notification")
                        .setContentText("It's Birthday today!")
                        .setDefaults(Notification.DEFAULT_ALL);
        Log.e("MSG", "NOTIF RECEIVED");


        NotificationManager notificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(001, builder.build());
    }
}
