package org.sample;

import org.base.Basecls;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class Apipra extends  Basecls{
	private void login() {
		addheader("Content_Type", "application/json");
		
		 basicaut("sujithgsk816@gmail.com", "Sujith@16");
		 Response response = requesttype("POST", "https://velsbusinessclub.vlcare.com/api/login");
		 ResponseBody body = response.getBody();
		 System.out.println(body.asPrettyString());
            JsonPath j = body.jsonPath();
            Object object = j.get("message");
		 System.out.println(object);
		 
		 Object object2 = j.get("data.first_name");
		 System.out.println(object2);

	}
	public static void main(String[] args) {
		Apipra a = new Apipra();
		a.login();
		
	}

}
