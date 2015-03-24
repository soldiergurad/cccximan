package cc.b2j.carmanager.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cc.b2j.carmanager.R;

public class MineFragment extends Fragment
{
	private String mTitle = "Default";

	public static final String TITLE = "title";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		if (getArguments() != null)
		{
			mTitle = getArguments().getString(TITLE);
		}
		   View v = inflater.inflate(R.layout.fragment_mine, container, false);
		
		
//		TextView tv = new TextView(getActivity());
//		tv.setTextSize(20);
//		tv.setBackgroundColor(Color.parseColor("#ffffffff"));
//		tv.setText(mTitle);
//		tv.setGravity(Gravity.CENTER);
		return v;

	}
}
