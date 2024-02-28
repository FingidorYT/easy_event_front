package com.example.easy_event_app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeEmpresarioFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeEmpresarioFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TextView nombre_empresa;
    private CardView alquilerS;
    private CardView alquilerE;
    private TextView solicitudAlq;
    private TextView dirEMP;
    private TextView nomEmp;
    private TextView telEmp;

    private TextView corrEmp;
    private TextView estadoEmp;



    public HomeEmpresarioFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeEmpresarioFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeEmpresarioFragment newInstance(String param1, String param2) {
        HomeEmpresarioFragment fragment = new HomeEmpresarioFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }



    }

    @Override
    public void onStart() {
        nombre_empresa = getActivity().findViewById(R.id.nombre_empresa);
        nombre_empresa.setText(Datainfo.resultLogin.getEmpresa().getNombre_empresa());

        alquilerS = getActivity().findViewById(R.id.alquiler1);
        alquilerE = getActivity().findViewById(R.id.alquiler2);


        alquilerS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent solicitudes = new Intent(getActivity(), SolicitudAlquileres.class);
                startActivity(solicitudes);
            }
        });

        alquilerE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent entregados = new Intent(getActivity(), EntregadosAlquileres.class);
                startActivity(entregados);
            }
        });

        /*nitEmp = getActivity().findViewById(R.id.nitEmp);
        nitEmp.setText(Datainfo.resultLogin.getEmpresa().getNit_empresa().toString());
        dirEMP = getActivity().findViewById(R.id.direEmp);
        dirEMP.setText(Datainfo.resultLogin.getEmpresa().getDireccion_empresa());
        nombre_empresa = getActivity().findViewById(R.id.nomEmp);
        nombre_empresa.setText(Datainfo.resultLogin.getEmpresa().getNombre_empresa());
        telEmp = getActivity().findViewById(R.id.telEmp);
        telEmp.setText(Datainfo.resultLogin.getEmpresa().getTelefono_empresa().toString());
        corrEmp = getActivity().findViewById(R.id.corrEmp);
        corrEmp.setText(Datainfo.resultLogin.getEmpresa().getEmail_empresa());
        estadoEmp = getActivity().findViewById(R.id.estadoEmp);
        estadoEmp.setText(Datainfo.resultLogin.getEmpresa().getEstado());*/
        super.onStart();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home_empresario, container, false);

        CardView palquiler = view.findViewById(R.id.alquiler1);

        palquiler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        return view;
    }


}