Feature: Application Login  

Scenario: Homepage default login
Given User is on Banking landing page
When user login into landing page with "arjun" and "arjy123"
Then homepage is populated
And cards are displayed "true"


Scenario: Homepage default login
Given User is on Banking landing page
When user login into landing page with "deepu" and "deepu@122"
Then homepage is populated
And cards are displayed "false"
