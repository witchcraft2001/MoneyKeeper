package ru.dm_dev.moneykeeper.common;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ru.dm_dev.moneykeeper.R;
import ru.dm_dev.moneykeeper.models.Operation;
import ru.dm_dev.moneykeeper.models.Wallet;

public class OperationsAdapter extends RecyclerView.Adapter<OperationsAdapter.ViewHolder>{
    private List<Operation> list;

    public OperationsAdapter(List<Operation> list) {
        this.list = list;
    }

    @Override
    public OperationsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.operation_item, parent, false);
        return new OperationsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(OperationsAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return (list == null) ? 0 : list.size();
    }

    public void swapList(List<Operation> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView nameText;
        public final ImageView starImage;
        private long rowID;

        public ViewHolder(View itemView) {
            super(itemView);
            nameText = (TextView) itemView.findViewById(R.id.name);
            starImage = (ImageView) itemView.findViewById(R.id.icon_star);
//            itemView.setOnClickListener(
//                    new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            clickListener.onClick(rowID);
//                        }
//                    }
//            );
        }

        public void setRowID(long rowID) {
            this.rowID = rowID;
        }
    }
}
