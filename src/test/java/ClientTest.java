import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ClientTest {

  @Rule
    public DatabaseRule database = new DatabaseRule();

  @Test
  public void Client_instantiatesCorrectly_true() {
    Client myClient = new Client("Betsy", 1);
    assertEquals(true, myClient instanceof Client);
  }

  @Test
  public void getClientName_taskInstantiatesWithClientName_String() {
    Client myClient = new Client("Betsy", 1);
    assertEquals("Betsy", myClient.getClientName());
  }

  @Test
  public void all_emptyAtFirst() {
    assertEquals(Client.all().size(), 0);
  }
  @Test
  public void equals_returnsTrueIfClientNamesAretheSame() {
    Client firstClient = new Client("Tara", 1);
    Client secondClient = new Client("Tara", 1);
    assertTrue(firstClient.equals(secondClient));
  }
  @Test
  public void save_returnsTrueIfClientNamesAretheSame() {
    Client myClient = new Client("Bary", 1);
    myClient.save();
    assertTrue(Client.all().get(0).equals(myClient));
  }
  @Test
  public void save_assignsIdToObject() {
    Client myClient = new Client("Alina", 1);
    myClient.save();
    Client savedClient = Client.all().get(0);
    assertEquals(myClient.getId(), savedClient.getId());
  }
  @Test
  public void find_findsClientInDatabase_true() {
    Client myClient = new Client("Mow the lawn", 1);
    myClient.save();
    Client savedClient = Client.find(myClient.getId());
    assertTrue(myClient.equals(savedClient));
  }

  @Test
  public void save_savesStylistIdIntoDB_true() {
    Stylist testStylist = new Stylist("A stylist");
    testStylist.save();
    Client myClient = new Client("A client", testStylist.getId());
    myClient.save();
    Client savedClient = Client.find(myClient.getId());
    assertEquals(savedClient.getStylistId(), testStylist.getId());
  }
}
