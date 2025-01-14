package com.androidstudiocourse.firstJavaApplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void gameAction(View view) {
        Button but = (Button) view;
        TextView tView = findViewById(R.id.textView3);
//        if (tView.getText() == R.string.text1) {
//            but.setText("X");
//        }
        if (tView.getText().equals(getString(R.string.text1))) {
            but.setText("X");
            tView.setText(R.string.text2);
            return;
        }
        but.setText("O");
        tView.setText(R.string.text1);
    }

}