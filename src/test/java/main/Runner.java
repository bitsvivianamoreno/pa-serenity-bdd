package main;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Esta clase contiene los features que se van a ejecutar
 */
@RunWith(CucumberWithSerenity.class)

@CucumberOptions(

        features = {"src/test/resources/features/demand.feature",
                    "src/test/resources/features-api"}
)

public class Runner {

}
