package com.bisam.assertjex;

public class Person {
  private final String surname;
  private final String firstName;
  private final int age;

  public Person(String firstName, String surname, int age) {
    this.surname = surname;
    this.firstName = firstName;
    this.age = age;
  }

  public String getSurname() {
    return surname;
  }

  public String getFirstName() {
    return firstName;
  }

  public int getAge() {
    return age;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Person)) {
      return false;
    }

    Person person = (Person)o;

    if (age != person.age) {
      return false;
    }
    if (surname != null ? !surname.equals(person.surname) : person.surname != null) {
      return false;
    }
    if (firstName != null ? !firstName.equals(person.firstName) : person.firstName != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = surname != null ? surname.hashCode() : 0;
    result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
    result = 31 * result + age;
    return result;
  }

  @Override
  public String toString() {
    return "Person{" +
           "name='" + surname + '\'' +
           ", surname='" + firstName + '\'' +
           ", age=" + age +
           '}';
  }
}
