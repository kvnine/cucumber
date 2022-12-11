@run
Feature: Accounts feature
#  shopping basket features

  Scenario: create an account for customer
#    Given Launch the discovery web app
    Given Launch the discovery web application
    And Provider username and password
    When Click on Login button
    Then Home page should be displayed
    And Close Browser

@getApi
  Scenario: Read test books list
    Given setup api inventory1
    When trigger get account api1
    Then verify books list is returned1

@postApi
  Scenario: Create book in books list
    Given setup api inventory1
    When trigger post account api1
    Then verify books list is returned1

@deleteApi
  Scenario: Delete book from books list
    Given setup api inventory1
    When trigger delete account api1
    Then verify books list is returned1

  @updateApi
  Scenario: Update book from books list
    Given setup api inventory1
    When trigger update account api1
    Then verify books list is returned1