package pt.com.automation.smartex.servicos;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class Responsee {

	private static Response responsee;

	public Responsee(Response responsee) {
		Responsee.responsee = responsee;
	}

	public Responsee() {

	}

	public ValidatableResponse getResponse() {
		return responsee.then().log().all();
	}

	public Integer receiveStatusCode(Integer statusCode) {
		return responsee.statusCode();
	}
	
	public int statusCode() {
		return responsee.getStatusCode();
	}
	
	public String saveObjectBody(String path) {
		return responsee.jsonPath().get(path).toString();
	}


}
