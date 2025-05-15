Feature:OrangeHRM login functionality
Scenario:Valid login
Given I am in OrangeHRM login page
When I give the username "Admin" and password "admin123"
And click on the login button
Then the page gets redirected to Dashboard

Scenario:Invalid login username
Given I am in login page and I give the username as "Sumi" and password as "admin123"
And click the submit button
Then the error message is displayed on login page

Scenario:Invalid login password
Given I am in login page
When I give the username as "Admin" and password as "sumi123"
And click on login button
Then error message is dosplayed as Invalid credentials
