package sports;

import java.util.ArrayList;

public class Team {

	private String name;
	private ArrayList<Athlete> athletes = new ArrayList<Athlete>();
	private Athlete captain;
	private Club club = null;
	private int salary;

	public void addAthlete(Athlete athlete) {
		if (!athletes.contains(athlete)) {
			athletes.add(athlete);
			athlete.setOnContract(true);
			athlete.setTeam(this);
		}
	}

	public Team(String name) {
		this.name = name;

	}

	public void removeAthlete(Athlete athlete) {
		athletes.remove(athlete);
		athlete.setOnContract(false);
		athlete.setTeam(null);

	}

	public int teamSalary() {

		salary = 0;
		for (Athlete element : athletes) {
			salary = salary + element.getSalary();
		}
		return salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Athlete> getAthletes() {
		return athletes;
	}

	public void setAthletes(ArrayList<Athlete> athletes) {
		this.athletes = athletes;
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

	public Athlete getCaptain() {
		return captain;
	}

	public void setCaptain(Athlete captain) {
		this.captain = captain;
	}

	public String toString() {
		String members = "";
		for (Athlete ath : athletes) {
			members += ath.toString() + "\n";
		}

		String out = this.name + "\n" + "Team Captain: " + "\n" + this.captain.toString() + "\n" + "Members: \n"
				+ members;

		return out;
	}

}
