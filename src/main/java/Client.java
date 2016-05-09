import java.util.List;
import org.sql2o.*;

public class Client {
  private int id;
  private String description;
  private int stylistId;

  public Client(String description, int stylistId) {
    this.description = description;
    this.stylistId = stylistId;
  }

  public String getDescription() {
    return description;
  }

  public int getId() {
    return id;
  }

  public int getStylistId() {
    return stylistId;
  }

  // public static List<Client> all() {
  //   String sql = "SELECT id, description, stylistId FROM clients";
  //   try(Connection con = DB.sql2o.open()) {
  //     return con.createQuery(sql).executeAndFetch(Client.class);
  //   }
  // }
  //
  // @Override
  // public boolean equals(Object otherClient){
  //   if (!(otherClient instanceof Client)) {
  //     return false;
  //   } else {
  //     Client newClient = (Client) otherClient;
  //     return this.getDescription().equals(newClient.getDescription()) &&
  //            this.getId() == newClient.getId()&&
  //            this.getStylistId() == newClient.getStylistId();
  //   }
  // }
  //
  // public void save() {
  //   try(Connection con = DB.sql2o.open()) {
  //     String sql = "INSERT INTO clients(description, stylistId) VALUES (:description, :stylistId)";
  //     this.id = (int) con.createQuery(sql, true)
  //       .addParameter("description", this.description)
  //       .addParameter("stylistId", this.stylistId)
  //       .executeUpdate()
  //       .getKey();
  //   }
  // }
  //
  // public static Client find(int id) {
  //   try(Connection con = DB.sql2o.open()) {
  //     String sql = "SELECT * FROM clients where id=:id";
  //     Client task = con.createQuery(sql)
  //       .addParameter("id", id)
  //       .executeAndFetchFirst(Client.class);
  //     return task;
  //   }
  // }
}
