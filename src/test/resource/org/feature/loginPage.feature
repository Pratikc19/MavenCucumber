Feature: Login page feature

Scenario: Validate login page
Given User is on login page
Then Username field is displayed 
And Password field is displayed 
And Login field is displayed 
And Keep me login checkbox is displayed 
And Actitime logo is displayed 
And Login page title is displayed as "actiTIME - Login"
And Login page URL is displayed as "http://localhost:90/login.do"

Scenario: Login successfully
Given User is on login page
When User enter Username
And User enter Password
And Click on login button 
Then Dashboard URL should be displayed "http://localhost:90/user/submit_tt.do"
And Dashboard page title should be displayed "actiTIME - Enter Time-Track"