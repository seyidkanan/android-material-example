package az.kanan.materialshowcase.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import az.kanan.materialshowcase.R;
import az.kanan.materialshowcase.models.Car;



public class AddElementFragment extends Fragment {

    EditText modelET, brandET, urlET;
    Button insertButton;


    String model, brand, url;

    Boolean isInsertAviable = true;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_first, null);
        initViews(v);



        model = modelET.getText().toString();
        brand = brandET.getText().toString();
        url = urlET.getText().toString();

        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //checkFields(model, brand, url);

                if (isInsertAviable)
                    insertData(new Car(brand, model, url));
                else
                    Toast.makeText(getActivity(), "Insert not aviable", Toast.LENGTH_SHORT).show();
            }
        });


        return v;
    }

    private void checkFields(String model, String brand, String url) {
        urlET.setError(null);
        modelET.setError(null);
        brandET.setError(null);

        if (model.matches("")) {
            isInsertAviable = false;
            modelET.setError("Field is empty");
        } else {
            isInsertAviable = true;
            modelET.setError(null);
        }

        if (brand.matches("")) {
            brandET.setError("Field is empty");
            isInsertAviable = false;
        } else {
            isInsertAviable = true;
            brandET.setError(null);
        }

        String regex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

        Pattern patt = Pattern.compile(regex);
        Matcher matcher = patt.matcher(url);

        if (matcher.matches()) {
            isInsertAviable = true;
            urlET.setError(null);
        } else {
            isInsertAviable = false;
            urlET.setError("Field is empty");
        }
    }


    private void insertData(Car newCar) {


        Log.e("kanan", "inserted");
    }

    private void initViews(View v) {
        modelET = (EditText) v.findViewById(R.id.modelEditText);
        brandET = (EditText) v.findViewById(R.id.brandEditText);
        urlET = (EditText) v.findViewById(R.id.imageUrlEditText);
        insertButton = (Button) v.findViewById(R.id.insertButton);
    }

}
