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
import kredivation.mrchai.adapter.CustomListAdapter;


public class IcedTeaFragmentFragment extends Fragment {
    ListView list;
    String[] itemname = {
            "Tea",
            "Water",
            "Shakes",
            "Hot Tea",
            "Cold Tea",
            "Chai",
            "Lamon Chai",
            "Tea"
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
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        CustomListAdapter adapter = new CustomListAdapter(getActivity(), itemname, imgid);
        list = (ListView) view.findViewById(R.id.listView);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

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

