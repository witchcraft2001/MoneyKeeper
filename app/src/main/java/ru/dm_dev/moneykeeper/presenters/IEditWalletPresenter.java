package ru.dm_dev.moneykeeper.presenters;

public interface IEditWalletPresenter {
    void init(long id);
    void onSelectCurrency(long id);
    void onSave();
}
