package com.todoist.tasks;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.hamcrest.Matchers.is;

import com.todoist.constants.SessionVariables;
import com.todoist.interactions.GetProjects;
import com.todoist.interactions.SendNewProject;
import com.todoist.model.ProjectResponse;
import java.util.List;
import java.util.Optional;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

public class AddProject implements Task {

  private final String projectName;

  public AddProject(String projectName) {
    this.projectName = projectName;
  }

  public static Performable withName(String projectName) {
    return instrumented(AddProject.class, projectName);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        GetProjects.details(),
        SeeProjects.wereLoaded()
    );

    List<ProjectResponse> projects = actor.recall(SessionVariables.PROJECTS);
    Optional<ProjectResponse> optProject = projects.stream()
        .filter(project -> project.getName().equals(projectName))
        .findFirst();

    actor.should(
        seeThat(
            String.format("the project name '%s', is available", projectName),
            question -> !optProject.isPresent(),
            is(true)
        )
    );

    actor.attemptsTo(
        SendNewProject.withName(projectName)
    );

  }
}
