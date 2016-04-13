package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class Application extends Controller {

    private static final String HEADER_CORRELATION_ID = "correlation_id";

    @Inject
    private services.TestService testService;

    public Result index() {
        testService.echo("saeed");
        return ok(index.render("Your new application is ready."));
    }

    @Inject
    daos.UserProfileDao userDao;

    public Result getUsers(){
        return ok(play.libs.Json.toJson(userDao.findAll()));
    }


    public Result getUserIByID(String id){
        return ok(play.libs.Json.toJson(userDao.findOne(id)));
    }

    public Result saveOrUpdateUser(){
        return updateUser("CREATE");
    }

    public Result updateUser(){
       return updateUser("UPDATE");
    }

    public Result deleteUserById(String id){
        if(null ==  request().headers().get(HEADER_CORRELATION_ID)){
            return unauthorized("Please call with proper Header");
        }
        userDao.delete(id);
        return getUsers();
    }

    private Result updateUser(String event){
        if(null ==  request().headers().get(HEADER_CORRELATION_ID )){
            return unauthorized("Please call with proper Header");
        }
        JsonNode jsonNode = request().body().asJson();request().body().asJson();
        daos.UserProfile up = new daos.UserProfile(jsonNode.get("name").asText("test"));
        return ok(play.libs.Json.toJson(userDao.save(up)));
        //return getUsers();
    }

}
