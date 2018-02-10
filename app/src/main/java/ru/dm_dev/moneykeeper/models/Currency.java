package ru.dm_dev.moneykeeper.models;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Currency {
    @Id
    private Long id;

    private String codeStr;

    private int codeInt;

    private String name;

    private String symbol;

    @Generated(hash = 2044425557)
    public Currency(Long id, String codeStr, int codeInt, String name,
            String symbol) {
        this.id = id;
        this.codeStr = codeStr;
        this.codeInt = codeInt;
        this.name = name;
        this.symbol = symbol;
    }

    @Generated(hash = 1387171739)
    public Currency() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeStr() {
        return this.codeStr;
    }

    public void setCodeStr(String codeStr) {
        this.codeStr = codeStr;
    }

    public int getCodeInt() {
        return this.codeInt;
    }

    public void setCodeInt(int codeInt) {
        this.codeInt = codeInt;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
