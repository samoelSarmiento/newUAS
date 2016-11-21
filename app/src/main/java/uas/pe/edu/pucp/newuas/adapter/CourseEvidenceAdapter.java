package uas.pe.edu.pucp.newuas.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.controller.FileDownloadController;
import uas.pe.edu.pucp.newuas.model.CoursesEvidences;
import uas.pe.edu.pucp.newuas.model.FileGen;

/**
 * Created by samoe on 21/11/2016.
 */

public class CourseEvidenceAdapter extends BaseAdapter {
    List<FileGen> items;
    LayoutInflater layoutInflater;
    Context context;

    public CourseEvidenceAdapter(List<FileGen> items, Context context) {
        this.items = items;
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public FileGen getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.item_course_evidence, null);
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.tvFileName = (TextView) view.findViewById(R.id.tvEvidence);
        viewHolder.btDownload = (Button) view.findViewById(R.id.btDownload);
        final FileGen evidences = items.get(position);
        viewHolder.tvFileName.setText(evidences.getFile_name());
        viewHolder.btDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileDownloadController.downloadFile(context, evidences.getFile_url());
            }
        });
        return view;
    }

    private static class ViewHolder {
        TextView tvFileName;
        Button btDownload;
    }
}
