package in.edureal.soothingcolors;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;


public class MainActivity extends AppCompatActivity {

    private LinearLayout division1;
    private LinearLayout division2;
    private LinearLayout division3;
    private LinearLayout division4;

    private TextView division1_hex;
    private TextView division2_hex;
    private TextView division3_hex;
    private TextView division4_hex;

    private String color1_hex;
    private String color2_hex;
    private String color3_hex;
    private String color4_hex;

    private static int clickNum=0;

    private InterstitialAd interstitialAd;

    private String toBrowserHexValue(int number){
        StringBuilder builder = new StringBuilder(Integer.toHexString(number & 0xff));
        while (builder.length() < 2) {
            builder.append("0");
        }
        return builder.toString().toUpperCase();
    }

    public String toHex(int r, int g, int b) {
        return "#" + toBrowserHexValue(r) + toBrowserHexValue(g) + toBrowserHexValue(b);
    }

    private int randomIntInRange(){
        double randomDouble = Math.random();
        randomDouble = randomDouble * 255 + 1;
        return (int) randomDouble;
    }

    private void clickFunction(){
        clickNum++;
        if(clickNum==20){
            if(interstitialAd.isLoaded()){
                interstitialAd.show();
            }else{
                interstitialAd.loadAd(new AdRequest.Builder().build());
            }
            clickNum=0;
        }
    }

    public void division1click(View view){
        generateDivision1Colors();
        setDivision1Colors();
        clickFunction();
    }

    public void division2click(View view){
        generateDivision2Colors();
        setDivision2Colors();
        clickFunction();
    }

    public void division3click(View view){
        generateDivision3Colors();
        setDivision3Colors();
        clickFunction();
    }

    public void division4click(View view){
        generateDivision4Colors();
        setDivision4Colors();
        clickFunction();
    }

    private void generateDivision1Colors(){
        int temp1=randomIntInRange();
        int temp2=randomIntInRange();
        int temp3=randomIntInRange();
        color1_hex=toHex(temp1,temp2,temp3);
    }

    private void generateDivision2Colors(){
        int temp1=randomIntInRange();
        int temp2=randomIntInRange();
        int temp3=randomIntInRange();
        color2_hex=toHex(temp1,temp2,temp3);
    }

    private void generateDivision3Colors(){
        int temp1=randomIntInRange();
        int temp2=randomIntInRange();
        int temp3=randomIntInRange();
        color3_hex=toHex(temp1,temp2,temp3);
    }

    private void generateDivision4Colors(){
        int temp1=randomIntInRange();
        int temp2=randomIntInRange();
        int temp3=randomIntInRange();
        color4_hex=toHex(temp1,temp2,temp3);
    }

    private void setDivision1Colors(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(Color.parseColor(color1_hex));
        }
        division1.setBackgroundColor(Color.parseColor(color1_hex));
        division1_hex.setText(color1_hex);
    }

    private void setDivision2Colors(){
        division2.setBackgroundColor(Color.parseColor(color2_hex));
        division2_hex.setText(color2_hex);
    }

    private void setDivision3Colors(){
        division3.setBackgroundColor(Color.parseColor(color3_hex));
        division3_hex.setText(color3_hex);
    }

    private void setDivision4Colors(){
        division4.setBackgroundColor(Color.parseColor(color4_hex));
        division4_hex.setText(color4_hex);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);

        division1=(LinearLayout) findViewById(R.id.division1);
        division2=(LinearLayout) findViewById(R.id.division2);
        division3=(LinearLayout) findViewById(R.id.division3);
        division4=(LinearLayout) findViewById(R.id.division4);

        division1_hex=(TextView) findViewById(R.id.division1_hex);
        division2_hex=(TextView) findViewById(R.id.division2_hex);
        division3_hex=(TextView) findViewById(R.id.division3_hex);
        division4_hex=(TextView) findViewById(R.id.division4_hex);

        color1_hex="";
        color2_hex="";
        color3_hex="";
        color4_hex="";


        generateDivision1Colors();
        generateDivision2Colors();
        generateDivision3Colors();
        generateDivision4Colors();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(Color.parseColor(color1_hex));
        }
        setDivision1Colors();
        setDivision2Colors();
        setDivision3Colors();
        setDivision4Colors();

        division1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipData clip = ClipData.newPlainText("Color Division1", color1_hex);
                clipboard.setPrimaryClip(clip);
                Toast.makeText(MainActivity.this, "Copied to Clipboard", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        division2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipData clip = ClipData.newPlainText("Color Division2", color2_hex);
                clipboard.setPrimaryClip(clip);
                Toast.makeText(MainActivity.this, "Copied to Clipboard", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        division3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipData clip = ClipData.newPlainText("Color Division3", color3_hex);
                clipboard.setPrimaryClip(clip);
                Toast.makeText(MainActivity.this, "Copied to Clipboard", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        division4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipData clip = ClipData.newPlainText("Color Division4", color4_hex);
                clipboard.setPrimaryClip(clip);
                Toast.makeText(MainActivity.this, "Copied to Clipboard", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");
        interstitialAd=new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        interstitialAd.loadAd(new AdRequest.Builder().build());
        interstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                interstitialAd.loadAd(new AdRequest.Builder().build());
            }
        });

    }
}
