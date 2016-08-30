package com.blogspot.fitrisyukriasari.counterdzikir;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

/**
 * Created by Fitri Syukriasari on 28/08/2016.
 */
public class About extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Button button = (Button)findViewById(R.id.button);
        button.getLinksClickable();
    }

}
