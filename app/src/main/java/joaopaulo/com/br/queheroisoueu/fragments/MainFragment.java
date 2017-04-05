package joaopaulo.com.br.queheroisoueu.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import joaopaulo.com.br.queheroisoueu.R;
import joaopaulo.com.br.queheroisoueu.activitys.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainFragment.MainFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment implements  View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters

    private Button botaoAcidente;
    private Button botaoMutacao;
    private Button botaoNasceu;
    private Button botaoEscolheu;


    private MainFragmentInteractionListener mListener;

    public MainFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);
        botaoAcidente = (Button) view.findViewById(R.id.buttonAcidente);
        botaoMutacao = (Button) view.findViewById(R.id.buttonMutacaoGenetica);
        botaoNasceu = (Button) view.findViewById(R.id.buttonNasceuComPoder);
        botaoEscolheu = (Button) view.findViewById(R.id.buttonEscolheuPoder);
        //
        botaoEscolheu.setEnabled(false);
        botaoEscolheu.getBackground().setAlpha(128);

        botaoAcidente.setOnClickListener(this);
        botaoMutacao.setOnClickListener(this);
        botaoNasceu.setOnClickListener(this);

        //
        botaoEscolheu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.loadEscolherPoderes();
            }
        });

        return view;
    }

    @Override
    public void onClick(View v) {
        Button btn = (Button) v;
        botaoEscolheu.setEnabled(true);
        botaoEscolheu.getBackground().setAlpha(255);
        //
        botaoAcidente.setCompoundDrawablesWithIntrinsicBounds(R.drawable.lightning,0,0,0);
        botaoMutacao.setCompoundDrawablesWithIntrinsicBounds(R.drawable.atomic,0,0,0);
        botaoNasceu.setCompoundDrawablesWithIntrinsicBounds(R.drawable.rocket,0,0,0);
        //
        int drawablebtnleft = 0;
        if (btn == botaoAcidente){
            drawablebtnleft = R.drawable.lightning;
        }else if(btn == botaoMutacao){
            drawablebtnleft = R.drawable.atomic;
        }else{
            drawablebtnleft = R.drawable.rocket;
        }
        btn.setCompoundDrawablesWithIntrinsicBounds(drawablebtnleft,0,R.drawable.item_selected,0);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onMainFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainFragmentInteractionListener) {
            mListener = (MainFragmentInteractionListener) context;
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


    public interface MainFragmentInteractionListener {
        // TODO: Update argument type and name
        void onMainFragmentInteraction(Uri uri);
    }
}
