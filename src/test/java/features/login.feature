Feature: Enter User Credentials
	Allow the user to login to account.
	
  Scenario Outline: User can login to the site
    Given the user is on the login page
    When the user enters logon credentials <email> and <password>
    And the user clicks the login button
    Then the user should see a success message

    Examples: 
      | email 											| password 				| 
      | testtesttest2345@test.com 	| 123456  				| 