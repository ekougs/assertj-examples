package com.bisam.assertjex;

public class Person {
  private final String name;
  private final String surname;

  public Person(String surname, String name) {
    this.name = name;
    this.surname = surname;
  }

  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }
}
