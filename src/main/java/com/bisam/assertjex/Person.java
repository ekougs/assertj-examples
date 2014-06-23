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
    if (name != null ? !name.equals(person.name) : person.name != null) {
      return false;
    }
    if (surname != null ? !surname.equals(person.surname) : person.surname != null) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + (surname != null ? surname.hashCode() : 0);
    result = 31 * result + age;
    return result;
  }

  @Override
  public String toString() {
    return "Person{" +
           "name='" + name + '\'' +
           ", surname='" + surname + '\'' +
           ", age=" + age +
           '}';
  }
}
