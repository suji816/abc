package org.base;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.base.Basecls;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import junit.framework.Assert;

public class Sample extends Basecls {
	String logToken;
	int adrsid;

	@Test(priority = 1)
	private void login() throws IOException {

		addheader("Content-Type", "application/json");
		basicaut(getpropertyvalue("email"), getpropertyvalue("password"));

		Response login = requesttype("POST", Endpoints.LOGIN);

		int getresponsecode = getresponsecode(login);
		System.out.println(getresponsecode);

		String getbodyasprettystring = getbodyasprettystring(login);
		System.out.println(getbodyasprettystring);
		
//		logToken = jsonpath("data.logtoken", login);

		String msg = jsonpath("message", response);
		Assert.assertEquals("verify successfully", "Login successfully", msg);

	}

//	@Test(priority = 2)
	private void createAddress() {
		List<Header> header = new ArrayList<>();
		Header h1 = new Header("Content-Type", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logToken);

		header.add(h1);
		header.add(h2);

		Headers headers = new Headers(header);

		addheaders(headers);

		addplayload("{\r\n" + "  \"first_name\": \"Raj\",\r\n" + "  \"last_name\": \"Khundra\",\r\n"
				+ "  \"mobile\": \"1234567898\",\r\n" + "  \"apartment\": \"apartment\",\r\n" + "  \"state\": 33,\r\n"
				+ "  \"city\": 3378,\r\n" + "  \"country\": 101,\r\n" + "  \"zipcode\": \"202020\",\r\n"
				+ "  \"address\": \"64/63 partap nagar\",\r\n" + "  \"address_type\": \"home\"\r\n" + "}");

		Response response = requesttype("POST", Endpoints.ADD_ADDRESS);
		System.out.println(getresponsecode(response));
		System.out.println(getbodyasprettystring(response));
	          adrsid = jsonpathnum("address_id", response);

		String msg = jsonpath("message", response);
		Assert.assertEquals("adress verify", "Address added successfully", msg);

	}
//   @Test(priority=3)
	private void updateAddress() {

		List<Header> header = new ArrayList<>();
		Header h1 = new Header("Content-Type", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logToken);

		header.add(h1);
		header.add(h2);

		Headers headers = new Headers(header);

		addheaders(headers);

		addplayload("{\r\n" + "  \"address_id\": \""+adrsid+"\",\r\n" + "  \"first_name\": \"Raj\",\r\n"
				+ "  \"last_name\": \"Khundra\",\r\n" + "  \"mobile\": \"1234567898\",\r\n"
				+ "  \"apartment\": \"apartment\",\r\n" + "  \"state\": 33,\r\n" + "  \"city\": 3378,\r\n"
				+ "  \"country\": 101,\r\n" + "  \"zipcode\": \"202020\",\r\n"
				+ "  \"address\": \"64/63 partap nagar\",\r\n" + "  \"address_type\": \"home\"\r\n" + "}");

		Response response1 = requesttype("PUT", Endpoints. UPDATE_ADDRESS);
		System.out.println(getresponsecode(response1));
		System.out.println(getbodyasprettystring(response1));

		String msg1 = jsonpath("message", response1);
		Assert.assertEquals("adress update verify","Address updated successfully", msg1);

	} 
	// @Test(priority=4)
    private void getAddress() {
		List<Header> header = new ArrayList<>();
		Header h1 = new Header("Content-Type", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logToken);

		header.add(h1);
		header.add(h2);

		Headers headers = new Headers(header);

		addheaders(headers);

     	Response response2 = requesttype("GET", Endpoints.GET_ADDRESS);
		System.out.println(getresponsecode(response2));
		System.out.println(getbodyasprettystring(response2));
		
		String msg1 = jsonpath("message", response2);
	    Assert.assertEquals("get address verify", "OK", msg1);
	}
// 	@Test(priority=5)
	private void deleteAdress() {
		List<Header> header = new ArrayList<>();
	Header h1 = new Header("Content-Type", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logToken);

		header.add(h1);
	header.add(h2);

		Headers headers = new Headers(header);

		addheaders(headers);
		
		addplayload("{\r\n" + 
				"  \"address_id\": \"1740\"\r\n" + 
				"}");
		
		
		Response response3 = requesttype("DELETE", Endpoints.DELETE_ADDRESS);
	System.out.println(getresponsecode(response3));
	System.out.println(getbodyasprettystring(response3));

		String msg3 = jsonpath("message", response3);
		Assert.assertEquals("adress delete verify","Address deleted successfully", msg3);

		
		
		
		
		
		

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
    }

