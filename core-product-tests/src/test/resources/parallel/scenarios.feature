Feature: Scenarios feature file

  Scenario: Test Scenario from main page
    Given I am on the CP page
    When I hover on threeDot and click News
    Then the page url should contain 'warriors'
    And I count total video feeds and flag all video feeds more than '3d'

  Scenario: Test Scenario from news page
    Given I am on the CP menu page
    Then the page url should contain 'news'
    And I count total video feeds and flag all video feeds more than '3d'