package ru.dm_dev.moneykeeper.common;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import ru.dm_dev.moneykeeper.models.Currency;

public class CurrencySpinAdapter extends ArrayAdapter {
    private Context context;
    private List<Currency> items;

    public CurrencySpinAdapter(@NonNull Context context, int resource, @NonNull List<Currency> items) {
        super(context, resource, items);
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Nullable
    @Override
    public Currency getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return items.get(position).getId();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TextView v = (TextView) super.getView(position, convertView, parent);
        v.setText(items.get(position).getName());
        return v;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TextView v = (TextView) super.getView(position, convertView, parent);
        v.setText(items.get(position).getName());
        return v;
    }
}
