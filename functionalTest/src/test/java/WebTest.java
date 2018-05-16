import net.serenitybdd.jbehave.SerenityStepFactory;
import net.serenitybdd.jbehave.SerenityStories;
import org.jbehave.core.steps.InjectableStepsFactory;

public class WebTest extends SerenityStories {

    @Override
    public InjectableStepsFactory stepsFactory() {
        return SerenityStepFactory.withStepsFromPackage("steps", configuration()).andClassLoader(getClassLoader());
    }
}