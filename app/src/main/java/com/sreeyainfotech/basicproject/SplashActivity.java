package com.sreeyainfotech.basicproject;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    private DisplayMetrics dm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        dm = new DisplayMetrics();
        SplashActivity.this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        Utilities.screenWidth = dm.widthPixels;
        Utilities.screenHeight = dm.heightPixels;

        TextView splash_text_driver_text = (TextView) findViewById(R.id.splash_text_driver_text);
        splash_text_driver_text.setText(Html.fromHtml("<font><b>" + "D" + "</b></font>" + "river" + "<font><b>" + " A" + "</b></font>" + "pp"));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            splash_text_driver_text.setText(Html.fromHtml("<font><b>" + "D" + "</b></font>" + "river" + "<font><b>" + " A" + "</b></font>" + "pp", Html.FROM_HTML_MODE_LEGACY));
        } else {
            splash_text_driver_text.setText(Html.fromHtml("<font><b>" + "D" + "</b></font>" + "river" + "<font><b>" + " A" + "</b></font>" + "pp"));
        }

        new Thread() {
            @Override
            public void run() {
                try {
                    synchronized (this) {
                        wait(1000);
                        if(Utilities.getBooleanPref(SplashActivity.this, "HasLogged_In", false)){
                            Intent login = new Intent(SplashActivity.this, HomeActivity.class);
                            startActivity(login);
                            finish();
                            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        }else{
                            Intent login = new Intent(SplashActivity.this, LoginActivity.class);
                            startActivity(login);
                            finish();
                            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                        }
                    }
                } catch (InterruptedException ex) {

                }
            }
        }.start();
    }
}
