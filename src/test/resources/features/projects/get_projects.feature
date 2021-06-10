Feature: Get Projects

  Scenario: Get all projects
    Given Juan is an authenticated user in todoist
    When he asks for his projects
    Then he should see his projects