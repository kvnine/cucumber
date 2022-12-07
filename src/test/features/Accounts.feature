@run
Feature: books list api
#  shopping basket features

  Scenario: test books list api
    Given setup api inventory
    When trigger api
    Then verify books list is returned

