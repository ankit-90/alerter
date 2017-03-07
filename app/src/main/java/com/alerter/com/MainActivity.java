package com.alerter.com;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.tapadoo.alerter.Alerter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mDefaultBtn = (Button) findViewById(R.id.btn_default);
        Button mColoredButton = (Button) findViewById(R.id.btn_colored);
        Button mIconButton = (Button) findViewById(R.id.btn_icon);
        Button mClickButton = (Button) findViewById(R.id.btn_alert_click);

        mDefaultBtn.setOnClickListener(this);
        mColoredButton.setOnClickListener(this);
        mIconButton.setOnClickListener(this);
        mClickButton.setOnClickListener(this);
    }


    private void showDefaultAlert(){
        Alerter.create(this)
                .setTitle("Alert Title")
                .setText("Alert message")
                .show();
    }

    private void showColoredAlert(){
        Alerter.create(this)
                .setTitle("Alert Title")
                .setText("Alert message")
                .setBackgroundColor(R.color.colorAlert)
                .show();
    }

    private void showCustomIconAlert(){
        Alerter.create(this)
                .setTitle("Alert Title")
                .setText("Alert message")
                .setIcon(R.drawable.ic_face)
                .show();
    }

    private void showClickAlert(){
        Alerter.create(this)
                .setTitle("Alert Title")
                .setText("Alert text...")
                .setDuration(10000)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "OnClick Called", Toast.LENGTH_LONG).show();
                    }
                })
                .show();
    }




    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_default:
                showDefaultAlert();
                break;
            case R.id.btn_colored:
                showColoredAlert();
                break;

            case R.id.btn_icon:
                showCustomIconAlert();
                break;
            case R.id.btn_alert_click:
                showClickAlert();
                break;
        }
    }
}
