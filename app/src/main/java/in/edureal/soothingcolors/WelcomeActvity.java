package in.edureal.soothingcolors;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActvity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_actvity);

        new CountDownTimer(3000, 3000) {
            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                Intent intent = new Intent(WelcomeActvity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }.start();

    }
}
