package mustafaonur.mustafaleague.manager;

import mustafaonur.mustafaleague.classes.Fixture;
import mustafaonur.mustafaleague.classes.Week;

public class MatchManager {
	int[] scores= {0,0};
	int[] endOfTheMatch1;
	int[] endOfTheMatch2;
	public void MatchWeek(Week week) {
		System.out.println("Begining of the Week!!!");
		endOfTheMatch1 = Exhibition(week.fixture1);
		System.out.println(ManageMatch(week.fixture1));
		endOfTheMatch2 = Exhibition(week.fixture2);
		System.out.println(ManageMatch(week.fixture2));
	}
	public int[] Exhibition(Fixture fixture) {
		int dice;
		for(int i = 0;i<10;i++) {
			dice = (int)(Math.random()*99+1);
			if(fixture.team1.power > dice) {
				scores[0]++;
			}
		}
		for(int i = 0;i<10;i++) {
			dice = (int)(Math.random()*99+1);
			if(fixture.team2.power > dice) {
				scores[1]++;
			}
		}
		return scores;
		
	}
	public String ManageMatch(Fixture fixture) {
		if(scores[0]>scores[1]) {
			
			fixture.team1.win+=1;
			fixture.team1.point+=3;
			fixture.team1.scoredGoal += scores[0];
			fixture.team1.concededGoal += scores[1];
			
			
			fixture.team2.lose+=1;
			fixture.team2.scoredGoal += scores[1];
			fixture.team2.concededGoal += scores[0];
			fixture.team1.average += scores[0]-scores[1];
			fixture.team2.average += scores[1]-scores[0];
			return fixture.team1.teamName +" "+scores[0]+"---"+scores[1]+" "+fixture.team2.teamName;
		}else if(scores[0]==scores[1]) {
			fixture.team1.draw+=1;
			fixture.team1.point+=1;
			fixture.team1.scoredGoal += scores[0];
			fixture.team1.concededGoal += scores[1];
			
			fixture.team2.draw+=1;
			fixture.team2.point+=1;
			fixture.team2.scoredGoal += scores[1];
			fixture.team2.concededGoal += scores[0];
			return fixture.team1.teamName +" "+scores[0]+"---"+scores[1]+" "+fixture.team2.teamName;
		}else if(scores[0]<scores[1]) {
			
			fixture.team2.win+=1;
			fixture.team2.point+=3;
			fixture.team2.scoredGoal += scores[1];
			fixture.team2.concededGoal += scores[0];
			
			
			
			fixture.team1.lose+=1;
			fixture.team1.scoredGoal += scores[0];
			fixture.team1.concededGoal += scores[1];
			fixture.team1.average += scores[0]-scores[1];
			fixture.team2.average += scores[1]-scores[0];
			return fixture.team1.teamName +" "+scores[0]+"---"+scores[1]+" "+fixture.team2.teamName;
		}
		return "sa";
	}
}
