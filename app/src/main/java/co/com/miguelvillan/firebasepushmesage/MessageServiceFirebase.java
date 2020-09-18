package co.com.miguelvillan.firebasepushmesage;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

class MessageServiceFirebase extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        String from = remoteMessage.getFrom();
        Log.d("SALIDA", "mensaje recibido de "+from);

        if(remoteMessage.getNotification() != null){
            Log.d("SALIDA", "message obtained ="+ remoteMessage.getNotification().getBody());
        }

    }

    @Override
    public void onNewToken(@NonNull String token) {
        super.onNewToken(token);

        Log.d("SALIDA", token);


    }
}
