Feature: Login into Application
Scenario Outline: Positive test validating login
Given initializing the browser with chrome
And navigate to "http://QAClickAcademy.com" site
And click on Login link in homepage to land on secure sign in page
When user enters <username> and <password> and logs in
Then verify that user is successfully logged in
And close the browsers

Examples:
|username				|password		|
|test99@gmail.com		|123456			|
|test123@gmail.com		|123			|