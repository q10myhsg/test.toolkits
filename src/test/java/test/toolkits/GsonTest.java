package test.toolkits;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import test.toolkits.bean.Student;

public class GsonTest {
	private static final Logger logger = LoggerFactory.getLogger(GsonTest.class);

	@Test
	public void testGsonParser() {
		String json = "{\"a\":\"100\",\"b\":[{\"b1\":\"b_value1\",\"b2\":\"b_value2\"}, "
				+ "{\"b1\":\"b_value1\",\"b2\":\"b_value2\"}],\"c\": {\"c1\":\"" + "c_value1\",\"c2\":\"c_value2\"}}";
		json.length();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(json);
		JsonObject jo = je.getAsJsonObject();
		logger.debug(jo.get("b").getAsJsonArray().get(0).toString());
	}

	@Test
	public void testJsonObject() {
		// Gson gson = new GsonBuilder().create();
		JsonObject jo = new JsonObject();
		jo.addProperty("1", "2");
		jo.addProperty("1", "3");
		JsonArray ja = new JsonArray();
		ja.add("a");
		ja.add("b");
		ja.add("a");
		logger.debug(jo.toString());
		logger.debug(ja.toString());
		jo.add("array", ja);
		logger.debug(jo.toString());
	}

	@Test
	public void testGson() {
		Gson gson = new GsonBuilder().create();
		JsonObject jo = new JsonObject();
		jo.addProperty("name", "wen");
		jo.addProperty("className", "yangyang");
		jo.addProperty("score", 4.5f);
		logger.info(jo.toString());
		Student t = gson.fromJson(jo, Student.class);
		logger.info(t.getScore() + "");
		logger.info(gson.toJson(t));
		
	}
}
