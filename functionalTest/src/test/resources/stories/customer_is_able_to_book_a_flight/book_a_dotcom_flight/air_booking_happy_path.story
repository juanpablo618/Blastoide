Meta:
@product Air

Narrative:
As a anonimous user
I want to book a flight
So that I can get the reservation number

Scenario: Air booking
Given an anonymous traveller
When I book a flight with the following itinerary:
|key                 |value               |
|ItineraryType       |itineraryType       |
|OutboundStops       |outboundStops       |
|InboundStops        |inboundStops        |
|AdultPassengerCount |adultPassengerCount |
|SeniorPassengerCount|seniorPassengerCount|
|DepartureDate       |departureDate       |
|ReturnDate          |returnDate          |

Then an air confirmation number is displayed

Examples:
|itineraryType|outboundStops|inboundStops|adultPassengerCount|seniorPassengerCount|departureDate|returnDate|
|One-way      |1            |0           |1                  |0                   |60           |62        |
|Roundtrip    |2            |1           |1                  |0                   |55           |57        |
