#Author: Arjun
Feature: GET: Hooks Demo
  Description: GET: purpose of this feature is to test demo Hooks.

  @hooks
  Scenario Outline: GET: Test Hooks
    #Given I want to set URL as "<URL>" for test case "<TestName>"
    When I set header content type as "<ContentType>"
    When I hit the API with requestbody "<RequestBody>" and request method is "<RequestMethod>"
    #Then I try to verify the status code is "<StatusCode>"

    Examples: 
      | ContentType      | RequestBody | RequestMethod |
      | application/json |             | GET           |