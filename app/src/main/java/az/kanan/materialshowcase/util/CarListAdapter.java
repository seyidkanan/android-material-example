package az.kanan.materialshowcase.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import az.kanan.materialshowcase.R;
import az.kanan.materialshowcase.models.Car;


/**
 * Created by Kanan on 12/31/2016.
 */

public class CarListAdapter extends BaseAdapter {


    Context context;
    List<Car> carList;

    public CarListAdapter(List<Car> carList, Context context) {
        this.context = context;
        this.carList = carList;
    }

    @Override
    public int getCount() {
        return carList.size();
    }

    @Override
    public Object getItem(int position) {
        return 0;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item, parent, false);
            holder = new ViewHolder();
            holder.brandTV = (TextView) convertView.findViewById(R.id.brandTextView);
            holder.modelTV = (TextView) convertView.findViewById(R.id.modelTextView);
            holder.imageView = (ImageView) convertView.findViewById(R.id.imageImageView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.brandTV.setText(carList.get(position).getBrand());
        holder.modelTV.setText(carList.get(position).getModel());
        holder.imageView.setImageResource(R.drawable.car_photo);
        return convertView;
    }


    class ViewHolder {
        TextView brandTV, modelTV;
        ImageView imageView;
    }

}
