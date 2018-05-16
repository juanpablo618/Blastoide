Meta:
@product earlyBird
@issue ECOM-17764
@suite RRTier

Narrative:
As a user
I want to purchase early bird with hot state
So that I can validate the payment method with a credit card or new credit card

Scenario: Use a saved credit card to made the early bird purchase

Given a PNR with the following Itinerary:
|key                 |value               |
|ItineraryType       |itineraryType       |
|DepartureAirport    |departureAirport    |
|ArrivalAirport      |arrivalAirport      |
|AdultPassengerCount |adultPassengerCount |
|DepartureDate       |departureDate       |
|ReturnDate          |returnDate          |

When I buy an Early bird option with a saved credit card

Then saved credit card radio button is selected by default
Examples:
|itineraryType|departureAirport|arrivalAirport|adultPassengerCount|departureDate|returnDate|
|Roundtrip    |DAL             |HOU           |1                  |55           |57        |

Scenario: Use a new credit card to made the early bird purchase

Given a PNR with the following Itinerary:
|key                 |value               |
|ItineraryType       |itineraryType       |
|DepartureAirport    |departureAirport    |
|ArrivalAirport      |arrivalAirport      |
|AdultPassengerCount |adultPassengerCount |
|DepartureDate       |departureDate       |
|ReturnDate          |returnDate          |

When I buy an Early bird option with a new credit card

Then credit card form is displayed
Examples:
|itineraryType|departureAirport|arrivalAirport|adultPassengerCount|departureDate|returnDate|
|Roundtrip    |DAL             |HOU           |1                  |55           |57        |