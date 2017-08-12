package com.mongodb;

import java.util.HashMap;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class SparkApp {

	public static void main(String[] args) {
		Spark.get("/", (request, response) -> {
			return "Hello world";
		});

		Route helloHandler = new Route() {

			@Override
			public Object handle(Request arg0, Response arg1) throws Exception {
				HashMap<String, Object> dataModel = new HashMap<>();
				dataModel.put("name", "Geraldo");
				return FreemarkerApp.createHtml("hello.ftl", dataModel);
			}
		};
		
		Spark.get("/hello", helloHandler);

	}
}
