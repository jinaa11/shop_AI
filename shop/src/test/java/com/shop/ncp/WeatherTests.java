package com.shop.ncp;

import com.shop.util.WeatherUtil;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

@SpringBootTest
class WeatherTests {

  @Test
  void contextLoads() throws Exception {
    String result = WeatherUtil.getWeatherInfo("159");
    System.out.println(result);

  }
}
