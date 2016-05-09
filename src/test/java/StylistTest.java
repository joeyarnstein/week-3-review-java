import java.util.Arrays;
import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class StylistTest {
  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void Stylist_instantiatesCorrectly_true() {
    Stylist test = new Stylist("Charlie");
    assertEquals(true, test instanceof Stylist);
  }

  @Test
  public void Stylist_instantiatesWithStylistName_Bob(){
    Stylist test = new Stylist("Bob");
    assertEquals("Bob", test.getName());
  }
}
