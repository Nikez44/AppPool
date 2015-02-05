package com.community.survey.fragments;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import roboguice.fragment.RoboFragment;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.RequestToken;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.community.social.TwitterApi;
import com.community.survey.R;
import com.community.survey.SurveyActivity;
import com.community.survey.TaskViewActivity;
import com.community.survey.VideoViewActivity;
import com.community.survey.web.response.DownloadFileResponse;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;
import com.facebook.widget.LoginButton;

@ContentView(R.layout.main_fragment)
public class MainFragment extends RoboFragment {

	public static final String TAG = MainFragment.class.getSimpleName();
    
    
    ProgressDialog pDialog;
	private UiLifecycleHelper uiHelper;

	@InjectView(R.id.mainActivity_enterButton)
	private Button mEnterButton;
	
	@InjectView(R.id.mainActivity_taskButton)
	private Button btntwitter;

	@InjectView(R.id.loginTwitter)
	private ImageView  mTwitterButton;
	
	@InjectView(R.id.mainActivity_btnLoginFacebook)
	private LoginButton mLoginFacebookButton;

	private TwitterApi twitter ;
	
	private OnClickListener logTwitter = new OnClickListener(){
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			//
			loginToTwitter();
		}
	};
	
	
	public void loginToTwitter(){
		twitter.loginToTwitter();
	}
	

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.main_fragment, container, false);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		uiHelper = new UiLifecycleHelper(getActivity(), callback);
		uiHelper.onCreate(savedInstanceState);
		
		twitter = new TwitterApi(getActivity());
		
		checkLogin();
		
	}
	
	public void checkLogin(){
		
		//mTwitterButton.setImageResource(R.drawable.signout_button);
		/**
		if(twitter.isLogued()){
			openTaskView();
		}*/
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		populateView();
		
		mTwitterButton.setOnClickListener(logTwitter);
		
		// new AsyncTask<String,Void, DownloadFileResponse >() {
		//
		// @Override
		// protected DownloadFileResponse doInBackground(String... params) {
		// // TODO Auto-generated method stub
		// WebServiceController controller = new WebServiceController();
		// DownloadFileRequest request = new DownloadFileRequest();
		// request.setFileUrl(params[0]);
		//
		// DownloadFileResponse response = controller.downloadVideo(request);
		//
		// return response;
		// }
		//
		// protected void onPostExecute(DownloadFileResponse result) {
		// hideDialog();
		// writeFile(result);
		// }
		//
		// protected void onPreExecute() {
		// showDialog();
		// }
		//
		// }.execute("http://porn.im.bbfc4d00.6311249.cdn.xvideos.com/videos/3gp/0/7/e/xvideos.com_07ea9aae195fc322a177e0b166b95135.mp4?e=1416081244&ri=1024&rs=85&h=1fade5116f10982a16e83fe54f185ad9");
		//
	}

	private void populateView() {
		mEnterButton.setOnClickListener(mOnClickListener);
		btntwitter.setOnClickListener(mOnClickListener);
		mLoginFacebookButton.setFragment(this); //Creo que aqui se pone el fragment que se desea abrir al iniciar sesion	
		
	}

	private void writeFile(DownloadFileResponse response) {
		if (response.isSuccess()) {
			File externalDir = Environment.getExternalStorageDirectory();
			File movieFile = new File(externalDir, "MiVideo.mp4");

			try {
				FileOutputStream fos = new FileOutputStream(movieFile);
				fos.write(response.getByteData());
				fos.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		AlertDialog.Builder bldr = new AlertDialog.Builder(getActivity(),
				AlertDialog.THEME_HOLO_LIGHT);
		bldr.setTitle("Downloaded File");
		if (response.isSuccess()) {
			String message = "MimeType: " + response.getMimeType()
					+ "\nFileSize: " + response.getByteData().length;
			bldr.setMessage(message);
		} else {
			bldr.setMessage("Error Downloading File");
		}
		bldr.show();
	}

	private void openSurveyActivity() {
		Intent intent = new Intent(getActivity(), SurveyActivity.class);
		startActivity(intent);
	}

	private void openVideoViewActivity() {
		Intent intent = new Intent(getActivity(), VideoViewActivity.class);
		startActivity(intent);
	}

	private void openTaskView() {
		Intent intent = new Intent(getActivity(), TaskViewActivity.class);
		startActivity(intent);
	}

	// private void showDialog(){
	// if(mDialog == null){
	// mDialog = new ProgressDialog(this, ProgressDialog.THEME_HOLO_LIGHT);
	// mDialog.setIndeterminate(true);
	// mDialog.setMessage("Descargando Informaci�n para su posterior uso en el dispositivo seleccionado");
	// }
	// mDialog.show();
	// }

	// private void hideDialog(){
	// if(mDialog != null){
	// mDialog.dismiss();
	// mDialog = null;
	// }
	// }

	private OnClickListener mOnClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			int buttonId = v.getId();
			switch (buttonId) {
			case R.id.mainActivity_enterButton:
				openSurveyActivity();
				break;			
			case R.id.mainActivity_taskButton:
				//twitter.logoutToTwitter();
				openTaskView();
				break;
			}
		}
	};

	// private ProgressDialog mDialog;

	// Listener SessionChange
	private Session.StatusCallback callback = new Session.StatusCallback() {
		@Override
		public void call(Session session, SessionState state,
				Exception exception) {
			onSessionStateChange(session, state, exception);
		}
	};

	private void onSessionStateChange(Session session, SessionState state,
			Exception exception) {	
		
		if (state.isOpened()) {
			Toast.makeText(getActivity(), "Logged in...", Toast.LENGTH_SHORT)
			.show();

		} else if (state.isClosed()) {
			Toast.makeText(getActivity(), "Logged out...", Toast.LENGTH_SHORT)
					.show();

		}
	}
	
	@Override
	public void onResume() {
	    super.onResume();
	    
	    // For scenarios where the main activity is launched and user
	    // session is not null, the session state change notification
	    // may not be triggered. Trigger it if it's open/closed.
	    Session session = Session.getActiveSession();
	    if (session != null &&
	           (session.isOpened() || session.isClosed()) ) {
	        onSessionStateChange(session, session.getState(), null);
	    }    
	    
	    uiHelper.onResume();
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		
		
	    super.onActivityResult(requestCode, resultCode, data);
	    uiHelper.onActivityResult(requestCode, resultCode, data);
	    
	    
	}
	

	@Override
	public void onPause() {
	    super.onPause();
	    uiHelper.onPause();
	}

	@Override
	public void onDestroy() {
	    super.onDestroy();
	    uiHelper.onDestroy();
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
	    super.onSaveInstanceState(outState);
	    uiHelper.onSaveInstanceState(outState);
	}
}

