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
import uas.pe.edu.pucp.newuas.model.InscriptionFilePSP;


/**
 * Created by jemarroquin on 01/11/2016.
 */
public class PSPInscriptionFilesItemsAdapter extends BaseAdapter {

    ArrayList<InscriptionFilePSP> items;
    Context context;
    LayoutInflater layoutInflater;
   public static InscriptionFilePSP inscripcion  = new InscriptionFilePSP();


    public PSPInscriptionFilesItemsAdapter(Context context ,  ArrayList<InscriptionFilePSP> items ) {
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
        View view = layoutInflater.inflate(R.layout.fragment_psp_items_inscriptionfile_view,null);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.jefeDirecto.setText(items.get(position).getJefeDirectoAux() ) ;
        viewHolder.telefonoJefeDirecto.setText(items.get(position).getTelefJefeDirecto() ) ;
        viewHolder.direccionEmpresa.setText(items.get(position).getDireccionEmpresa() ) ;
        viewHolder.nombreArea.setText(items.get(position).getNombreArea() ) ;
        viewHolder.puesto.setText(items.get(position).getPuesto() ) ;
        viewHolder.razonsocial.setText(items.get(position).getRazonSocial() ) ;
        viewHolder.ubicacionArea.setText(items.get(position).getUbicacionArea() ) ;
        viewHolder.actividadEconomica.setText(items.get(position).getActividadEconomica() ) ;
        viewHolder.fechatermino.setText(items.get(position).getFechaTermino() ) ;
        viewHolder.fechaInicio.setText(items.get(position).getFechaInicio() ) ;


        inscripcion.setId(  items.get(0).getId() );
        inscripcion.setJefeDirectoAux(     items.get(0).getJefeDirectoAux()   );
        inscripcion.setTelefJefeDirecto(       items.get(0).getTelefJefeDirecto()  );
        inscripcion.setRecomendaciones( items.get(0).getRecomendaciones());




        return view;

    }
    public static class ViewHolder{
        TextView jefeDirecto, telefonoJefeDirecto , direccionEmpresa , nombreArea , puesto , razonsocial, ubicacionArea , actividadEconomica, fechaInicio, fechatermino;
        public ViewHolder(View view) {
            jefeDirecto = (TextView)view.findViewById(R.id.pspJefeDirectoValor);
            telefonoJefeDirecto= (TextView)view.findViewById(R.id.pspTelefonoJefeDirectoValor);
            direccionEmpresa = (TextView)view.findViewById(R.id.pspDireccionEmpresaValor);
            nombreArea = (TextView)view.findViewById(R.id.pspNombreDelAreaValor);
            puesto = (TextView)view.findViewById(R.id.pspPuestoValor);
            razonsocial = (TextView)view.findViewById(R.id.pspRazonSocialValor);
            ubicacionArea = (TextView)view.findViewById(R.id.pspUbicacionAreaValor);
            actividadEconomica = (TextView)view.findViewById(R.id.pspActividadEconomicaValor);
            fechaInicio= (TextView)view.findViewById(R.id.pspFechaInicioValor);
            fechatermino= (TextView)view.findViewById(R.id.pspFechaTerminoValor);


        }
    }
}
