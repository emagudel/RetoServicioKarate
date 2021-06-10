package com.todoist.tasks;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.hamcrest.Matchers.emptyCollectionOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

import com.todoist.constants.SessionVariables;
import com.todoist.model.ProjectResponse;
import com.todoist.questions.Projects;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;
import org.apache.http.HttpStatus;

public class SeeProjects implements Task {

  public static Performable wereLoaded() {
    return instrumented(SeeProjects.class);
  }

  @Step("{0} should see the projects were loaded")
  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.should(
        seeThat(
            question -> SerenityRest.lastResponse().getStatusCode(),
            equalTo(HttpStatus.SC_OK)
        ),
        seeThat(
            Projects.response(),
            not(emptyCollectionOf(ProjectResponse.class))
        )
    );

    actor.remember(SessionVariables.PROJECTS, Projects.response());

  }
}
