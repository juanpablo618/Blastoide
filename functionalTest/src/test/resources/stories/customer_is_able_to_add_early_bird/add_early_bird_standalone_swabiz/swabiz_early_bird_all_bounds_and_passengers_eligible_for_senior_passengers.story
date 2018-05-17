Meta:
@product earlyBird
@suite swabizSmoke

Narrative:
As a Swabiz user
I want to be able to add an EarlyBird to my reservation only senior passengers
So that I can validate the confirmation page is displayed

Scenario: Add early bird to reservation with an IRN on the purchase

Given I book a flight on Swabiz with the following itinerary:
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

When I add the early-bird option on Swabiz
Then an air confirmation number is displayed on Swabiz Early Bird Confirmation page for seniors
And an air internal reference number is displayed on Swabiz Early Bird confirmation page
Examples:
|itineraryType|departureAirport|arrivalAirport|destinationAirport|outboundStops|inboundStops|adultPassengerCount|seniorPassengerCount|departureDate|returnDate|confirmationNumber|
|Roundtrip    |LGA             |ATL           |                  |1            |1           |0                  |1                   |55           |57        |PIT83Y            |
|One-way      |DAL             |HOU           |                  |1            |1           |0                  |1                   |63           |65        |PIU7V3            |
|One-way      |MEX             |HOU           |                  |1            |1           |0                  |2                   |60           |62        |PIUTDD            |
|Multi-city   |DAL             |SAT           |HOU               |1            |1           |0                  |1                   |60           |62        |PIWYEZ            |