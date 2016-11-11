package uas.pe.edu.pucp.newuas.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import uas.pe.edu.pucp.newuas.R;
import uas.pe.edu.pucp.newuas.configuration.Configuration;
import uas.pe.edu.pucp.newuas.controller.FileDownloadController;
import uas.pe.edu.pucp.newuas.controller.ImprovementPlanController;
import uas.pe.edu.pucp.newuas.model.ImprovementPlan;

/**
 * Created by Marshall on 2/11/2016.
 */

public class ImprovementPlanViewFragment extends Fragment {


    public ImprovementPlanViewFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getActivity().setTitle("Plan de Mejora");

        View view = inflater.inflate(R.layout.fragment_improvement_plan_view, container, false);

        TextView tvIpTitle = (TextView) view.findViewById(R.id.tvIpTitle);
        TextView tvIpType = (TextView) view.findViewById(R.id.tvIpType);
        TextView tvIpFound = (TextView) view.findViewById(R.id.tvIpFound);
        TextView tvIpCause = (TextView) view.findViewById(R.id.tvIpCause);
        TextView tvIpResp = (TextView) view.findViewById(R.id.tvIpResp);
        TextView tvIpDate = (TextView) view.findViewById(R.id.tvIpDate);
        TextView tvIpStatus = (TextView) view.findViewById(R.id.tvIpStatus);

        Button btActions = (Button) view.findViewById(R.id.btnActions);
        Button btSugg = (Button) view.findViewById(R.id.btnSug);
        Button btDownload = (Button) view.findViewById(R.id.btnDownloadFile);
        Bundle bundle = this.getArguments();

        if (bundle != null) {
            final ImprovementPlan ip = (ImprovementPlan) bundle.getSerializable("IPlan");

            tvIpTitle.setText(ip.getDescripcion());
            tvIpType.setText(ip.getImprovementPlanType().getCodigo() + " " + ip.getImprovementPlanType().getDescripcion());
            tvIpFound.setText(ip.getHallazgo());
            tvIpCause.setText(ip.getAnalisisCausal());
            if (ip.getTeacher() != null)
                tvIpResp.setText(ip.getTeacher().getNombre() + " " + ip.getTeacher().getApellidoPaterno() + " " + ip.getTeacher().getApellidoMaterno());

            tvIpDate.setText(ip.getFechaImplementacion());
            tvIpStatus.setText(ip.getEstado());

            btActions.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ImprovementPlanController ipc = new ImprovementPlanController();
                    ipc.getActionsOfImprovementPlan(getActivity(), ip.getIdPlanMejora());
                }
            });

            btSugg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ImprovementPlanController controller = new ImprovementPlanController();
                    controller.getImprovementPlanSuggestions(getActivity(), ip.getIdPlanMejora());
                }
            });

            if (ip.getIdArchivoEntrada() != null){

                btDownload.setEnabled(true);

                btDownload.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        FileDownloadController fdc = new FileDownloadController();
                        fdc.downloadFile(getActivity(), Configuration.FILE_URL +  ip.getFile().getFilename() );
                    }
                });

            }else{
                btDownload.setEnabled(false);

            }








        }

        return view;

    }

    @Override
    public void onStart() {
        super.onStart();
    }
}
