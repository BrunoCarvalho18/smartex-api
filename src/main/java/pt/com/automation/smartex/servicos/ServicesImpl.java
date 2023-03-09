package pt.com.automation.smartex.servicos;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class ServicesImpl implements Services{
	
	private Response responsee;

	@Override
	public Responsee getEndpoint(String endPoint) {
		responsee = given().when().log().all().get(endPoint);
		return new Responsee(responsee);
	}

	@Override
	public Responsee postEndpoint(String endPoint, Object message) {
		responsee = given().contentType("application/json").body(message).when().log().all().post(endPoint);
		return new Responsee(responsee);
	}

	@Override
	public Responsee putEndPoint(String endPoint, Object message) {
		responsee = given().contentType("application/json").body(message).when().log().all().put(endPoint);
		return new Responsee(responsee);
	}

	@Override
	public Responsee deleteEndpoint(String endPoint) {
		responsee = given().when().log().all().delete(endPoint);
		return new Responsee(responsee);
	}

}
