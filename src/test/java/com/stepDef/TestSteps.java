package com.stepDef;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;

import com.jsonResponse.JsonResponse;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;


public class TestSteps {
	String response;
	JsonPath js;
	@Given("^Store response in String$")
    public void store_response_in_string(){
		response=JsonResponse.res;
    }

    @When("^Deserialaize the resopnse$")
    public void deserialaize_the_resopnse() throws IOException{
    	js=new JsonPath(response);
    }

	@Then("^Validate That the team has only 4 foreign players$")
    public void validate_that_the_team_has_only_4_foreign_players() {
    	List<Object> country = js.getList("player.country");
    	int foreignPlayer=0;
    	for(int i=0; i<country.size();i++) {
    		if(!country.get(i).equals("India")) {
    			foreignPlayer++;
    		}
    	}
    	Assert.assertEquals(foreignPlayer, 4);
    }

    @And("^Validate that there is ateast 1 wicket keeper$")
    public void validate_that_there_is_ateast_1_wicket_keeper() {
    	List<Object> role = js.getList("player.role");
    	boolean wicketKeeper = false;
    	for(int i=0;i<role.size(); i++) {
    		if(role.get(i).equals("Wicket-keeper")) {
    			wicketKeeper = true;
    			break;
    		}
    	}
    	Assert.assertTrue(wicketKeeper);
    }

}
