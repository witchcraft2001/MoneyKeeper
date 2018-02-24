package ru.dm_dev.moneykeeper.presenters;

import android.os.AsyncTask;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

import ru.dm_dev.moneykeeper.app.MoneyKeeperApp;
import ru.dm_dev.moneykeeper.models.DaoSession;
import ru.dm_dev.moneykeeper.models.Wallet;
import ru.dm_dev.moneykeeper.models.WalletDao;
import ru.dm_dev.moneykeeper.views.IWalletsView;

public class WalletsPresenterImpl implements IWalletsPresenter {
    private IWalletsView view;
    private List<Wallet> wallets;
    private DaoSession daoSession;

    public WalletsPresenterImpl(IWalletsView view) {
        this.view = view;
    }

    @Override
    public void init() {
        daoSession = ((MoneyKeeperApp) view.getApplication()).getDaoSession();
        new GetWallets().execute();
    }

    @Override
    public void onItemClick(long walletId) {

    }

    @Override
    public void Refresh() {

    }

    @Override
    public void setSearchQuery(String query) {

    }

    private class GetWallets extends AsyncTask<Void, Void, List<Wallet>> {
        @Override
        protected List<Wallet> doInBackground(Void... voids) {
            QueryBuilder<Wallet> builder = daoSession.getWalletDao().queryBuilder();

            return builder.orderAsc(WalletDao.Properties.Name).list();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            view.showLoader();
        }

        @Override
        protected void onPostExecute(List<Wallet> items) {
            view.hideLoader();
            wallets = items;
            view.setListAdapter(items);
        }
    }
}
