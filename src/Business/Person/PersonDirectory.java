/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Person;

import java.util.ArrayList;

/**
 *
 * @author JJPL
 */
public class PersonDirectory {
    
    private ArrayList <Person> personList;
    
    public PersonDirectory ()
    {
        this.personList = new ArrayList<>();
    }

    public ArrayList<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(ArrayList<Person> personList) {
        this.personList = personList;
    }
    
    public Person addPerson(Person p)
    {
        personList.add(p);
        return p;
    }
}
