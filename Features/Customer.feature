Feature: New customer

  Scenario Outline: : Add a new customer

    Given User Launch Chrome Browser
    When user Opens URL "https://admin-demo.nopcommerce.com/login"
    And User enter Email as "<email>" and Password as "<password>"
    And Click on login
    Then User can view Dashboard
    When User click on customer menu
    And User click on customer menu in dropdown
    And Click on AddNew button
    Then User can view add new customer page
    When User enter customer info
    And Click the save button
    Then User can view confirmation message "The new customer has been added successfully."
    And Close Browser
    Examples:
      |  email|password|
      | admin@yourstore.com |admin|

