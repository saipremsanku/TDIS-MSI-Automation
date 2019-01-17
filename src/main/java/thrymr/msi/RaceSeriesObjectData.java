package thrymr.msi;

public class RaceSeriesObjectData {


	private String raceSeriesRaceTeamName;
	private String raceseriesVIN;	
	private String RacingSeries;
	private String RacingSeriesSeason;	
	private String RaceEvent;	
	private String raceSeriesDriverName;

	
	
	public String getRacingSeries() {
		return RacingSeries;
	}


	public void setRacingSeries(String racingSeries) {
		RacingSeries = racingSeries;
	}

	public String getRacingSeriesSeason() {
		return RacingSeriesSeason;
	}

	public void setRacingSeriesSeason(String racingSeriesSeason) {
		RacingSeriesSeason = racingSeriesSeason;
	}

	public String getRaceEvent() {
		return RaceEvent;
	}

	public void setRaceEvent(String RaceEvent) {
		this.RaceEvent = RaceEvent;
	}

	
	public String getRaceSeriesRaceTeamName() {
		return raceSeriesRaceTeamName;
	}
	public void setRaceSeriesRaceTeamName(String raceSeriesRaceTeamName) {
		this.raceSeriesRaceTeamName = raceSeriesRaceTeamName;
	}
	
	public String getRaceseriesVIN() {
		return raceseriesVIN;
	}
	public void setRaceseriesVIN(String raceseriesVIN) {
		this.raceseriesVIN = raceseriesVIN;
	}
	
	public String getRaceSeriesDriverName() {
		return raceSeriesDriverName;
	}
	public void setRaceSeriesDriverName(String raceSeriesDriverName) {
		this.raceSeriesDriverName = raceSeriesDriverName;
	}
	
//	@Override
//	public String toString() {
//		return ObjectData ;
//	}
	
}
