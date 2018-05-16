Meta:
@product earlyBird
@suite swabizRegression

Narrative:
As a Swabiz user adding EB to my reservation
I want to see not eligible passenger(s) included in the reservation
So that I am aware about the pax that are not able to purchase the product

Scenario: Validate not eligible passengers on Early Bird's select page

Given a swabiz PNR with the following Itinerary:
|key                      |value                    |
|ItineraryType            |itineraryType            |
|DepartureAirport         |departureAirport         |
|ArrivalAirport           |arrivalAirport           |
|AdultPassengerCount      |adultPassengerCount      |
|DepartureDate            |departureDate            |
|ReturnDate               |returnDate               |
|AListPreferredUsersCount |aListPreferredUsersCount |
|ConfirmationNumber       |confirmationNumber       |

When I retrieve reservation for early bird purchase on swabiz
Then The correct amount of ineligible passenger is displayed on swabiz
Examples:
|itineraryType|departureAirport|arrivalAirport|adultPassengerCount|departureDate|returnDate|aListPreferredUsersCount|confirmationNumber|
|One-way      |DAL             |HOU           |2                  |55           |57        |1                       |TZP6FV            |