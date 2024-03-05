Feature: Finding NewBikes

  Scenario: upcoming bikes
    Given Navigate to Zigwheels website
    When user hover newBikes and click upcomingbikes
    Then user   select honda from manufacturer and click viewmore
    Then validate Honda bikes under 4lakh

  Scenario: Popular models
    When User hover usedcars and click chennai
    Then print all popular models in usedcar
    Then navigate to home page

  Scenario: Invalid login
    When user clicks login and gives invalid input
    Then user gets error msg
  