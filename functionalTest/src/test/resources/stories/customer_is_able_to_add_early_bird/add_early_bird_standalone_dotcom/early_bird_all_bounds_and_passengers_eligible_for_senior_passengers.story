Meta:
@product earlyBird
@suite smoke

Narrative:
As a Southwest user
I want to be able to add an EarlyBird to my reservation only with Senior Passengers
So that I can have priority boarding in my flight

Scenario: Add early bird to reservation with all bounds and senior passengers type elegible

Given a PNR with the following Itinerary:
|key                 |value               |
|ItineraryType       |itineraryType       |
|DepartureAirport    |departureAirport    |
|ArrivalAirport      |arrivalAirport      |
|DestinationAirport  |destinationAirport  |
|OutboundStops       |outboundStops       |
|InboundStops        |inboundStops        |
|AdultPassengerCount |adultPassengerCount |
|SeniorPassengerCount|seniorPassengerCount|
|DepartureDate       |departureDate       |
|ReturnDate          |returnDate          |
|ConfirmationNumber  |confirmationNumber  |

When I add the early-bird option
Then confirmation page is displayed containing the correct information for Senior Passengers
Examples:
|itineraryType|departureAirport|arrivalAirport|destinationAirport|outboundStops|inboundStops|adultPassengerCount|seniorPassengerCount|departureDate|returnDate|confirmationNumber|
|Roundtrip    |LGA             |ATL           |                  |1            |1           |0                  |1                   |55           |57        |PIT83Y            |
|One-way      |DAL             |HOU           |                  |1            |1           |0                  |1                   |63           |65        |PIU7V3            |
|One-way      |MEX             |HOU           |                  |1            |1           |0                  |2                   |60           |62        |PIUTDD            |
|Multi-city   |DAL             |FLL           |MEX               |1            |1           |0                  |1                   |60           |62        |PIWYEZ            |