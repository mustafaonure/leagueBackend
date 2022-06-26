package mustafaonur.mustafaleague.manager;

import java.util.Arrays;

import mustafaonur.mustafaleague.classes.Team;



public class TableManager {
	public void ShowTable(Team[] teams) {
		Team team1 = teams[0];
		Team team2 = teams[1];
		Team team3 = teams[2];
		Team team4 = teams[3];
		Team[] sortedList = {team1,team2,team3,team4};
		Arrays.sort(sortedList);
		
		
	}
}
