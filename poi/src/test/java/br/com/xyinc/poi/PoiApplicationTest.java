package br.com.xyinc.poi;

import static com.jayway.restassured.RestAssured.get;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jayway.restassured.path.json.JsonPath;

import br.com.xyinc.poi.entity.PontoInteresse;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PoiApplicationTest {
    
    @Test
    public void findAll() {
//        given()
//      .contentType("application/json")
//      .body(car)
//      .when().post("/garage/slots").then()
//      .statusCode(200);        
        
        JsonPath path = get("/pontoInteresse").andReturn().jsonPath();

        List<PontoInteresse> poiList = path.getList("");

        assertNotEquals(0, poiList.size());
    }
      
}
