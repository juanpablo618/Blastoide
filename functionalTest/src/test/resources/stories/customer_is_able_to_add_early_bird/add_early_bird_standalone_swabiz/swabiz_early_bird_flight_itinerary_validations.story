Meta:
@product earlyBird
@suite swabizRegression

Narrative:
As a Swabiz user with an eligible reservation to add EarlyBird
I want to retrieve my reservation
So that I can know the itinerary details

Scenario: Validate flight itinerary to add early bird

Given a swabiz PNR with the following Itinerary:
|key                 |value               |
|ItineraryType       |itineraryType       |
|DepartureAirport    |departureAirport    |
|ArrivalAirport      |arrivalAirport      |
|OutboundStops       |outboundStops       |
|InboundStops        |inboundStops        |
|AdultPassengerCount |adultPassengerCount |
|DepartureDate       |departureDate       |
|ReturnDate          |returnDate          |
|NumbersOfRRUser     |numbersOfRRUser     |
|ConfirmationNumber  |confirmationNumber  |

When I retrieve reservation for early bird purchase on swabiz
Then reservation and passenger details are correctly displayed on swabiz

Examples:
|itineraryType|departureAirport|arrivalAirport|outboundStops|inboundStops|adultPassengerCount|departureDate|returnDate|numbersOfRRUser|confirmationNumber|
|Roundtrip    |LGA             |ATL           |1            |1           |3                  |55           |57        |1              |TZLID5            |
|One-way      |SAN             |LGA           |1            |1           |1                  |60           |62        |0              |TZM62O            |
|One-way      |MEX             |DAL           |1            |1           |2                  |60           |62        |0              |OOUNYT            |