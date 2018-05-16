Meta:
@product earlyBird
@issue ECOM-17762
@suite regression

Narrative:
As a Southwest user adding EB to my reservation
I want to see not eligible bound in the reservation with its correct reason
So that I am aware about the bound that is ineligible

Scenario: Add early bird to reservation with at least one ineligible bound

Given a PNR with the following Itinerary:
|key                 |value               |
|ItineraryType       |itineraryType       |
|DepartureAirport    |departureAirport    |
|DestinationAirport  |destinationAirport  |
|ArrivalAirport      |arrivalAirport      |
|AdultPassengerCount |adultPassengerCount |
|DepartureDate       |departureDate       |
|ReturnDate          |returnDate          |
|FareTypeOB          |fareTypeOB          |
|FareTypeIB          |fareTypeIB          |
|ConfirmationNumber  |confirmationNumber  |

When I retrieve reservation for early bird purchase
Then The correct ineligible bound is displayed
Examples:
|itineraryType|departureAirport|destinationAirport|arrivalAirport|adultPassengerCount|departureDate|returnDate|fareTypeOB    |fareTypeIB     |confirmationNumber|
|Multi-city   |DAL             |AMA               |HOU           |1                  |65           |67        |Wanna get away|Business select|TYUX9W            |
|Roundtrip    |DAL             |                  |OMA           |1                  |1            |15        |Anytime       |Anytime        |TYUTOR            |