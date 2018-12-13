@touchID
Feature: Appium Touch ID Automation Feature
  #Sample Test Scenario Description

  @touchIDAndroid
  Scenario: Invoke Touch ID on Android Device and return FAIL to the script
    Given I start application by name "FingerPrintDemo"
    And I am using an AppiumDriver
    When I click on "//*[contains(@name,'AUTH')]|//*[contains(@text,'AUTH')]"
    And I set sensor authentication with error type "authFailed" result to application by name "FingerPrintDemo"
    Then I must see text "fail"
    And I close application by name "FingerPrintDemo"

  @touchIDAndroid
  Scenario: Invoke Touch ID on Android Device and return SUCCESS to the script
    Given I start application by name "FingerPrintDemo"
    And I am using an AppiumDriver
    When I click on "//*[contains(@name,'AUTH')]|//*[contains(@text,'AUTH')]"
    And I set fingerprint with success result to application by name "FingerPrintDemo"
    Then I must see text "success"
    And I close application by name "FingerPrintDemo"

  @touchIDiOS
  Scenario: Invoke Touch ID on iOS and return FAIL to the script
    Given I start application by name "FingerprintTest"
    And I am using an AppiumDriver
    When I click on "//*[contains(@name,'AUTH')]|//*[contains(@text,'AUTH')]"
    And I set sensor authentication with error type "authFailed" result to application by name "FingerprintTest"
    Then I must see text "fail"
    And I close application by name "FingerprintTest"

  @touchIDiOS
  Scenario: Invoke Touch ID on iOSand return SUCCESS to the script
    Given I start application by name "FingerprintTest"
    And I am using an AppiumDriver
    When I click on "//*[contains(@name,'AUTH')]|//*[contains(@text,'AUTH')]"
    And I set fingerprint with success result to application by name "Fingerprinttest"
    Then I must see text "success"
    And I close application by name "FingerprintTest"