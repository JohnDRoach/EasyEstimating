package JD.EasyEstimating;

import java.util.Random;
import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class EasyEstimatingActivity extends Activity {
	String[] times;
	String[] units;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		PopulateArrays();
	}
	
	private void PopulateArrays() {
		Resources res = getResources();
		times = res.getStringArray(R.array.Times);
		units = res.getStringArray(R.array.Units);
	}

	public void onClick(View v) {
		GenerateRandomEstimates();
	}

	private void GenerateRandomEstimates() {
		SetText(GetRandomTime(), GetRandomUnit());
	}
	
	private void SetText(String time, String unit)
	{
		TextView timeView = GetTimeView();
		TextView unitView = GetUnitView();
		
		timeView.setText(time);
		unitView.setText(unit);
	}

	private String GetRandomTime() {
		return times[GetRandomNumberBetweenZeroAnd(times.length)];
	}
	
	private String GetRandomUnit() {
		return units[GetRandomNumberBetweenZeroAnd(units.length)];
	}
	
	private TextView GetTimeView() {
		return (TextView)findViewById(R.id.TimeTextView);
	}

	private TextView GetUnitView() {
		return (TextView)findViewById(R.id.UnitsTextView);
	}
	
	private int GetRandomNumberBetweenZeroAnd(int upperNotInclusive)
	{
		return new Random().nextInt(upperNotInclusive);
	}
}