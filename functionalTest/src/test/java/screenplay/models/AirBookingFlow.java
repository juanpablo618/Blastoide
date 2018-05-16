package screenplay.models;

import org.jbehave.core.model.ExamplesTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AirBookingFlow {
    private static String EXTRA_SEAT = "XS";
    private String itineraryType = "Roundtrip";
    private String departureAirport = "DAL";
    private String destinationAirport = "AMA";
    private String arrivalAirport = "HOU";
    private int outboundStops;
    private int inboundStops;
    private int adultPassengerCount;
    private int seniorPassengerCount;
    private int departureDate;
    private int returnDate;
    private int numbersOfRRUser;
    private String internalReferenceNumber;
    private String firstName;
    private String lastName;
    private String confirmationNumber;
    private int aListPreferredUsersCount;
    private int aListPreferredExtraSeatCount;
    private List<Passenger> passengers;
    private String fareTypeOB = "Wanna get away";
    private String fareTypeIB = "Wanna get away";
    private int extraSeatPassengerCount;
    private String creditCardNumber;
    private String cvvNumber;
    private int positionOfCCSelector;

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCvvNumber() {
        return cvvNumber;
    }

    public void setCvvNumber(String cvvNumber) {
        this.cvvNumber = cvvNumber;
    }

    public int getPositionOfCCSelector() {
        return positionOfCCSelector;
    }

    public void setPositionOfCCSelector(int positionOfCCSelector) {
        this.positionOfCCSelector = positionOfCCSelector;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public int getNumbersOfRRUser() {
        return numbersOfRRUser;
    }

    public void setNumbersOfRRUser(int numbersOfRRUser) {
        this.numbersOfRRUser = numbersOfRRUser;
    }

    public String getItineraryType() {
        return itineraryType;
    }

    public void setItineraryType(String itineraryType) {
        this.itineraryType = itineraryType;
    }

    public int getOutboundStops() {
        return outboundStops;
    }

    public void setOutboundStops(int outboundStops) {
        this.outboundStops = outboundStops;
    }

    public int getInboundStops() {
        return inboundStops;
    }

    public void setInboundStops(int inboundStops) {
        this.inboundStops = inboundStops;
    }

    public int getAdultPassengerCount() {
        return adultPassengerCount;
    }

    public void setAdultPassengerCount(int adultPassengerCount) {
        this.adultPassengerCount = adultPassengerCount;
    }

    public int getSeniorPassengerCount() {
        return seniorPassengerCount;
    }

    public void setSeniorPassengerCount(int seniorPassengerCount) {
        this.seniorPassengerCount = seniorPassengerCount;
    }

    public int getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(int departureDate) {
        this.departureDate = departureDate;
    }

    public int getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(int returnDate) {
        this.returnDate = returnDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getConfirmationNumber() {
        return confirmationNumber;
    }

    public void setConfirmationNumber(String confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }

    public int getAListPreferredUsersCount() {
        return aListPreferredUsersCount;
    }

    public void setAListPreferredUsersCount(int aListPreferredUsersCount) {
        this.aListPreferredUsersCount = aListPreferredUsersCount;
    }

    public String getInternalReferenceNumber() {
        return internalReferenceNumber;
    }

    public void setInternalReferenceNumber(String internalReferenceNumber) {
        this.internalReferenceNumber = internalReferenceNumber;
    }

    public String getFareTypeOB() {
        return fareTypeOB;
    }

    public void setFareTypeOB(String fareTypeOB) {
        this.fareTypeOB = fareTypeOB;
    }

    public String getFareTypeIB() {
        return fareTypeIB;
    }

    public void setFareTypeIB(String fareTypeIB) {
        this.fareTypeIB = fareTypeIB;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public int getExtraSeatPassengerCount() {
        return extraSeatPassengerCount;
    }

    public void setExtraSeatPassengerCount(int extraSeatPassengerCount) {
        this.extraSeatPassengerCount = extraSeatPassengerCount;
    }

    public int getAListPreferredExtraSeatCount() {
        return aListPreferredExtraSeatCount;
    }

    public void setAListPreferredExtraSeatCount(int aListPreferredExtraSeatCount) {
        this.aListPreferredExtraSeatCount = aListPreferredExtraSeatCount;
    }

    public static AirBookingFlow storeAirBookingFlowData(ExamplesTable table) {
        AirBookingFlow airBookingFlow = new AirBookingFlow();

        for (int i = 0; i < table.getRowCount(); i++) {
            Map<String, String> row = table.getRow(i);
            String key = row.get("key");
            if (key.equals("ItineraryType")) {
                airBookingFlow.setItineraryType(table.getRowAsParameters(i, true).valueAs("value", String.class));
            } else if (key.equals("DepartureAirport")) {
                airBookingFlow.setDepartureAirport(table.getRowAsParameters(i, true).valueAs("value", String.class));
            } else if (key.equals("DestinationAirport")) {
                airBookingFlow.setDestinationAirport(table.getRowAsParameters(i, true).valueAs("value", String.class));
            } else if (key.equals("ArrivalAirport")) {
                airBookingFlow.setArrivalAirport(table.getRowAsParameters(i, true).valueAs("value", String.class));
            } else if (key.equals("OutboundStops")) {
                airBookingFlow.setOutboundStops(Integer.parseInt(table.getRowAsParameters(i, true).valueAs("value", String.class)));
            } else if (key.equals("InboundStops")) {
                airBookingFlow.setInboundStops(Integer.parseInt(table.getRowAsParameters(i, true).valueAs("value", String.class)));
            } else if (key.equals("AdultPassengerCount")) {
                airBookingFlow.setAdultPassengerCount(Integer.parseInt(table.getRowAsParameters(i, true).valueAs("value", String.class)));
            } else if (key.equals("SeniorPassengerCount")) {
                airBookingFlow.setSeniorPassengerCount(Integer.parseInt(table.getRowAsParameters(i, true).valueAs("value", String.class)));
            } else if (key.equals("ExtraSeatPassengerCount")) {
                airBookingFlow.setExtraSeatPassengerCount(Integer.parseInt(table.getRowAsParameters(i, true).valueAs("value", String.class)));
            } else if (key.equals("DepartureDate")) {
                airBookingFlow.setDepartureDate(Integer.parseInt(table.getRowAsParameters(i, true).valueAs("value", String.class)));
            } else if (key.equals("ReturnDate")) {
                airBookingFlow.setReturnDate(Integer.parseInt(table.getRowAsParameters(i, true).valueAs("value", String.class)));
            } else if (key.equals("NumbersOfRRUser")) {
                airBookingFlow.setNumbersOfRRUser(Integer.parseInt(table.getRowAsParameters(i, true).valueAs("value", String.class)));
            } else if (key.equals("ConfirmationNumber")) {
                airBookingFlow.setConfirmationNumber(table.getRowAsParameters(i, true).valueAs("value", String.class));
            } else if (key.equals("AListPreferredUsersCount")) {
                airBookingFlow.setAListPreferredUsersCount(Integer.parseInt(table.getRowAsParameters(i, true).valueAs("value", String.class)));
            } else if (key.equals("AListPreferredExtraSeatCount")) {
                airBookingFlow.setAListPreferredExtraSeatCount(Integer.parseInt(table.getRowAsParameters(i, true).valueAs("value", String.class)));
            } else if (key.equals("FareTypeOB")) {
                airBookingFlow.setFareTypeOB(table.getRowAsParameters(i, true).valueAs("value", String.class));
            } else if (key.equals("FareTypeIB")) {
                airBookingFlow.setFareTypeIB(table.getRowAsParameters(i, true).valueAs("value", String.class));
            } else if (key.equals("InternalReferenceNumber")) {
                airBookingFlow.setInternalReferenceNumber(table.getRowAsParameters(i, true).valueAs("value", String.class));
            } else if (key.equals("CreditCardNumber")) {
                airBookingFlow.setCreditCardNumber(table.getRowAsParameters(i, true).valueAs("value", String.class));
            } else if (key.equals("CvvNumber")) {
                airBookingFlow.setCvvNumber(table.getRowAsParameters(i, true).valueAs("value", String.class));
            }else if (key.equals("PositionOfCCSelector")) {
                airBookingFlow.setPositionOfCCSelector(Integer.parseInt(table.getRowAsParameters(i, true).valueAs("value", String.class)));
            }

        }
        airBookingFlow.setPassengers(populatePassengerList(airBookingFlow));
        return airBookingFlow;
    }

    private static List populatePassengerList(AirBookingFlow airBookingFlow) {
        List<Passenger> passengersList = new ArrayList<>();
        Passenger passenger;
        for (int i = 0; i < airBookingFlow.getAListPreferredUsersCount(); i++) {
            passenger = new Passenger();
            passenger.setAccountNumber(RapidRewardsPassengers.A_LIST_PREFERRED_NUMBERS[i]);
            passenger.setFirstName(RapidRewardsPassengers.A_LIST_PREFERRED_FIRST_NAMES[i]);
            passenger.setMiddleName(RapidRewardsPassengers.A_LIST_PREFERRED_MIDDLE_NAMES[i]);
            passenger.setLastName(RapidRewardsPassengers.A_LIST_PREFERRED_LAST_NAMES[i]);
            passenger.setPassengerType("Adult");
            passengersList.add(passenger);
        }

        for (int i = 0; i < airBookingFlow.getAListPreferredExtraSeatCount(); i++) {
            passenger = new Passenger();
            passenger.setAccountNumber(RapidRewardsPassengers.A_LIST_PREFERRED_NUMBERS[i]);
            passenger.setFirstName(RapidRewardsPassengers.A_LIST_PREFERRED_FIRST_NAMES[i]);
            passenger.setMiddleName(airBookingFlow.EXTRA_SEAT);
            passenger.setLastName(RapidRewardsPassengers.A_LIST_PREFERRED_LAST_NAMES[i]);
            passenger.setPassengerType("Adult");
            passengersList.add(passenger);
        }

        for (int i = 0; i < airBookingFlow.getAdultPassengerCount() - airBookingFlow.getAListPreferredUsersCount()
                - airBookingFlow.getExtraSeatPassengerCount(); i++) {
            passenger = new Passenger();
            passenger.setFirstName(AnonymousPassengers.FIRST_NAMES[i]);
            passenger.setMiddleName(AnonymousPassengers.MIDDLE_NAMES[i]);
            passenger.setLastName(AnonymousPassengers.LAST_NAMES[i]);
            passenger.setPassengerType("Adult");
            passengersList.add(passenger);
        }

        for (int i = 0; i < airBookingFlow.getExtraSeatPassengerCount() - airBookingFlow.getAListPreferredExtraSeatCount(); i++) {
            passenger = new Passenger();
            passenger.setFirstName(AnonymousPassengers.FIRST_NAMES[i]);
            passenger.setMiddleName(airBookingFlow.EXTRA_SEAT);
            passenger.setLastName(AnonymousPassengers.LAST_NAMES[i]);
            passenger.setPassengerType("Adult");
            passengersList.add(passenger);
        }

        for (int i = 0; i < airBookingFlow.getSeniorPassengerCount() - airBookingFlow.getAListPreferredUsersCount()
                - airBookingFlow.getExtraSeatPassengerCount(); i++) {
            passenger = new Passenger();
            passenger.setFirstName(AnonymousPassengers.FIRST_NAMES[i]);
            passenger.setLastName(AnonymousPassengers.LAST_NAMES[i]);
            passenger.setPassengerType("Senior");
            passengersList.add(passenger);
        }

        airBookingFlow.setFirstName(passengersList.get(0).getFirstName());
        airBookingFlow.setLastName(passengersList.get(0).getLastName());

        return passengersList;
    }
}