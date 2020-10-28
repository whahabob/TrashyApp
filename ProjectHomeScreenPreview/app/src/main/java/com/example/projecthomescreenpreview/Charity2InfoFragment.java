package com.example.projecthomescreenpreview;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Charity2InfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Charity2InfoFragment extends Fragment {
    Button Button_Charity2Back;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String TAG ="Charity1InfoFragment";
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Charity2InfoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Charity2InfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Charity2InfoFragment newInstance(String param1, String param2) {
        Charity2InfoFragment fragment = new Charity2InfoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_charity2_info, container, false);
        View v = inflater.inflate(R.layout.fragment_charity2_info, container, false);

        Button_Charity2Back = (Button) v.findViewById(R.id.Button_Charity2Back);
        Button_Charity2Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getActivity(), "Going to Charity List", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), CharityInfoActivity.class);
                startActivity(intent);
                //can navigate to next fragment
            }
        });
        return v;
    }
}