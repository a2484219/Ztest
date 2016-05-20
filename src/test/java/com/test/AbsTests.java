package com.test;  

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 功能：
 * 作者：lscm
 * 日期：2016-5-18下午6:11:10
 *
 */
public class AbsTests {

	public static void main(String[] args){
		Object o = new Object();
		A a = new A("aa");
		A aa = new A("aa");
		System.out.println(a.equals(aa));
		System.out.println(a==aa);
		System.out.println(a.hashCode());
		System.out.println(aa.hashCode());
		/*Map map = new HashMap();
		map.put(a, "a");
		map.put(aa, "b");
		System.out.println(map.get(a));
		System.out.println(map.get(aa));*/
	}
	
}

class A{
	String name;
	A(String name){
		this.name = name;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		A a = (A)obj;
		if(this.name.equals(a.getName())){
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
//		System.out.println(name.hashCode());
		return name.hashCode();
	}
}

class B{
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
 
