package sports;

import java.util.ArrayList;

public class Club {

	private String name;
	private int yearEstablished;
	private ArrayList<Team> teams = new ArrayList<Team>();
	private int clubSalary = 0;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYearEstablished() {
		return yearEstablished;
	}

	public void setYearEstablished(int yearEstablished) {
		this.yearEstablished = yearEstablished;
	}

	public ArrayList<Team> getTeams() {
		return teams;
	}

	public void setTeams(ArrayList<Team> teams) {
		this.teams = teams;
	}

	public Club(String name, int yearEstablished) {
		this.name = name;
		this.yearEstablished = yearEstablished;
	}

	public Club(String name, int yearEstablished, ArrayList<Team> teams) {
		this.name = name;
		this.yearEstablished = yearEstablished;
		this.teams = teams;
	}

	public void addTeam(Team team) {
		teams.add(team);
		team.setClub(this);
	}

	public void removeTeam(Team team) {
		teams.remove(team);
		team.setClub(null);
	}

	public int clubSalary() {

		clubSalary = 0;
		for (Team element : teams) {
			clubSalary = clubSalary + element.teamSalary();
		}
		return clubSalary;

	}

	public String toString() 
	{
		String t = "";
		for(Team team: teams)
		{
			t += team.toString() + "\n";
		}	
		String out = "Club: " + this.name + "\n" + "Year Established: " + this.yearEstablished + "\n" + "Teams: " + "\n" + t;
		out = out + "Total Club Salary: " + this.clubSalary() + "TL\n";
		return out;
	}
	
	public int genderCount(Athlete.Gender gender) {
		int count= 0;
		for (Team team : teams) {
			ArrayList<Athlete> temp = team.getAthletes();
			for (Athlete ath : temp) {
				
				if(ath.getGender().equals(gender)) {
					count++;
				}
			}
			
			
		}
		return count;
		
	}

}
