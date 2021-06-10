package com.todoist.steps;

import com.todoist.tasks.SetStage;
import cucumber.api.java.en.Given;

public class SessionStepDefinitions {

  @Given("^(.*) is an authenticated user in todoist")
  public void is_an_user(String name) {
    SetStage.forActor(name);
  }

}
