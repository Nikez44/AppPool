package com.community.survey.web;

import java.io.IOException;
import java.net.HttpURLConnection;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.community.survey.web.request.DownloadFileRequest;
import com.community.survey.web.response.DownloadFileResponse;

public class WebServiceController {
	
	public DownloadFileResponse downloadVideo(DownloadFileRequest request){
		DownloadFileResponse response = new DownloadFileResponse();
		
		String videoUrl = request.getFileUrl();
		
		HttpEntity responseEntity = consumeGetRequest(videoUrl);
		if(responseEntity != null){
			try {
				byte[] responseArray = EntityUtils.toByteArray(responseEntity);
				response.setByteData(responseArray);
				String contentType = responseEntity.getContentType().getValue();
				response.setMimeType(contentType);
				
				response.setSuccess(true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				response.setSuccess(false);
			}
		}else{
			response.setSuccess(false);
		}
		
		return response;
	}
	
	private HttpEntity consumeGetRequest(String fullUrl){
		HttpClient httpClient = new DefaultHttpClient();
		
		HttpGet getMethod = new HttpGet(fullUrl);
		HttpEntity responseEntity = null;
		try {
			HttpResponse response = httpClient.execute(getMethod);
			StatusLine statusLine = response.getStatusLine();
			int statusCode = statusLine.getStatusCode();
			if(statusCode == HttpURLConnection.HTTP_OK){
				responseEntity = response.getEntity();
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return responseEntity;
	}
}
