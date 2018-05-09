package com.bove.martin.toolbar.fragments;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.bove.martin.toolbar.R;
import com.bove.martin.toolbar.interfaces.Comunicacion;
import com.bove.martin.toolbar.model.Pais;
import com.bove.martin.toolbar.model.Persona;
import com.bove.martin.toolbar.utils.Utils;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FormFragment extends Fragment {
    private EditText editTextNombre;
    private Spinner spinnerPais;
    private Button buttonAgregar;
    private ArrayList<Pais> countryList;
    private Comunicacion callback;
    private Pais paisSelecionado;
    private InputMethodManager imm;

    public FormFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            callback = (Comunicacion) context;
        } catch (Exception e) {
            throw new ClassCastException(context.toString() + " Debes implementar Comunicacion.");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_form, container, false);

        editTextNombre = view.findViewById(R.id.editTextNombre);
        spinnerPais = view.findViewById(R.id.spinnerCountry);
        buttonAgregar = view.findViewById(R.id.buttonAgregar);

        countryList = Utils.getComboArry();

        //fill data in spinner
        ArrayAdapter<Pais> adapter = new ArrayAdapter<Pais>(view.getContext(), android.R.layout.simple_spinner_dropdown_item, countryList);
        spinnerPais.setAdapter(adapter);

        spinnerPais.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                imm.hideSoftInputFromWindow(container.getWindowToken(), 0);
                paisSelecionado = (Pais) parent.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        buttonAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!editTextNombre.getText().toString().isEmpty()){
                    //Hide the soft keyboard
                    imm.hideSoftInputFromWindow(container.getWindowToken(), 0);

                    editTextNombre.onEditorAction(EditorInfo.IME_ACTION_DONE);

                    Persona nuevaPersona = new Persona(editTextNombre.getText().toString(), paisSelecionado);
                    callback.enviarPersona(nuevaPersona);
                }
            }
        });

        //get the input method manager service
        imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);

        return view;
    }

    @Override
    public void onDetach() {
        callback = null;
        super.onDetach();
    }
}
