package ar.com.lfishkel.sudoku;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class FullscreenActivity extends Activity {

    private Sudoku sudoku;

    private int selectedText = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);
        sudoku = Sudoku.getInstance();
    }

    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    public void levelEasy(View view) {
        this.clear();
        this.sudoku.init();
        this.sudoku.clear(Sudoku.VERY_EASY);
        fillGrid();
    }

    public void levelHard(View view) {
        this.clear();
        this.sudoku.init();
        this.sudoku.clear(Sudoku.VERY_HARD);
        fillGrid();
    }

    private void fillGrid() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                StringBuilder sb = new StringBuilder("s");
                sb.append(i);
                sb.append(j);
                View text = super.findViewById(getResources().getIdentifier(sb.toString(), "id", this.getApplicationContext().getPackageName()));
                if (sudoku.getMatrix2()[i][j] != 0) {
                    ((TextView)text).setText("   " + String.valueOf(sudoku.getMatrix2()[i][j]));
                    text.setClickable(false);
                }
            }
        }
    }

    private void clear() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                StringBuilder sb = new StringBuilder("s");
                sb.append(i);
                sb.append(j);
                View text = super.findViewById(getResources().getIdentifier(sb.toString(), "id", this.getApplicationContext().getPackageName()));
                ((TextView)text).setText("");
            }
        }
    }

    public void textSelected(View view) {
        if (selectedText != -1) {
            View text = super.findViewById(this.selectedText);
            text.setBackgroundColor(Color.TRANSPARENT);
        }
        this.selectedText = view.getId();
        view.setBackgroundColor(Color.RED);
    }


    public void putNumber(View v) {
        if (selectedText != -1) {
            View text = super.findViewById(this.selectedText);
            switch (v.getId()) {
                case (R.id.btn1):
                    ((TextView) text).setText("    " + "1");
                    text.setBackgroundColor(Color.TRANSPARENT);
                    break;
                case (R.id.btn2):
                    ((TextView) text).setText("    " + "2");
                    text.setBackgroundColor(Color.TRANSPARENT);
                    break;
                case (R.id.btn3):
                    ((TextView) text).setText("    " + "3");
                    text.setBackgroundColor(Color.TRANSPARENT);
                    break;
                case (R.id.btn4):
                    ((TextView) text).setText("    " + "4");
                    text.setBackgroundColor(Color.TRANSPARENT);
                    break;
                case (R.id.btn5):
                    ((TextView) text).setText("    " + "5");
                    text.setBackgroundColor(Color.TRANSPARENT);
                    break;
                case (R.id.btn6):
                    ((TextView) text).setText("    " + "6");
                    text.setBackgroundColor(Color.TRANSPARENT);
                    break;
                case (R.id.btn7):
                    ((TextView) text).setText("    " + "7");
                    text.setBackgroundColor(Color.TRANSPARENT);
                    break;
                case (R.id.btn8):
                    ((TextView) text).setText("    " + "8");
                    text.setBackgroundColor(Color.TRANSPARENT);
                    break;
                case (R.id.btn9):
                    ((TextView) text).setText("    " + "9");
                    text.setBackgroundColor(Color.TRANSPARENT);
                    break;
            }
        }
    }
}
