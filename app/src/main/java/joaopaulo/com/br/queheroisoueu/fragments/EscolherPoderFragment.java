package joaopaulo.com.br.queheroisoueu.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import joaopaulo.com.br.queheroisoueu.R;
import joaopaulo.com.br.queheroisoueu.activitys.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link EscolherPoderFragment.EscolherPoderesInteractListerner} interface
 * to handle interaction events.
 * Use the {@link EscolherPoderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EscolherPoderFragment extends Fragment  implements  View.OnClickListener {


    private EscolherPoderesInteractListerner mListener;
    private Button buttonPoderTartaruga;
    private Button buttonPoderRaios;
    private Button buttonPoderVoo;
    private Button buttonPoderAtiraTeias;
    private Button buttonVisaoDeCalor;
    private Button buttonPoderSuperForca;
    private Button buttonEscolheuPoder;
    private int poderEscolhido;

    public EscolherPoderFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static EscolherPoderFragment newInstance(String param1, String param2) {
        EscolherPoderFragment fragment = new EscolherPoderFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_escolher_poder, container, false);

        buttonPoderRaios = (Button) view.findViewById(R.id.buttonPoderRaios);
        buttonPoderRaios.setOnClickListener(this);

        buttonPoderTartaruga = (Button) view.findViewById(R.id.buttonPoderTartaruga);
        buttonPoderTartaruga.setOnClickListener(this);

        buttonPoderVoo = (Button) view.findViewById(R.id.buttonPoderVoo);
        buttonPoderVoo.setOnClickListener(this);

        buttonPoderAtiraTeias = (Button) view.findViewById(R.id.buttonPoderAtiraTeias);
        buttonPoderAtiraTeias.setOnClickListener(this);

        buttonVisaoDeCalor = (Button) view.findViewById(R.id.buttonVisaoDeCalor);
        buttonVisaoDeCalor.setOnClickListener(this);

        buttonPoderSuperForca = (Button) view.findViewById(R.id.buttonPoderSuperForca);
        buttonPoderSuperForca.setOnClickListener(this);

        buttonEscolheuPoder = (Button) view.findViewById(R.id.buttonEscolheuPoder);
        buttonEscolheuPoder.setEnabled(false);
        buttonEscolheuPoder.getBackground().setAlpha(128);
        buttonEscolheuPoder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.loadMostrarHistoria(poderEscolhido);
            }
        });
        return view;
    }
    @Override
    public void onClick(View v) {
        Button btn = (Button) v;
        buttonEscolheuPoder.setEnabled(true);
        buttonEscolheuPoder.getBackground().setAlpha(255);
//        setCompoundDrawablesWithIntrinsicBounds
        buttonPoderTartaruga.setCompoundDrawablesWithIntrinsicBounds(R.drawable.turtle_power,0,0,0);
        buttonPoderRaios.setCompoundDrawablesWithIntrinsicBounds(R.drawable.thors_hammer,0,0,0);
        buttonPoderVoo.setCompoundDrawablesWithIntrinsicBounds(R.drawable.super_man_crest,0,0,0);
        buttonPoderAtiraTeias.setCompoundDrawablesWithIntrinsicBounds(R.drawable.spider_web,0,0,0);
        buttonVisaoDeCalor.setCompoundDrawablesWithIntrinsicBounds(R.drawable.laser_vision,0,0,0);
        buttonPoderSuperForca.setCompoundDrawablesWithIntrinsicBounds(R.drawable.super_strength,0,0,0);

        int drawablebtnleft = 0;

        if (btn == buttonPoderTartaruga){drawablebtnleft = R.drawable.turtle_power;poderEscolhido = 5;};
        if (btn == buttonPoderRaios){drawablebtnleft = R.drawable.thors_hammer;poderEscolhido = 1;};
        if (btn == buttonPoderVoo){drawablebtnleft = R.drawable.super_man_crest;poderEscolhido = 2;};
        if (btn == buttonPoderAtiraTeias){drawablebtnleft = R.drawable.spider_web;poderEscolhido = 3;};
        if (btn == buttonVisaoDeCalor){drawablebtnleft = R.drawable.laser_vision;poderEscolhido = 4;};
        if (btn == buttonPoderSuperForca){drawablebtnleft = R.drawable.super_strength;poderEscolhido = 0;};

        btn.setCompoundDrawablesWithIntrinsicBounds(drawablebtnleft,0,R.drawable.item_selected,0);


    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onEscolherPoderesFragmentInteraction(uri);
        }
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof EscolherPoderesInteractListerner) {
            mListener = (EscolherPoderesInteractListerner) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface EscolherPoderesInteractListerner {
        // TODO: Update argument type and name
        void onEscolherPoderesFragmentInteraction(Uri uri);
    }
}
