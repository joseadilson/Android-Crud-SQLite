package com.example.jose.crud_cadastro.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

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
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
