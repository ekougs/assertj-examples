package com.bisam.assertjex;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static com.bisam.assertjex.PersonInstances.YELLOW_TEAM;
import static org.assertj.core.api.Assertions.extractProperty;
import static org.assertj.core.api.Assertions.tuple;

public class ExtractionTest {

  @Test
  public void testSurnames() throws Exception {
    Assertions.assertThat(YELLOW_TEAM).extracting("surname").containsOnly("Pascal", "Fatima", "Guillaume", "Fouad");
  }

  @Test
  public void testSurnamesInError() throws Exception {
    Assertions.assertThat(YELLOW_TEAM).extracting("surname").containsOnly("Pascal", "Guillaume", "Fouad");
  }

  @Test
  public void testNamesAndSurnames() throws Exception {
    Assertions.assertThat(YELLOW_TEAM).extracting("surname", "name")
      .containsOnly(tuple("Pascal", "Ekouaghe"),
                    tuple("Guillaume", "Michel"),
                    tuple("Fouad", "Hellou"),
                    tuple("Fatima", "Amach"));

  }

  @Test
  public void testNamesAndSurnamesInError() throws Exception {
    Assertions.assertThat(YELLOW_TEAM).extracting("surname", "name")
      .containsOnly(tuple("Guillaume", "Michel"),
                    tuple("Fouad", "Hellou"),
                    tuple("Fatima", "Amach"));

  }

  @Test
  public void testAgeWithStrongTypingExtraction() throws Exception {
    Assertions.assertThat(extractProperty("age", Integer.class).from(YELLOW_TEAM)).containsOnly(25, 35, 29, 27);
  }
}
