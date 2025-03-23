package de.htwsaar.persistenz;

import de.htwsaar.servicelayer.components.*;

public interface ComponentServiceInterface {

    
    void printAllRAMComponents();
    void printAllCPUComponents();
    void printAllGPUComponents();
    void printAllMainboardComponents();
    void printAllPowerUnitComponents();
    void printAllCaseComponents();

    CPU getOneCPU(int id);
    GPU getOneGPU(int id);
    RAM getOneRAM(int id);
    Mainboard getOneMainboard(int id);
    PowerUnit getOnePowerUnit(int id);
    ComputerCase getOneComputerCase(int id);
}
