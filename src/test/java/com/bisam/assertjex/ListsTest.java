package com.bisam.assertjex;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import static com.bisam.assertjex.PersonInstances.*;
import static org.assertj.core.api.Assertions.extractProperty;
import static org.assertj.core.api.Assertions.tuple;

public class ListsTest {
  private Persons yellowTeam;

  @Before
  public void setUp() {
    yellowTeam = new Persons();
    yellowTeam.add(PASCAL)
      .add(GUILLAUME)
      .add(FOUAD)
      .add(FATIMA);
  }

  @Test
  public void testSurnames() throws Exception {
    Assertions.assertThat(yellowTeam).extracting("surname").containsOnly("Pascal", "Fatima", "Guillaume", "Fouad");
  }

  @Test
  public void testSurnamesInError() throws Exception {
    Assertions.assertThat(yellowTeam).extracting("surname").containsOnly("Pascal", "Guillaume", "Fouad");
  }

  @Test
  public void testNamesAndSurnames() throws Exception {
    Assertions.assertThat(yellowTeam).extracting("surname", "name")
      .containsOnly(tuple("Pascal", "Ekouaghe"),
                    tuple("Guillaume", "Michel"),
                    tuple("Fouad", "Hellou"),
                    tuple("Fatima", "Amach"));

  }

  @Test
  public void testNamesAndSurnamesInError() throws Exception {
    Assertions.assertThat(yellowTeam).extracting("surname", "name")
      .containsOnly(tuple("Guillaume", "Michel"),
                    tuple("Fouad", "Hellou"),
                    tuple("Fatima", "Amach"));

  }

  @Test
  public void testAgeWithStrongTypingExtraction() throws Exception {
    Assertions.assertThat(extractProperty("age", Integer.class).from(yellowTeam)).containsOnly(25, 35, 29, 27);
  }
}
