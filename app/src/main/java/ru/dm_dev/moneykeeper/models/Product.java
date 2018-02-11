package ru.dm_dev.moneykeeper.models;

import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToOne;

public class Product {
    @Id
    private Long id;

    @NotNull
    private String name;

    private String uuid;

    private long categoryId;

    @ToOne(joinProperty = "categoryId")
    private Category category;
}
