package cc.b2j.carmanager.base;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import cc.b2j.carmanager.R;

public class BaseActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
	}

	

	
}
