package ru.dm_dev.moneykeeper.presenters;

import android.os.AsyncTask;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

import ru.dm_dev.moneykeeper.app.MoneyKeeperApp;
import ru.dm_dev.moneykeeper.models.DaoSession;
import ru.dm_dev.moneykeeper.models.Operation;
import ru.dm_dev.moneykeeper.models.OperationDao;
import ru.dm_dev.moneykeeper.views.IOperationsView;

public class OperationsPresenterImpl implements IOperationsPresenter {
    private IOperationsView view;
    private List<Operation> operations;
    private DaoSession daoSession;

    public OperationsPresenterImpl(IOperationsView view) {
        this.view = view;
    }

    @Override
    public void init() {
        daoSession = ((MoneyKeeperApp) view.getApplication()).getDaoSession();
        new GetOperations().execute();
    }

    @Override
    public void onItemClick(long operationId) {

    }

    @Override
    public void Refresh() {

    }

    @Override
    public void setSearchQuery(String query) {

    }

    private class GetOperations extends AsyncTask<Void, Void, List<Operation>> {
        @Override
        protected List<Operation> doInBackground(Void... voids) {
            QueryBuilder<Operation> builder = daoSession.getOperationDao().queryBuilder();

            return builder.orderAsc(OperationDao.Properties.Description).list();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            view.showLoader();
        }

        @Override
        protected void onPostExecute(List<Operation> items) {
            view.hideLoader();
            operations = items;
            view.setListAdapter(items);
        }
    }
}
