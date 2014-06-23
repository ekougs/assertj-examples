package com.bisam.assertjex;

import org.junit.Test;

import java.util.Comparator;

import static com.bisam.assertjex.PersonInstances.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ComparisonTest {

  @Test
  public void testSurnamesUsingComparator() throws Exception {
    Comparator<Person> surnameFirstLetterComparator = new SurnameFirstLetterComparator();
    assertThat(GUILLAUME).usingComparator(surnameFirstLetterComparator).isNotEqualTo(PASCAL);
    assertThat(FATIMA).usingComparator(surnameFirstLetterComparator).isEqualTo(FOUAD);
  }

  private static class SurnameFirstLetterComparator implements Comparator<Person> {
    public int compare(Person person1, Person person2) {
      return getSurnameFirstLetter(person1).compareToIgnoreCase(getSurnameFirstLetter(person2));
    }

    private String getSurnameFirstLetter(Person person1) {
      return new Character(person1.getSurname().charAt(0)).toString();
    }
  }
}
