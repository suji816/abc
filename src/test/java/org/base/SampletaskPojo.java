package org.base;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import junit.framework.Assert;

public class SampletaskPojo extends Basecls {
	String logToken;
	 Integer address_id;

	@Test(priority = 1)
	private void login() throws IOException {

		addheader("Content-Type", "application/json");
		basicaut(getpropertyvalue("email"), getpropertyvalue("password"));

		Response login = requesttype("POST", Endpoints.LOGIN);
		
		Login_Output_Pojo login_Output_Pojo = login.as(Login_Output_Pojo.class);
		
		

		int getresponsecode = getresponsecode(login);
		System.out.println(getresponsecode);

		String getbodyasprettystring = getbodyasprettystring(login);
		System.out.println(getbodyasprettystring);
		
		Assert.assertEquals("Verify Successfuylly login","Login successfully", login_Output_Pojo.getMessage());
		
	    logToken = login_Output_Pojo.getData().getLogtoken();
		System.out.println(logToken);

		
		
	}
	
	@Test(priority = 2)
	private void createAddress() {
		List<Header> header = new ArrayList<>();
		Header h1 = new Header("Content-Type", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logToken);

		header.add(h1);
		header.add(h2);

		Headers headers = new Headers(header);

		addheaders(headers);

		AddAddress_Pojo addAddress_Pojo = new AddAddress_Pojo("sujith", "kumar", "9080807220", "anbu12", 12, 21, 34, "60777", "gugannagar", "home");

	    addplayload(addAddress_Pojo);
	    
		Response response = requesttype("POST", Endpoints.ADD_ADDRESS);
		
		System.out.println(getresponsecode(response));
		System.out.println(getbodyasprettystring(response));
		
	 add_ouput_pojo adrsouput = response.as(add_ouput_pojo.class);
	 address_id = adrsouput.getAddress_id();
	 System.out.println(address_id);
	 
	 Assert.assertEquals("address verify", "Address added successfully",  adrsouput.getMessage());
	
	}
	 @Test(priority=3)
		private void updateAddress() {

			List<Header> header = new ArrayList<>();
			Header h1 = new Header("Content-Type", "application/json");
			Header h2 = new Header("Authorization", "Bearer " + logToken);

			header.add(h1);
			header.add(h2);

			Headers headers = new Headers(header);

			addheaders(headers);
			 Update_address_input_pojo update_adress_input = new  Update_address_input_pojo(""+ address_id+"", "sujith", "kumar", "8300191276", "rupy", 90, 629601, 91, "629601", "parakkai", "string");
			

			addplayload(update_adress_input);
			
			Response response1 = requesttype("PUT", Endpoints. UPDATE_ADDRESS);
			System.out.println(getresponsecode(response1));
			System.out.println(getbodyasprettystring(response1));
			
		Update_output_data update_adrs_output = response1.as(Update_output_data.class);

	
	Assert.assertEquals("adress update verify","Address updated successfully",update_adrs_output.getMessage() );

	 }
	 @Test(priority=4)
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
			
//			Get_address_output get_address_output = response2.as(Get_address_output.class);
//			Assert.assertEquals("get address verify", "ok", get_address_output.getMessage());
			
			
		}
    //  @Test(priority=5)
		private void deleteAdress() {
			List<Header> header = new ArrayList<>();
		    Header h1 = new Header("Content-Type", "application/json");
			Header h2 = new Header("Authorization", "Bearer " + logToken);

			header.add(h1);
		    header.add(h2);

			Headers headers = new Headers(header);

			addheaders(headers);
			
			Delete_input_addrs delete_input_adres = new Delete_input_addrs(address_id);
			
			addplayload(delete_input_adres);
			
			
			Response response3 = requesttype("DELETE", Endpoints.DELETE_ADDRESS);
		    System.out.println(getresponsecode(response3));
		    System.out.println(getbodyasprettystring(response3));
		    
		    Delete_output_address outputadrs = response3.as(Delete_output_address.class);
		    

			Assert.assertEquals("adress delete verify","Address deleted successfully", outputadrs.getMessage());
			

		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
