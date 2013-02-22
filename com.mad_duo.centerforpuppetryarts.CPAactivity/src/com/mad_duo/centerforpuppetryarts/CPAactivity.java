package com.mad_duo.centerforpuppetryarts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

public class CPAactivity extends Activity 
{	
	private ImageButtonView showButton;
	private ImageButtonView activityButton;
	private ImageButtonView facebookButton;
	private ImageButtonView twitterButton;
	private ImageButtonView youtubeButton;
	private ImageButtonView logoButton;
	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);
        this.getWindow().addFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
        
        showButton = new ImageButtonView((ImageView) findViewById(R.id.show_sign));
        showButton.setOnTouchListener(new OnTouchListener()
        {
        	public boolean onTouch(View v, MotionEvent e)
        	{
    			Intent performanceIntent = new Intent(v.getContext(), PerformanceActivity.class);
    			startActivity(performanceIntent);
        		return true;
        	}
        });
        activityButton = new ImageButtonView((ImageView) findViewById(R.id.activity_sign));
        activityButton.setOnTouchListener(new OnTouchListener()
        {
        	public boolean onTouch(View v, MotionEvent e)
        	{
    			Intent museumIntent = new Intent(v.getContext(), MuseumActivity.class);
    			startActivity(museumIntent);
        		return true;
        	}
        });
        facebookButton = new ImageButtonView((ImageView) findViewById(R.id.facebook_icon));
        twitterButton = new ImageButtonView((ImageView) findViewById(R.id.twitter_icon));
        youtubeButton = new ImageButtonView((ImageView) findViewById(R.id.youtube_icon));
        logoButton = new ImageButtonView((ImageView) findViewById(R.id.logo_button));
        Data.socialMediaLinks(CPAactivity.this, logoButton, facebookButton, 
        		twitterButton, youtubeButton);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {
        getMenuInflater().inflate(R.menu.cpa_layout, menu);
        return true;
    }
}
