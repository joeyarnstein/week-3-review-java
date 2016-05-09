import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import java.util.ArrayList;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("stylists", Stylist.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/stylists", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String stylistName = request.queryParams("stylist");
      Stylist newStylist = new Stylist(stylistName);
      newStylist.save();
      model.put("stylists", Stylist.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/stylists/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      int stylistId = Integer.parseInt(request.params("id"));
      Stylist thisStylist = Stylist.find(stylistId);
      model.put("stylist", thisStylist);
      model.put("clients", thisStylist.getClients());
      model.put("template", "templates/stylist-page.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/stylists/:id/client", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String clientName = request.queryParams("client");
      int stylistId = Integer.parseInt(request.params("id"));
      Client newClient = new Client (clientName, stylistId);
      newClient.save();
      Stylist thisStylist = Stylist.find(stylistId);
      response.redirect("/stylists/" + thisStylist.getId());
      return null;
    });

    get("client/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      int clientId = Integer.parseInt(request.params("id"));
      Client currentClient = Client.find(clientId);
      int stylistId = currentClient.getStylistId();
      Stylist assignedStylist = Stylist.find(stylistId);
      model.put("stylist", assignedStylist);
      model.put("client", currentClient);
      model.put("template", "templates/client-update.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("clients/:id/update", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String newNote = request.queryParams("note");
      int clientId = Integer.parseInt(request.params("id"));
      Client thisClient = Client.find(clientId);
      thisClient.updateNotes(newNote);
      response.redirect("/client/" + thisClient.getId());
      return null;
    });
  }

}
