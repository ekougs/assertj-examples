package com.bisam.assertjex;

public class Person {
  private final String name;
  private final String surname;
  private final int age;

  public Person(String surname, String name, int age) {
    this.name = name;
    this.surname = surname;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }

  public int getAge() {
    return age;
  }
}
