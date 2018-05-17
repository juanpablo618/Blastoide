Meta:
@product earlyBird

Narrative:
As a Southwest user
I want to be able to add an EarlyBird to my reservation
So that I can have priority boarding in my flight

Scenario: Add early bird to reservation with all bounds and passengers elegible passenger with large name and random suffix

Given a PNR with the following Itinerary with suffix, middle name and large first name:
|key                 |value               |
|ItineraryType       |itineraryType       |
|DepartureAirport    |departureAirport    |
|ArrivalAirport      |arrivalAirport      |
|DestinationAirport  |destinationAirport  |
|AdultPassengerCount |adultPassengerCount |
|DepartureDate       |departureDate       |
|ReturnDate          |returnDate          |
|ConfirmationNumber  |confirmationNumber  |

When I add the early-bird option
Then confirmation page is displayed containing the correct information
Examples:
|itineraryType|departureAirport|arrivalAirport|destinationAirport|adultPassengerCount|departureDate|returnDate|confirmationNumber|
|Roundtrip    |LGA             |ATL           |                  |1                  |55           |57        |W5OOHD            |