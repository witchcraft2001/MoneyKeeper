package ru.dm_dev.moneykeeper.views;

import android.app.Application;

import java.util.List;

import ru.dm_dev.moneykeeper.app.MoneyKeeperApp;
import ru.dm_dev.moneykeeper.models.WalletType;

public interface IEditWalletActivity {
    void showLoader();
    void hideLoader();
    void setName(String name);
    String getName();
    void setWalletTypeListAdapter(List<WalletType> list);
    void setSelectedPositionWalletType(int position);
    long getSelectedWalletTypeId();
    void setSelectedPositionCurrency(int position);
    long getSelectedCurrency();
    void setBalance(String balance);
    String getBalance();
    void setSymbol(String symbol);
    Application getApplication();
}
