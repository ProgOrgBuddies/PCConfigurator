/*
 * This file is generated by jOOQ.
 */
package de.htwsaar.pcconfig.generated.tables.records;


import de.htwsaar.pcconfig.generated.tables.Ssd;

import org.jooq.Record1;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class SsdRecord extends UpdatableRecordImpl<SsdRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>SSD.SSD_ID</code>.
     */
    public void setSsdId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>SSD.SSD_ID</code>.
     */
    public Integer getSsdId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>SSD.Name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>SSD.Name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>SSD.Marke</code>.
     */
    public void setMarke(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>SSD.Marke</code>.
     */
    public String getMarke() {
        return (String) get(2);
    }

    /**
     * Setter for <code>SSD.Größe</code>.
     */
    public void setGröße(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>SSD.Größe</code>.
     */
    public Integer getGröße() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>SSD.Preis</code>.
     */
    public void setPreis(Float value) {
        set(4, value);
    }

    /**
     * Getter for <code>SSD.Preis</code>.
     */
    public Float getPreis() {
        return (Float) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SsdRecord
     */
    public SsdRecord() {
        super(Ssd.SSD);
    }

    /**
     * Create a detached, initialised SsdRecord
     */
    public SsdRecord(Integer ssdId, String name, String marke, Integer größe, Float preis) {
        super(Ssd.SSD);

        setSsdId(ssdId);
        setName(name);
        setMarke(marke);
        setGröße(größe);
        setPreis(preis);
        resetChangedOnNotNull();
    }
}
