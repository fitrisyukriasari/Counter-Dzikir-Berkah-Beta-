package com.blogspot.fitrisyukriasari.counterdzikir;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Fitri Syukriasari on 28/08/2016.
 */
public class Splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        Animasi();
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Splash.this.startActivity(new Intent(Splash.this, MainActivity.class));
                Splash.this.finish();
            }
        }, 3500);
    }

    private void Animasi() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha);
        animation.reset();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relay);
        relativeLayout.clearAnimation();
        relativeLayout.startAnimation(animation);
        animation = AnimationUtils.loadAnimation(this, R.anim.translate);
        animation.reset();
        ImageView imageView = (ImageView) findViewById(R.id.imgLogo);
        imageView.clearAnimation();
        imageView.startAnimation(animation);
    }
}
