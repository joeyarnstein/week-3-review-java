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
  public void getDescription_taskInstantiatesWithDescription_String() {
    Client myClient = new Client("Betsy", 1);
    assertEquals("Betsy", myClient.getDescription());
  }

  // @Test
  // public void all_emptyAtFirst() {
  //   assertEquals(Client.all().size(), 0);
  // }
  // @Test
  // public void equals_returnsTrueIfDescriptionsAretheSame() {
  //   Client firstClient = new Client("Mow the lawn", 1);
  //   Client secondClient = new Client("Mow the lawn", 1);
  //   assertTrue(firstClient.equals(secondClient));
  // }
  // @Test
  // public void save_returnsTrueIfDescriptionsAretheSame() {
  //   Client myClient = new Client("Mow the lawn", 1);
  //   myClient.save();
  //   assertTrue(Client.all().get(0).equals(myClient));
  // }
  // @Test
  // public void save_assignsIdToObject() {
  //   Client myClient = new Client("Mow the lawn", 1);
  //   myClient.save();
  //   Client savedClient = Client.all().get(0);
  //   assertEquals(myClient.getId(), savedClient.getId());
  // }
  // @Test
  // public void find_findsClientInDatabase_true() {
  //   Client myClient = new Client("Mow the lawn", 1);
  //   myClient.save();
  //   Client savedClient = Client.find(myClient.getId());
  //   assertTrue(myClient.equals(savedClient));
  // }
  //
  // @Test
  // public void save_savesCategoryIdIntoDB_true() {
  //   Category myCategory = new Category("Household chores");
  //   myCategory.save();
  //   Client myClient = new Client("Mow the lawn", myCategory.getId());
  //   myClient.save();
  //   Client savedClient = Client.find(myClient.getId());
  //   assertEquals(savedClient.getCategoryId(), myCategory.getId());
  // }
}
