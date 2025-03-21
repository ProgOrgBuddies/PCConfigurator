package de.htwsaar.servicelayer;


/* Hier werden alle Methoden deklariert die ein UserInterface der Logic Klasse stellen muss, damit der Ablauf des Programmes reguliert werden kann.
 * Dadurch ist die Logik des Programmes unabhängig vom UserInterface, sodass das UserInterface leicht ersetzt werden kann durch ein GUI z.B.
 * In unserem Beispiel erweitert die Dialog Klasse das UserInterface, wodurch ein TextInterface gestellt wird.
 */

public interface UserInterface {

    int showMainMenu();

    int showDatabaseMenu();

    int showPersonalListMenu();

    int createPersonalListMenu();

    void illegalInput(String message);

    void showMessage(String message);

    int readMinMaxInput(int min, int max);




}
