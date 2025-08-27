Feature: Entity consultation

  Scenario Outline: Query Entity
    Given the application is running
    When I request the Entity for id <id>
    Then the response should contain id <id>

    Examples:
      | id        |
      | 1         |