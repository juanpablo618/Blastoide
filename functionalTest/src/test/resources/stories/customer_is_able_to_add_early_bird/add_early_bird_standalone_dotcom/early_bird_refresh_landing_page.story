Meta:
@product earlyBird
@issue ECOM-17787
@suite regression

Narrative:
As a Southwest/Swabiz user adding an EarlyBird to my reservation
I want to be able to enter the PNR, First Name and Last Name
So that I refresh the page and don't see the oops message and the inputs fields not deleted

Scenario: Validate refresh action on landing page

Given a PNR with the following Itinerary:
|key                 |value               |
|ItineraryType       |itineraryType       |
|DepartureAirport    |departureAirport    |
|ArrivalAirport      |arrivalAirport      |
|AdultPassengerCount |adultPassengerCount |
|DepartureDate       |departureDate       |
|ReturnDate          |returnDate          |
|ConfirmationNumber  |confirmationNumber  |

When I complete the early bird landing form with an invalid passenger information
And I refresh the early bird landing
Then the oops message is not displayed and the entered information persist on landing page

Examples:
|itineraryType|departureAirport|arrivalAirport|adultPassengerCount|departureDate|returnDate|confirmationNumber|
|One-way      |DAL             |HOU           |2                  |55           |57        |TPHQ74            |

Scenario: Validate refresh action on landing page and inputs fields not deleted

Given a PNR with the following Itinerary:
|key                 |value               |
|ItineraryType       |itineraryType       |
|DepartureAirport    |departureAirport    |
|ArrivalAirport      |arrivalAirport      |
|AdultPassengerCount |adultPassengerCount |
|DepartureDate       |departureDate       |
|ReturnDate          |returnDate          |
|ConfirmationNumber  |confirmationNumber  |

When I complete the early bird landing form with an invalid confirmation number
And I refresh the early bird landing
Then the oops message is not displayed and the entered information persist on landing page

Examples:
|itineraryType|departureAirport|arrivalAirport|adultPassengerCount|departureDate|returnDate|confirmationNumber|
|One-way      |DAL             |HOU           |1                  |63           |65        |ASD123            |