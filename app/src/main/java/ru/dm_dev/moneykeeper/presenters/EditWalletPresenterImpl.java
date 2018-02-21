package ru.dm_dev.moneykeeper.presenters;

import android.os.AsyncTask;
import android.util.Log;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

import ru.dm_dev.moneykeeper.app.MoneyKeeperApp;
import ru.dm_dev.moneykeeper.models.Currency;
import ru.dm_dev.moneykeeper.models.CurrencyDao;
import ru.dm_dev.moneykeeper.models.DaoSession;
import ru.dm_dev.moneykeeper.models.Wallet;
import ru.dm_dev.moneykeeper.models.WalletType;
import ru.dm_dev.moneykeeper.models.WalletTypeDao;
import ru.dm_dev.moneykeeper.views.IEditWalletActivity;

public class EditWalletPresenterImpl implements IEditWalletPresenter {

    private static final String LOG_TAG = "EditWalletPresenterImpl";
    private Wallet item;
    private DaoSession daoSession;
    private IEditWalletActivity view;
    private long id;
    private List<Currency> currencies;
    private List<WalletType> walletTypes;

    public EditWalletPresenterImpl(IEditWalletActivity view) {
        this.view = view;
    }

    @Override
    public void init(long id) {
        this.id = id;
        daoSession = ((MoneyKeeperApp) view.getApplication()).getDaoSession();
        if (id == 0) {
            item = new Wallet();
        } else {
            new GetWalletItem().execute();
        }
        new GetWalletTypes().execute();
        new GetCurrencies().execute();
    }

    private void showModel(){
        view.setBalance(String.valueOf(item.getBalance()));
        view.setName(item.getName());
        view.setSymbol(item.getCurrency().getSymbol());
        view.setSelectedPositionCurrency(getCurrencyPositionById(item.getCurrencyId()));
        view.setSelectedPositionWalletType(getWalletTypePositionById(item.getWalletTypeId()));
    }

    private int getWalletTypePositionById(long walletTypeId) {
        for (int i = 0; i < walletTypes.size(); i++) {
            if (walletTypes.get(i).getId() == walletTypeId) {
                return i;
            }
        }
        return 0;
    }

    private int getCurrencyPositionById(long currencyId) {
        for (int i = 0; i < currencies.size(); i++) {
            if (currencies.get(i).getId() == currencyId) {
                return i;
            }
        }
        return 0;
    }

    @Override
    public void onSelectCurrency(long id) {

    }

    @Override
    public void onSave() {
        item.setName(view.getName());
        //todo: доработать преобразование
        try {
            item.setBalance(Double.parseDouble(view.getBalance()));
        }catch (Exception e) {
            Log.e(LOG_TAG, e.getMessage());
        }
        item.setCurrencyId(view.getSelectedCurrencyId());
        item.setWalletTypeId(view.getSelectedWalletTypeId());
        daoSession.getWalletDao().save(item);
        view.finish();
    }

    private class GetWalletItem extends AsyncTask<Void, Void, Wallet> {

        @Override
        protected Wallet doInBackground(Void... voids) {
            return daoSession.getWalletDao().loadDeep(id);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            view.showLoader();
        }

        @Override
        protected void onPostExecute(Wallet wallet) {
            view.hideLoader();
            item = wallet;
            showModel();
        }
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
        protected void onPostExecute(List<WalletType> items) {
            view.hideLoader();
            walletTypes = items;
            view.setWalletTypeListAdapter(items);
        }
    }

    private class GetCurrencies extends AsyncTask<Void, Void, List<Currency>> {

        @Override
        protected List<Currency> doInBackground(Void... voids) {
            QueryBuilder<Currency> builder = daoSession.getCurrencyDao().queryBuilder();
            return builder.orderAsc(CurrencyDao.Properties.Name).list();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            view.showLoader();
        }

        @Override
        protected void onPostExecute(List<Currency> items) {
            view.hideLoader();
            currencies = items;
            view.setCurrencyListAdapter(items);
        }
    }
}
