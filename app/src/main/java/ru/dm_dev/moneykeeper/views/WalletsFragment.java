package ru.dm_dev.moneykeeper.views;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.dm_dev.moneykeeper.R;

public class WalletsFragment extends Fragment implements IWalletsView {

    public static WalletsFragment instance;

    public WalletsFragment() {
        // Required empty public constructor
    }

    public static WalletsFragment getInstance() {
        if (instance == null) {
            instance = new WalletsFragment();
        }
        return instance;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_wallets, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void showLoader() {

    }

    @Override
    public void hideLoader() {

    }
}
