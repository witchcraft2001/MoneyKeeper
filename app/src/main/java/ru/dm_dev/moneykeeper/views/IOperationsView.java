package ru.dm_dev.moneykeeper.views;

import android.app.Application;

import java.util.List;

import ru.dm_dev.moneykeeper.models.Operation;

public interface IOperationsView {
    void showLoader();
    void hideLoader();
    void setListAdapter(List<Operation> list);
    Application getApplication();
}
