Meta:
@product earlyBird
@issue ECOM-17711,ECOM-17740,ECOM-17751,ECOM-17765
@suite regression

Narrative:
As a Southwest user
I want to be able to add an EarlyBird to my reservation on a flight with extra seats
So that I can have priority boarding in my flight and see that the extra seats are not elegible

Scenario: Add early bird for 4 passengers with Extra seats and a passenger is A-list

Given a PNR with the following Itinerary:
|key                         |value                       |
|ItineraryType               |itineraryType               |
|DepartureAirport            |departureAirport            |
|ArrivalAirport              |arrivalAirport              |
|AdultPassengerCount         |adultPassengerCount         |
|ExtraSeatPassengerCount     |extraSeatPassengerCount     |
|AListPreferredUsersCount    |aListPreferredUsersCount    |
|AListPreferredExtraSeatCount|aListPreferredExtraSeatCount|
|DepartureDate               |departureDate               |
|ReturnDate                  |returnDate                  |
|ConfirmationNumber          |confirmationNumber          |

When I add the early-bird option
Then confirmation page is displayed containing the correct information
Examples:
|itineraryType|departureAirport|arrivalAirport|adultPassengerCount|extraSeatPassengerCount|departureDate|returnDate|confirmationNumber|aListPreferredUsersCount|aListPreferredExtraSeatCount|
|Roundtrip    |LGA             |ATL           |8                  |                      4|55           |57        |SZ4K7V            |                       1|                           1|