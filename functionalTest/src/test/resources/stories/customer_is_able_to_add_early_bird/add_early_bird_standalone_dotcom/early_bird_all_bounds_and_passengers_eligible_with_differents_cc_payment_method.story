Meta:
@product earlyBird
@suite regression

Narrative:
As a Southwest user
I want to be able to add an EarlyBird to my reservation with differents CC
So that I can have priority boarding in my flight

Scenario: Add early bird to reservation with all bounds and passengers elegible with different CC payment methods

Given a PNR with the following Itinerary:
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

When I add the early-bird option with specific CC
Then confirmation page is displayed containing the correct information
Examples:
|itineraryType|departureAirport|arrivalAirport|adultPassengerCount|departureDate|returnDate|confirmationNumber|creditCardNumber |cvvNumber|positionOfCCSelector|
|Roundtrip    |DAL             |LAS           |3                  |55           |57        |OOTREF            |378282246310005  |1234     |5                   |
|Roundtrip    |LGA             |ATL           |3                  |55           |57        |OOTREF            |6000000000000007 |123      |7                   |
|Roundtrip    |HOU             |DAL           |3                  |55           |57        |OOTREF            |5555555555554444 |123      |3                   |
|Roundtrip    |LOS             |DAL           |3                  |55           |57        |OOTREF            |4111999999999999 |123      |1                   |
|Roundtrip    |LGA             |ATL           |3                  |55           |57        |OOTREF            |135412345678911  |123      |6                   |