package ru.dm_dev.moneykeeper.views;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import ru.dm_dev.moneykeeper.R;

public class EditOperationActivity extends AppCompatActivity implements IEditOperationView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_operation);
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
}
