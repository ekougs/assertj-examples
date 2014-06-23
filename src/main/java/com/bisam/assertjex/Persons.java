package com.bisam.assertjex;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Persons implements Iterable<Person> {
  private final List<Person> persons = new ArrayList<Person>();

  Persons add(Person person) {
    persons.add(person);
    return this;
  }

  public Iterator<Person> iterator() {
    return persons.iterator();
  }
}
