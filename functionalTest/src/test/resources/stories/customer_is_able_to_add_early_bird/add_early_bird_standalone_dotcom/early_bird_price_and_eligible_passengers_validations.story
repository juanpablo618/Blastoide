Meta:
@product earlyBird
@issue ECOM-17887
@suite regression

Narrative:
As a Southwest user with an eligible reservation to add EarlyBird
I want to retrieve my reservation
So that I can know the early bird prices

Scenario: See the price information for EarlyBird's select page

Given a PNR with the following Itinerary:
|key                 |value               |
|ItineraryType       |itineraryType       |
|DepartureAirport    |departureAirport    |
|ArrivalAirport      |arrivalAirport      |
|AdultPassengerCount |adultPassengerCount |
|DepartureDate       |departureDate       |
|ReturnDate          |returnDate          |
|NumbersOfRRUser     |numbersOfRRUser     |
|ConfirmationNumber  |confirmationNumber  |

When I retrieve a reservation to select passengers for Early Bird:
|key                        |value                      |
|NumberOfSelectedPassengerOB|numberOfSelectedPassengerOB|
|NumberOfSelectedPassengerIB|numberOfSelectedPassengerIB|

Then Subtotal and estimated total is displayed
And the continue button is <continueButtonState>

Examples:
|itineraryType|departureAirport|arrivalAirport|adultPassengerCount|departureDate|returnDate|numberOfSelectedPassengerOB|numberOfSelectedPassengerIB|continueButtonState|numbersOfRRUser|confirmationNumber|
|Roundtrip    |LGA             |ATL           |4                  |55           |57        |4                          |4                          |Enable             |1              |TZS7FZ            |
|One-way      |SAN             |LGA           |1                  |57           |59        |1                          |0                          |Enable             |0              |TZQW6K            |
|One-way      |MEX             |HOU           |1                  |60           |62        |1                          |0                          |Enable             |0              |TZSNVN            |
|Roundtrip    |LGA             |ATL           |4                  |55           |57        |2                          |2                          |Enable             |1              |TZSL6Z            |
