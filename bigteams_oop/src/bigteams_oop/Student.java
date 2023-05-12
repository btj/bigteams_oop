package bigteams_oop;

import logicalcollections.LogicalSet;

/**
 * Each instance of this class represents a
 * student in a team membership graph.
 * 
 * @invar | getTeam() == null || getTeam().getMembers().contains(this)
 */
public class Student {
	
	/**
	 * @invar | team == null || team.members.contains(this)
	 * 
	 * @peerObject
	 */
	Team team;
	
	/**
	 * @peerObject
	 */
	public Team getTeam() { return team; }

	/**
	 * @post | getTeam() == null
	 */
	public Student() {}
	
	/**
	 * @pre | team != null
	 * @pre | getTeam() == null
	 * @mutates_properties | this.getTeam(), team.getMembers()
	 * @post | getTeam() == team
	 * @post | team.getMembers().equals(LogicalSet.plus(old(team.getMembers()), this))
	 */
	public void joinTeam(Team team) {
		this.team = team;
		team.members.add(this);
	}
	
	/**
	 * @pre | getTeam() != null
	 * @mutates_properties | getTeam(), getTeam().getMembers()
	 * @post | getTeam() == null
	 * @post | old(getTeam()).getMembers().equals(LogicalSet.minus(old(getTeam().getMembers()), this)) 
	 */
	public void leaveTeam() {
		team.members.remove(this);
		team = null;
	}
	
}
