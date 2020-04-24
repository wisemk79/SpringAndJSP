package spring9;

import java.util.Map;

public class ProtocolHanderFactory {
   //Map
	private Map<String,Object>map;
	
	public void setMap(Map<String,Object> map) {
		this.map=map;
		System.out.println("setMap()호출 (map)=>"+map);
	}
}
