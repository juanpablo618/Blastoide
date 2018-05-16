package screenplay.models;

import org.jbehave.core.model.ExamplesTable;

import java.util.Map;

public class EarlyBirdFlowInformation {

    private int numberOfSelectedPassengerOB;
    private int numberOfSelectedPassengerIB;
    private double priceEB;
    private double subTotalOB;
    private double subTotalIB;
    private double totalEB;
    private String currentUrl;
    private String ineligibilityReason;
    private String ineligibleBound;

    public double getPriceEB() {
        return priceEB;
    }

    public void setPriceEB(double priceEB) {
        this.priceEB = priceEB;
    }

    public int getNumberOfSelectedPassengerOB() {
        return numberOfSelectedPassengerOB;
    }

    public void setNumberOfSelectedPassengerOB(int numberOfSelectedPassengerOB) {
        this.numberOfSelectedPassengerOB = numberOfSelectedPassengerOB;
    }

    public int getNumberOfSelectedPassengerIB() {
        return numberOfSelectedPassengerIB;
    }

    public void setNumberOfSelectedPassengerIB(int numberOfSelectedPassengerIB) {
        this.numberOfSelectedPassengerIB = numberOfSelectedPassengerIB;
    }

    public double getSubTotalOB() {
        return subTotalOB;
    }

    public void setSubTotalOB(double subTotalOB) {
        this.subTotalOB = subTotalOB;
    }

    public double getSubTotalIB() {
        return subTotalIB;
    }

    public void setSubTotalIB(double subTotalIB) {
        this.subTotalIB = subTotalIB;
    }

    public double getTotalEB() {
        return totalEB;
    }

    public void setTotalEB(double totalEB) {
        this.totalEB = totalEB;
    }

    public String getCurrentUrl() {
        return currentUrl;
    }

    public void setCurrentUrl(String currentUrl) {
        this.currentUrl = currentUrl;
    }

    public String getIneligibilityReason() {
        return ineligibilityReason;
    }

    public void setIneligibilityReason(String ineligibilityReason) {
        this.ineligibilityReason = ineligibilityReason;
    }

    public String getIneligibleBound() {
        return ineligibleBound;
    }

    public void setIneligibleBound(String ineligibleBound) {
        this.ineligibleBound = ineligibleBound;
    }

    public static EarlyBirdFlowInformation storeSelectPassengerForEB(ExamplesTable table, EarlyBirdFlowInformation earlyBirdFlowInformation) {
        for (int i = 0; i < table.getRowCount(); i++) {
            Map<String, String> row = table.getRow(i);
            String key = row.get("key");
            if (key.equals("NumberOfSelectedPassengerOB")) {
                earlyBirdFlowInformation.setNumberOfSelectedPassengerOB(Integer.parseInt(table.getRowAsParameters(i, true).valueAs("value", String.class)));
            } else if (key.equals("NumberOfSelectedPassengerIB")) {
                earlyBirdFlowInformation.setNumberOfSelectedPassengerIB(Integer.parseInt(table.getRowAsParameters(i, true).valueAs("value", String.class)));
            }
        }
        return earlyBirdFlowInformation;
    }
}