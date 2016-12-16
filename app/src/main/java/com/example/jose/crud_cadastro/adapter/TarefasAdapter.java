package com.example.jose.crud_cadastro.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.jose.crud_cadastro.R;
import com.example.jose.crud_cadastro.model.Tarefa;

import java.util.List;

/**
 * Created by Jose on 15/12/2016.
 */

public class TarefasAdapter extends BaseAdapter {

    private Context context;
    private List<Tarefa> lista;


    public TarefasAdapter(Context ctx, List<Tarefa> tarefa){
        this.context = ctx;
        this.lista = tarefa;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Tarefa tarefa = lista.get(position);

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.tarefas, null);
        }

        TextView lbNome = (TextView)view.findViewById(R.id.tarefaLista);
        lbNome.setText(tarefa.getTarefa());

        return view;
    }
}
