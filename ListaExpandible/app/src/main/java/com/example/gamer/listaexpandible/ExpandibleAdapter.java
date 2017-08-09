package com.example.gamer.listaexpandible;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Gamer on 09/08/2017.
 */

public class ExpandibleAdapter extends BaseExpandableListAdapter {
    private ArrayList<String> categoria;
    private Map<String , ArrayList<String>> mapchildren;// aca se almacena la categoria y los hijos(el contenido de la lista principal) que se va a desplegar
    private Context contexto;

    public ExpandibleAdapter(ArrayList<String> categoria, Map<String, ArrayList<String>> mapchildren, Context contexto) {
        this.categoria = categoria;
        this.mapchildren = mapchildren;
        this.contexto = contexto;
    }

    @Override
    //xtodo lo que se vea con grup hace referencia ala categoria es decir la parte celeste y los child al contenido de la lista (loque se despliega)
    public int getGroupCount() {
        return categoria.size(); // obtener cuantos grups tenemos
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mapchildren.get(categoria.get(groupPosition)).size();//obtenemos cuantos hijos tiene cada categoria(lo que se despliega)
    }

    @Override
    public Object getGroup(int groupPosition) {
        return categoria.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mapchildren.get(categoria.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override //aqui se implementan las vistas
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String titulocategoria=(String)getGroup(groupPosition);
        convertView = LayoutInflater.from(contexto).inflate(R.layout.lista_grupos_principales,null);
        TextView tvgroup= (TextView) convertView.findViewById(R.id.texto_lista_principal);
        tvgroup.setText(titulocategoria);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
      String item = (String)getChild(groupPosition,childPosition);
        convertView= LayoutInflater.from(contexto).inflate(R.layout.contenido_lista_principal,null);
        TextView tvchild= (TextView)convertView.findViewById(R.id.texto_contido);
        tvchild.setText(item);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
