@ACEDemo
Feature: Demo of Perfecto Automation Coverage Extensions
  #Sample Test Scenario Description

  @ACEDLogging
  Scenario: ACE Start Logging
    Given I start device logging
    Then I start device vitals

  @ACELocation
  Scenario: ACE Iterate Locations
    Given I start the device Map application
    And I am using an AppiumDriver
    When I wait for "10" seconds
    Then I take a device screenshot

    When I set the device location to the address "Rio, Brazil"
    And I wait for "10" seconds
    Then I take a device screenshot

    When I set the device location to the address "Toronto, Canada"
    And I wait for "10" seconds
    Then I take a device screenshot

    When I set the device location to the address "Cape Town, SA"
    And I wait for "10" seconds
    Then I take a device screenshot

    When I set the device location to the address "Manchester, UK"
    And I wait for "10" seconds
    Then I take a device screenshot

    When I set the device location to the address "Tokyo, Japan"
    And I wait for "10" seconds
    Then I take a device screenshot

    When I reset the device location
    Then I close the device Map application

  @ACENV
  Scenario: ACE Virtual Networking
    Given I open browser to webpage "http://www.perfecto.io"
    Then I wait "30" seconds to see the text "Menu"

    When I set the device packet loss to "100" Percent
    And I open browser to webpage "http://www.bbc.co.uk"
    Then I wait for "15" seconds

    When I update the virtual network to "3.5g_hspa_average"
    And I open browser to webpage "http://www.cnn.com"
    Then I must see text "cnn.com"

  @ACEInterruptions
  Scenario: ACE Interruptions
    Given I press mobile "HOME" key
    When I receive a phone call
    And I wait for "10" seconds
    Then I take a device screenshot

    When I receive an SMS with the text: "Greetings to the NedBank PoC!!"
    And I wait for "15" seconds
    And I start application by name "Messages"
    Then I must see text "NedBank"
    And I close application by name "Messages"

  @ACEImage
  Scenario: ACE Image Injection
    Given I start the device image capture application
    And I wait for "15" seconds
    Then I inject image: "PUBLIC:Nedbank/1200px-Nedbank_logo.svg.png"


  @ACEEndLogging
  Scenario: ACE Stop Logging
    When I stop device vital
    Then I stop device logging

