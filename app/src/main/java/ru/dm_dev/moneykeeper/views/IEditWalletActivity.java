package ru.dm_dev.moneykeeper.views;

public interface IEditWalletActivity {
    void showLoader();
    void hideLoader();
    void setName(String name);
    String getName();
    void setSelectedPositionWalletType(int position);
    long getSelectedWalletTypeId();
    void setSelectedPositionCurrency(int position);
    long getSelectedCurrency();
    void setBalance(String balance);
    String getBalance();
    void setSymbol(String symbol);
}
