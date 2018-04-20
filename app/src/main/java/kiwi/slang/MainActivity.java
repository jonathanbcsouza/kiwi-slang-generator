package kiwi.slang;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Slangs getOther = new Slangs();
    private TextView btnChangeMsg, randomMsg;
    private RelativeLayout backgroundColorAnimation;
    private ColorsBackground colorsBackground = new ColorsBackground();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView title = findViewById(R.id.title);
        randomMsg = findViewById(R.id.msg);
        btnChangeMsg = (Button) findViewById(R.id.button);
        backgroundColorAnimation = (RelativeLayout) findViewById(R.id.background);

        btnChangeMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String getClass = getOther.getSlangs();
                randomMsg.setText(getClass);
                int colors = colorsBackground.getColor();
                backgroundColorAnimation.setBackgroundColor(colors);
                btnChangeMsg.setTextColor(colors);
            }
        });
    }
}
