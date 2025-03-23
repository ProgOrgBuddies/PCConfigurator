package de.htwsaar.persistenz;

import java.util.Map;

import de.htwsaar.servicelayer.PersonalList;

public interface PersonalListServiceInterface {

    public void savePersonalList(PersonalList personalList);

    public Map<Integer, PersonalList> loadPersonalList();

    public void deletePersonalList(int id);
}