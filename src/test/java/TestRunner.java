import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/resources/myFeatures",
        glue = {"com.vazidev.seleniumcucumberjwatest"},
        plugin = { "pretty", "html:target/HTMLReports/index.html",
        "json:target/JsonReports/report.json",
        "junit:target/XmlReports/report.xml"}

)
public class TestRunner {
    //todo

}
