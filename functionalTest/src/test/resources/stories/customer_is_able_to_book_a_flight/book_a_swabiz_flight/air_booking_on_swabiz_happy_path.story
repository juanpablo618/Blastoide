Meta:
@product Swabiz Air

Narrative:
As a anonymous user on Swabiz
I want to book a flight on Swabiz
So that I can get the reservation number

Scenario: Air booking
Given an anonymous traveller on Swabiz
And I book a flight on Swabiz with the following itinerary:
|key                        |value                  |
|ItineraryType              |itineraryType          |
|DepartureAirport           |departureAirport       |
|ArrivalAirport             |arrivalAirport         |
|OutboundStops              |outboundStops          |
|InboundStops               |inboundStops           |
|AdultPassengerCount        |adultPassengerCount    |
|SeniorPassengerCount       |seniorPassengerCount   |
|DepartureDate              |departureDate          |
|ReturnDate                 |returnDate             |

Then an air confirmation number is displayed on Swabiz confirmation page

Examples:
|itineraryType|departureAirport|arrivalAirport|outboundStops|inboundStops|adultPassengerCount|seniorPassengerCount|departureDate|returnDate|
|Roundtrip    |DAL             |AMA           |0            |0           |1                  |0                   |55           |57        |
|One-way      |HOU             |AMA           |0            |0           |1                  |0                   |63           |65        |