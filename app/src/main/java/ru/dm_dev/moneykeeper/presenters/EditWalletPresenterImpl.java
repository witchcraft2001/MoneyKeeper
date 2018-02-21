package ru.dm_dev.moneykeeper.presenters;

import android.os.AsyncTask;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

import ru.dm_dev.moneykeeper.app.MoneyKeeperApp;
import ru.dm_dev.moneykeeper.models.DaoSession;
import ru.dm_dev.moneykeeper.models.WalletType;
import ru.dm_dev.moneykeeper.models.WalletTypeDao;
import ru.dm_dev.moneykeeper.views.IEditWalletActivity;

public class EditWalletPresenterImpl implements IEditWalletPresenter {

    DaoSession daoSession;
    IEditWalletActivity view;
    long id;

    public EditWalletPresenterImpl(IEditWalletActivity view) {
        this.view = view;
    }

    @Override
    public void init(long id) {
        this.id = id;
        daoSession = ((MoneyKeeperApp) view.getApplication()).getDaoSession();
        new GetWalletTypes().execute();
    }

    private class GetWalletTypes extends AsyncTask<Void, Void, List<WalletType>> {
        @Override
        protected List<WalletType> doInBackground(Void... voids) {
            QueryBuilder<WalletType> builder = daoSession.getWalletTypeDao().queryBuilder();

            return builder.orderAsc(WalletTypeDao.Properties.Name).list();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            view.showLoader();
        }

        @Override
        protected void onPostExecute(List<WalletType> walletTypes) {
            view.hideLoader();
            view.setWalletTypeListAdapter(walletTypes);
        }
    }
}
