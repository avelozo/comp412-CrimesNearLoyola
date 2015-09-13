package com.loyola.crimes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class CrimesReader {
	
	private Selector selector;

	public static void main(String[] args) {
		CrimesReader obj = new CrimesReader();
		 System.out.println("main");
		obj.run();

	}
	
	
	public void run() {

		String csvFile = "crimes2001-now_LSC.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",(?![^(]*\\))";
		ArrayList<Crime> crimeList = new ArrayList<Crime>();
System.out.println("run");
		try {

			br = new BufferedReader(new FileReader(csvFile));
			int i= 0;
			while ((line = br.readLine()) != null) {

				Crime crime = new Crime();
				String[] csvData = line.split(cvsSplitBy);
				
				crime.setCaseNumber(csvData[0]);
				crime.setDate(csvData[1]);
				crime.setTime(csvData[1]);
				crime.setPrimaryDescription(csvData[4]);
				crime.setSecondaryDescription(csvData[5]);
				crime.setLocationType(csvData[6]);
				crime.setArrest(csvData[7].equalsIgnoreCase("true") ? true : false);
				crimeList.add(crime);
			
				
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
	
		HashMap<String,Integer> frequencyMap = countCrimesByData(crimeList, Selector.PRIMARYDESCRIPTION);
		
		
		Iterator it = frequencyMap.entrySet().iterator();
		while(it.hasNext()){
			
			 Map.Entry pair = (Map.Entry)it.next();
			 System.out.println(pair.getKey() + "=" + pair.getValue());
		     it.remove(); // avoids a ConcurrentModificationException
		     
		}
		
	}
	
	
	
	// Method that will count crimes by what you selected in the enum Selector
	public HashMap<String,Integer> countCrimesByData(ArrayList<Crime> crimeList, Selector selector){
	
		HashMap<String,Integer> frequencyMap = new HashMap<String,Integer>();
		String data= "";
		Iterator<Crime> i = crimeList.iterator();
		while(crimeList!=null && i.hasNext()){
		
			
			switch (selector) {
			case PRIMARYDESCRIPTION:
			 data = i.next().getPrimaryDescription();
			break;
			case DATE:
				data = i.next().getDate();
			break;
			default	:
			data = "";
			break;
			}	
			if(frequencyMap.containsKey(data)){
			    frequencyMap.put(data, frequencyMap.get(data)+1);
			  }
			  else{ 
				
				  frequencyMap.put(data, 1);
			   }
			
		}
		
		return frequencyMap;	
	}
	
	
}
