package com.example.projecthomescreenpreview;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CharityDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CharityDetailsFragment extends Fragment {
    Button button_Charity1;
    Button button_Charity2;
    Button button_Back2Shop;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CharityDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CharityDetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CharityDetailsFragment newInstance(String param1, String param2) {
        CharityDetailsFragment fragment = new CharityDetailsFragment();
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
        View v = inflater.inflate(R.layout.fragment_charity_details, container, false);




        button_Charity1 = (Button) v.findViewById(R.id.button_Charity1);
        button_Charity2 = (Button) v.findViewById(R.id.button_Charity2);
        button_Back2Shop = (Button) v.findViewById(R.id.button_Back2Shop);

        button_Charity1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CharityInfoActivity) getActivity()).setViewPager(1);
            }
                });

        button_Charity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CharityInfoActivity) getActivity()).setViewPager(2);
            }
        });

        
        button_Back2Shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),ShopActivity.class);
                startActivity(intent);
                // ((CharityInfoActivity) getActivity()).setViewPager(0);
            }
        });

        return v;
        };

    }
