package com.todoist.tasks;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import com.todoist.model.ProjectResponse;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import org.apache.http.HttpStatus;

public class SeeProject implements Task {

  private final String projectName;

  public SeeProject(String projectName) {
    this.projectName = projectName;
  }

  public static Performable wasCreated(String projectName) {
    return instrumented(SeeProject.class, projectName);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.should(
        seeThat(
            question -> SerenityRest.lastResponse().getStatusCode(),
            equalTo(HttpStatus.SC_OK)
        )
    );

    ProjectResponse project = SerenityRest.lastResponse().as(ProjectResponse.class);

    actor.should(
        seeThat(
            question -> project,
            is(notNullValue())
        ),
        seeThat(
            question -> project.getName(),
            equalTo(projectName)
        )
    );
  }
}
