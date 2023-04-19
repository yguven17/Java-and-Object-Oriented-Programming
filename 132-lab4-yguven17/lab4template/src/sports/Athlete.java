package sports;

import java.util.ArrayList;

public class Athlete {

	private String jersey_number;
	private String name;
	private String surname;
	private int salary = 0;
	private boolean on_contract = false;
	private Team team;
	private Gender gender;

	public enum Gender {
		FEMALE, MALE
	};

	private static ArrayList<Athlete> all_athletes = new ArrayList<Athlete>();

	public static ArrayList<Athlete> searchByName(String name) {

		ArrayList<Athlete> sameNames = new ArrayList<Athlete>();

		for (Athlete element : all_athletes) {
			if (element.getName().equals(name)) {

				sameNames.add(all_athletes.get(all_athletes.indexOf(element)));
			}

		}

		return sameNames;

	}

	public Athlete(String jersey_number, String name, String surname, Gender gender) {

		this.jersey_number = jersey_number;
		this.name = name;
		this.surname = surname;
		this.gender = gender;
		all_athletes.add(this);
	}

	public Athlete(String jersey_number, String name, String surname, Gender gender, int salary) {

		this.jersey_number = jersey_number;
		this.name = name;
		this.surname = surname;
		this.gender = gender;
		this.salary = salary;
		all_athletes.add(this);
	}

	public String getFullName() {
		return name + " " + surname;

	}

	public String toString() {
		return this.jersey_number + "," + this.surname + "," + this.name + "," + this.salary + " TL";
	}

	public String getJerseyNumber() {
		return jersey_number;
	}

	public void setJerseyNumber(String jersey_number) {
		this.jersey_number = jersey_number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getFullname() {

		return getName().toString() + " " + getSurname().toString();
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public boolean getOnContract() {
		return on_contract;
	}

	public void setOnContract(boolean on_contract) {
		this.on_contract = on_contract;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Gender getGender() {
		return gender;
	}

}
