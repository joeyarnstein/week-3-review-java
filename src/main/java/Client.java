import java.util.List;
import org.sql2o.*;

public class Client {
  private int id;
  private String clientName;
  private int stylistId;
  //private String notes;

  public Client(String clientName, int stylistId) {
    this.clientName = clientName;
    this.stylistId = stylistId;
  }

  public String getClientName() {
    return clientName;
  }

  public int getId() {
    return id;
  }

  public int getStylistId() {
    return stylistId;
  }

  public static List<Client> all() {
    String sql = "SELECT id, clientName, stylistId FROM clients";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Client.class);
    }
  }

  @Override
  public boolean equals(Object otherClient){
    if (!(otherClient instanceof Client)) {
      return false;
    } else {
      Client newClient = (Client) otherClient;
      return this.getClientName().equals(newClient.getClientName()) &&
             this.getId() == newClient.getId()&&
             this.getStylistId() == newClient.getStylistId();
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO clients(clientName, stylistId) VALUES (:clientName, :stylistId)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("clientName", this.clientName)
        .addParameter("stylistId", this.stylistId)
        .executeUpdate()
        .getKey();
    }
  }
  //
  // public void updateNotes(){
  //   try(Conn)
  // }

  public static Client find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM clients where id=:id";
      Client task = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Client.class);
      return task;
    }
  }
}
