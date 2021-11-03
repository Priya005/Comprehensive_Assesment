package com.utility;
import java.io.IOException;
import java.util.ArrayList;
public class TestSample {
	public static void main(String[] args) throws IOException {
		DataDriven d = new DataDriven();
		ArrayList<String> data= d.getData("searchproduct");
		for(int i=0;i<data.size()-1;i++) {
			System.out.println(data.get(i+1));
		}
	
	
	}
}
