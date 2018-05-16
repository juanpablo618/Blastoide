Meta:
@product earlyBird
@suite smoke

Narrative:
As a Southwest user
I want to be able to add an EarlyBird to my reservation
So that I can have priority boarding in my flight

Scenario: Add early bird to reservation with all bounds and passengers elegible

Given a PNR with the following Itinerary:
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
|Roundtrip    |LGA             |ATL           |                  |3                  |55           |57        |OOTREF            |
|One-way      |SAN             |LGA           |                  |1                  |63           |65        |OOUFLZ            |
|One-way      |MEX             |HOU           |                  |2                  |60           |62        |OOV3X7            |
|Multi-city   |DAL             |FLL           |MEX               |2                  |60           |62        |OOUNYT            |