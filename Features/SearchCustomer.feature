Feature: SearchCustomer

   Background:  Below steps are common steps
    Given User Launch  Browser
    When user Opens URL "https://admin-demo.nopcommerce.com/login"
    And User enter Email as "admin@yourstore.com" and Password as "admin"
    And Click on login
    Then User can view Dashboard
@sanity
  Scenario: Search customer by Name

    When User click on customer menu
    And User click on customer menu in dropdown
    And Enter customer FirstName
    And Enter customer LastName
    When Click on search button
    Then User should found Name in the Search table
    And Close Browser

@regression
  Scenario: Search customer by email ID

    When User click on customer menu
    And User click on customer menu in dropdown
    And Enter customer EmailID
    When Click on search button
    Then User should found Email in the Search table
    And Close Browser
