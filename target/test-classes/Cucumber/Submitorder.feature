
@tag
Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file
  
  
  Background:
  Given I Land on Ecommerce page

  @tag2
  Scenario Outline: Positive Test of submitting the order
    Given Login with username<name> and password<password>
    When I add the <product> to cart
    And checkout <product> and submit order
    Then "THANKYOU FOR THE ORDER." message displayed on confirmationpage

    Examples: 
      | name                       |     password      |       product         |
      | akileshnikki@outlook.com |   Akilesh@123       | ADIDAS ORIGINAL       |
      
