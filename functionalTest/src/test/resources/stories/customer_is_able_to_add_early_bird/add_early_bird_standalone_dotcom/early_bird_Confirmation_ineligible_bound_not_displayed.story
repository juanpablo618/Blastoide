Meta:
@product earlyBird
@issue ECOM-18015
@suite regression

Narrative:
As a Southwest user adding EB to my reservation
I want to see ineligible bound is not displayed in the confirmation page

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

When I add the early-bird option
Then The ineligible bound is not displayed in confirmation page

Examples:
|itineraryType|departureAirport|destinationAirport|arrivalAirport|adultPassengerCount|departureDate|returnDate|fareTypeOB    |fareTypeIB     |confirmationNumber|
|Multi-city   |DAL             |AMA               |HOU           |1                  |65           |67        |Wanna get away|Business select|TYUX9W            |
|Roundtrip    |DAL             |                  |OMA           |1                  |1            |15        |Anytime       |Anytime        |TYUTOR            |