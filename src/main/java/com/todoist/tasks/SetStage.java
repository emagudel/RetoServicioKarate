package com.todoist.tasks;

import com.todoist.constants.Constants;
import com.todoist.constants.SessionVariables;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

public class SetStage {

  public static void forActor(String name) {
    OnStage.setTheStage(Cast.ofStandardActors());

    Actor actor = OnStage.theActorCalled(name);
    actor.can(
        CallAnApi.at(Constants.BASE_URL)
    );

    actor.remember(SessionVariables.ACCESS_TOKEN, Constants.ACCESS_TOKEN);
  }

}
