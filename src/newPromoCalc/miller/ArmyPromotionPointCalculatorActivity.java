package newPromoCalc.miller;

import newPromoCalc.miller.R;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

public class ArmyPromotionPointCalculatorActivity extends TabActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppRater.app_launched(this);
        setContentView(R.layout.main);

        Resources res = getResources(); // Resource object to get Drawables
        TabHost tabHost = getTabHost();  // The activity TabHost
        TabHost.TabSpec spec;  // Resusable TabSpec for each tab
        Intent intent;  // Reusable Intent for each tab

        // Create an Intent to launch an Activity for the tab (to be reused)
        intent = new Intent().setClass(this, E5CalculatorActivity.class);

        // Initialize a TabSpec for each tab and add it to the TabHost
        spec = tabHost.newTabSpec("sgt").setIndicator("To SGT",
                          res.getDrawable(R.drawable.e5_tab))
                      .setContent(intent);
        tabHost.addTab(spec);

        // Do the same for the other tabs
        intent = new Intent().setClass(this, E6CalculatorActivity.class);
        spec = tabHost.newTabSpec("ssg").setIndicator("To SSG",
                          res.getDrawable(R.drawable.e6_tab))
                      .setContent(intent);
        tabHost.addTab(spec);

        intent = new Intent().setClass(this, apftActivity.class);
        spec = tabHost.newTabSpec("apft").setIndicator("APFT",
                          res.getDrawable(R.drawable.apft_tab))
                      .setContent(intent);
        tabHost.addTab(spec);
        
        intent = new Intent().setClass(this, recentPointsActivity.class);
        spec = tabHost.newTabSpec("recent").setIndicator("Points",
                          res.getDrawable(R.drawable.recent_tab))
                      .setContent(intent);
        tabHost.addTab(spec);
        
        intent = new Intent().setClass(this, aboutActivity.class);
        spec = tabHost.newTabSpec("about").setIndicator("About",
                          res.getDrawable(R.drawable.about_tab))
                      .setContent(intent);
        tabHost.addTab(spec);

        tabHost.setCurrentTab(0);
    }
}