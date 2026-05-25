Feature: Login Module

Scenario: Login with valid credentials
Given User launches the application
When User clicks on My Account
And User clicks on Login
And User enters valid email
And User enters valid password
And User clicks Login button
Then User should login successfully

Scenario: Login with invalid email
Given User launches the application
When User clicks on My Account
And User clicks on Login
And User enters invalid email
And User enters valid password
And User clicks Login button
Then Warning message should be displayed