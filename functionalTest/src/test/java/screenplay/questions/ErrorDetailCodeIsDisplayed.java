package screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import screenplay.user_interface.earlyBird.LandingPageForm;

public class ErrorDetailCodeIsDisplayed implements Question<Boolean> {
    private String errorCode;
    private static final String INVALID_PNR_ERROR_CODE = "400620389";
    private static final String INVALID_PASSENGER_ERROR_CODE = "400520165";
    private static final String CANCELLED_PNR_ERROR_CODE = "400520432";
    private static final String UNACCOMPANIED_MINOR_ERROR_CODE = "400520438";
    private static final String BOUND_INELIGIBLE_ERROR_CODE = "400309996";
    private static final String PASSENGER_INELIGIBLE_ERROR_CODE = "400309997";

    public ErrorDetailCodeIsDisplayed(String errorCode) {
        this.errorCode = errorCode;
    }

    public static ErrorDetailCodeIsDisplayed forInvalidPNR() {
        return new ErrorDetailCodeIsDisplayed(INVALID_PNR_ERROR_CODE);
    }

    public static ErrorDetailCodeIsDisplayed forInvalidPassenger() {
        return new ErrorDetailCodeIsDisplayed(INVALID_PASSENGER_ERROR_CODE);
    }

    public static ErrorDetailCodeIsDisplayed forCancelledPNR() {
        return new ErrorDetailCodeIsDisplayed(CANCELLED_PNR_ERROR_CODE);
    }

    public static ErrorDetailCodeIsDisplayed forUnaccompaniedMinor() {
        return new ErrorDetailCodeIsDisplayed(UNACCOMPANIED_MINOR_ERROR_CODE);
    }

    public static ErrorDetailCodeIsDisplayed forBoundInelegible() {
        return new ErrorDetailCodeIsDisplayed(BOUND_INELIGIBLE_ERROR_CODE);
    }

    public static ErrorDetailCodeIsDisplayed forPassengerInelegible() {
        return new ErrorDetailCodeIsDisplayed(PASSENGER_INELIGIBLE_ERROR_CODE);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return Text.of(LandingPageForm.ERROR_DETAIL_CODE).viewedBy(actor).asString().contains(errorCode);
    }
}
