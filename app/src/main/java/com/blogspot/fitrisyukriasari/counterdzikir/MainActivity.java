package com.blogspot.fitrisyukriasari.counterdzikir;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnmulai, btntekan, btnselesai;
    private TextView tcounter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnmulai = (Button)findViewById(R.id.btnmulai);
        btntekan = (Button)findViewById(R.id.btntekan);
        btnselesai = (Button)findViewById(R.id.selesai);
        tcounter = (TextView)findViewById(R.id.tvskor);

        btntekan.setVisibility(View.INVISIBLE);
        btnselesai.setVisibility(View.INVISIBLE);

        btnmulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btntekan.setVisibility(View.VISIBLE);
                btnmulai.setVisibility(View.INVISIBLE);
                btnselesai.setVisibility(View.VISIBLE);
            }
        });

        btntekan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int skor, hasil;
                skor = Integer.parseInt(tcounter.getText().toString());
                hasil = skor + 1;

                tcounter.setText(Integer.toString(hasil));
;
            }
        });


        btnselesai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertOut = new AlertDialog.Builder(MainActivity.this);
                alertOut.setMessage("Yakin Dzikirnya sudah selesai ?")
                        .setPositiveButton("Ya", new AlertDialog.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                // TODO Auto-generated method stub
                                btntekan.setVisibility(View.INVISIBLE);
                                btnmulai.setVisibility(View.VISIBLE);
                                btnselesai.setVisibility(View.INVISIBLE);
                                tcounter.setText("0");
                            }

                        })
                        .setNegativeButton("Tidak", new AlertDialog.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // TODO Auto-generated method stub
                                dialog.cancel();
                            }

                        });
                AlertDialog window = alertOut.create();
                window.setTitle("Peringatan !");
                window.show();

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.about) {

            Intent about = new Intent(this, About.class);
            startActivity(about);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertOut = new AlertDialog.Builder(MainActivity.this);
        alertOut.setMessage("Apakah anda ingin keluar dari aplikasi ?")
                .setPositiveButton("Keluar", new AlertDialog.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        // TODO Auto-generated method stub
                        end();
                    }

                })
                .setNegativeButton("Tidak", new AlertDialog.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        dialog.cancel();
                    }

                });
        AlertDialog window = alertOut.create();
        window.setTitle("Peringatan");
        window.show();
    }

    public void end() {
        finish();
    }



}
