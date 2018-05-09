package com.bove.martin.toolbar.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.bove.martin.toolbar.R;
import com.bove.martin.toolbar.adapters.ListViewAdapter;
import com.bove.martin.toolbar.model.Persona;
import com.bove.martin.toolbar.utils.Utils;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {
    private ListView listView;
    private ListViewAdapter adapter;
    private ArrayList<Persona> personas;

    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        listView = view.findViewById(R.id.listView);
        personas = Utils.getPersonas();
        adapter = new ListViewAdapter(view.getContext(), R.layout.list_item, personas);
        listView.setAdapter(adapter);

        return view;
    }

    public void updateAdapter() {
        adapter.notifyDataSetChanged();
    }

}
