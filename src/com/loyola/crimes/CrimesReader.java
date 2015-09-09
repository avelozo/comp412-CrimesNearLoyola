package com.loyola.crimes;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CrimesReader {

	public static void main(String[] args) {
		CrimesReader obj = new CrimesReader();
		obj.run();

	}
	
	
	public void run() {

		String csvFile = "teste.txt";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		
		try {

			
			br = new BufferedReader(new FileReader("recentCrimes.csv"));
			 
			while ((line = br.readLine()) != null) {

			        // use comma as separator
				String[] description = line.split(cvsSplitBy);

				System.out.println("Description [Primary= " + description[4] 
	                                 + " , Secondary=" + description[5] + "]");

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		System.out.println("Done");
	  }
	
	
	

}
