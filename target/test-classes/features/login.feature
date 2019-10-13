Feature: Login into Application

Scenario Outline: Positive test validating login
Given Intialize the browser with chrome
And Navigate to "http://qaclickacademy.com" site
And Click on Login link in Home psge to land on Secure sign in Page 
When User enters <username> and <password>and logs in
Then Verify that user is succefully logged in
And Close browsers

Examples:
|username			|password	|
|test99@gmail.com	|123456		|
|test123@gmail.com	|1234		|
|test12345@gmail.com|4321		|