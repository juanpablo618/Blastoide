Meta:
@product earlyBird
@suite swabizRegression

Narrative:
As a Swabiz user adding an EarlyBird to my reservation
I want to be able to enter invalid data
So that I can see the error handling of landing page

Scenario: Validate invalid passenger for valid reservation

Given a swabiz PNR with the following Itinerary:
|key                 |value               |
|ItineraryType       |itineraryType       |
|DepartureAirport    |departureAirport    |
|ArrivalAirport      |arrivalAirport      |
|AdultPassengerCount |adultPassengerCount |
|DepartureDate       |departureDate       |
|ReturnDate          |returnDate          |
|ConfirmationNumber  |confirmationNumber  |

When I complete the early bird landing form with an invalid passenger information on swabiz
Then an invalid passenger error is displayed on swabiz

Examples:
|itineraryType|departureAirport|arrivalAirport|adultPassengerCount|departureDate|returnDate|confirmationNumber|
|One-way      |DAL             |HOU           |2                  |55           |57        |TPHQ74            |

Scenario: Validate reservation not found

Given a swabiz PNR with the following Itinerary:
|key                 |value               |
|ItineraryType       |itineraryType       |
|DepartureAirport    |departureAirport    |
|ArrivalAirport      |arrivalAirport      |
|AdultPassengerCount |adultPassengerCount |
|DepartureDate       |departureDate       |
|ReturnDate          |returnDate          |
|ConfirmationNumber  |confirmationNumber  |

When I complete the early bird landing form with an invalid confirmation number on swabiz
Then a not found confirmation number error is displayed on swabiz

Examples:
|itineraryType|departureAirport|arrivalAirport|adultPassengerCount|departureDate|returnDate|confirmationNumber|
|One-way      |DAL             |HOU           |1                  |63           |65        |ASD123            |

Scenario: Retrieving a cancelled reservation

Given a cancelled swabiz PNR with the following Itinerary:
|key                 |value               |
|ItineraryType       |itineraryType       |
|DepartureAirport    |departureAirport    |
|ArrivalAirport      |arrivalAirport      |
|AdultPassengerCount |adultPassengerCount |
|DepartureDate       |departureDate       |
|ReturnDate          |returnDate          |
|ConfirmationNumber  |confirmationNumber  |

When I retrieve reservation for early bird purchase on swabiz
Then the cancelled reservation oops message is displayed on swabiz landing page

Examples:
|itineraryType|departureAirport|arrivalAirport|adultPassengerCount|departureDate|returnDate|confirmationNumber|
|One-way      |SAN             |LGA           |1                  |63           |65        |WUP5FK            |

Scenario: Retrieving a Inelegible bound due to time window and the other for Business Select PNR

Given a swabiz PNR with the following Itinerary:
|key                 |value               |
|ItineraryType       |itineraryType       |
|DepartureAirport    |departureAirport    |
|ArrivalAirport      |arrivalAirport      |
|AdultPassengerCount |adultPassengerCount |
|DepartureDate       |departureDate       |
|ReturnDate          |returnDate          |
|ConfirmationNumber  |confirmationNumber  |

When I retrieve reservation for early bird purchase on swabiz
Then the bounds ineligible oops message is displayed on swabiz landing page

Examples:
|itineraryType|departureAirport|arrivalAirport|adultPassengerCount|departureDate|returnDate|fareTypeOB|fareTypeIB     |confirmationNumber|
|Roundtrip    |LOS             |DAL           |1                  |1            |4         |Anytime   |Business select|QJIZ9R            |

Scenario: Retrieving a PNR with EB purchased for one bound and the other is Business Select

Given a swabiz PNR with the following Itinerary:
|key                 |value               |
|ItineraryType       |itineraryType       |
|DepartureAirport    |departureAirport    |
|ArrivalAirport      |arrivalAirport      |
|AdultPassengerCount |adultPassengerCount |
|DepartureDate       |departureDate       |
|ReturnDate          |returnDate          |
|ConfirmationNumber  |confirmationNumber  |

When I retrieve reservation for early bird purchase on swabiz
Then the bounds ineligible oops message is displayed on swabiz landing page

Examples:
|itineraryType|departureAirport|arrivalAirport|adultPassengerCount|departureDate|returnDate|fareTypeOB     |fareTypeIB|confirmationNumber|
|Roundtrip    |LOS             |DAL           |1                  |55           |60        |Business select|Anytime   |QJL66O            |

Scenario: Retrieving an PNR with Ineligible passenger

Given a swabiz PNR with the following Itinerary:
|key                 |value               |
|ItineraryType       |itineraryType       |
|DepartureAirport    |departureAirport    |
|ArrivalAirport      |arrivalAirport      |
|AdultPassengerCount |adultPassengerCount |
|DepartureDate       |departureDate       |
|ReturnDate          |returnDate          |
|ConfirmationNumber  |confirmationNumber  |

When I retrieve reservation for early bird purchase on swabiz
Then the passengers ineligible oops message is displayed on swabiz landing page

Examples:
|itineraryType|departureAirport|arrivalAirport|adultPassengerCount|departureDate|returnDate|confirmationNumber|
|Roundtrip    |LOS             |DAL           |1                  |63           |65        |QJK5QQ            |