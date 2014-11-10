package com.codepath.apps.calculate;

import java.text.DecimalFormat;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CalculationActivity extends Activity {

	public void calculateTip10(View view) {
		this.calculateTip(view, 0.1);
	}

	public void calculateTip15(View view) {
		this.calculateTip(view, 0.15);
	}

	public void calculateTip20(View view) {
		this.calculateTip(view, 0.2);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_calculator);
	}

	private void calculateTip(View view, double percentage) {
		EditText editText = (EditText) findViewById(R.id.editText);
		String input = editText.getText().toString();
		String value;
		try {
			double bill = Integer.parseInt(input);
			double tip = bill * percentage;
			DecimalFormat df = new DecimalFormat("#,###,###,##0.00");
			value = "Tip = " + df.format(tip);
		} catch (NumberFormatException e) {
			value = "Input Is Not A Valid Number...";
		}

		TextView textView = (TextView) findViewById(R.id.textView);
		textView.setText(value);
	}

}
