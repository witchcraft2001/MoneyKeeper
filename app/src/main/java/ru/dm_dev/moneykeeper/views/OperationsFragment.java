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
import ru.dm_dev.moneykeeper.common.OperationsAdapter;
import ru.dm_dev.moneykeeper.models.Operation;
import ru.dm_dev.moneykeeper.presenters.IOperationsPresenter;
import ru.dm_dev.moneykeeper.presenters.OperationsPresenterImpl;

public class OperationsFragment extends Fragment implements IOperationsView, View.OnClickListener {

    View rootView;
    public static OperationsFragment instance;
    private IOperationsPresenter presenter;
    private RecyclerView recyclerView;
    private OperationsAdapter listAdapter;

    public OperationsFragment() {
        // Required empty public constructor
    }

    public static OperationsFragment getInstance() {
        if (instance == null) {
            instance = new OperationsFragment();
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
        rootView = inflater.inflate(R.layout.fragment_operations, container, false);

        FloatingActionButton fab = (FloatingActionButton)rootView.findViewById(R.id.fab);
        fab.setOnClickListener(this);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.rv);

        // recyclerView should display items in a vertical list
        recyclerView.setLayoutManager(
                new LinearLayoutManager(getActivity().getBaseContext()));


        listAdapter = new OperationsAdapter(null);
        recyclerView.setAdapter(listAdapter);

        // attach a custom ItemDecorator to draw dividers between list items
//        recyclerView.addItemDecoration(new ItemDivider(getContext()));

        // improves performance if RecyclerView's layout size never changes
        recyclerView.setHasFixedSize(true);
        presenter = new OperationsPresenterImpl(this);

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
    public void setListAdapter(List<Operation> list) {
        listAdapter.swapList(list);
    }

    @Override
    public Application getApplication() {
        return getActivity().getApplication();
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getContext(), EditOperationActivity.class);
        intent.putExtra("Id", 0L);
        startActivity(intent);
    }
}
