package com.bisam.assertjex;

public class PersonInstances {
  static final Person PASCAL = new Person("Pascal", "Ekouaghe", 27);
  static final Person GUILLAUME = new Person("Guillaume", "Michel", 35);
  static final Person FOUAD = new Person("Fouad", "Hellou", 29);
  static final Person FATIMA = new Person("Fatima", "Amach", 25);

  static final Person SOLENE = new Person("Solène", "Le Dorze", 25);

  static final Persons YELLOW_TEAM = new Persons();

  static {
    YELLOW_TEAM.add(PASCAL)
      .add(GUILLAUME)
      .add(FOUAD)
      .add(FATIMA);
  }
}
