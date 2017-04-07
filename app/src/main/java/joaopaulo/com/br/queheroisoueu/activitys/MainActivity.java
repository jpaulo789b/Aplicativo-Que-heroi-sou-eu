package joaopaulo.com.br.queheroisoueu.activitys;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import joaopaulo.com.br.queheroisoueu.R;
import joaopaulo.com.br.queheroisoueu.fragments.EscolherPoderFragment;
import joaopaulo.com.br.queheroisoueu.fragments.HistoriaFragment;
import joaopaulo.com.br.queheroisoueu.fragments.MainFragment;
import joaopaulo.com.br.queheroisoueu.historias.Historias;

public class MainActivity extends AppCompatActivity implements MainFragment.MainFragmentInteractionListener, EscolherPoderFragment.EscolherPoderesInteractListerner, HistoriaFragment.OnFragmentInteractionListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = this.getSupportFragmentManager();
        Fragment fragmento = manager.findFragmentById(R.id.frameImport);
        if (fragmento == null){
            fragmento = new MainFragment();
            manager.beginTransaction().add(R.id.frameImport,fragmento).commit();
        }

    }
    public void loadTelaIncial(){
        MainFragment mainFragment = new MainFragment();
        this.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameImport, mainFragment).commit();
    }
    public void loadEscolherPoderes(){
        EscolherPoderFragment escolherPoderFragment = new EscolherPoderFragment();
        this.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameImport, escolherPoderFragment)
                .addToBackStack(null).commit();
    }
    public void  loadMostrarHistoria(int i){
        Historias h = new Historias();

        HistoriaFragment historiaFragment = new HistoriaFragment();
        historiaFragment.setHistoria(h.retornaHistoria(i));
        this.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameImport, historiaFragment)
                .addToBackStack(null).commit();

    }

    @Override
    public void onMainFragmentInteraction(Uri uri) {

    }

    @Override
    public void onEscolherPoderesFragmentInteraction(Uri uri) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
