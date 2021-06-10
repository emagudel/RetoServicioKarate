package com.todoist.steps;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.todoist.interactions.GetProjects;
import com.todoist.tasks.SeeProjects;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GetProjectsStepDefinitions {

  @When("he asks for his projects")
  public void asks_for_this_projects() {
    theActorInTheSpotlight().attemptsTo(
        GetProjects.details()
    );
  }

  @Then("he should see his projects")
  public void should_see_his_projects() {
    theActorInTheSpotlight().attemptsTo(
        SeeProjects.wereLoaded()
    );
  }
}
