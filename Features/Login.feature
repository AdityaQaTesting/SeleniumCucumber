Feature: Login


@sanity
  Scenario: Successful login with valid credentials
    Given User Launch  Browser
    When user Opens URL "https://admin-demo.nopcommerce.com/login"
    And User enter Email as "admin@yourstore.com" and Password as "admin"
    And Click on login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on Logout link
    Then Page Title should be "Your store. Login"
    And Close Browser


@regression
  Scenario Outline: : login with data driven
    Given User Launch  Browser
    When user Opens URL "https://admin-demo.nopcommerce.com/login"
    And User enter Email as "<email>" and Password as "<password>"
    And Click on login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on Logout link
    Then Page Title should be "Your store. Login"
    And Close Browser
    Examples:
      |  email|password|
      | admin@yourstore.com |admin|



