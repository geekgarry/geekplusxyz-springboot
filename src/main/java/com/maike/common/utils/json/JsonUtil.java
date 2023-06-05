package com.maike.common.utils.json;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maike.common.entity.ComKey;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @ClassName JsonUtil
 * @Description json格式和object格式类型数据转换
 * @Author Zheng
 * @Date 2018年1月10日 上午8:19:41
 */
public class JsonUtil {

	public static ObjectMapper objectMapper=new ObjectMapper();
	/**
	 * json字符转化成对象
	 * @param jsonStr
	 * @param classT
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Object jsonToObject(String jsonStr,Class classT){
		/**
		 * 将字符串转化成Map对象
		 * 将Map对象转化成对象类型
		 */
		Map map = null;;
		Object object = null;
		try {
			map = objectMapper.readValue(jsonStr, Map.class);
			object = objectMapper.convertValue(map,classT);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return object;
	}
	/**
	 * 对象转化成json字符
	 * @param object
	 * @return
	 */
	public static String objectToJsonStr(Object object){
		String backMsg = null ;
		try {
			backMsg = objectMapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return backMsg;
	}
	/**
	 * json 转化成列表
	 * @param arrayJson
	 * @param classT
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static List jsonToList(String arrayJson,Class classT){
		JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, classT);
		List lists = null ;
		try {
			lists = objectMapper.readValue(arrayJson, javaType);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lists;
	}
	/**
	 * 获取规格参数
	* @Title: getStandardFromJsonStr
	* @Description:
	* @param arrayJson
	* @return List<List<ComKey>>
	* @author WeiZheng
	* @date 2018年10月8日下午12:03:28
	 */
	public static List<List<ComKey>> getStandardFromJsonStr(String arrayJson){
		// [[{"key":1006,"value":"豪华版"},{"key":1003,"value":"粉色"}]]
		List<Map<String,String>> jsonList = JsonUtil.jsonToList(arrayJson, Map.class);
		List<List<ComKey>> backList = new ArrayList<>();
		List<ComKey> keyList ;
		ComKey tmp = null;
		for(Map<String,String> items : jsonList){
			keyList = new ArrayList<>();
			for(Entry<String, String> entry: items.entrySet()){
				tmp = new ComKey(entry.getKey(), entry.getValue());
				keyList.add(tmp);
			}
			backList.add(keyList);
		}
		return backList;
	}
	public static List<ComKey> getOneProductStandard(String arrayJson){
		// [{"key":"shuxing 101","value":"1002#流沙金"},{"key":"shuxing 102","value":"1006#豪华版"}]
		List<ComKey> keyList = new ArrayList<>();
		ComKey tmp = null;
		//JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, ComKey.class);
		//keyList = (List<ComKey>) JsonUtil.jsonToObject(arrayJson, javaType.getClass());
		List<Map<String,String>> jsonObject = JsonUtil.jsonToList(arrayJson, Map.class);
		for(Map<String,String> tmpMap : jsonObject) {
			for(Entry<String, String> entry: tmpMap.entrySet()){
				tmp = new ComKey(entry.getKey(), entry.getValue());
				keyList.add(tmp);
			}
		}
		return keyList;
	}
	public static Map<String,String> getProductStand3(List<ComKey> keys){
		Map<String,String> backMap = new HashMap<>();
		if(keys == null || keys.isEmpty()) {}else {
			for(ComKey comKey : keys) {
				backMap.put((String)comKey.getKey(), (String)comKey.getValue());
			}
		}
		return backMap;
	}
	public static List<ComKey> getOneProductStandard2(String arrayJson){
		// {"shuxing 101":"1002#流沙金","shuxing 102":"1006#豪华版"}
		List<ComKey> keyList = new ArrayList<>();
		ComKey tmp = null;
		Map<String,String> jsonObject = (Map<String, String>) JsonUtil.jsonToObject(arrayJson, Map.class);
		for(Entry<String, String> entry: jsonObject.entrySet()){
			tmp = new ComKey(entry.getKey(), entry.getValue());
			keyList.add(tmp);
	    }
		return keyList;
	}
	public static void main(String[] args) {
		//ObjectMapper objectMapper=new ObjectMapper();
		//将json字符串转换成对象
		//Map map = objectMapper.readValue(jsonString, Map.class);
		//转换对象类型
		//SomethingPOJO pojo = objectMapper.convertValue(map, SomethingPOJO.class);
		//将对象转换成json字符串
		//Sting string = objectMapper.writeValueAsString(pojo);
		//将json字符串转换成List
		//JavaType javaType = mapper.getTypeFactory()
		//.constructParametricType(List.class, Person.class);
		//List<Person> jsonToPersonList = objectMapper.readValue(arrayToJson, mapType);
//		List<Map<String,String>> jsonList = JsonUtil.jsonToList("[{\"101\":\"1001#name\",\"102\":\"1004\"},{\"101\":\"1001#name\"}]", Map.class);
//		for(Map<String,String> items : jsonList){
//			//System.out.println(items.getKey() + " : "+items.getValue());
//			for(String key : items.keySet()){
//				System.out.println(key + " : "+items.get(key));
//			}
//		}
//		String sstr = "\"[{\"key\":\"shuxing 101\",\"value\":\"1002#流沙金\"},{\"key\":\"shuxing 102\",\"value\":\"1006#豪华版\"}]\"";
//		for(ComKey tmp : getOneProductStandard(sstr) ) {
//			System.out.println(tmp.getKey()+":"+tmp.getValue());
//		}
		//[{"key":"shuxing 101","value":"1002#流沙金"},{"key":"shuxing 102","value":"1006#豪华版"}]
//		List<ComKey> tmp = new ArrayList<>();
//		ComKey comKey = new ComKey();
//		comKey.setKey("shuxing 101");
//		comKey.setValue("1002#流沙金");
//		ComKey comKey1 = new ComKey();
//		comKey1.setKey("shuxing 101");
//		comKey1.setValue("1002#流沙金");
//		tmp.add(comKey);
//		tmp.add(comKey1);
//		System.out.println(JsonUtil.objectToJsonStr(tmp));
		String jsonStr = "[{\"1006\":\"1002#流沙金\",\"1001\":\"102#豪华版\"},{\"1006\":\"1002#流沙金\",\"1001\":\"102#豪华版\"}]";
		List<List<ComKey>> lists = getStandardFromJsonStr(jsonStr);
		for(List<ComKey> list : lists) {
			System.out.println("------------------");
			for(ComKey tmp : list) {
				System.out.println(tmp.getKey()+":"+tmp.getValue());
			}
		}
		System.out.println("-------单个商品-----");
		String singleStr = "{\"1006\":\"1002#流沙金\",\"1001\":\"102#豪华版\"}";
		List<ComKey> singles = getOneProductStandard2(singleStr);
		for(ComKey tmp : singles) {
			System.out.println(tmp.getKey()+":"+tmp.getValue());
		}
	}
}
