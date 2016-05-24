package com.davincilord.diceroller;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.security.SecureRandom;

/**
 * Created by davincilord on 24/05/16.
 */
public class DiceActivity extends Activity implements View.OnClickListener{

    private TextView result;
    private int max;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roll);

        max = getIntent().getIntExtra("max", 0);

        TextView xSidedDice = (TextView) findViewById(R.id.x_sided_dice);
        xSidedDice.setText(getString(R.string.sided_dice, max));

        result = (TextView) findViewById(R.id.result);
        result.setText("");

        Button rollButton = (Button) findViewById(R.id.button_roll);
        rollButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        SecureRandom random = new SecureRandom();
        int resultRoll = random.nextInt(max) + 1;
        result.setText(String.valueOf(resultRoll));
    }
}
