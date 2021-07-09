package com.crm.comcast.product;

import java.lang.reflect.Method;

public class DataProvider {

	public  Object[][] dpmethod(Method m)
	{
		switch(m.getName()) {
		case "sum":
			return new Object[][] {{2,3,5},{5,7,9}};
		case "diff":
			return new Object[][] {{2,3,-1},{5,7,-2}};
			
		}
		return null;
		
	}
	
	
}
