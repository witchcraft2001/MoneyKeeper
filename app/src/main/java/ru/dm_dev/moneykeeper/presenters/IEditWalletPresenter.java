package ru.dm_dev.moneykeeper.presenters;

import ru.dm_dev.moneykeeper.views.IEditWalletActivity;

public interface IEditWalletPresenter {
    void init(IEditWalletActivity view, long id);
}
