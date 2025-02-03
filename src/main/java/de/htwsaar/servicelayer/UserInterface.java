package de.htwsaar.servicelayer;

import java.util.Scanner;

public interface UserInterface {

    int showMainMenu();

    int showDatabaseMenu();

    int showPersonalListMenu();

    int createPersonalListMenu();

    void IllegalInput(String message);

    void showMessage(String message);

    int readMinMaxInput(int min, int max);




}
