package com.dream.tools.json;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

 
//数据绑定DataBinding
public class JacksonDemo {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		
		String jackStr = "{\"name\":\"jack\",\"age\":12}";
		
		ObjectMapper mapper = new ObjectMapper();
		
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		
		//字符串反序列化为对象
		Jack jack =  mapper.readValue(jackStr, Jack.class);
		Map<String,Object> jackMap = mapper.readValue(jackStr, Map.class);
		
		//序列化
		String mapStr = mapper.writeValueAsString(jackMap);
		
		
		System.out.println("name:"+jack.getName());
		System.out.println("age:"+jack.getAge());
		
		System.out.println("nameMap:"+ jackMap.get("name"));
		System.out.println("ageMap:"+jackMap.get("age"));
		
		System.out.println(mapStr);
		
	}
	
	
	
}
