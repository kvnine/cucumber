@run
Feature: Accounts feature
#  shopping basket features

  Scenario: create an account for customer
    Given Launch the discovery web app
#    When Fill the details of customer and click on Create Account button
#    Then Account should be created
#    And Account should be present in db



  Scenario: test books list api
    Given setup api inventory
    When trigger api
    Then verify books list is returned
#  Scenario: delete an account for customer
