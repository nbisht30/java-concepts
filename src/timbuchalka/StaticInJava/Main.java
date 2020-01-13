package timbuchalka.StaticInJava;

public class Main {

	static {
		System.out.println("Static block of Main class.");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Emp navin = new Emp();
//		navin.setName("Navin");
//		navin.setSalary(50000);
//		navin.setCompany("Sapient");
//		navin.setCeo("Alan Ravy");
//		System.out.println("Details of " + navin.getName() + ":-\nSalary: " + navin.getSalary() + "\nCEO: "
//				+ navin.getCeo() + "\nCompany: " + navin.getCompany());
//		Emp nikhil = new Emp();
//		nikhil.setName("Nikhil");
//		nikhil.setSalary(100000);
//		System.out.println("\nDetails of " + nikhil.getName() + ":-\nSalary: " + nikhil.getSalary() + "\nCEO: "
//				+ nikhil.getCeo() + "\nCompany: " + nikhil.getCompany());

	}

}

class Emp {
	private String name;
	private int salary;
	private static String company;
	private static String ceo;

	static {
		System.out.println("In Static block of Emp class.");
		company = "Sapient";
		ceo = "Nigel";
	}

	public Emp() {
		System.out.println("In Default Constructor of Emp class.");
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public static String getCompany() {
		return company;
	}

	public static void setCompany(String company) {
		Emp.company = company;
	}

	public static String getCeo() {
		return ceo;
	}

	public static void setCeo(String ceo) {
		Emp.ceo = ceo;
	}

}