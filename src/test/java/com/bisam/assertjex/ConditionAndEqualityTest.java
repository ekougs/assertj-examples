package com.bisam.assertjex;

import org.assertj.core.api.Condition;
import org.junit.Test;

import java.util.Comparator;

import static com.bisam.assertjex.PersonInstances.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ConditionAndEqualityTest {

  @Test
  public void testSurnamesUsingComparator() throws Exception {
    Comparator<Person> surnameFirstLetterComparator = new SurnameFirstLetterComparator();
    assertThat(GUILLAUME).usingComparator(surnameFirstLetterComparator).isNotEqualTo(PASCAL);
    assertThat(FATIMA).usingComparator(surnameFirstLetterComparator).isEqualTo(FOUAD);
  }

  @Test
  public void testTeamMembership() throws Exception {
    YellowTeamMemberCondition yellowTeamMember = new YellowTeamMemberCondition();
    assertThat(SOLENE).isNot(yellowTeamMember);
    assertThat(FATIMA).is(yellowTeamMember);
  }

  @Test
  public void testYellowTeamAreAllAdults() throws Exception {
    GrownUpCondition allGrownUp = new GrownUpCondition();
    assertThat(YELLOW_TEAM).are(allGrownUp);
  }

  private static class SurnameFirstLetterComparator implements Comparator<Person> {
    public int compare(Person person1, Person person2) {
      return getSurnameFirstLetter(person1).compareToIgnoreCase(getSurnameFirstLetter(person2));
    }

    private String getSurnameFirstLetter(Person person1) {
      return new Character(person1.getSurname().charAt(0)).toString();
    }
  }

  private static class YellowTeamMemberCondition extends Condition<Person> {
    @Override
    public boolean matches(Person person) {
      return YELLOW_TEAM.contains(person);
    }
  }

  private static class GrownUpCondition extends Condition<Person> {
    @Override
    public boolean matches(Person person) {
      return person.getAge() >= 18;
    }
  }
}
