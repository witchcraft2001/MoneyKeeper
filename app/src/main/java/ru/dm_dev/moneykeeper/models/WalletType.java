package ru.dm_dev.moneykeeper.models;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class WalletType {
    @Id
    private Long id;

    @NotNull
    private String name;

    private String uuid;

    @Generated(hash = 1875892688)
    public WalletType(Long id, @NotNull String name, String uuid) {
        this.id = id;
        this.name = name;
        this.uuid = uuid;
    }

    @Generated(hash = 646323294)
    public WalletType() {
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
