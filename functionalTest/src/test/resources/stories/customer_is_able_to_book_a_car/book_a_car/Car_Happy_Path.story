Meta:
@tag product:Car
@issue ECOM-1123
@product Car

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: Car booking

Given I am on the Car Search page
When I book a car with <firstName> and <lastName>
Then I validate the confirmation number
Examples:
| firstName | lastName |
| James     | Lebron   |
| Mariano   | Joison   |
