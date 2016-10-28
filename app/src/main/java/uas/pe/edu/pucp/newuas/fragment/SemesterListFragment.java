package uas.pe.edu.pucp.newuas.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.adapter.MeasureInstrumentAdapter;
import uas.pe.edu.pucp.newuas.adapter.SemesterAdapter;
import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.controller.SpecialtyController;
import uas.pe.edu.pucp.newuas.model.MeasureInstrument;
import uas.pe.edu.pucp.newuas.model.Semester;

/**
 * Created by Marshall on 25/10/2016.
 */

public class SemesterListFragment extends Fragment {

    ListView lvSemesters;
    ArrayList<Semester> list;

    SemesterAdapter semAdapter;

    public SemesterListFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

        getActivity().setTitle("Semestres");

        View view = inflater.inflate(R.layout.fragment_semester_list, container, false);

        lvSemesters = (ListView) view.findViewById(R.id.lvSemester);

        /*

        TextView tvsplabel = (TextView) view.findViewById(R.id.tvSpecialtyLabel);
        TextView tvspcode = (TextView) view.findViewById(R.id.tvSpecialtyCode);
        TextView tvspcoord = (TextView) view.findViewById(R.id.tvSpecialtyCoord);
        TextView tvspdesc = (TextView) view.findViewById(R.id.tvSpecialtyDesc);

        */

        Bundle bundle = this.getArguments();
        if (bundle != null){

            ArrayList<Semester> str = (ArrayList<Semester>) bundle.getSerializable("Semesters");
            list = str;

            /*
            Gson gson = new Gson();
            JsonParser jp = new JsonParser();
            JsonArray json = jp.parse(str).getAsJsonArray();
            Log.d("TAG",json.getAsString());
            Context context = getActivity();
            */
            Context context = getActivity();
            semAdapter = new SemesterAdapter(context,list);
            lvSemesters.setAdapter(semAdapter);

            lvSemesters.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Semester sem = (Semester) semAdapter.getItem(position);

                    SpecialtyController sc= new SpecialtyController();
                    Context context = getActivity();

                    if (Configuration.LOGIN_USER.getUser().getIdPerfil() == 3){
                        sc.getCoursesxSpecialyxCycle(context, Configuration.SPECIALTY.getIdEspecialidad(),sem.getIdCicloAcademico());

                    }else{
                        sc.getCoursesxSpecialyxCycle(context, Configuration.LOGIN_USER.getUser().getAccreditor().getIdEspecialidad(),sem.getIdCicloAcademico());

                    }



                    /*
                    CoursesxSpecialtyFragment cxsf = new CoursesxSpecialtyFragment();


                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Course", sem);

                    cxsf.setArguments(bundle);
                    Context context = getActivity();

                    ((Activity)context).getFragmentManager().beginTransaction().addToBackStack(null).replace(R.id.fragment_container,cxsf).commit();
                    ((Activity)context).setTitle("Cursos");
                    */


                }
            });

            /*
            lvMeaInst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    MeasureInstrument mi = (MeasureInstrument) miAdapter.getItem(position);
                    Log.d("mi",mi.getIdEspecialidad()+ "");

                    MeasurePeriodViewFragment mpvFragment = new MeasurePeriodViewFragment();

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("Period", per);
                    mpvFragment.setArguments(bundle);

                    Context context = getActivity();

                    ((Activity)context).getFragmentManager().beginTransaction().replace(R.id.fragment_container,mpvFragment).commit();
                    ((Activity)context).setTitle("Periodo de Medicion");
                }
            }); */
            /*
            tvsplabel.setText(json.get("Nombre").getAsString());
            tvspcode.setText(json.get("Codigo").getAsString());
            JsonObject json2 = json.get("coordinator").getAsJsonObject();
            tvspcoord.setText(json2.get("Nombre").getAsString() + " " + json2.get("ApellidoPaterno").getAsString() + " " + json2.get("ApellidoMaterno").getAsString());
            tvspdesc.setText(json.get("Descripcion").getAsString());
            Log.d("TAG",json.get("Nombre").getAsString());
            //Log.d("TAG",json.getAsString());
            */
        }






        return view;

    }

    @Override
    public void onStart(){
        super.onStart();






    }
}
