import org.junit.Assert.*;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Test;
import com.loyola.crimes.*;
import junit.framework.Assert;

public class testCrimes {
	
	
	CrimesReader crimesReader = new CrimesReader();
	ArrayList<Crime> crimeList= new ArrayList();
	
	@Test
	public void testReadCSV(){
		crimeList = crimesReader.run("CrimesTest.csv");
		Assert.assertEquals(11, crimeList.size());
		
	}

	@Test
	public void testCountCrimesbyDescription(){
		crimeList = crimesReader.run("CrimesTest.csv");
		HashMap<String,Integer> crimesDesc = new HashMap<String, Integer>();
		crimesDesc = crimesReader.countCrimesByData(crimeList, Selector.PRIMARYDESCRIPTION);
		int total= crimesDesc.get("THEFT");
		Assert.assertEquals(4, total);
		
	}
	
	@Test
	public void testOrderCrimes(){
		crimeList = crimesReader.run("CrimesTest.csv");
		HashMap<String,Integer> crimesDesc = new HashMap<String, Integer>();
		crimesDesc = crimesReader.countCrimesByData(crimeList, Selector.PRIMARYDESCRIPTION);
		int total= crimesDesc.get("THEFT");
		Assert.assertEquals(4, total);
		
	}
	
	@Test
	public void testCountCrimesbyYear(){
		crimeList = crimesReader.run("CrimesTest.csv");
		HashMap<String,Integer> crimesDesc = new HashMap<String, Integer>();
		crimesDesc = crimesReader.countCrimesByData(crimeList, Selector.YEAR);
		int total= crimesDesc.get("2013");
		Assert.assertEquals(11, total);
		
	}
	
}
