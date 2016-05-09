import java.util.Arrays;
import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.List;

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

  @Test
  public void all_emptyAtFirst() {
    assertEquals(Stylist.all().size(), 0);
  }
  @Test
  public void save_savesIntoDatabase_true() {
    Stylist test = new Stylist("Stacy");
    test.save();
    assertTrue(Stylist.all().get(0).equals(test));
  }
  @Test
  public void save_assignsIdToObject() {
    Stylist myStylist = new Stylist("Stacy");
    myStylist.save();
    Stylist savedStylist = Stylist.all().get(0);
    assertEquals(myStylist.getId(), savedStylist.getId());
  }
  @Test
  public void find_findStylistInDatabase_true() {
    Stylist myStylist = new Stylist("Randa");
    myStylist.save();
    Stylist savedStylist = Stylist.find(myStylist.getId());
    assertTrue(myStylist.equals(savedStylist));
  }
  // @Test
  // public void getClients_retrievesAllClientsFromDatabase_tasksList() {
  //   Stylist myStylist = new Stylist("Household chores");
  //   myStylist.save();
  //   Client firstClient = new Client("Mow the lawn", myStylist.getId());
  //   firstClient.save();
  //   Client secondClient = new Client("Do the dishes", myStylist.getId());
  //   secondClient.save();
  //   Client[] tasks = new Client[] { firstClient, secondClient };
  //   assertTrue(myStylist.getClients().containsAll(Arrays.asList(tasks)));
  // }
}
