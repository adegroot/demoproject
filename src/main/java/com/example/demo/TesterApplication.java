package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class TesterApplication {
    static ObjectMapper objectMapper = new ObjectMapper();

	public static void main(String[] args) {

		//test1();
		test2();
	}

	public static void test1() {
		List<Map<String,Object>> list =  TestData.getTestData();
		writeList(list);
		System.out.println("-----------------------------------");

		
		List<Map<String,Object>> list2 =  new ArrayList<Map<String,Object>>();
		for (Map<String,Object> item : list){

			list2.add(extractKey(item,"orlo"));

			}
		writeList(list2);

	}
	
	public static void test2() {

		List<Map<String,Object>> list =  TestData.getTestData();
		List<Map<String,Object>> list2 =  new ArrayList<Map<String,Object>>();
		for (Map<String,Object> item : list){

			list2.add(extractKey(item,"orlo"));

			}
		writeList(list2);

		String key = "orlo";
		List<Map<String,Object>> list3 =  TestData.getTestData2();
		for (Map<String,Object> extra : list3){

			Object extraKeyValue = extra.get(key);
			//find the master record
			for (Map<String,Object> master : list2){
				Object masterKeyValue =  master.get(key);
				if (extraKeyValue.equals(masterKeyValue)) {
					
					master = combineKey(master, extra, key);
				}
			}

		}

		writeList(list2);

	}
	
	
	public static Map<String,Object> extractKey(Map<String,Object> map, String key) {
		Map<String,Object> keyData = new HashMap<String,Object>();
		
		keyData.put(key, map.get(key));
		map.remove(key);
		keyData.put("data", map);
			
		return keyData;
	}
	
	public static Map<String,Object> combineKey(Map<String,Object> master, Map<String,Object> extra, String key) {
		extra.remove(key);
		Map<String,Object> m = (Map<String,Object>)master.get("data");
		m.putAll(extra);
			
		return master;
	}
	
	
	public static void writeList(List<Map<String,Object>> list) {
		
	      String jsonInString = null;
			try {
				jsonInString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			System.out.println(jsonInString);
	  
	}
		
}
