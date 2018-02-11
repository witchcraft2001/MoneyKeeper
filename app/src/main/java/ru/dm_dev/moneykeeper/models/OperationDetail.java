package ru.dm_dev.moneykeeper.models;

import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;

public class OperationDetail {
    @Id
    private Long id;

    private String description;

    private String uuid;

    @ToOne(joinProperty = "productId")
    private long productId;

    private Product product;

    private int quantity;

    private double price;

    private double amount;
}
