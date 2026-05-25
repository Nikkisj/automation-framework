Feature: Registration Module

Scenario: Register successfully
Given User launches the application
When User navigates to Register page
And User enters registration details
And User clicks Continue button
Then Account should be created successfully