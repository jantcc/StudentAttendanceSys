package com.zjc.util;

public class Commual {
	 public static boolean isInteger(String str) {
	        int begin = 0;
	        if (str == null || str.trim().equals("")) {
	            return false;
	        }
	        str = str.trim();
	        if (str.startsWith("+") || str.startsWith("-")) {
	            if (str.length() == 1) {
	                // "+" "-"
	                return false;
	            }
	            begin = 1;
	        }
	        for (int i = begin; i < str.length(); i++) {
	            if (!Character.isDigit(str.charAt(i))) {
	                return false;
	            }
	        }
	        return true;
	    }


}
