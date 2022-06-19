package org.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Basecls { 
	static RequestSpecification reqspec;
	 static Response response;
	
	public  void addheader(String key,String value) {
          reqspec = RestAssured.given().header(key,value);

	}
	public void queryparam(String key,String value) {
		 reqspec = reqspec.queryParam(key,value);

	}
	public void pathparam(String key,String value) {
		reqspec = reqspec.pathParam(key, value);
		
	}
	public void basicaut(String username,String password) {
		reqspec = reqspec.auth().preemptive().basic(username, password);
		
	}
	public void addplayload(String body) {
		reqspec.body(body);

	}
	
	public void addplayload(Object body) {
		reqspec.body(body);

	}
	
	public Response requesttype(String type,String endpoint) {
		
		switch (type) {
		case "GET":
			 response = reqspec.log().all().get(endpoint);
			break;
		case "POST":
			 response = reqspec.log().all().post(endpoint);
			break;
		case "PUT":
			 response = reqspec.log().all().put(endpoint);
			break;
		case "DELETE":
			 response = reqspec.log().all().delete(endpoint);
			break;
		default:
			break;
		}
return response;
	}
	
	public int getresponsecode(Response response) {
    int statusCode = response.getStatusCode();
	return statusCode;
 
	}
	public ResponseBody  getresbody(Response response) {
		ResponseBody body = response.getBody();
		return body;

	}
	public String getbodyasstring(Response response) {
    String asString = getresbody(response).asString();
	return asString;
	}
	public String getbodyasprettystring(Response response) {
		String asPrettyString = getresbody(response).asPrettyString();
		return asPrettyString;

	}
	public String  getpropertyvalue(String key) throws IOException {
		
		FileInputStream stream = new  FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\prob\\config.properties");
		
		
		Properties properties = new Properties();
		properties.load(stream);
		
		Object object = properties.get(key);
		
		String s = (String) object;
		return s;

	}
	public String jsonpath(String key, Response response) {
		JsonPath jsonPath = getresbody(response).jsonPath();
		Object object = jsonPath .get(key);
		String value=  (String) object;
		return value;
	}
	public void addheaders(Headers headers) {
	     reqspec = RestAssured.given().headers(headers);
	}
	public int jsonpathnum(String key, Response response) {
		JsonPath jsonPath = getresbody(response).jsonPath();
		Object object = jsonPath .get(key);
		Integer value=  (Integer) object;
		return value;
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


