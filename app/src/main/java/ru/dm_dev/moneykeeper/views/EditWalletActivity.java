package ru.dm_dev.moneykeeper.views;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import ru.dm_dev.moneykeeper.R;

public class EditWalletActivity extends AppCompatActivity implements IEditWalletActivity {

    private EditText nameEdit;
    private EditText balanceEdit;
    private Spinner walletTypeSpinner;
    private Spinner currencySpinner;
    private TextView symbolText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_wallet);
        nameEdit = (EditText)findViewById(R.id.edit_wallet_name);
        balanceEdit = (EditText)findViewById(R.id.edit_balance);
        walletTypeSpinner = (Spinner)findViewById(R.id.spinner_wallet_type);
        currencySpinner = (Spinner)findViewById(R.id.spinner_currency);
        symbolText = (TextView)findViewById(R.id.text_view_currency_symbol);
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
