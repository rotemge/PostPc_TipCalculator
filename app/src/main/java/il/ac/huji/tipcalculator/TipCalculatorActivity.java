package il.ac.huji.tipcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class TipCalculatorActivity extends Activity {

    private static TextView amount;
    private static TextView result;
    private static CheckBox round;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
        amount = (TextView)findViewById(R.id.edtBillAmount);
        result = (TextView)findViewById(R.id.txtTipResult);
        round = (CheckBox)findViewById(R.id.chkRound);
        Button calc = (Button)findViewById(R.id.btnCalculate);
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double doubleAmount = Double.parseDouble(amount.getText().toString());
                    if (doubleAmount <= 0) {
                        result.setText(R.string.negative_amount);
                    }
                    double tip = doubleAmount * 0.12;
                    String res = String.format(getString(R.string.resultDouble), tip);
                    if(round.isChecked()){
                        res = String.format(getString(R.string.resultInt), (int) Math.round(tip));
                    }
                    result.setText(res);
                } catch (NumberFormatException e) {
                    result.setText(R.string.not_number);
                }
            }
        });
    }
}
