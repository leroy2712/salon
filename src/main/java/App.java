import java.util.Map;
import java.util.HashMap;
import java.util.List;
import spark.ModelAndView;
import spark.QueryParamsMap;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    ProcessBuilder process = new ProcessBuilder();
    Integer port;
    if (process.environment().get("PORT") != null) {
        port = Integer.parseInt(process.environment().get("PORT"));
    } else {
        port = 4567;
    }

    setPort(port);
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      String subscriberEmail = request.queryParams("email");
      Subscriber newSubscriber = new Subscriber(subscriberEmail);
      newSubscriber.save();
      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/login", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/login.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/login", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      String adminEmail = request.queryParams("admin-email");
      String adminPassword = request.queryParams("pwd");

      Admin newAdmin = new Admin(adminEmail, adminPassword);
      List <String> check = newAdmin.login();
      
      if(check.isEmpty()){
        model.put("template", "templates/login-error.vtl");
        return new ModelAndView(model, layout);
      } else {
        String user = check.get(0);
        model.put("username", user);
        model.put("template", "templates/stylists.vtl");
        return new ModelAndView(model, layout);
      }

    }, new VelocityTemplateEngine());

    get("/login", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/login.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/stylists", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("stylists", Stylists.getAll());
      model.put("template", "templates/stylists.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/stylists/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("stylist", Stylists.finds(Integer.parseInt(request.params(":id"))));
      model.put("template", "templates/stylist.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/stylists/:id/clients", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("stylist", Stylists.findAll(Integer.parseInt(request.params(":id"))));
      model.put("template", "templates/stylist-clients.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/stylists/:id/update", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Stylists stylist = Stylists.finds(Integer.parseInt(request.params(":id")));
      String name = request.queryParams("name");
      int age = Integer.parseInt(request.queryParams("age"));
      String experience = request.queryParams("experience");
      String specialties = request.queryParams("specialties");
      stylist.update(name, age, experience, specialties);
      response.redirect("/stylists");
      return null;
    });

    post("/stylists/:id/delete", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Stylists stylist= Stylists.finds(Integer.parseInt(request.params(":id")));
      model.put("template", "templates/stylists.vtl");
      stylist.delete();
      model.put("stylists", Stylists.getAll());
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/clients", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("clients", Clients.getAll());
      model.put("template", "templates/clients.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}