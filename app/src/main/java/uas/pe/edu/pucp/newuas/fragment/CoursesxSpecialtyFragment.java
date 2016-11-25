package uas.pe.edu.pucp.newuas.fragment;

import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.adapter.SpecialtyxCoursesAdapter;
import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.model.CourseResponse;
import uas.pe.edu.pucp.newuas.view.NavigationDrawerAcreditacion;

public class CoursesxSpecialtyFragment extends Fragment implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {

    ArrayList<CourseResponse> list;
    SpecialtyxCoursesAdapter adapter;
    Spinner spnNivel;
    ArrayAdapter<String> spnAdapter;
    int idCicloAcademico = 0;

    public CoursesxSpecialtyFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("Cursos de la Especialidad");

        View view = inflater.inflate(R.layout.fragment_courses_x_specialty, container, false);
        ListView coursesxspecialty = (ListView) view.findViewById(R.id.lvCourses);
        coursesxspecialty.setOnItemClickListener(this);
        //la informacion de la lista a mostrar
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            idCicloAcademico = bundle.getInt("cicloAcademico");
            list = (ArrayList<CourseResponse>) bundle.getSerializable("CourseList");
            spnNivel = (Spinner) view.findViewById(R.id.spinnerNivel);
            if (list != null && !list.isEmpty()) {
                spnNivel.setOnItemSelectedListener(this);
                Set<String> niveles = retornarNiveles(list);
                String[] sniveles = niveles.toArray(new String[niveles.size()]);
                spnAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, sniveles);
                spnNivel.setAdapter(spnAdapter);
                Configuration.CXE_ITEM_SHOW = Integer.parseInt(sniveles[0]);
                Context context = getActivity();
                adapter = new SpecialtyxCoursesAdapter(context, list);
                coursesxspecialty.setAdapter(adapter);
            } else {
                TextView tvNoCourses = (TextView) view.findViewById(R.id.tvNoCourses);
                TextView tvNivel = (TextView) view.findViewById(R.id.tvNivel);
                tvNivel.setVisibility(View.GONE);
                tvNoCourses.setVisibility(View.VISIBLE);
                spnNivel.setVisibility(View.GONE);
                coursesxspecialty.setVisibility(View.GONE);
            }
        }
        return view;
    }

    private Set<String> retornarNiveles(ArrayList<CourseResponse> list) {
        Set<String> niveles = new TreeSet<String>(new Comparator<String>() {
            public int compare(String a, String b) {
                return Integer.valueOf(a).compareTo(Integer.valueOf(b));
            }
        });
        for (CourseResponse course : list) {
            niveles.add("" + course.getNivelAcademico());
        }
        return niveles;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    //Para el spinner cambia el list view
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String value = spnNivel.getItemAtPosition(position).toString();
        Configuration.CXE_ITEM_SHOW = Integer.parseInt(value);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    //Cuando se apreta un item del list view manda a otro fragment
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        CourseResponse courseResponse = list.get(position);
        Bundle bundle = new Bundle();
        bundle.putSerializable("Course", courseResponse);
        bundle.putInt("cicloAcademico", idCicloAcademico);
        //crear fragment
        CourseFragment courseFragment = new CourseFragment();
        courseFragment.setArguments(bundle);
        getActivity().getFragmentManager()
                .beginTransaction()
                .addToBackStack(null)
                .replace(R.id.fragment_container, courseFragment)
                .commit();
        getActivity().setTitle(courseResponse.getNombre());
    }
}
