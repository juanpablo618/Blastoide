Meta:
@product earlyBird
@issue ECOM-17743
@suite regression

Narrative:
As a Southwest/Swabiz user adding an EarlyBird to my reservation
I want to be able to enter the PNR, First Name and Last Name
So that I can retrieve the reservation if the provided information matches with an existing reservation

Scenario: Validate invalid passenger for valid reservation

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
Then an invalid passenger error is displayed

Examples:
|itineraryType|departureAirport|arrivalAirport|adultPassengerCount|departureDate|returnDate|confirmationNumber|
|One-way      |DAL             |HOU           |2                  |55           |57        |TPHQ74            |

Scenario: Validate reservation not found

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
Then a not found confirmation number error is displayed

Examples:
|itineraryType|departureAirport|arrivalAirport|adultPassengerCount|departureDate|returnDate|confirmationNumber|
|One-way      |DAL             |HOU           |1                  |63           |65        |ASD123            |

Scenario: Retrieving a cancelled reservation

Given a cancelled PNR with the following Itinerary:
|key                 |value               |
|ItineraryType       |itineraryType       |
|DepartureAirport    |departureAirport    |
|ArrivalAirport      |arrivalAirport      |
|AdultPassengerCount |adultPassengerCount |
|DepartureDate       |departureDate       |
|ReturnDate          |returnDate          |
|ConfirmationNumber  |confirmationNumber  |

When I retrieve reservation for early bird purchase
Then the cancelled reservation oops message is displayed on landing page

Examples:
|itineraryType|departureAirport|arrivalAirport|adultPassengerCount|departureDate|returnDate|confirmationNumber|
|One-way      |SAN             |LGA           |1                  |63           |65        |WUP5FK            |

Scenario: Retrieving a unaccompanied minor PNR

Given a unaccompanied minor PNR with the following Itinerary:
|key                 |value               |
|ItineraryType       |itineraryType       |
|DepartureAirport    |departureAirport    |
|ArrivalAirport      |arrivalAirport      |
|AdultPassengerCount |adultPassengerCount |
|DepartureDate       |departureDate       |
|ReturnDate          |returnDate          |
|ConfirmationNumber  |confirmationNumber  |

When I retrieve reservation for early bird purchase
Then the unaccompanied minor reservation oops message is displayed on landing page

Examples:
|itineraryType|departureAirport|arrivalAirport|adultPassengerCount|departureDate|returnDate|confirmationNumber|
|One-way      |LOS             |DAL           |1                  |63           |65        |O7Z4PC            |

Scenario: Retrieving a Inelegible bound due to time window and the other for Business Select PNR

Given a PNR with the following Itinerary:
|key                 |value               |
|ItineraryType       |itineraryType       |
|DepartureAirport    |departureAirport    |
|ArrivalAirport      |arrivalAirport      |
|AdultPassengerCount |adultPassengerCount |
|DepartureDate       |departureDate       |
|ReturnDate          |returnDate          |
|ConfirmationNumber  |confirmationNumber  |

When I retrieve reservation for early bird purchase
Then the bounds ineligible oops message is displayed on landing page

Examples:
|itineraryType|departureAirport|arrivalAirport|adultPassengerCount|departureDate|returnDate|fareTypeOB|fareTypeIB     |confirmationNumber|
|Roundtrip    |LOS             |DAL           |1                  |1            |4         |Anytime   |Business select|QJIZ9R            |

Scenario: Retrieving a PNR with EB purchased for one bound and the other is Business Select

Given a PNR with the following Itinerary with early bird:
|key                 |value               |
|ItineraryType       |itineraryType       |
|DepartureAirport    |departureAirport    |
|ArrivalAirport      |arrivalAirport      |
|AdultPassengerCount |adultPassengerCount |
|DepartureDate       |departureDate       |
|ReturnDate          |returnDate          |
|ConfirmationNumber  |confirmationNumber  |

When I retrieve reservation for early bird purchase
Then the bounds ineligible oops message is displayed on landing page

Examples:
|itineraryType|departureAirport|arrivalAirport|adultPassengerCount|departureDate|returnDate|fareTypeOB     |fareTypeIB|confirmationNumber|
|Roundtrip    |LOS             |DAL           |1                  |55           |60        |Business select|Anytime   |QJL66O            |

Scenario: Retrieving an PNR with Ineligible passenger

Given a PNR with the following Itinerary with early bird:
|key                 |value               |
|ItineraryType       |itineraryType       |
|DepartureAirport    |departureAirport    |
|ArrivalAirport      |arrivalAirport      |
|AdultPassengerCount |adultPassengerCount |
|DepartureDate       |departureDate       |
|ReturnDate          |returnDate          |
|ConfirmationNumber  |confirmationNumber  |

When I retrieve reservation for early bird purchase
Then the passengers ineligible oops message is displayed on landing page

Examples:
|itineraryType|departureAirport|arrivalAirport|adultPassengerCount|departureDate|returnDate|confirmationNumber|
|Roundtrip    |LOS             |DAL           |1                  |63           |65        |QJK5QQ            |