package mustafaonur.mustafaleague;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import db.DbConnection;
import mustafaonur.mustafaleague.classes.Fixture;
import mustafaonur.mustafaleague.classes.Team;
import mustafaonur.mustafaleague.classes.Week;
import mustafaonur.mustafaleague.manager.MatchManager;
import mustafaonur.mustafaleague.manager.TableManager;
public class Main {

	public static void main(String[] args) throws SQLException {
		
		DbConnection.getConnection();
		DbConnection.clearQuery();
		
		int test = 0 ;
		
		Team team1 = new Team("Manchester City",10);
		Team team2 = new Team("Manchester United",6);
		Team team3 = new Team("Chelsea",8);
		Team team4 = new Team("Tottenham",7);
		Team[] teams = {team1,team2,team3,team4};
		
		List<Week> weeks = CreateFixture(teams);
		Scanner myObj = new Scanner(System.in);
		int choose = myObj.nextInt();
		for(int i = 0 ; i<weeks.size();i++) {
			MatchManager matchManager = new MatchManager();
			matchManager.MatchWeek(weeks.get(i));
			if(choose == 1) {
				choose = myObj.nextInt();
			}
		}
		TableManager manager = new TableManager();
		manager.ShowTable(teams);
		
		System.out.println("Takım Adı --- Win --- Lose --- Draw --- Average --- Point -----------");
		String query = "insert into league(teamname ,power, win, lose, draw, point, average, scoredgoal,concededgoal) values(?,?,?,?,?,?,?,?,?)";
		//String orderByPoints = "select * from league order by points asc";
;		for(var item : teams) {
			System.out.println(item.teamName +"  "+item.win+ "  "+item.lose+"  "+item.draw+"  "+item.average+"  "+item.point + "       " );
			
			try {
				
				DbConnection.getConnection().setAutoCommit(false);
				PreparedStatement statement = DbConnection.getConnection().prepareStatement(query);
				statement.setString(1, item.teamName);
				statement.setInt(2, item.power);
				statement.setInt(3, item.win);
				statement.setInt(4, item.lose);
				statement.setInt(5, item.draw);
				statement.setInt(6, item.point);
				statement.setInt(7, item.average);
				statement.setInt(8, item.scoredGoal);
				statement.setInt(9, item.concededGoal);
				
				
				test = statement.executeUpdate();
				
				
				DbConnection.getConnection().setAutoCommit(true);
			}catch(Exception e) {
				DbConnection.getConnection().rollback();
			}
		}
		
	}
	public static List<Week> CreateFixture(Team[] teams) {
		//List<Team> teams = new ArrayList<Team>();
				
				List<Fixture> fixtures = new ArrayList<Fixture>();
				for(int i = 0;i<teams.length;i++) {
					for(int j = 0 ; j<teams.length;j++) {
						if(teams[i] != teams[j]) {
							fixtures.add(new Fixture(teams[i],teams[j]));
						}
					}
				}
				
				
				
				List<Week> weeks = new ArrayList<Week>();
				for (int i = 0; i < fixtures.size(); i++)
		        {
		            for(int j = i+1; j < fixtures.size(); j++)
		            {
		            if (
		                    fixtures.get(i).team1.teamName != fixtures.get(j).team1.teamName &&
		                    fixtures.get(i).team1.teamName != fixtures.get(j).team2.teamName &&
		                    fixtures.get(i).team2.teamName != fixtures.get(j).team1.teamName &&
		                    fixtures.get(i).team2.teamName != fixtures.get(j).team2.teamName
		                ){
		                    weeks.add(new Week(fixtures.get(i),fixtures.get(j)));
		                  }
		            }
		            
		        }
				
				List<Week> leagueWeeks = new ArrayList<Week>();
				leagueWeeks.add(weeks.get(0));
				leagueWeeks.add(weeks.get(10));
				leagueWeeks.add(weeks.get(4));
				leagueWeeks.add(weeks.get(7));
				leagueWeeks.add(weeks.get(2));
				leagueWeeks.add(weeks.get(11));
				return leagueWeeks;
				
	}

}
//1 vs 2------3 vs 4
//3 vs 1------4 vs 2
//1 vs 4------2 vs 3
//2 vs 1------4 vs 3
//1 vs 3------2 vs 4
//3 vs 2------4 vs 1