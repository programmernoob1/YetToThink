package com.example.santy.yettothink;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NotifService extends Service {
    private Context context;
    FirebaseDatabase database=FirebaseDatabase.getInstance();
    DatabaseReference messageDatabaseReference;
    FirebaseAuth auth;
    public NotifService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        auth=FirebaseAuth.getInstance();
        messageDatabaseReference=database.getReference().child("messages");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.i("Check","In on start");
                messageDatabaseReference.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                        Message message=dataSnapshot.getValue(Message.class);
                        Intent intent = new Intent(NotifService.this, HomeActivity.class);
                        PendingIntent pIntent = PendingIntent.getActivity(NotifService.this, (int) System.currentTimeMillis(), intent, 0);
                        Notification n  = new Notification.Builder(NotifService.this)
                                .setContentTitle(message.getName())
                                .setContentText(message.getText())
                                .setSmallIcon(R.drawable.icon)
                                .setContentIntent(pIntent)
                                .setAutoCancel(true).build();
                        NotificationManager notificationManager =
                                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                        notificationManager.notify(0, n);
                    }

                    @Override
                    public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                    }

                    @Override
                    public void onChildRemoved(DataSnapshot dataSnapshot) {

                    }

                    @Override
                    public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });


            }
        }).start();
        return Service.START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.i("Check","In destroy");
        super.onDestroy();

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
