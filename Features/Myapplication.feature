@tag
Feature: Test the Facebook login

  Scenario Outline: Test facebooklogin with valid credintial
    Given open firefox and start application
    When I enter valid "<uname>" and "<pwd>"
    Then user should be able to login successfully
    

    Examples: 
      | uname                  | pwd       |
      | www.samarora@gmail.com | asd!!!!!! |
   
 @tag1
   

Scenario Outline: Test facebooklogin with valid credintial
    Given user navigate to facebook 
    When enter valid "<uname>" and "<pwd>"
    Then user should be able to login successfully and post status
    

    Examples: 
      | uname                  | pwd       |
      | sunny.stestq@gmail.com | ffdfdffdg |