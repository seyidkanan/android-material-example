package az.kanan.materialshowcase.util;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import az.kanan.materialshowcase.R;
import az.kanan.materialshowcase.models.Car;

/**
 * Created by Kanan on 1/4/2017.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {

    List<Car> carList;

    public RVAdapter(List<Car> carList) {
        this.carList = carList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.brandTextV.setText(carList.get(position).getBrand());
        holder.modelTextV.setText(carList.get(position).getModel());
    }

    @Override
    public int getItemCount() {
        return carList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        TextView brandTextV, modelTextV;


        public ViewHolder(View itemView) {
            super(itemView);
            brandTextV = (TextView) itemView.findViewById(R.id.brand_text);
            modelTextV = (TextView) itemView.findViewById(R.id.model_text);
        }
    }

}
