package uas.pe.edu.pucp.newuas.model;

import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Formatter;

import uas.pe.edu.pucp.newuas.R;

/**
 * Created by Franz on 21/10/2016.
 */

public class DocViewHolder {
    private TextView tvNameDocument, tvFormatDocument, tvCreationDocument, tvAuthorDocument;


    public void buildView(View inflater, ArrayList lista, int position) {

        tvNameDocument = (TextView) inflater.findViewById(R.id.tv_name_document);
        tvFormatDocument = (TextView)  inflater.findViewById(R.id.tv_format_document);
        tvCreationDocument = (TextView)  inflater.findViewById(R.id.tv_creation_document);
        tvAuthorDocument = (TextView)  inflater.findViewById(R.id.tv_author_document);

        PSPDocument document =(PSPDocument) lista.get(position);

        this.tvNameDocument.setText(document.getName());
        this.tvAuthorDocument.setText(document.getAuthor());
        this.tvFormatDocument.setText(document.getFormat());
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        this.tvCreationDocument.setText(formatter.format(document.getDate()));



    }
}
