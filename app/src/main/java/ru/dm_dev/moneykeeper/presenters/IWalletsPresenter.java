package ru.dm_dev.moneykeeper.presenters;

public interface IWalletsPresenter {
    void init();
    void onItemClick(long walletId);
    void Refresh();
    void setSearchQuery(String query);
}
