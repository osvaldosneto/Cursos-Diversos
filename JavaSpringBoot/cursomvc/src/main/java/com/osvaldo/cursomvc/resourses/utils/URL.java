package com.osvaldo.cursomvc.resourses.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class URL {
	
	public static List<Long> decodeIntList(String s){
		String[] vetorString = s.split(",");
		List<Long> lista = new ArrayList<>();
		for(String x : vetorString) {
			lista.add(Long.parseLong(x));
		}
		return lista;
	}
	
	public static String decodeParam(String s) {
		try {
			return URLDecoder.decode(s,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}

}
