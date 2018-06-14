import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.core.annotations.WithTag;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@WithTag("rest")
@CucumberOptions(
        features = {"src/test/resources/features/rest"},
        glue     = {"stepdefinitions/rest"},
        junit    = {"--filename-compatible-names"},
        plugin   = {"pretty", "html:target/site/rest"},
        tags     = {"@GET,@POST"}
)
public class restapi {

}