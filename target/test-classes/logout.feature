@smoke
Feature: Parabank logout testing
Description: User should already have an account 
Background: User should be logged in
@TC1 
Scenario Outline: As a loggedin user I want to logout from Parabank website 
Given open the browser
And pass the URL "<URL>"
When enter username "<username>" in the user field
And enter password "<password>" in the password field
And click on Login
And click on Logout
Then Validate Logout is successful
Examples:
|URL                                                           |username|password|
|https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC|Jesmin  |amma01716PA!@|