package uas.pe.edu.pucp.newuas.model;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import uas.pe.edu.pucp.newuas.R;

/**
 * Created by Franz on 22/11/2016.
 */

public class MyToast {

    public static int errorAlert = 0;
    public static int checkAlert = 1;
    public static int infoAlert = 2;

    public static Toast makeText(Context context, String text, int time, int alert) {

        Activity activity = (Activity) context;
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = null;
        if (alert == checkAlert)
            view = inflater.inflate(R.layout.toast_layout_ok, (ViewGroup) activity.findViewById(R.id.toast_layout_root));
        else if (alert == errorAlert)
            view = inflater.inflate(R.layout.toast_layout_notok, (ViewGroup) activity.findViewById(R.id.toast_layout_root));
        else if (alert == infoAlert)
            view = inflater.inflate(R.layout.toast_layout_info, (ViewGroup) activity.findViewById(R.id.toast_layout_root));

        if (view != null) {
            TextView textView = (TextView) view.findViewById(R.id.text_toast);
            textView.setText(text);
        }

        Toast toast = new Toast(context);
        
        toast.setGravity(Gravity.BOTTOM, 0, 50);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(view);
        return toast;
    }
}
