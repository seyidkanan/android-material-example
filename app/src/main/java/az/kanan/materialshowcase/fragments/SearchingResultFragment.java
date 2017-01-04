package az.kanan.materialshowcase.fragments;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import az.kanan.materialshowcase.R;
import az.kanan.materialshowcase.models.Car;
import az.kanan.materialshowcase.util.CarListAdapter;

public class SearchingResultFragment extends Fragment {

    ListView listView;


    List<Car> carList;

    public SearchingResultFragment() {
    }

    @SuppressLint("ValidFragment")
    public SearchingResultFragment(List<Car> carList) {
        this.carList = carList;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_second, null);
        listView = (ListView) v.findViewById(R.id.carListView);
        listView.setAdapter(new CarListAdapter(carList, getActivity()));
        return v;
    }

}

