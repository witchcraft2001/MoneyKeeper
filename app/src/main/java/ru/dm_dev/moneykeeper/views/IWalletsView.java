package ru.dm_dev.moneykeeper.views;

import android.app.Application;

import java.util.List;

import ru.dm_dev.moneykeeper.models.Wallet;

public interface IWalletsView {
    void showLoader();
    void hideLoader();
    void setListAdapter(List<Wallet> list);
    Application getApplication();
}
