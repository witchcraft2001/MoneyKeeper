package ru.dm_dev.moneykeeper.views;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

import ru.dm_dev.moneykeeper.R;
import ru.dm_dev.moneykeeper.common.CurrencySpinAdapter;
import ru.dm_dev.moneykeeper.common.WalletTypeSpinAdapter;
import ru.dm_dev.moneykeeper.models.Currency;
import ru.dm_dev.moneykeeper.models.WalletType;
import ru.dm_dev.moneykeeper.presenters.EditWalletPresenterImpl;
import ru.dm_dev.moneykeeper.presenters.IEditWalletPresenter;

public class EditWalletActivity extends AppCompatActivity implements IEditWalletActivity {

    private static final String LOG_TAG = "EditWalletActivity";
    private EditText nameEdit;
    private EditText balanceEdit;
    private Spinner walletTypeSpinner;
    private Spinner currencySpinner;
    private TextView symbolText;
    private IEditWalletPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_wallet);
        nameEdit = (EditText)findViewById(R.id.edit_wallet_name);
        balanceEdit = (EditText)findViewById(R.id.edit_balance);
        walletTypeSpinner = (Spinner)findViewById(R.id.spinner_wallet_type);
        currencySpinner = (Spinner)findViewById(R.id.spinner_currency);
        symbolText = (TextView)findViewById(R.id.text_view_currency_symbol);
        presenter = new EditWalletPresenterImpl(this);
        presenter.init(0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_edit_operation, menu);
        return true;
    }

    @Override
    public void showLoader() {

    }

    @Override
    public void hideLoader() {

    }

    @Override
    public void setName(String name) {
        nameEdit.setText(name);
    }

    @Override
    public String getName() {
        return nameEdit.getText().toString();
    }

    @Override
    public void setWalletTypeListAdapter(List<WalletType> list) {
        Log.d(LOG_TAG, "setWalletTypeListAdapter");
        if (list != null) {
            Log.d(LOG_TAG, "Items count = " + list.size());
        }
        WalletTypeSpinAdapter adapter = new WalletTypeSpinAdapter(this, R.layout.support_simple_spinner_dropdown_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        walletTypeSpinner.setAdapter(adapter);
    }

    @Override
    public void setCurrencyListAdapter(List<Currency> list) {
        Log.d(LOG_TAG, "setCurrencyListAdapter");
        if (list != null) {
            Log.d(LOG_TAG, "Items count = " + list.size());
        }
        CurrencySpinAdapter adapter = new CurrencySpinAdapter(this, R.layout.support_simple_spinner_dropdown_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        currencySpinner.setAdapter(adapter);
    }

    @Override
    public void setSelectedPositionWalletType(int position) {
        walletTypeSpinner.setSelection(position);
    }

    @Override
    public long getSelectedWalletTypeId() {
        return walletTypeSpinner.getSelectedItemId();
    }

    @Override
    public void setSelectedPositionCurrency(int position) {
        currencySpinner.setSelection(position);
    }

    @Override
    public long getSelectedCurrency() {
        return currencySpinner.getSelectedItemId();
    }

    @Override
    public void setBalance(String balance) {
        balanceEdit.setText(balance);
    }

    @Override
    public String getBalance() {
        return balanceEdit.getText().toString();
    }

    @Override
    public void setSymbol(String symbol) {
        symbolText.setText(symbol);
    }
}
