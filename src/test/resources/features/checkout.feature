Feature: Checkout Module

Scenario: Complete checkout successfully
Given User launches the application
When User logs in and adds HP product
And User completes checkout process
Then Order should be placed successfully