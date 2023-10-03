package com.utlis;

import java.io.BufferedReader;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class httpUtil {
	private String value;
	
  public httpUtil(String value) {
		super();
		this.value = value;
	}
  public <T> T toProduct(Class<T> tClass) {
	try {
		return new ObjectMapper().readValue(value, tClass);
	} catch (JsonParseException e) {
		
		e.printStackTrace();
	} catch (JsonMappingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}
public static httpUtil of(BufferedReader reader) {
	  StringBuilder sb = new StringBuilder();
	  
		try {
			String line;
		    while ((line = reader.readLine()) != null) {
		        sb.append(line);
		    }
		} catch (IOException e) {
			System.out.print(e.getMessage());
		}
		return new httpUtil(sb.toString());
	}
  }

