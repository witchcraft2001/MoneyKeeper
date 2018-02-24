package ru.dm_dev.moneykeeper.presenters;

public interface IOperationsPresenter {
    void init();
    void onItemClick(long operationId);
    void Refresh();
    void setSearchQuery(String query);
}
