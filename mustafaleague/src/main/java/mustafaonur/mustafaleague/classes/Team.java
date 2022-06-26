package mustafaonur.mustafaleague.classes;

import javax.persistence.Entity;

@Entity
public class Team implements Comparable<Team>{
	public String teamName;
	public int id;
	public int power;
	public int win;
	public int lose;
	public int draw;
	public int point;
	public int average;
	public int scoredGoal;
	public int concededGoal;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public int getWin() {
		return win;
	}
	public void setWin(int win) {
		this.win = win;
	}
	public int getLose() {
		return lose;
	}
	public void setLose(int lose) {
		this.lose = lose;
	}
	public int getDraw() {
		return draw;
	}
	public void setDraw(int draw) {
		this.draw = draw;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getAverage() {
		return average;
	}
	public void setAverage(int average) {
		this.average = average;
	}
	public int getScoredGoal() {
		return scoredGoal;
	}
	public void setScoredGoal(int scoredGoal) {
		this.scoredGoal = scoredGoal;
	}
	public int getConcededGoal() {
		return concededGoal;
	}
	public void setConcededGoal(int concededGoal) {
		this.concededGoal = concededGoal;
	}
	
	public Team(String teamName, int power) {
		this.teamName = teamName;
		this.power = power;
	}
	@Override
	public int compareTo(Team o) {
		return this.point-o.point;
	}
}
