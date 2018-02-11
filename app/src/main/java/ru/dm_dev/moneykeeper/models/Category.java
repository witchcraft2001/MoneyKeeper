package ru.dm_dev.moneykeeper.models;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

@Entity
public class Category {
    @Id
    private Long id;

    @NotNull
    private String name;

    private String uuid;

    private long categoryId;

    @ToOne(joinProperty = "categoryId")
    private Category parentCategory;

    //true - доход
    //false - расход
    private boolean type;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 40161530)
    private transient CategoryDao myDao;

    @Generated(hash = 1684685513)
    public Category(Long id, @NotNull String name, String uuid, long categoryId,
            boolean type) {
        this.id = id;
        this.name = name;
        this.uuid = uuid;
        this.categoryId = categoryId;
        this.type = type;
    }

    @Generated(hash = 1150634039)
    public Category() {
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

    public long getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public boolean getType() {
        return this.type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    @Generated(hash = 1138982838)
    private transient Long parentCategory__resolvedKey;

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1468988659)
    public Category getParentCategory() {
        long __key = this.categoryId;
        if (parentCategory__resolvedKey == null
                || !parentCategory__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            CategoryDao targetDao = daoSession.getCategoryDao();
            Category parentCategoryNew = targetDao.load(__key);
            synchronized (this) {
                parentCategory = parentCategoryNew;
                parentCategory__resolvedKey = __key;
            }
        }
        return parentCategory;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 528616836)
    public void setParentCategory(@NotNull Category parentCategory) {
        if (parentCategory == null) {
            throw new DaoException(
                    "To-one property 'categoryId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.parentCategory = parentCategory;
            categoryId = parentCategory.getId();
            parentCategory__resolvedKey = categoryId;
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

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 503476761)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getCategoryDao() : null;
    }
}
