package football;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.get;

public class FootBallCRUD {
    @BeforeClass
    public void setup(){
        RestAssured.baseURI = "https://api.football-data.org";
        RestAssured.basePath = "/v2";

        RestAssured.requestSpecification = new RequestSpecBuilder().
                setContentType("application/json").
                addHeader("X-Auth-Token","031c150214154ca0b791a0abc1a8fbff").build();
    }
    @Test
    public void getTeams(){
        get("/teams").then().assertThat().statusCode(200);
    }

    @Test
    public void getTeamsDataSimple(){
        //expression language
        Response response = get("/teams");
        //first team name
        String firstName = response.path("teams[0].name");
        System.out.println("First Team name---" + firstName);

        String lastName = response.path("teams[-1].name");
        System.out.println("First Team name---" + lastName);

        List<String> allTeams = response.path("teams.name");
        for(String team:allTeams){
           if(team.contains("Aston Villa FC")) {
               System.out.println("team name exists in the list");
           }
        }
    //Fetch teams array and save it to list
        List<Map<String,?>> teamsList = response.path("teams");
    //Fetch specific team object based on some condition such as name
        Map<String,?> teamObj = response.path("teams.find{it.name =='Aston Villa FC'}");
    }

    @Test
    public void getTeamsDataComplex() {
        //expression language
        Response response = get("/teams/66");
        String competitionName = response.path("activeCompetitions.find {it.code == \"CL\"}.name");
        Assert.assertEquals(competitionName, "UEFA Champions League");
        List<String> list = response.path("activeCompetitions.findAll {it.id > 2000}.name");
        //max id
        System.out.println(response.path("activeCompetitions.max {it.id}.name").toString());
        //min id
        System.out.println(response.path("activeCompetitions.min {it.id}.name").toString());
        //fetch the player who is in tire one and have code as CL
        System.out.println(response.path("activeCompetitions.findAll {it.plan == \"TIER_ONE\"}.find {it.code == \"CL\"}.name").toString());
    }
}
