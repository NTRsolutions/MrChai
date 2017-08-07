package kredivation.mrchai.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import kredivation.mrchai.R;
import kredivation.mrchai.adapter.CustomHotTeaAdapter;


public class HotTeaFragment extends Fragment {
    View view;
    private ListView productList;

    String[] itemname = {
            "Hot Tea",
            "Ginger Tea",
            "Adrak Tea",
            "Ilachi Tea",
            "Simple Tea",
            "orange Tea",
            "Vwhitae Tea",
            "Cold Tea"
    };


    String[] itemprice = {
            "100",
            "200",
            "300",
            "250",
            "50",
            "60",
            "90",
            "125"
    };

    Integer[] imgid = {
            R.drawable.shakesh,
            R.drawable.shakesh,
            R.drawable.shakesh,
            R.drawable.shakesh,
            R.drawable.shakesh,
            R.drawable.shakesh,
            R.drawable.shakesh,
            R.drawable.shakesh,
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_list, container, false);

        CustomHotTeaAdapter adapter = new CustomHotTeaAdapter(getActivity(), itemname, itemprice, imgid);
        productList = (ListView) view.findViewById(R.id.listView);
        productList.setAdapter(adapter);

        productList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                String Slecteditem = itemname[+position];
                Toast.makeText(getActivity(), Slecteditem, Toast.LENGTH_SHORT).show();

            }
        });
        return view;
    }


}


