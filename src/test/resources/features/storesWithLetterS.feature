Feature: Going to the desired store

  @storeswithletters
  Scenario: Go to the desired store with the desired letter
    Given User opens the browser and goes to the stores page
    And User clicks all stores button
    When User filters the stores with letter "S"
    Then User goes to the desired store