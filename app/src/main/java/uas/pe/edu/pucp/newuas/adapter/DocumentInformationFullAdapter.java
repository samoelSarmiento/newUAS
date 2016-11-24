package uas.pe.edu.pucp.newuas.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.model.DocumentStudentPsp;
import uas.pe.edu.pucp.newuas.model.InscriptionFilePSP;
/**
 * Created by jemarroquin on 21/11/2016.
 */
public class DocumentInformationFullAdapter extends BaseAdapter {
    ArrayList<DocumentStudentPsp> items;
    Context context;
    LayoutInflater layoutInflater;
     public static DocumentStudentPsp documento  = new DocumentStudentPsp();
    public DocumentInformationFullAdapter(Context context ,  ArrayList<DocumentStudentPsp> items ) {
        this.context = context;
        this.items = items;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.fragment_psp_items_documentfull_view,null);
        ViewHolder viewHolder = new ViewHolder(view);

        viewHolder.nombreDocumento.setText(items.get(position).getTituloPlantilla() ) ;

        if( items.get(position).getEsObligatorio().compareTo("s") == 0)
        viewHolder.esObligatorio.setText("Si") ; else
           viewHolder.esObligatorio.setText("No") ;

        viewHolder.fechaLimite.setText(items.get(position).getFechaLimite() ) ;

        if( items.get(position).getRuta().isEmpty() )
            viewHolder.docEntregado.setText("No se ha entregado el documento" ) ;
        else
            viewHolder.docEntregado.setText("Si" ) ;


        if( items.get(position).getObservaciones().isEmpty() )
            viewHolder.observaciones.setText("No hay observaciones" ) ;
        else
            viewHolder.observaciones.setText(items.get(position).getObservaciones() ) ;


        documento.setRuta( items.get(position).getRuta() );

        return view;
    }
    public static class ViewHolder{
        TextView nombreDocumento, esObligatorio, fechaLimite , docEntregado , observaciones;
        public ViewHolder(View view) {
            nombreDocumento = (TextView)view.findViewById(R.id.pspNombreDocumentoFullValor);
            esObligatorio= (TextView)view.findViewById(R.id.psp_esObligatorioValor);
           fechaLimite=  (TextView)view.findViewById(R.id.psp_fechaLimitedocValor);
            docEntregado=  (TextView)view.findViewById(R.id.psp_documentoEntregadoValor);
            observaciones=  (TextView)view.findViewById(R.id.psp_observacionesDocValor);
        }
    }
}
