package ru.dm_dev.moneykeeper.models;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

import java.util.UUID;

@Entity
public class Wallet {
    @Id
    private Long id;

    @NotNull
    private String name;

    private String uuid;

    private long walletTypeId;

    @ToOne(joinProperty = "walletTypeId")
    private WalletType walletType;

    private long currencyId;

    @ToOne(joinProperty = "currencyId")
    private Currency currency;

    private double balance;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 741381941)
    private transient WalletDao myDao;

    @Generated(hash = 1021023799)
    public Wallet(Long id, @NotNull String name, String uuid, long walletTypeId, long currencyId,
            double balance) {
        this.id = id;
        this.name = name;
        this.uuid = uuid;
        this.walletTypeId = walletTypeId;
        this.currencyId = currencyId;
        this.balance = balance;
    }

    @Keep
    public Wallet() {
        this.uuid = UUID.randomUUID().toString();
    }

    public Wallet(@NotNull String name, long walletTypeId, long currencyId, double balance) {
        this();
        this.name = name;
        this.walletTypeId = walletTypeId;
        this.currencyId = currencyId;
        this.balance = balance;
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

    public long getCurrencyId() {
        return this.currencyId;
    }

    public void setCurrencyId(long currencyId) {
        this.currencyId = currencyId;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Generated(hash = 1489923924)
    private transient Long currency__resolvedKey;

    @Generated(hash = 1226422428)
    private transient Long walletType__resolvedKey;

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 670547195)
    public Currency getCurrency() {
        long __key = this.currencyId;
        if (currency__resolvedKey == null || !currency__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            CurrencyDao targetDao = daoSession.getCurrencyDao();
            Currency currencyNew = targetDao.load(__key);
            synchronized (this) {
                currency = currencyNew;
                currency__resolvedKey = __key;
            }
        }
        return currency;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 2029286997)
    public void setCurrency(@NotNull Currency currency) {
        if (currency == null) {
            throw new DaoException(
                    "To-one property 'currencyId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.currency = currency;
            currencyId = currency.getId();
            currency__resolvedKey = currencyId;
        }
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    public long getWalletTypeId() {
        return this.walletTypeId;
    }

    public void setWalletTypeId(long walletTypeId) {
        this.walletTypeId = walletTypeId;
    }

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 413595982)
    public WalletType getWalletType() {
        long __key = this.walletTypeId;
        if (walletType__resolvedKey == null || !walletType__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            WalletTypeDao targetDao = daoSession.getWalletTypeDao();
            WalletType walletTypeNew = targetDao.load(__key);
            synchronized (this) {
                walletType = walletTypeNew;
                walletType__resolvedKey = __key;
            }
        }
        return walletType;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 2002680000)
    public void setWalletType(@NotNull WalletType walletType) {
        if (walletType == null) {
            throw new DaoException(
                    "To-one property 'walletTypeId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.walletType = walletType;
            walletTypeId = walletType.getId();
            walletType__resolvedKey = walletTypeId;
        }
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 657468544)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getWalletDao() : null;
    }

}
