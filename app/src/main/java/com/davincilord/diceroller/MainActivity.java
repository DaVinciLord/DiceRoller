package com.davincilord.diceroller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createController();
    }

    private void createController() {
        View.OnClickListener lst = initListener();

        Button button6 = (Button) findViewById(R.id.button6);
        Button button10 = (Button) findViewById(R.id.button10);
        Button button20 = (Button) findViewById(R.id.button20);

        button6.setOnClickListener(lst);
        button10.setOnClickListener(lst);
        button20.setOnClickListener(lst);
    }

    private View.OnClickListener initListener() {
        View.OnClickListener lst = new View.OnClickListener() {
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
        return lst;
    }
}
