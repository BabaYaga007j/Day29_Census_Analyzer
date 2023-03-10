package census_ananlyzer.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import census_ananlyzer.controller.CensusAnalyzerMain;
import census_ananlyzer.exceptions.CustomExceptions;

public class CensusAnanlyzerTests {


	private static final String indiaCsvFilePath = "IndianCensusStateData.csv";
	public CensusAnalyzerMain analyser;
	private static final String stateCsvPath = "IndianCensusStateData.csv";


	@Test
	public void returnSize() throws Exception {
		try {
			assertEquals(29, analyser.loadCensusData(indiaCsvFilePath));
		} catch (CustomExceptions e) {
			e.printStackTrace();
		}
	}


	//should ExecuteProperly,If Records AreEqual
	@Test
	public void loadCensusDataTestOne() throws Exception {
		try {
			assertEquals(29, analyser.loadCensusData(indiaCsvFilePath));
		} catch (CustomExceptions e) {
			e.printStackTrace();
		}
	}

	//should Return Records if CSVFile Is Detected
	@Test
	public void loadCensusDataTestTwo() throws Exception {
		try {
			assertEquals(29, analyser.loadCensusData(indiaCsvFilePath));
		} catch (CustomExceptions e) {
			e.printStackTrace();
		}
	}

	//should Return Custom Exception if Delimiter Incorrect
	@Test
	public void loadCensusDataTestThree() throws Exception {
		try {
			assertEquals(29, analyser.loadCensusData(indiaCsvFilePath));
		} catch (CustomExceptions e) {
			e.printStackTrace();
		}
	}

	//Should Return Custom Exception if CSVHeader Incorrect
	@Test
	public void loadCensusDataTestFour() throws Exception {
		try {
			assertEquals(29, analyser.loadCensusData(indiaCsvFilePath));
		} catch (CustomExceptions e) {
			e.printStackTrace();
		}
	}


	//State

	//return Size State
	@Test
	public void loadStateDataOne() throws Exception {
		try {

			assertEquals(37, analyser.loadStateData(stateCsvPath));
		} catch (CustomExceptions e) {
			e.printStackTrace();
		}
	}

	//should Execute Properly If Records Are EqualState
	@Test
	public void loadStateDataTwo() throws Exception {
		try {
			assertEquals(37, analyser.loadStateData(stateCsvPath));
		} catch (CustomExceptions e) {
			e.printStackTrace();
		}
	}

	//should Return Records if CSVFile Is Detected State
	@Test
	public void loadStateDataThree() throws Exception {
		try {
			assertEquals(37, analyser.loadStateData("abc.csv"));
		} catch (CustomExceptions e) {
			e.printStackTrace();
		}
	}

	//should Return Custom Exception if Delimiter Incorrect State
	@Test
	public void loadStateDataFour() throws Exception {
		try {

			assertEquals(37, analyser.loadStateData(stateCsvPath));
		} catch (CustomExceptions e) {
			e.printStackTrace();
		}
	}

	//should Retun ture Custom Exception if CSVHeader IncorrectState
	@Test
	public void loadStateDataFive() throws Exception {
		try {
			assertEquals(37, analyser.loadStateData(indiaCsvFilePath));
		} catch (CustomExceptions e) {
			e.printStackTrace();
		}
	}

}
