package screenplay.models;

public class WhoIsDrivingInfo {

    private String driverEmail = "a@a.com";
    private String driverFirstName = "Chuck";
    private String driverLastName = "Norris";
    private String phoneNumber = "2132131231";

    public String getEmail() {
        return driverEmail;
    }

    public String getFirstName() {
        return driverFirstName;
    }

    public String getLastName() {
        return driverLastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setFirstName(String firstName) {
        this.driverFirstName= firstName;
    }

    public void setLastName(String lastName) {
        this.driverLastName = lastName;
    }
}