package com.bisam.assertjex;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class ListsTest {
  private Persons yellowTeam;

  @Before
  public void setUp() {
    yellowTeam = new Persons();
    yellowTeam.add(new Person("Pascal", "Ekouaghe"))
      .add(new Person("Guillaume", "Michel"))
      .add(new Person("Fouad", "Hellou"))
      .add(new Person("Fatima", "Amach"));
  }

  @Test
  public void testSurnames() throws Exception {
    Assertions.assertThat(yellowTeam).extracting("surname").containsOnly("Pascal", "Guillaume", "Fouad", "Fatima");
  }

  @Test
  public void testSurnamesInError() throws Exception {
    Assertions.assertThat(yellowTeam).extracting("surname").containsOnly("Pascal", "Guillaume", "Fouad");
  }
}
