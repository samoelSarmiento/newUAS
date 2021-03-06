package uas.pe.edu.pucp.newuas.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        SimpleDateFormat sdfDisplay = new SimpleDateFormat("dd MMM hh:mm a", new Locale("es", "ES"));
        try {
            Date when = sdf.parse(suggestion.getCreado());
            viewHolder.tvWhen.append(" " + sdfDisplay.format(when));
            Date update = sdf.parse(suggestion.getModificado());
            //si son diferentes
            if (!when.equals(update)) {
                Log.d("update", sdfDisplay.format(update));
                //tvEdit -> visible y updeteo
                viewHolder.tvEdit.setVisibility(View.VISIBLE);
                viewHolder.tvEdit.append(" " + sdfDisplay.format(update));
            }
            //si son iguales tvEdit se queda gone
        } catch (ParseException e) {
            e.printStackTrace();
        }


        return view;
    }

    private static class ViewHolder {
        TextView tvWhen, tvWho, tvTitle, tvDescription, tvEdit;
    }
}
