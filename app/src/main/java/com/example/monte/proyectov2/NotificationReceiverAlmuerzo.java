package com.example.monte.proyectov2;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

public class NotificationReceiverAlmuerzo extends BroadcastReceiver {
    String channelId = "some_channel_id";

    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationManager notificationManager = (NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);

        Intent repIntent = new Intent(context, Alimentacion.class);
        repIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(context,120,repIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, channelId).setAutoCancel(true).
                setContentIntent(pendingIntent).setContentTitle("Almuerzo").
                setContentText("Go eat").setSmallIcon(R.drawable.alarma);

        notificationManager.notify(120,builder.build());

    }
}
