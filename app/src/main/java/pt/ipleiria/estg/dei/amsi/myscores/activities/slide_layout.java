package pt.ipleiria.estg.dei.amsi.myscores.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;

import pt.ipleiria.estg.dei.amsi.myscores.R;
import pt.ipleiria.estg.dei.amsi.myscores.singletonClasses.SingletonBD;
import pt.ipleiria.estg.dei.amsi.myscores.singletonClasses.SingletonJogos;
import pt.ipleiria.estg.dei.amsi.myscores.fragments.fragmentCiriarEquipaA;
import pt.ipleiria.estg.dei.amsi.myscores.fragments.fragmentCriarDetalhesJogo;
import pt.ipleiria.estg.dei.amsi.myscores.fragments.fragmentCriarEquipaB;

public class slide_layout extends AppCompatActivity {

    //The number of pages (wizard steps) to show in this demo.
    private static final int NUM_PAGES = 3;

    //The pager widget, which handles animation and allows swiping horizontally to access previous
    //and next wizard steps.
    private ViewPager mPager;

    //The pager adapter, which provides the pages to the view pager widget.
    private PagerAdapter mPagerAdapter;

    LinearLayout sliderDotspanel;
    private int dotscount;
    private ImageView[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_layout);

        //LocalBaseDados localBaseDados = new LocalBaseDados(this);

        SingletonBD.iniciarBD(this);

        //adicionar uso de base de dados

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new SlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

        sliderDotspanel = (LinearLayout) findViewById(R.id.dots);
        dotscount = mPagerAdapter.getCount();
        dots = new ImageView[dotscount];

        for(int i = 0; i < dotscount; i++) {

            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            sliderDotspanel.addView(dots[i], params);
        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));
        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for(int i = 0; i< dotscount; i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));
                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    public void onBackPressed(){
        if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    public class SlidePagerAdapter extends FragmentStatePagerAdapter {

        public SlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {

                case 0:
                    return new fragmentCiriarEquipaA();

                case 1:
                    return new fragmentCriarEquipaB();

                case 2:
                    return new fragmentCriarDetalhesJogo();

                default:
                    return null;
            }
        }

        @Override
        public int getCount() {

            return NUM_PAGES;
        }
    }

}
