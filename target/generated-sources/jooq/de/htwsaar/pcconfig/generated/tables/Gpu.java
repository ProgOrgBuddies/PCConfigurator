/*
 * This file is generated by jOOQ.
 */
package de.htwsaar.pcconfig.generated.tables;


import de.htwsaar.pcconfig.generated.DefaultSchema;
import de.htwsaar.pcconfig.generated.Keys;
import de.htwsaar.pcconfig.generated.tables.records.GpuRecord;

import java.util.Collection;

import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.Name;
import org.jooq.PlainSQL;
import org.jooq.QueryPart;
import org.jooq.SQL;
import org.jooq.Schema;
import org.jooq.Select;
import org.jooq.Stringly;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class Gpu extends TableImpl<GpuRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>GPU</code>
     */
    public static final Gpu GPU = new Gpu();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<GpuRecord> getRecordType() {
        return GpuRecord.class;
    }

    /**
     * The column <code>GPU.GPU_ID</code>.
     */
    public final TableField<GpuRecord, Integer> GPU_ID = createField(DSL.name("GPU_ID"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>GPU.Name</code>.
     */
    public final TableField<GpuRecord, String> NAME = createField(DSL.name("Name"), SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>GPU.Brand</code>.
     */
    public final TableField<GpuRecord, String> BRAND = createField(DSL.name("Brand"), SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>GPU.VRAM</code>.
     */
    public final TableField<GpuRecord, Integer> VRAM = createField(DSL.name("VRAM"), SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>GPU.Price</code>.
     */
    public final TableField<GpuRecord, Float> PRICE = createField(DSL.name("Price"), SQLDataType.REAL.nullable(false), this, "");

    private Gpu(Name alias, Table<GpuRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private Gpu(Name alias, Table<GpuRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>GPU</code> table reference
     */
    public Gpu(String alias) {
        this(DSL.name(alias), GPU);
    }

    /**
     * Create an aliased <code>GPU</code> table reference
     */
    public Gpu(Name alias) {
        this(alias, GPU);
    }

    /**
     * Create a <code>GPU</code> table reference
     */
    public Gpu() {
        this(DSL.name("GPU"), null);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public UniqueKey<GpuRecord> getPrimaryKey() {
        return Keys.GPU__PK_GPU;
    }

    @Override
    public Gpu as(String alias) {
        return new Gpu(DSL.name(alias), this);
    }

    @Override
    public Gpu as(Name alias) {
        return new Gpu(alias, this);
    }

    @Override
    public Gpu as(Table<?> alias) {
        return new Gpu(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Gpu rename(String name) {
        return new Gpu(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Gpu rename(Name name) {
        return new Gpu(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Gpu rename(Table<?> name) {
        return new Gpu(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Gpu where(Condition condition) {
        return new Gpu(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Gpu where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Gpu where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Gpu where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Gpu where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Gpu where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Gpu where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Gpu where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Gpu whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Gpu whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
