package com.todoist.steps;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.todoist.tasks.AddProject;
import com.todoist.tasks.SeeProject;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddProjectStepDefinitions {

  @When("^he creates a new project: (.*)$")
  public void create_new_project(String projectName) {
    theActorInTheSpotlight().attemptsTo(
        AddProject.withName(projectName)
    );
  }

  @Then("^he should see the project (.*) was created$")
  public void should_see_the_project_was_created(String projectName) {
    theActorInTheSpotlight().attemptsTo(
        SeeProject.wasCreated(projectName)
    );
  }

}
