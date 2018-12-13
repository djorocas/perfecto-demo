@locationInjection
Feature: Appium Touch ID Automation Feature
  #Sample Test Scenario Description

  @locationCycleAndroid
  Scenario: Cycle Locations on Android
    Given I start application by name "Maps"
    And I am using an AppiumDriver
    When I set the device location to the address "Rio, Brazil"
    And I wait for "10" seconds
    And I set the device location to the address "Toronto, Canada"
    And I wait for "10" seconds
    And I set the device location to the address "Cape Town, SA"
    And I wait for "10" seconds
    And I set the device location to the address "Manchester, UK"
    And I wait for "10" seconds
    And I set the device location to the address "Tokyo, Japan"
    And I wait for "10" seconds
    Then I reset the device location
    And I close application by name "Maps"

  @locationCycleiOS
  Scenario: Cycle Locations on iOS
    Given I start application by name "Google Maps"
    And I am using an AppiumDriver
    When I set the device location to the address "Rio, Brazil"
    And I wait for "10" seconds
    And I set the device location to the address "Toronto, Canada"
    And I wait for "10" seconds
    And I set the device location to the address "Cape Town, SA"
    And I wait for "10" seconds
    And I set the device location to the address "Manchester, UK"
    And I wait for "10" seconds
    And I set the device location to the address "Tokyo, Japan"
    And I wait for "10" seconds
    Then I reset the device location
    And I close application by name "Google Maps"
