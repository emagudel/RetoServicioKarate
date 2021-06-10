package com.todoist.interactions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.todoist.constants.SessionVariables;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;

public class GetProjects implements Interaction {

  public static Performable details() {
    return instrumented(GetProjects.class);
  }

  @Step("{0} gets projects details")
  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Get.resource("/rest/v1/projects")
            .with(spec -> spec
                .header("Authorization", actor.recall(SessionVariables.ACCESS_TOKEN))
                .accept(ContentType.JSON)
            )
    );
  }

}
