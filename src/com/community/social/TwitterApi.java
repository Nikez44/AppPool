package com.community.social;

import java.util.List;

import com.community.survey.R;
import com.community.survey.R.string;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TwitterApi{
	
	private static Twitter twitter;
	private static RequestToken requestToken;
	private static AccessToken  accesstoken = null;
	private static SharedPreferences mSharedPreferences;

	private String consumerKey = null;
	private String consumerSecret = null;
	private String callbackUrl = null;
	private String oAuthVerifier = null;
	
	private boolean login = false;
	
	private ConfigurationBuilder builder;
	private TwitterFactory factory;
	
	
	private Activity activity;
	
	
	public TwitterApi(Activity activity){
		this.activity = activity;
		initTwitterConfigs();
		
		mSharedPreferences = this.activity.getSharedPreferences("Twitter", 0);

		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);
		
		
		builder = new ConfigurationBuilder();
		builder.setOAuthConsumerKey(consumerKey);
		builder.setOAuthConsumerSecret(consumerSecret);

		Configuration configuration = builder.build();
		factory = new TwitterFactory(configuration);
		twitter = factory.getInstance();
		
		initConsumer();
	}
	
	public boolean isLogued(){
		return login;
	}
	
	
	/* Reading twitter essential configuration parameters from strings.xml */
	private void initTwitterConfigs() {
		consumerKey = activity.getString(R.string.twitter_consumer_key);
		consumerSecret = activity.getString(R.string.twitter_consumer_secret);
		callbackUrl = activity.getString(R.string.twitter_callback);
		oAuthVerifier = activity.getString(R.string.twitter_oauth_verifier);
	}
	
	
	public void loginToTwitter() {

			if(login){
				Toast t = Toast.makeText(activity, "You are loggued", Toast.LENGTH_SHORT);
				t.show();
				return;
			}
		
			try {
				requestToken = twitter.getOAuthRequestToken(callbackUrl);
				
				/**
				 *  Loading twitter login page on webview for authorization 
				 *  Once authorized, results are received at onActivityResult
				 *  */
				Intent intent = new Intent(activity, WebViewActivity.class);
				intent.putExtra(WebViewActivity.EXTRA_URL, requestToken.getAuthenticationURL());
				activity.startActivity(intent);
				
				
			} catch (TwitterException e) {
				e.printStackTrace();
			}
	}
	
	public void logoutToTwitter(){
		twitter.setOAuth2Token(null);
		
		
		Editor e = mSharedPreferences.edit();
		
		e.remove("token");
		e.remove("secret");
	}
	
	
	
	public static void wardTokens(String verifier){
		try {
			AccessToken token = twitter.getOAuthAccessToken(verifier);
			
			Editor e = mSharedPreferences.edit();
			e.putString("token", token.getToken());
			e.putString("secret", token.getTokenSecret());
			
			e.commit();
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	private void initConsumer(){
		String token = mSharedPreferences.getString("token", "0");
		String secret = mSharedPreferences.getString("secret", "0");
		
		if(token.equals("0") && secret.equals("0")){
			return;
		}
		
		login = true;
		
		accesstoken = new AccessToken(token, secret);
		twitter.setOAuthAccessToken(accesstoken);
		
	}
	
	public void sendTweet(String tweet){
		
		
		try {
			int SDK_INT = android.os.Build.VERSION.SDK_INT;
			if (SDK_INT > 8) 
		    {
				//Se activa el uso
		        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		        StrictMode.setThreadPolicy(policy);
		        
		        twitter.updateStatus(tweet);
		    }
			
			
			//ENVIADO
		} catch (TwitterException e) {
			//ERROR
		}
	}
	
	public void retweetStatus(long statusId){
		try {
			int SDK_INT = android.os.Build.VERSION.SDK_INT;
			if (SDK_INT > 8) 
		    {
				//Se activa el uso
		        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		        StrictMode.setThreadPolicy(policy);
			
		        twitter.retweetStatus(statusId);
		    }
		} catch (TwitterException e) {
			//ERROR
		}
	}
	
	public void getTweets(String user) {

	    try {
	    	
	    	int SDK_INT = android.os.Build.VERSION.SDK_INT;
			if (SDK_INT > 8) 
		    {
				//Se activa el uso
		        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		        StrictMode.setThreadPolicy(policy);
		        
		        List<Status> statuses;
		        statuses = twitter.getUserTimeline(user);
	        
		        System.out.println("Showing @" + user + "'s user timeline.");
		        for (Status status : statuses) {

		        	System.out.println("@" + status.getUser().getScreenName()
	                    + " - " + status.getText());
		        }
		    }

	    } catch (TwitterException te) {
	        te.printStackTrace();
	        System.out.println("Failed to get timeline: " + te.getMessage());
	    }

	}
	
	
}
