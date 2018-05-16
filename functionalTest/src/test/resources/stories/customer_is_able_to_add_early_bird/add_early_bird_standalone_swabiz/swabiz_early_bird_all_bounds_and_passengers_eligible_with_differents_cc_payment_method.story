Meta:
@product earlyBird
@suite swabizRegression

Narrative:
As a Southwest user
I want to be able to add an EarlyBird to my reservation with differents CC
So that I can have priority boarding in my flight

Scenario: Add early bird to reservation with all bounds and passengers elegible on swabiz

Given I book a flight on Swabiz with the following itinerary:
|key                  |value                |
|ItineraryType        |itineraryType        |
|DepartureAirport     |departureAirport     |
|ArrivalAirport       |arrivalAirport       |
|AdultPassengerCount  |adultPassengerCount  |
|DepartureDate        |departureDate        |
|ReturnDate           |returnDate           |
|ConfirmationNumber   |confirmationNumber   |
|CreditCardNumber     |creditCardNumber     |
|CvvNumber            |cvvNumber            |
|PositionOfCCSelector |positionOfCCSelector |

When I add the early-bird option with specific CC on swabiz
Then an air confirmation number is displayed on Swabiz Early Bird Confirmation page for adult passengers
Examples:
|itineraryType|departureAirport|arrivalAirport|adultPassengerCount|departureDate|returnDate|confirmationNumber|creditCardNumber |cvvNumber|positionOfCCSelector|
|Roundtrip    |DAL             |LAS           |1                  |55           |57        |OOTREF            |378282246310005  |1234     |5                   |
|Roundtrip    |LGA             |ATL           |2                  |55           |57        |OOTREF            |6000000000000007 |123      |7                   |
|Roundtrip    |HOU             |DAL           |4                  |55           |57        |OOTREF            |5555555555554444 |123      |3                   |
|Roundtrip    |LOS             |DAL           |2                  |55           |57        |OOTREF            |4111999999999999 |123      |1                   |
|Roundtrip    |LGA             |ATL           |1                  |55           |57        |OOTREF            |135412345678911  |123      |6                   |