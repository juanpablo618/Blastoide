Meta:
@product earlyBird
@suite swabizRegression

Narrative:
As a Swabiz user
I want to see sub total for each bound and total related to the EarlyBird product selected on the purchase page

Scenario: Validate sub total inbound, outbound and total, retrieved from the select page

Given a swabiz PNR with the following Itinerary:
|key                 |value               |
|ItineraryType       |itineraryType       |
|DepartureAirport    |departureAirport    |
|ArrivalAirport      |arrivalAirport      |
|DestinationAirport  |destinationAirport  |
|OutboundStops       |outboundStops       |
|InboundStops        |inboundStops        |
|AdultPassengerCount |adultPassengerCount |
|DepartureDate       |departureDate       |
|ReturnDate          |returnDate          |
|ConfirmationNumber  |confirmationNumber  |

When I confirm the passenger to add early bird on swabiz
Then purchase itinerary section is correctly displayed on swabiz
Examples:
|itineraryType|departureAirport|destinationAirport|arrivalAirport|outboundStops|inboundStops|adultPassengerCount|departureDate|returnDate|confirmationNumber|
|One-way      |SAN             |                  |LGA           |1            |1           |1                  |60           |62        |TZYLSD            |
|Multi-city   |DAL             |AMA               |HOU           |0            |0           |2                  |55           |57        |TZZEAL            |