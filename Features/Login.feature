Feature: Login

Scenario: Successful Login with Valid Credentials
    Given User Launch Chrome Browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and password as "admin"
    And Click on Login
    Then Page Title should be "Dashboard/ nopCommerce administration"
    When Click on Logout link
    Then Page Title should be "Your store. Login"
    And close browser