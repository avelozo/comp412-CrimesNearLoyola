package com.loyola.crimes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CrimesReader {

	public static void main(String[] args) {
		CrimesReader obj = new CrimesReader();
		obj.run();

	}
	
	
	public void run() {

		String csvFile = "crimes2001-now_LSC.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		ArrayList<Crime> crimeList = new ArrayList<Crime>();
		
		try {

			
			br = new BufferedReader(new FileReader(csvFile));
			int i= 0;
			while ((line = br.readLine()) != null) {

				Crime crime = new Crime();
				String[] csvData = line.split(cvsSplitBy);
				
				crime.setCaseNumber(csvData[0]);
				crime.setDate(csvData[2]);
				crime.setTime(csvData[2]);
				crime.setPrimaryDescription(csvData[5]);
				crime.setSecondaryDescription(csvData[6]);
				crime.setLocation(csvData[7]);
				crime.setArrest(csvData[8]=="true"?true:false);

				crimeList.add(crime);
				
				System.out.println(((Crime)crimeList.get(i)).getCaseNumber());
				i++;

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
	  }

}
