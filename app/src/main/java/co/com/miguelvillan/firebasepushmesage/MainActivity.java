package co.com.miguelvillan.firebasepushmesage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.GetInstance();
    }

    private void GetInstance(){
        FirebaseInstanceId
                .getInstance()
                .getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if(task.isSuccessful()){

                            // Get the new Instance ID token
                            String token = task.getResult().getToken();

                            // Log  and Toast
                            String message = "Token recibido = " + token;
                            Log.d("SALIDA", message);
                            Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG);

                        }else{
                            Log.w("ERROR", "An Error has ocurred when try to get instance" + task.getException());
                        }
                    }
                });
    }
}