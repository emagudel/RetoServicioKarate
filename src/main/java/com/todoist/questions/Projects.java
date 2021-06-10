package com.todoist.questions;

import com.todoist.model.ProjectResponse;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

public class Projects implements Question<List<ProjectResponse>> {

  public static Question<List<ProjectResponse>> response() {
    return new Projects();
  }

  @Subject("the projects")
  @Override
  public List<ProjectResponse> answeredBy(Actor actor) {
    return Arrays
        .stream(SerenityRest.lastResponse().as(ProjectResponse[].class))
        .collect(Collectors.toList());
  }
}
