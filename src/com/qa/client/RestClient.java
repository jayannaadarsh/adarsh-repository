package com.qa.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {
	
	//Get method
	
	public  CloseableHttpResponse Get(String url) throws Exception, IOException
	{
		CloseableHttpClient httpclient= HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url); //get request
		CloseableHttpResponse closablehttpresponse = httpclient.execute(httpget);// hit the url
		return closablehttpresponse;
		
	}
	
	
	
	
	

}
