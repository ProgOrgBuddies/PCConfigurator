/*
 * This file is generated by jOOQ.
 */
package de.htwsaar.pcconfig.generated.tables.records;


import de.htwsaar.pcconfig.generated.tables.Cpu;

import org.jooq.Record1;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class CpuRecord extends UpdatableRecordImpl<CpuRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>CPU.CPU_ID</code>.
     */
    public void setCpuId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>CPU.CPU_ID</code>.
     */
    public Integer getCpuId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>CPU.Name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>CPU.Name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>CPU.Brand</code>.
     */
    public void setBrand(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>CPU.Brand</code>.
     */
    public String getBrand() {
        return (String) get(2);
    }

    /**
     * Setter for <code>CPU.Cores</code>.
     */
    public void setCores(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>CPU.Cores</code>.
     */
    public Integer getCores() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>CPU.Price</code>.
     */
    public void setPrice(Float value) {
        set(4, value);
    }

    /**
     * Getter for <code>CPU.Price</code>.
     */
    public Float getPrice() {
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
     * Create a detached CpuRecord
     */
    public CpuRecord() {
        super(Cpu.CPU);
    }

    /**
     * Create a detached, initialised CpuRecord
     */
    public CpuRecord(Integer cpuId, String name, String brand, Integer cores, Float price) {
        super(Cpu.CPU);

        setCpuId(cpuId);
        setName(name);
        setBrand(brand);
        setCores(cores);
        setPrice(price);
        resetChangedOnNotNull();
    }
}
