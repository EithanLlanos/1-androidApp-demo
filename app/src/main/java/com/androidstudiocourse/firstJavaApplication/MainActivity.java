package com.androidstudiocourse.firstJavaApplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
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

    private char[] cList = {'.', '.', '.', '.', '.', '.', '.', '.', '.'};
//    private final StringBuilder dString = new StringBuilder("...-...-...-...-...-...-...-...");

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
        String arg;
        if (tView.getText().equals(getString(R.string.text1))) {
            arg = "X";
            but.setText(arg);
            tView.setText(R.string.text2);
        } else {
            arg = "O";
            but.setText(arg);
            tView.setText(R.string.text1);
        }
        but.setClickable(false);
        int i = Integer.parseInt(but.getTag().toString());
        mapGame(i, arg.charAt(0));
        checkWin();
    }

    private void mapGame(int i, char arg) {
        cList[i] = arg;
    }

    private void checkWin() {
        String txt = new String(cList, 0, 3) + "-" + new String(cList, 3, 3) + "-" + new String(cList, 6, 3) + "-" + cList[0] + cList[3] + cList[6] + "-" + cList[1] + cList[4] + cList[7] + "-" + cList[2] + cList[5] + cList[8] + "-" + cList[0] + cList[4] + cList[8] + "-" + cList[2] + cList[4] + cList[6];
        if (txt.contains("XXX")) win(1);
        else if (txt.contains("OOO")) win(2);
        else if (!txt.contains(".")) win(0);
    }

    private void win(int val) {
        String txt = "";
        switch (val) {
            case 0:
                txt = "Draw";
                break;
            case 1:
                txt = "X wins";
                break;
            case 2:
                txt = "0 wins";
                break;
        }
//        logg because not workin as intended
//        txt += " " + new String(cList);
        new AlertDialog.Builder(this)
                .setTitle("Game Over")
                .setMessage(txt)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
        clearGame();
    }

    public void clearGame() {
        cList = new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'};
        ((Button) findViewById(R.id.btn0)).setText("");
        findViewById(R.id.btn0).setClickable(true);
        ((Button) findViewById(R.id.btn1)).setText("");
        findViewById(R.id.btn1).setClickable(true);
        ((Button) findViewById(R.id.btn2)).setText("");
        findViewById(R.id.btn2).setClickable(true);
        ((Button) findViewById(R.id.btn3)).setText("");
        findViewById(R.id.btn3).setClickable(true);
        ((Button) findViewById(R.id.btn4)).setText("");
        findViewById(R.id.btn4).setClickable(true);
        ((Button) findViewById(R.id.btn5)).setText("");
        findViewById(R.id.btn5).setClickable(true);
        ((Button) findViewById(R.id.btn6)).setText("");
        findViewById(R.id.btn6).setClickable(true);
        ((Button) findViewById(R.id.btn7)).setText("");
        findViewById(R.id.btn7).setClickable(true);
        ((Button) findViewById(R.id.btn8)).setText("");
        findViewById(R.id.btn8).setClickable(true);
    }
}