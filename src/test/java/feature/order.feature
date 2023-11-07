#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
 @smoke
Feature: verifying order details of amazon
  

@smoke
  Scenario: verifying last 3 months order 
    Given amzon url loaded :"https://www.amazon.ca/"
    
    When I click on order page
    
   
    Then Order List for the Filter should be shown
    

@smoke
  Scenario Outline: verifying cancelled order
    Given Amazon url "https://www.amazon.ca/"

    When I move to cancel order tabe
    Then Order List for the Filter should be shown

