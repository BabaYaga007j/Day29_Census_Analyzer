package census_ananlyzer.model;

public class CensusData {
	
	
	 public String state;
	    public long population;
	    public long areaSqKm;
	    public int densityPerSqKm;

	    public CensusData() {

	    }

	    public CensusData(String state, long population, long areaSqKm, int densityPerSqKm) {
	        this.state = state;
	        this.population = population;
	        this.areaSqKm = areaSqKm;
	        this.densityPerSqKm = densityPerSqKm;
	    }
	

}
