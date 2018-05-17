Meta:
@product earlyBird
@issue ECOM-18287
@suite swabizSmoke

Narrative:
As a Swabiz user
I want to be able to add an EarlyBird to my reservation
So that I can validate the IRN display on the purchase

Scenario: Add early bird to reservation with an IRN on the purchase

Given I book a flight on Swabiz with the following itinerary:
|key                    |value                  |
|ItineraryType          |itineraryType          |
|DepartureAirport       |departureAirport       |
|ArrivalAirport         |arrivalAirport         |
|OutboundStops          |outboundStops          |
|InboundStops           |inboundStops           |
|AdultPassengerCount    |adultPassengerCount    |
|SeniorPassengerCount   |seniorPassengerCount   |
|DepartureDate          |departureDate          |
|ReturnDate             |returnDate             |
|InternalReferenceNumber|internalReferenceNumber|

When I add the early-bird option on Swabiz
Then an air confirmation number is displayed on Swabiz Early Bird Confirmation page for adult passengers
And an air internal reference number is displayed on Swabiz Early Bird confirmation page

Examples:
|itineraryType|departureAirport|arrivalAirport|outboundStops|inboundStops|adultPassengerCount|seniorPassengerCount|departureDate|returnDate|internalReferenceNumber|
|Roundtrip    |DAL             |AMA           |0            |0           |3                  |0                   |55           |57        |1234567890123          |
|One-way      |HOU             |AMA           |0            |0           |1                  |0                   |63           |65        |1234567890123          |