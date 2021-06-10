Feature: Add Project

  Scenario Outline: Add new project
    Given Juan is an authenticated user in todoist
    When he creates a new project: <name>
    Then he should see the project <name> was created
    Examples:
      | name      |
      | project x |
      | project y |