package com.davincilord.diceroller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createController();
    }

    private void createController() {
        OnClickListener lst = initListener();

        Button button6 = (Button) findViewById(R.id.button6);
        Button button10 = (Button) findViewById(R.id.button10);
        Button button20 = (Button) findViewById(R.id.button20);

        if (button6 != null) {
            button6.setOnClickListener(lst);
        } else {
            throw new RuntimeException("Button 6 is null");
        }

        if (button10 != null) {
            button10.setOnClickListener(lst);
        } else {
            throw new RuntimeException("Button 10 is null");
        }

        if (button20 != null) {
            button20.setOnClickListener(lst);
        } else {
            throw new RuntimeException("Button 20 is null");
        }
    }

    private OnClickListener initListener() {
        return new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DiceActivity.class);
                intent.putExtra("max", searchMax(v));
                startActivity(intent);
            }

            private int searchMax(View v) {
                switch (v.getId()) {
                    case R.id.button6:
                        return 6;
                    case R.id.button10:
                        return 10;
                    case R.id.button20:
                        return 20;
                }
                return 6;
            }
        };
    }
}
