package com.bove.martin.toolbar.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bove.martin.toolbar.R;
import com.bove.martin.toolbar.model.Persona;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Martín Bove on 04/05/2018.
 * E-mail: mbove77@gmail.com
 */
public class ListViewAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<Persona> personas;

    public ListViewAdapter(Context context, int layout, ArrayList<Persona> personas) {
        this.context = context;
        this.layout = layout;
        this.personas = personas;
    }

    @Override
    public int getCount() {
        return personas.size();
    }

    @Override
    public Object getItem(int position) {
        return personas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //View Holder Pattern
        ViewHolder viewHolder;

        if(convertView == null) {
            // Inflamos la vista
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(this.layout, null);

            viewHolder = new ViewHolder();
            // Guardamos la referencia de los elementos en el viewHolder
            viewHolder.textViewNombre = convertView.findViewById(R.id.textViewNombre);
            viewHolder.textViewPais = convertView.findViewById(R.id.textViewPais);
            viewHolder.imageViewPais = convertView.findViewById(R.id.imageViewCountry);

            // Guardamos el viewHolder en el convertView
            convertView.setTag(viewHolder);

        } else {
            // Recuperamos el viewHolder ya cargado
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Cargamos el objeto actual
        final Persona personaActual = (Persona) getItem(position);

        // Completamos los elementos de la ui con datos
        viewHolder.textViewNombre.setText(personaActual.getNombre());
        viewHolder.textViewPais.setText(personaActual.getPais().getNombre());

        String urlImagen = "http://www.geognos.com/api/en/countries/flag/"+ personaActual.getPais().getCodigoPais() +".png";
        Picasso.get().load(urlImagen).fit().into(viewHolder.imageViewPais);

        return convertView;
    }

    // Creamos el ViewHolder
    static  class ViewHolder {
        private TextView textViewNombre;
        private TextView textViewPais;
        private ImageView imageViewPais;
    }
}
