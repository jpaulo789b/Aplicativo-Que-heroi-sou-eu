package joaopaulo.com.br.queheroisoueu.activitys;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import joaopaulo.com.br.queheroisoueu.R;
import joaopaulo.com.br.queheroisoueu.fragments.EscolherPoderesFragment;
import joaopaulo.com.br.queheroisoueu.fragments.MainFragment;

public class MainActivity extends AppCompatActivity implements MainFragment.MainFragmentInteractionListener, EscolherPoderesFragment.EscolherPoderesInteractListerner{



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
    public void loadEscolherPoderes(){
        EscolherPoderesFragment escolherPoderesFragment = new EscolherPoderesFragment();
        this.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameImport, escolherPoderesFragment)
                .addToBackStack(null).commit();
    }

    @Override
    public void onMainFragmentInteraction(Uri uri) {

    }

    @Override
    public void onEscolherPoderesFragmentInteraction(Uri uri) {

    }
}
