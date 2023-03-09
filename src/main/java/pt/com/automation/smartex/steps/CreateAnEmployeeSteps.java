package pt.com.automation.smartex.steps;

import org.junit.Assert;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pt.com.automation.smartex.pojos.Employee;
import pt.com.automation.smartex.servicos.Responsee;
import pt.com.automation.smartex.servicos.ServicesImpl;

public class CreateAnEmployeeSteps {
	
	Gson gson = new Gson();
	Employee employee = new Employee();
	ServicesImpl verbs = new ServicesImpl();
	Responsee assertion = new Responsee();
	Responsee response;
	Faker faker = new Faker();
	
	@Given("made a request in API to create an employee  {string}  {string}  {string}")
	public void made_a_request_in_api_to_create_a_employee(String name, String salary, String age) {
	   employee.setName(faker.name().firstName());
	   employee.setSalary(salary);
	   employee.setAge(age);
	   String json = gson.toJson(employee);
	   response = verbs.postEndpoint("https://dummy.restapiexample.com/api/v1/create", json);
	   verbs.postEndpoint("https://dummy.restapiexample.com/api/v1/create", json);
		 
	  
	}
	@And("API retrive the status code {int}")
	public void api_retrive_the_status_code(Integer statusCode) {
	    assertion.getResponse().statusCode(statusCode);
	    String status = response.saveObjectBody("status");
	    Assert.assertEquals(status, "success");
	}
	
	@Then("delete this user")
	public void delete_this_user() {
		 String id = response.saveObjectBody("data.id");
		 verbs.deleteEndpoint("https://dummy.restapiexample.com/api/v1/delete/" + id); 
		 assertion.getResponse().statusCode(200);
		 String status = response.saveObjectBody("status");
		 Assert.assertEquals(status, "success");
		 
	}

}
