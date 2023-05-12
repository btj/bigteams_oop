package bigteams_oop.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.Test;

import bigteams_oop.Student;
import bigteams_oop.Team;

class BigTeamsTest {

	@Test
	void test() {
		Student alice = new Student();
		// assertNull(alice.team); // Not accessible!
		assertNull(alice.getTeam());
		
		Team team1 = new Team();
		assertTrue(team1.getMembers().isEmpty());
		
		alice.joinTeam(team1);
		// alice.team = null; // Not accessible! Would break the consistency of the bidirectional association
		assertSame(team1, alice.getTeam());
		assertEquals(Set.of(alice), team1.getMembers());
		
		alice.leaveTeam();
		assertNull(alice.getTeam());
		assertTrue(team1.getMembers().isEmpty());
	}

}
