/*
 * This file is generated by jOOQ.
 */
package de.htwsaar.pcconfig.generated.tables;


import de.htwsaar.pcconfig.generated.DefaultSchema;
import de.htwsaar.pcconfig.generated.Keys;
import de.htwsaar.pcconfig.generated.tables.records.MainboardRecord;

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
public class Mainboard extends TableImpl<MainboardRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>Mainboard</code>
     */
    public static final Mainboard MAINBOARD = new Mainboard();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<MainboardRecord> getRecordType() {
        return MainboardRecord.class;
    }

    /**
     * The column <code>Mainboard.MB_ID</code>.
     */
    public final TableField<MainboardRecord, Integer> MB_ID = createField(DSL.name("MB_ID"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>Mainboard.Name</code>.
     */
    public final TableField<MainboardRecord, String> NAME = createField(DSL.name("Name"), SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>Mainboard.Marke</code>.
     */
    public final TableField<MainboardRecord, String> MARKE = createField(DSL.name("Marke"), SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>Mainboard.Form</code>.
     */
    public final TableField<MainboardRecord, String> FORM = createField(DSL.name("Form"), SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>Mainboard.Sockel</code>.
     */
    public final TableField<MainboardRecord, String> SOCKEL = createField(DSL.name("Sockel"), SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>Mainboard.Preis</code>.
     */
    public final TableField<MainboardRecord, Float> PREIS = createField(DSL.name("Preis"), SQLDataType.REAL.nullable(false), this, "");

    private Mainboard(Name alias, Table<MainboardRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private Mainboard(Name alias, Table<MainboardRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>Mainboard</code> table reference
     */
    public Mainboard(String alias) {
        this(DSL.name(alias), MAINBOARD);
    }

    /**
     * Create an aliased <code>Mainboard</code> table reference
     */
    public Mainboard(Name alias) {
        this(alias, MAINBOARD);
    }

    /**
     * Create a <code>Mainboard</code> table reference
     */
    public Mainboard() {
        this(DSL.name("Mainboard"), null);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public UniqueKey<MainboardRecord> getPrimaryKey() {
        return Keys.MAINBOARD__PK_MAINBOARD;
    }

    @Override
    public Mainboard as(String alias) {
        return new Mainboard(DSL.name(alias), this);
    }

    @Override
    public Mainboard as(Name alias) {
        return new Mainboard(alias, this);
    }

    @Override
    public Mainboard as(Table<?> alias) {
        return new Mainboard(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Mainboard rename(String name) {
        return new Mainboard(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Mainboard rename(Name name) {
        return new Mainboard(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Mainboard rename(Table<?> name) {
        return new Mainboard(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Mainboard where(Condition condition) {
        return new Mainboard(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Mainboard where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Mainboard where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Mainboard where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Mainboard where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Mainboard where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Mainboard where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Mainboard where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Mainboard whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Mainboard whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
