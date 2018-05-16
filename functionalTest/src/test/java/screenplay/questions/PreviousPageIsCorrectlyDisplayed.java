package screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.openqa.selenium.WebDriver;
import screenplay.models.EarlyBirdFlowInformation;

public class PreviousPageIsCorrectlyDisplayed implements Question<Boolean> {

    private WebDriver webDriver;
    private EarlyBirdFlowInformation earlyBirdFlowInformation;

    public PreviousPageIsCorrectlyDisplayed(WebDriver webDriver, EarlyBirdFlowInformation earlyBirdFlowInformation) {
        this.webDriver = webDriver;
        this.earlyBirdFlowInformation = earlyBirdFlowInformation;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return webDriver.getCurrentUrl().contains(earlyBirdFlowInformation.getCurrentUrl());
    }
}
