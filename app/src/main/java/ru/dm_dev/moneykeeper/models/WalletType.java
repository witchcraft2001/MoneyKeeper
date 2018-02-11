package ru.dm_dev.moneykeeper.models;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

import java.util.UUID;

@Entity
public class WalletType {
    @Id
    private Long id;

    @NotNull
    private String name;

    @Index(unique = true)
    private String uuid;

    @Generated(hash = 1875892688)
    public WalletType(Long id, @NotNull String name, String uuid) {
        this.id = id;
        this.name = name;
        this.uuid = uuid;
    }

    @Keep
    public WalletType() {
        this.uuid = UUID.randomUUID().toString();
    }

    public WalletType(String name) {
        this();
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
