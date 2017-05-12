package br.com.xyinc.poi;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PoiApplicationTest {

	@Before
	public void setup() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8085;
	}

	@Test
	public void testFindAllReturnsAllPois() throws Exception {
		Response response = get("/pontoInteresse").andReturn();
		assertEquals(200, response.getStatusCode());
	}

	@Test
	public void testFindNearbyReturnAllPoisNear() throws Exception {
		Response response = get("/pontoInteresse/20/10/10").andReturn();
		assertEquals(200, response.getStatusCode());
	}

	@Test
	public void testSavePoiReturn200WithId() throws Exception {
		String poi = "{ \"nome\": \"Lavanderia\", \"x\": 18, \"y\": 17 }";

		Response response = given().contentType("application/json").body(poi).post("/pontoInteresse").andReturn();
		assertEquals(201, response.getStatusCode());

		JsonPath path = response.jsonPath();
		assertNotNull(path.get("id"));
	}

	@Test
	public void testSaveWithInvalidCordinatesReturnUnprocessableEntity() throws Exception {
		String poi = "{ \"nome\": \"Fábrica\", \"x\": -18, \"y\": 17 }";

		Response response = given().contentType("application/json").body(poi).post("/pontoInteresse").andReturn();
		assertEquals(422, response.getStatusCode());
	}
}
