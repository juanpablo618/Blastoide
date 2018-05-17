package screenplay.user_interface.swabizAirBooking;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SwabizTravelForm {

    public static final Target COMPANY_ID_INPUT = Target.the("Company id input box").located(By.id("companyIdField"));
    public static final Target COMPANY_ID_BUTTON = Target.the("Company id button").located(By.cssSelector("#swabizTravel .swa-button_primary"));
}
