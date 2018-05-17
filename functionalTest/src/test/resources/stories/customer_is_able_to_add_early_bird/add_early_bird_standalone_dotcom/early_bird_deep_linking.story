Meta:
@product earlyBird
@issue ECOM-17788
@suite regression

Narrative:
As a Southwest user
I want to be able to use deep link for the Select page
So that I can access from different entrypoints

Scenario: Deep linking to select page for valid reservation

Given a PNR with the following Itinerary:
|key                 |value               |
|ItineraryType       |itineraryType       |
|DepartureAirport    |departureAirport    |
|ArrivalAirport      |arrivalAirport      |
|AdultPassengerCount |adultPassengerCount |
|DepartureDate       |departureDate       |
|ReturnDate          |returnDate          |
|ConfirmationNumber  |confirmationNumber  |

When access to select page with flight information
Then reservation and passenger details are correctly displayed
Examples:
|itineraryType|departureAirport|arrivalAirport|adultPassengerCount|departureDate|returnDate|confirmationNumber|
|Roundtrip    |LGA             |ATL           |3                  |55           |57        |OOTREF            |

Scenario: Deep linking to select page for cancelled reservation

Given a cancelled PNR with the following Itinerary:
|key                 |value               |
|ItineraryType       |itineraryType       |
|DepartureAirport    |departureAirport    |
|ArrivalAirport      |arrivalAirport      |
|AdultPassengerCount |adultPassengerCount |
|DepartureDate       |departureDate       |
|ReturnDate          |returnDate          |
|ConfirmationNumber  |confirmationNumber  |

When access to select page with flight information
Then an oops message is displayed on landing page
Examples:
|itineraryType|departureAirport|arrivalAirport|adultPassengerCount|departureDate|returnDate|confirmationNumber|
|One-way      |SAN             |LGA           |1                  |63           |65        |WUP5FK            |

Scenario: Deep linking to purchase page

Given an anonymous user
When access to purchase page
Then landing page is displayed

Scenario:Deep linking to select page

Given an anonymous user
When access to select page without flight information
Then landing page is displayed