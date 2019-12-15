package com.souza.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HellowordClient {
	
	
	 private static int HTTP_COD_SUCESSO = 200;
	 
	    public static void main(String[] args) {
	 
	        try {
	 
	            URL url = new URL("http://localhost:8080/api/v1/helloword/1");
	            HttpURLConnection con = (HttpURLConnection) url.openConnection();
	 
	            if (con.getResponseCode() != HTTP_COD_SUCESSO) {
	                throw new RuntimeException("HTTP error code : "+ con.getResponseCode());
	            }
	 
	            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	                
	            System.out.println(br.readLine());
	         
	            con.disconnect();
	 
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	    }
}
