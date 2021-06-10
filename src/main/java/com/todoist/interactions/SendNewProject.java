package com.todoist.interactions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.todoist.constants.SessionVariables;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class SendNewProject implements Interaction {

  private final String projectName;

  public SendNewProject(String projectName) {
    this.projectName = projectName;
  }

  public static Performable withName(String projectName) {
    return instrumented(SendNewProject.class, projectName);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Post.to("/rest/v1/projects")
            .with(spec -> spec
                .header("Authorization", actor.recall(SessionVariables.ACCESS_TOKEN))
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(String.format("{\"name\": \"%s\"}", projectName))
            )
    );
  }
}
