package com.utlis;

import java.io.BufferedReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpUtil {
	private String value;

	public HttpUtil(String value) {
		super();
		this.value = value;
	}

	public <T> T toProduct(Class<T> clazz) {
		try {
			return new ObjectMapper().readValue(value, clazz);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static HttpUtil of(BufferedReader reader) {
		StringBuilder sb = new StringBuilder();
		try {
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new HttpUtil(sb.toString());
	}
}
