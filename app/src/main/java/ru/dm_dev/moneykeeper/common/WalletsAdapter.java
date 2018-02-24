package ru.dm_dev.moneykeeper.common;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ru.dm_dev.moneykeeper.R;
import ru.dm_dev.moneykeeper.models.Wallet;

public class WalletsAdapter extends RecyclerView.Adapter<WalletsAdapter.ViewHolder>{
    private List<Wallet> list;

    public WalletsAdapter(List<Wallet> list)
    {
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.wallet_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WalletsAdapter.ViewHolder holder, int position) {
        holder.nameText.setText(list.get(position).getName());
        holder.setRowID(list.get(position).getId());
    }

    @Override
    public int getItemCount() {
        return (list == null) ? 0 : list.size();
    }

    public void swapList(List<Wallet> list) {
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
