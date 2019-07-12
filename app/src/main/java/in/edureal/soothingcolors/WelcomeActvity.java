package in.edureal.soothingcolors;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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
