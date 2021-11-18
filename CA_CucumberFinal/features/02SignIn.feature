Feature: Sign In

Scenario Outline: User is Signing In

Given Getting driver from the HomePageSD file
Then click on SignIn button
Then giving the email as "<email>" and Password as "<password>"
And Clicking on the submit button

Examples:
|	email	|	password	|
|		    |		            |
|	simon@123	|	abcd	|
|	JackNJill@gmail.com	|	JackNJill	|
