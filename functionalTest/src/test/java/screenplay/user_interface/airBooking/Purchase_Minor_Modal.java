package screenplay.user_interface.airBooking;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class Purchase_Minor_Modal {

    public static final Target ACCOMPANIED_MINOR_MODAL_NO_ACCOMPANIED_BUTTON = Target.the("Accompanied Minor Modal NO button")
            .located(By.cssSelector(".purchase-passenger-age-modal .dialog-modal--cancel"));

    public static final Target ACCOMPANIED_MINOR_MODAL_YES_BUTTON = Target.the("Accompanied Minor Modal YES button")
            .located(By.cssSelector(".purchase-passenger-age-modal .purchase-passenger-age-modal--button"));
}
