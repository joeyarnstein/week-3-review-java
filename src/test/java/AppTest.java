import org.sql2o.*; // for DB support
import org.junit.*; // for @Before and @After

import org.fluentlenium.adapter.FluentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;
//import static org.fluentlenium.core.filter.FilterConstructor.*;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();


  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Add Stylist Name");
  }
  @Test
  public void stylistIsCreatedTest() {
    goTo("http://localhost:4567/");
    fill("#stylist").with("Sara");
    submit(".btn");
    assertThat(pageSource()).contains("Sara");
  }

}
