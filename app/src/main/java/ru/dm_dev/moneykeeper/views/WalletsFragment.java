package ru.dm_dev.moneykeeper.views;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ru.dm_dev.moneykeeper.R;
import ru.dm_dev.moneykeeper.common.WalletAdapter;
import ru.dm_dev.moneykeeper.models.Wallet;
import ru.dm_dev.moneykeeper.presenters.IWalletsPresenter;
import ru.dm_dev.moneykeeper.presenters.WalletsPresenterImpl;

public class WalletsFragment extends Fragment implements IWalletsView, View.OnClickListener {

    View rootView;
    public static WalletsFragment instance;
    private RecyclerView recyclerView;
    private WalletAdapter listAdapter;
    private IWalletsPresenter presenter;

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
        rootView = inflater.inflate(R.layout.fragment_wallets, container, false);
        FloatingActionButton fab = (FloatingActionButton)rootView.findViewById(R.id.fab);
        fab.setOnClickListener(this);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.rv);

        // recyclerView should display items in a vertical list
        recyclerView.setLayoutManager(
                new LinearLayoutManager(getActivity().getBaseContext()));


        listAdapter = new WalletAdapter(null);
        recyclerView.setAdapter(listAdapter);

        // attach a custom ItemDecorator to draw dividers between list items
//        recyclerView.addItemDecoration(new ItemDivider(getContext()));

        // improves performance if RecyclerView's layout size never changes
        recyclerView.setHasFixedSize(true);
        presenter = new WalletsPresenterImpl(this);
        return rootView;
    }

    @Override
    public void onResume(){
        super.onResume();
        presenter.init();
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

    @Override
    public void setListAdapter(List<Wallet> list) {
        listAdapter.swapList(list);
    }

    @Override
    public Application getApplication() {
        return getActivity().getApplication();
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getContext(), EditWalletActivity.class);
        intent.putExtra("Id", 0L);
        startActivity(intent);
    }
}
