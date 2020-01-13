package timbuchalka.CollectionsFramework.Sets.Challenge;

public class Planet extends HeavenlyBody {

	public Planet(String name, double orbitalPeriod, String bodyType) {
		super(name, orbitalPeriod, bodyType);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean addMoon(HeavenlyBody moon) {
		//System.out.println(moon.getClass().getSimpleName());
		if(moon.getClass().getSimpleName().equals("Moon")) {
			//System.out.println("In if");
			return super.addMoon(moon);
			}
		else
			return false;
	}

}
