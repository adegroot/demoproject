package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestData {

	public static List<Map<String,Object>> getTestData() {
		
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		
		Map<String,Object> a = new HashMap<String,Object>();
		a.put("orlo", 1);
		a.put("count", 11);
		a.put("name", "orlo een");

		Map<String,Object> b = new HashMap<String,Object>();
		b.put("orlo", 2);
		b.put("count", 22);
		b.put("name", "orlo twee");

		Map<String,Object> c = new HashMap<String,Object>();
		c.put("orlo", 3);
		c.put("count", 33);
		c.put("name", "orlo drie");

		list.add(a);
		list.add(b);
		list.add(c);
		
		return list;
	}
		

	public static List<Map<String,Object>> getTestData2() {
		
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		
		Map<String,Object> a = new HashMap<String,Object>();
		a.put("orlo", 1);
		a.put("frequency", 111);
		a.put("description", "extra description");


		Map<String,Object> c = new HashMap<String,Object>();
		c.put("orlo", 3);
		c.put("frequency", 333);

		list.add(a);
		list.add(c);
		
		return list;
	}
		

	
}
