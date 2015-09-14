package com.loyola.crimes;

import java.io.BufferedReader;
import java.io.Console;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class CrimesReader {
	
	public static void main(String[] args) throws IOException {
		CrimesReader obj = new CrimesReader();
		ArrayList<Crime> crimeList = new ArrayList();
		crimeList = obj.run();
	//	String input = System.console().readLine();
		String s="9";
		
		do{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        System.out.print("Select crimes by:"+
			"\n 1- PRIMARY DESCRIPTION"
			+ "\n 2- SECONDARY DESCRIPTION"
			+ "\n 3- DATE"
			+ "\n 4- LOCATION"
			+ "\n 5- YEAR"
			+ "\n Press any other key to exit ");
	        s = br.readLine();
			
	    switch(s){ 
	    case "1":
		obj.showCrimesbyType(crimeList,Selector.PRIMARYDESCRIPTION);
		break;
	    case "2":
	    obj.showCrimesbyType(crimeList,Selector.SECDESCRIPTION);
	    break;
	    case "3":
	    obj.showCrimesbyType(crimeList,Selector.DATE);
	    break;
	    case "4":
	    	obj.showCrimesbyType(crimeList,Selector.LOCATION);	
	    break;
	    case "5":
	    	obj.showCrimesbyType(crimeList,Selector.YEAR);	
	    break;
	    default:
	    	s="exit";
	    }
		}while(s!="exit");
	}
	
	
	
	public ArrayList<Crime> run() {

		String csvFile = "crimes2001-now_LSC.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",(?![^(]*\\))";
		ArrayList<Crime> crimeList = new ArrayList<Crime>();
		try {

			br = new BufferedReader(new FileReader(csvFile));
			int i= 0;
			while ((line = br.readLine()) != null) {

				Crime crime = new Crime();
				String[] csvData = line.split(cvsSplitBy);
				String[] csvDate = csvData[1].split("\\s");
				crime.setCaseNumber(csvData[0]);
				crime.setDate(csvDate[0]);
				crime.setPrimaryDescription(csvData[4]);
				crime.setSecondaryDescription(csvData[5]);
				crime.setLocationType(csvData[6]);
				crime.setArrest(csvData[7].equalsIgnoreCase("true") ? true : false);
				crime.setYear(csvData[14]);
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
		return crimeList;
		
	}
	
	public void showCrimesbyType (ArrayList<Crime> crimeList, Selector selector){
		
		
		HashMap<String,Integer> frequencyMap = countCrimesByData(crimeList, selector);	
		frequencyMap = sortByValues(frequencyMap);
		Iterator it = frequencyMap.entrySet().iterator();
		while(it.hasNext()){
			 Map.Entry pair = (Map.Entry)it.next();
			System.out.println(pair.getKey() + "=" + pair.getValue());
		     it.remove(); 
		     
		}
	}
	
	private static HashMap sortByValues(HashMap map) { 
	       List list = new LinkedList(map.entrySet());
	       Collections.sort(list, new Comparator() {
	            public int compare(Object o1, Object o2) {
	               return ((Comparable) ((Map.Entry) (o1)).getValue())
	                  .compareTo(((Map.Entry) (o2)).getValue());
	            }
	       });

	       HashMap sortedHashMap = new LinkedHashMap();
	       for (Iterator it = list.iterator(); it.hasNext();) {
	              Map.Entry entry = (Map.Entry) it.next();
	              sortedHashMap.put(entry.getKey(), entry.getValue());
	       } 
	       return sortedHashMap;
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
			case SECDESCRIPTION:
				data = i.next().getSecondaryDescription();
			break;
			case LOCATION:
				data = i.next().getLocationtType();
			break;
			case YEAR:
				data = i.next().getYear();
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
