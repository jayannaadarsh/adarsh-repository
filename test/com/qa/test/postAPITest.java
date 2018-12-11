package com.qa.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.TestBase.testBase;
import com.qa.client.RestClient;
import com.qa.data.Users;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.text.html.parser.Entity;
import java.io.File;
import java.util.HashMap;

public class postAPITest extends testBase{


    testBase testbase;
    String urlpost;
    RestClient restclient;
    CloseableHttpResponse closablehttpresponse;

    @BeforeMethod
    public void SetUp() throws Exception
    {
        testbase= new testBase();
        urlpost=prop.getProperty("urlpost");
    }

    @Test
    public void postAPITest() throws Exception
    {
        restclient= new RestClient();
        HashMap<String, String> headerMap= new HashMap<String, String>();
        headerMap.put("content-Type", "application/json;");

        ObjectMapper mapper = new ObjectMapper();
        Users users = new Users("morpheus","leader"); //expected user object

        //object to jason conversion

        mapper.writeValue(new File("C:\\Users\\User 2\\workspace\\project_API_Automation\\src\\com\\qa\\data\\users.json"),users);

        //object to json string

        String usersJSONstrin=mapper.writeValueAsString(users);
        System.out.println(usersJSONstrin);
        closablehttpresponse = restclient.post(urlpost,usersJSONstrin,headerMap);
        //System.out.println(closablehttpresponse);

        //1. Status code
        int statuscode= closablehttpresponse.getStatusLine().getStatusCode();
        System.out.println(statuscode);

        //2. javastring

       String responsestring= EntityUtils.toString(closablehttpresponse.getEntity(), "UTF-8");
        JSONObject responseJson= new JSONObject(responsestring);
        System.out.println(responseJson);

        //json to java object
        Users userobj= mapper.readValue(responsestring, Users.class); //actual user object
        System.out.println(userobj);

        //System.out.println(users.getName().equals(userobj.getName()));



    }



}
