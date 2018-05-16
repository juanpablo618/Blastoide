Meta:
@product earlyBird
@issue ECOM-17787
@suite regression

Narrative:
As a Southwest user
I want to be able to go back from the select to the landing page
So that I can see the navigation works correctly

Scenario: Return from select to landing page

Given a PNR with the following Itinerary:
|key                 |value               |
|ItineraryType       |itineraryType       |
|DepartureAirport    |departureAirport    |
|ArrivalAirport      |arrivalAirport      |
|AdultPassengerCount |adultPassengerCount |
|DepartureDate       |departureDate       |
|ReturnDate          |returnDate          |
|ConfirmationNumber  |confirmationNumber  |

When access to select page with flight information and return to the entrypoint
Then webpage to the entrypoint is correctly displayed

Examples:
|itineraryType|departureAirport|arrivalAirport|adultPassengerCount|departureDate|returnDate|confirmationNumber|
|Roundtrip    |LGA             |ATL           |3                  |55           |57        |OOTREF            |