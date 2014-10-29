package com.example.funapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends ActionBarActivity {

	private static final int PROGRESS = 0x1;

	private Handler myHandler = new Handler();
	private ProgressBar mProgress;
	private int mProgressStatus = 0;

	

	@Override
	protected void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.activity_main);

		mProgress = (ProgressBar) findViewById(R.id.progressBar1);
		
		

		Button loginBtn = (Button) findViewById(R.id.loginButton);
		loginBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent i = new Intent(getApplicationContext(),
						NextActivity.class);
				myHandler.post(r);

			}
		});
		
		
		Button changepasswordBtn = (Button) findViewById(R.id.changepasswordButton);
		changepasswordBtn.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent j = new Intent(getApplicationContext(),
							OtherActivity.class);
				myHandler.post(x);
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	Runnable r = new Runnable() {

		@Override
		public void run() {
			if (mProgressStatus == 100) {

				startActivity(new Intent(getApplicationContext(),
						NextActivity.class));
			} else {
				mProgress.setProgress(mProgressStatus);
				mProgressStatus += 10;
				myHandler.postDelayed(r, 250);
			}
		}
	};
	
	Runnable x = new Runnable() {

		@Override
		public void run() {
			if (mProgressStatus == 100) {

				startActivity(new Intent(getApplicationContext(),
						OtherActivity.class));
			} else {
				mProgress.setProgress(mProgressStatus);
				mProgressStatus += 10;
				myHandler.postDelayed(x, 250);
			}
		}
	};
}
