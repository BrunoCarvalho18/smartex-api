#Author: Bruno Carvalho

@general
Feature: Create an employee
    I would like to create an employee	

    
  @create-employee @post @delete
  Scenario Outline: Create an Employee
    Given made a request in API to create an employee  "<name>"  "<salary>"  "<age>" 
    And API retrive the status code 200
    Then delete this user
  
  Examples:
   |name         |salary          |age       |
   |Nicola       | 2000           | 33       |