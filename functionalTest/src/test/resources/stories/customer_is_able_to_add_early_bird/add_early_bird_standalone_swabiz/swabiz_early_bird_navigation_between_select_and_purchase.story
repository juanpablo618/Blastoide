Meta:
@product earlyBird
@issue ECOM-17787
@suite swabizRegression

Narrative:
As a Southwest user
I want to be able to navigate between select and purchase page
So that I can see the navigation works correctly

Scenario: Navigate between select and purchase page

Given a swabiz PNR with the following Itinerary:
|key                 |value               |
|ItineraryType       |itineraryType       |
|DepartureAirport    |departureAirport    |
|ArrivalAirport      |arrivalAirport      |
|AdultPassengerCount |adultPassengerCount |
|DepartureDate       |departureDate       |
|ReturnDate          |returnDate          |
|ConfirmationNumber  |confirmationNumber  |

When navigate between select and purchase on swabiz
Then All the inputs fields are empty on the purchase page on swabiz

Examples:
|itineraryType|departureAirport|arrivalAirport|adultPassengerCount|departureDate|returnDate|confirmationNumber|
|Roundtrip    |LGA             |ATL           |3                  |55           |57        |OOTREF            |