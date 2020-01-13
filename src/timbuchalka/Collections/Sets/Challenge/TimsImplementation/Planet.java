package timbuchalka.Collections.Sets.Challenge.TimsImplementation;

public class Planet extends HeavenlyBody {

	public Planet(String name, double orbitalPeriod) {
		super(name, orbitalPeriod, BodyTypes.PLANET);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean addSatellite(HeavenlyBody moon) {
		//System.out.println(moon.getClass().getSimpleName());
		if(moon.getClass().getSimpleName().equals("Moon")) {
			//System.out.println("In if");
			return super.addSatellite(moon);
			}
		else
			return false;
	}

}
