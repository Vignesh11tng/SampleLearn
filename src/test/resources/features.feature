Feature: Validate the Adactin Home Page Login

  Scenario Outline: Validate the Book Hotel Page Login using Valid credentials
    Given User should navigate to Adactin Home Page
    When User enter "<username>" and "<Password>"
    And User clicks the login buttion
    And User enter location, Hotels, Room Type, NumberOfRooms, DateIn, DateOut, AdultsPerRoom, ChildrenPerRoom
    And User clicks the Search buttion
    And User should select desired hotel
    And User clicks the Continue buttion
    And User enter FirstName, LastName, BillingAddress, CreditCardNo, CreditCardType, ExpiryMonth, ExpiryYear, CVVNumber
    And User clicks the BookNow button
    Then Validate Order Number Generated or not
    Examples:
    |username|Password|
    |Vigneshn660066|Vigneshn660066|