package census_ananlyzer.model;

public class StateCSVFile {

	public Integer srNo;
    public String stateName;
    public Integer tin;
    public String stateCode;

    public StateCSVFile() {

    }

    public StateCSVFile(Integer srNo, String stateName, Integer tin, String stateCode) {
        this.srNo = srNo;
        this.stateName = stateName;
        this.tin = tin;
        this.stateCode = stateCode;
    }

    @Override
    public String toString() {
        return "StateCSV [srNo=" + srNo + ", stateName=" + stateName + ", tin=" + tin + ", stateCode=" + stateCode
                + "]";
    }
}
