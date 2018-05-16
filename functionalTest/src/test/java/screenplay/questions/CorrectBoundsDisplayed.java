package screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import screenplay.models.AirBookingFlow;
import screenplay.user_interface.earlyBird.EarlyBirdSelectPageForm;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CorrectBoundsDisplayed implements Question<Boolean> {

    private Target boundIcon;
    private Target boundStopIcons;

    public CorrectBoundsDisplayed(Target boundIcon, Target boundStopIcons) {
        this.boundIcon = boundIcon;
        this.boundStopIcons = boundStopIcons;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(
            WaitUntil.the(EarlyBirdSelectPageForm.CONTINUE_BUTTON, isVisible()).forNoMoreThan(20).seconds()
        );

        return Visibility.of(boundIcon).viewedBy(actor).resolve() &&
                (boundStopIcons == null || Visibility.of(boundStopIcons).viewedBy(actor).resolve());
    }

    public static CorrectBoundsDisplayed forOutbound(AirBookingFlow airBookingFlow) {
        Target stopsIcons = null;
        if (airBookingFlow.getOutboundStops() != 0) {
            stopsIcons = EarlyBirdSelectPageForm.OUTBOUND_FLIGHT_STOP_ICONS;
        }
        return new CorrectBoundsDisplayed(EarlyBirdSelectPageForm.OUTBOUND_SWA_ICON_PLANE, stopsIcons);
    }

    public static CorrectBoundsDisplayed forInbound(AirBookingFlow airBookingFlow) {
        Target stopsIcons = null;
        if (airBookingFlow.getInboundStops() != 0) {
            stopsIcons = EarlyBirdSelectPageForm.INBOUND_FLIGHT_STOP_ICONS;
        }
        return new CorrectBoundsDisplayed(EarlyBirdSelectPageForm.INBOUND_SWA_ICON_PLANE, stopsIcons);
    }
}