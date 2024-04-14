Feature: Footer Link Testing for DP2 page

  @DP2 @smoke @DP2smoke
  Scenario: Test to find all anchor links in footer and check duplicates
    Given I am on the DP2 page
    When I get all anchor links present
    Then I store all links and find duplicates
    And I write them to a CSV file[output.csv] and flag duplicates
