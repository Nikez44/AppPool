package com.community.social;

import com.community.survey.R;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends Activity {
	
	private WebView webView;
	
	public static String EXTRA_URL = "extra_url";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_webview);
		
		setTitle("Login");

		final String url = this.getIntent().getStringExtra(EXTRA_URL);
		if (null == url) {
			Log.e("Twitter", "URL cannot be null");
			finish();
		}

		webView = (WebView) findViewById(R.id.webView);
		webView.setWebViewClient(new MyWebViewClient());
		webView.loadUrl(url);
	}


	class MyWebViewClient extends WebViewClient {
		
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {

			if (url.contains(getResources().getString(R.string.twitter_callback))) {
				Uri uri = Uri.parse(url);
				
				/* Sending results back */
				String verifier = uri.getQueryParameter(getString(R.string.twitter_oauth_verifier));
				
				SharedPreferences mSharedPreferences = getSharedPreferences("Twitter", 0);
				
				Editor e = mSharedPreferences.edit();
				e.putString("oauth_verifier", verifier);
				
				e.commit();
				
				TwitterApi.wardTokens(verifier);
				
				Log.d("Twitter", verifier);
				
				/*
				Intent resultIntent = new Intent();
				resultIntent.putExtra(getString(R.string.twitter_oauth_verifier), verifier);
				setResult(RESULT_OK, resultIntent);
				*/
				
				
				/* closing webview */
				finish();
				return true;
			}
			return false;
		}
	}
	
}
