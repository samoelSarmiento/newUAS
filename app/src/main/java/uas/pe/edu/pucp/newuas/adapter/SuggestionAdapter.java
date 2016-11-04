package uas.pe.edu.pucp.newuas.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.model.Aspect;
import uas.pe.edu.pucp.newuas.model.Suggestion;

/**
 * Created by samoe on 04/11/2016.
 */

public class SuggestionAdapter extends BaseAdapter {
    List<Suggestion> items;
    Context context;
    LayoutInflater layoutInflater;

    public SuggestionAdapter(Context context, List<Suggestion> items) {
        this.context = context;
        this.items = items;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Suggestion getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.item_suggestion, null);
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.tvWhen = (TextView) view.findViewById(R.id.tvWhen);
        viewHolder.tvWho = (TextView) view.findViewById(R.id.tvWho);
        viewHolder.tvTitle = (TextView) view.findViewById(R.id.tvTitle);
        viewHolder.tvDescription = (TextView) view.findViewById(R.id.tvDescription);
        viewHolder.tvEdit = (TextView) view.findViewById(R.id.tvEdit);

        Suggestion suggestion = items.get(position);
        viewHolder.tvWho.append(" " + suggestion.getNombre());
        viewHolder.tvTitle.append(" " + suggestion.getTitulo());
        viewHolder.tvDescription.append(" " + suggestion.getDescripcion());



        //parsear fecha de creacion y modificacion
        //si son diferentes
        //tvEdit -> visible y updeteo
        //si son iguales tvEdit se queda gone
        return view;
    }

    private static class ViewHolder {
        TextView tvWhen, tvWho, tvTitle, tvDescription, tvEdit;
    }
}
