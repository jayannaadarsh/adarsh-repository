package com.qa.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {
	
	//1.Get method without headers
	
	public  CloseableHttpResponse Get(String url) throws Exception, IOException
	{
		CloseableHttpClient httpclient= HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url); //get request
		CloseableHttpResponse closablehttpresponse = httpclient.execute(httpget);// hit the url
		return closablehttpresponse;
		
	}


	//2.Get method With headers

	public  CloseableHttpResponse Get(String url, HashMap<String, String> headersMap) throws Exception, IOException
	{
		CloseableHttpClient httpclient= HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url); //get request
		for (Map.Entry<String, String> entery: headersMap.entrySet())
		{
			httpget.addHeader(entery.getKey(), entery.getValue());
			
		}

		CloseableHttpResponse closablehttpresponse = httpclient.execute(httpget);// hit the url
		return closablehttpresponse;

	}
	
	
	
	
	

}
