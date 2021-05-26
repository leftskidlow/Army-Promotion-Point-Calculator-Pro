package newPromoCalc.miller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import newPromoCalc.miller.R;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

public class recentPointsActivity extends Activity {
	
	
	
	private int formSelect;
	private int rankSelection;
	private int userPoints;
	//public static int[] primY;
	//public static int[] secY;
	
	private String mos1 = "09L";
    private String mos2 = "11B";
    private String mos3 = "11C";
    private String mos4 = "12B";
    private String mos5 = "12C";
    private String mos6 = "12D";
    private String mos7 = "12H";
    private String mos8 = "12K";
    private String mos9 = "12M";
    private String mos10 = "12N";
    private String mos11 = "12P";
    private String mos12 = "12R";
    private String mos13 = "12T";
    private String mos14 = "12V";
    private String mos15 = "12W";
    private String mos16 = "12Y";
    private String mos17 = "13B";
    private String mos18 = "13D";
    private String mos19 = "13F";
    private String mos20 = "13M";
    private String mos21 = "13P";
    private String mos22 = "13R";
    private String mos23 = "13T";
    private String mos24 = "14E";
    private String mos25 = "14G";
    private String mos26 = "14H";
    private String mos27 = "14S";
    private String mos28 = "14T";
    private String mos29 = "15B";
    private String mos30 = "15D";
    private String mos31 = "15E";
    private String mos32 = "15F";
    private String mos33 = "15G";
    private String mos34 = "15H";
    private String mos35 = "15J";
    private String mos36 = "15N";
    private String mos37 = "15P";
    private String mos38 = "15Q";
    private String mos39 = "15R";
    private String mos40 = "15S";
    private String mos41 = "15T";
    private String mos42 = "15U";
    private String mos43 = "15W";
    private String mos44 = "15Y";
    private String mos45 = "18B";
    private String mos46 = "18C";
    private String mos47 = "18D";
    private String mos48 = "18E";
    private String mos49 = "19D";
    private String mos50 = "19K";
    private String mos51 = "25B";
    private String mos52 = "25C";
    private String mos53 = "25E";
    private String mos54 = "25F";
    private String mos55 = "25L";
    private String mos56 = "25M";
    private String mos57 = "25N";
    private String mos58 = "25P";
    private String mos59 = "25Q";
    private String mos60 = "25R";
    private String mos61 = "25S";
    private String mos62 = "25U";
    private String mos63 = "25V";
    private String mos64 = "27D";
    private String mos65 = "29E";
    private String mos66 = "31B";
    private String mos67 = "31D";
    private String mos68 = "31E";
    private String mos69 = "35F";
    private String mos70 = "35G";
    private String mos71 = "35L";
    private String mos72 = "35M";
    private String mos73 = "35N";
    private String mos74 = "35P";
    private String mos75 = "35PAD";
    private String mos76 = "35PAE";
    private String mos77 = "35PAN";
    private String mos78 = "35PAP";
    private String mos79 = "35PAZ";
    private String mos80 = "35PCM";
    private String mos81 = "35PDG";
    private String mos82 = "35PFR";
    private String mos83 = "35PKP";
    private String mos84 = "35PPF";
    private String mos85 = "35PPU";
    private String mos86 = "35PPV";
    private String mos87 = "35PPW";
    private String mos88 = "35PRU";
    private String mos89 = "35Q";
    private String mos90 = "35S";
    private String mos91 = "35T";
    private String mos92 = "36B";
    private String mos93 = "37F";
    private String mos94 = "38B";
    private String mos95 = "42A";
    private String mos96 = "42R";
    private String mos97 = "46Q";
    private String mos98 = "46R";
    private String mos99 = "51C";
    private String mos100 = "56M";
    private String mos101 = "68A";
    private String mos102 = "68D";
    private String mos103 = "68E";
    private String mos104 = "68G";
    private String mos105 = "68H";
    private String mos106 = "68J";
    private String mos107 = "68K";
    private String mos108 = "68M";
    private String mos109 = "68P";
    private String mos110 = "68Q";
    private String mos111 = "68R";
    private String mos112 = "68S";
    private String mos113 = "68T";
    private String mos114 = "68V";
    private String mos115 = "68W";
    private String mos116 = "68X";
    private String mos117 = "74D";
    private String mos118 = "79R";
    private String mos119 = "79S";
    private String mos120 = "88H";
    private String mos121 = "88K";
    private String mos122 = "88L";
    private String mos123 = "88M";
    private String mos124 = "88N";
    private String mos125 = "89A";
    private String mos126 = "89B";
    private String mos127 = "89D";
    private String mos128 = "91A";
    private String mos129 = "91B";
    private String mos130 = "91C";
    private String mos131 = "91D";
    private String mos132 = "91E";
    private String mos133 = "91F";
    private String mos134 = "91G";
    private String mos135 = "91H";
    private String mos136 = "91J";
    private String mos137 = "91K";
    private String mos138 = "91L";
    private String mos139 = "91M";
    private String mos140 = "91P";
    private String mos141 = "91S";
    private String mos142 = "92A";
    private String mos143 = "92F";
    private String mos144 = "92G";
    private String mos145 = "92L";
    private String mos146 = "92M";
    private String mos147 = "92R";
    private String mos148 = "92S";
    private String mos149 = "92W";
    private String mos150 = "92Y";
    private String mos151 = "94A";
    private String mos152 = "94D";
    private String mos153 = "94E";
    private String mos154 = "94F";
    private String mos155 = "94H";
    private String mos156 = "94M";
    private String mos157 = "94P";
    private String mos158 = "94R";
    private String mos159 = "94S";
    private String mos160 = "94T";
    private String mos161 = "94Y";
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createSpinner();
        //setContentView(R.layout.recent);
    }
    public void createSpinner () {
    	setContentView(R.layout.recent);
        Spinner spinner = (Spinner) findViewById(R.id.mosSelectSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.mosSpinner, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new MyOnItemSelectedListener());
    }

   public class MyOnItemSelectedListener implements OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent,
            View view, int pos, long id) {
        	   String toTest = parent.getItemAtPosition(pos).toString();
               if (toTest.equals(mos1)) {
            	   formSelect=1;
               }
               else if (toTest.equals(mos2)) {
            	   formSelect=2;
               }
               else if (toTest.equals(mos3)) {
            	   formSelect=3;
               }
               else if (toTest.equals(mos4)) {
            	   formSelect=4;
               }
               else if (toTest.equals(mos5)) {
            	   formSelect=5;
               }
               else if (toTest.equals(mos6)) {
            	   formSelect=6;
               }
               else if (toTest.equals(mos7)) {
            	   formSelect=7;
               }
               else if (toTest.equals(mos8)) {
            	   formSelect=8;
               }
               else if (toTest.equals(mos9)) {
            	   formSelect=9;
               }
               else if (toTest.equals(mos10)) {
            	   formSelect=10;
               }
               else if (toTest.equals(mos11)) {
            	   formSelect=11;
               }
               else if (toTest.equals(mos12)) {
            	   formSelect=12;
               }
               else if (toTest.equals(mos13)) {
            	   formSelect=13;
               }
               else if (toTest.equals(mos14)) {
            	   formSelect=14;
               }
               else if (toTest.equals(mos15)) {
            	   formSelect=15;
               }
               else if (toTest.equals(mos16)) {
            	   formSelect=16;
               }
               else if (toTest.equals(mos17)) {
            	   formSelect=17;
               }
               else if (toTest.equals(mos18)) {
            	   formSelect=18;
               }
               else if (toTest.equals(mos19)) {
            	   formSelect=19;
               }
               else if (toTest.equals(mos20)) {
            	   formSelect=20;
               }
               else if (toTest.equals(mos21)) {
            	   formSelect=21;
               }
               else if (toTest.equals(mos22)) {
            	   formSelect=22;
               }
               else if (toTest.equals(mos23)) {
            	   formSelect=23;
               }
               else if (toTest.equals(mos24)) {
            	   formSelect=24;
               }
               else if (toTest.equals(mos25)) {
            	   formSelect=25;
               }
               else if (toTest.equals(mos26)) {
            	   formSelect=26;
               }
               else if (toTest.equals(mos27)) {
            	   formSelect=27;
               }
               else if (toTest.equals(mos28)) {
            	   formSelect=28;
               }
               else if (toTest.equals(mos29)) {
            	   formSelect=29;
               }
               else if (toTest.equals(mos30)) {
            	   formSelect=30;
               }
               else if (toTest.equals(mos31)) {
            	   formSelect=31;
               }
               else if (toTest.equals(mos32)) {
            	   formSelect=32;
               }
               else if (toTest.equals(mos33)) {
            	   formSelect=33;
               }
               else if (toTest.equals(mos34)) {
            	   formSelect=34;
               }
               else if (toTest.equals(mos35)) {
            	   formSelect=35;
               }
               else if (toTest.equals(mos36)) {
            	   formSelect=36;
               }
               else if (toTest.equals(mos37)) {
            	   formSelect=37;
               }
               else if (toTest.equals(mos38)) {
            	   formSelect=38;
               }
               else if (toTest.equals(mos39)) {
            	   formSelect=39;
               }
               else if (toTest.equals(mos40)) {
            	   formSelect=40;
               }
               else if (toTest.equals(mos41)) {
            	   formSelect=41;
               }
               else if (toTest.equals(mos42)) {
            	   formSelect=42;
               }
               else if (toTest.equals(mos43)) {
            	   formSelect=43;
               }
               else if (toTest.equals(mos44)) {
            	   formSelect=44;
               }
               else if (toTest.equals(mos45)) {
            	   formSelect=45;
               }
               else if (toTest.equals(mos46)) {
            	   formSelect=46;
               }
               else if (toTest.equals(mos47)) {
            	   formSelect=47;
               }
               else if (toTest.equals(mos48)) {
            	   formSelect=48;
               }
               else if (toTest.equals(mos49)) {
            	   formSelect=49;
               }
               else if (toTest.equals(mos50)) {
            	   formSelect=50;
               }
               else if (toTest.equals(mos51)) {
            	   formSelect=51;
               }
               else if (toTest.equals(mos52)) {
            	   formSelect=52;
               }
               else if (toTest.equals(mos53)) {
            	   formSelect=53;
               }
               else if (toTest.equals(mos54)) {
            	   formSelect=54;
               }
               else if (toTest.equals(mos55)) {
            	   formSelect=55;
               }
               else if (toTest.equals(mos56)) {
            	   formSelect=56;
               }
               else if (toTest.equals(mos57)) {
            	   formSelect=57;
               }
               else if (toTest.equals(mos58)) {
            	   formSelect=58;
               }
               else if (toTest.equals(mos59)) {
            	   formSelect=59;
               }
               else if (toTest.equals(mos60)) {
            	   formSelect=60;
               }
               else if (toTest.equals(mos61)) {
            	   formSelect=61;
               }
               else if (toTest.equals(mos62)) {
            	   formSelect=62;
               }
               else if (toTest.equals(mos63)) {
            	   formSelect=63;
               }
               else if (toTest.equals(mos64)) {
            	   formSelect=64;
               }
               else if (toTest.equals(mos65)) {
            	   formSelect=65;
               }
               else if (toTest.equals(mos66)) {
            	   formSelect=66;
               }
               else if (toTest.equals(mos67)) {
            	   formSelect=67;
               }
               else if (toTest.equals(mos68)) {
            	   formSelect=68;
               }
               else if (toTest.equals(mos69)) {
            	   formSelect=69;
               }
               else if (toTest.equals(mos70)) {
            	   formSelect=70;
               }
               else if (toTest.equals(mos71)) {
            	   formSelect=71;
               }
               else if (toTest.equals(mos72)) {
            	   formSelect=72;
               }
               else if (toTest.equals(mos73)) {
            	   formSelect=73;
               }
               else if (toTest.equals(mos74)) {
            	   formSelect=74;
               }
               else if (toTest.equals(mos75)) {
            	   formSelect=75;
               }
               else if (toTest.equals(mos76)) {
            	   formSelect=76;
               }
               else if (toTest.equals(mos77)) {
            	   formSelect=77;
               }
               else if (toTest.equals(mos78)) {
            	   formSelect=78;
               }
               else if (toTest.equals(mos79)) {
            	   formSelect=79;
               }
               else if (toTest.equals(mos80)) {
            	   formSelect=80;
               }
               else if (toTest.equals(mos81)) {
            	   formSelect=81;
               }
               else if (toTest.equals(mos82)) {
            	   formSelect=82;
               }
               else if (toTest.equals(mos83)) {
            	   formSelect=83;
               }
               else if (toTest.equals(mos84)) {
            	   formSelect=84;
               }
               else if (toTest.equals(mos85)) {
            	   formSelect=85;
               }
               else if (toTest.equals(mos86)) {
            	   formSelect=86;
               }
               else if (toTest.equals(mos87)) {
            	   formSelect=87;
               }
               else if (toTest.equals(mos88)) {
            	   formSelect=88;
               }
               else if (toTest.equals(mos89)) {
            	   formSelect=89;
               }
               // Stopped here!!
               else if (toTest.equals(mos90)) {
            	   formSelect=90;
               }
               else if (toTest.equals(mos91)) {
            	   formSelect=91;
               }
               else if (toTest.equals(mos92)) {
            	   formSelect=92;
               }
               else if (toTest.equals(mos93)) {
            	   formSelect=93;
               }
               else if (toTest.equals(mos94)) {
            	   formSelect=94;
               }
               else if (toTest.equals(mos95)) {
            	   formSelect=95;
               }
               else if (toTest.equals(mos96)) {
            	   formSelect=96;
               }
               else if (toTest.equals(mos97)) {
            	   formSelect=97;
               }
               else if (toTest.equals(mos98)) {
            	   formSelect=98;
               }
               else if (toTest.equals(mos99)) {
            	   formSelect=99;
               }
               else if (toTest.equals(mos100)) {
            	   formSelect=100;
               }
               else if (toTest.equals(mos101)) {
            	   formSelect=101;
               }
               else if (toTest.equals(mos102)) {
            	   formSelect=102;
               }
               else if (toTest.equals(mos103)) {
            	   formSelect=103;
               }
               else if (toTest.equals(mos104)) {
            	   formSelect=104;
               }
               else if (toTest.equals(mos105)) {
            	   formSelect=105;
               }
               else if (toTest.equals(mos106)) {
            	   formSelect=106;
               }
               else if (toTest.equals(mos107)) {
            	   formSelect=107;
               }
               else if (toTest.equals(mos108)) {
            	   formSelect=108;
               }
               else if (toTest.equals(mos109)) {
            	   formSelect=109;
               }
               else if (toTest.equals(mos110)) {
            	   formSelect=110;
               }
               else if (toTest.equals(mos111)) {
            	   formSelect=111;
               }
               else if (toTest.equals(mos112)) {
            	   formSelect=112;
               }
               else if (toTest.equals(mos113)) {
            	   formSelect=113;
               }
               else if (toTest.equals(mos114)) {
            	   formSelect=114;
               }
               else if (toTest.equals(mos115)) {
            	   formSelect=115;
               }
               else if (toTest.equals(mos116)) {
            	   formSelect=116;
               }
               else if (toTest.equals(mos117)) {
            	   formSelect=117;
               }
               else if (toTest.equals(mos118)) {
            	   formSelect=118;
               }
               else if (toTest.equals(mos119)) {
            	   formSelect=119;
               }
               else if (toTest.equals(mos120)) {
            	   formSelect=120;
               }
               else if (toTest.equals(mos121)) {
            	   formSelect=121;
               }
               else if (toTest.equals(mos122)) {
            	   formSelect=122;
               }
               else if (toTest.equals(mos123)) {
            	   formSelect=123;
               }
               else if (toTest.equals(mos124)) {
            	   formSelect=124;
               }
               else if (toTest.equals(mos125)) {
            	   formSelect=125;
               }
               else if (toTest.equals(mos126)) {
            	   formSelect=126;
               }
               else if (toTest.equals(mos127)) {
            	   formSelect=127;
               }
               else if (toTest.equals(mos128)) {
            	   formSelect=128;
               }
               else if (toTest.equals(mos129)) {
            	   formSelect=129;
               }
               else if (toTest.equals(mos130)) {
            	   formSelect=130;
               }
               else if (toTest.equals(mos131)) {
            	   formSelect=131;
               }
               else if (toTest.equals(mos132)) {
            	   formSelect=132;
               }
               else if (toTest.equals(mos133)) {
            	   formSelect=133;
               }
               else if (toTest.equals(mos134)) {
            	   formSelect=134;
               }
               else if (toTest.equals(mos135)) {
            	   formSelect=135;
               }
               else if (toTest.equals(mos136)) {
            	   formSelect=136;
               }
               else if (toTest.equals(mos137)) {
            	   formSelect=137;
               }
               else if (toTest.equals(mos138)) {
            	   formSelect=138;
               }
               else if (toTest.equals(mos139)) {
            	   formSelect=139;
               }
               else if (toTest.equals(mos140)) {
            	   formSelect=140;
               }
               else if (toTest.equals(mos141)) {
            	   formSelect=141;
               }
               else if (toTest.equals(mos142)) {
            	   formSelect=142;
               }
               else if (toTest.equals(mos143)) {
            	   formSelect=143;
               }
               else if (toTest.equals(mos144)) {
            	   formSelect=144;
               }
               else if (toTest.equals(mos145)) {
            	   formSelect=145;
               }
               else if (toTest.equals(mos146)) {
            	   formSelect=146;
               }
               else if (toTest.equals(mos147)) {
            	   formSelect=147;
               }
               else if (toTest.equals(mos148)) {
            	   formSelect=148;
               }
               else if (toTest.equals(mos149)) {
            	   formSelect=149;
               }
               else if (toTest.equals(mos150)) {
            	   formSelect=150;
               }
               else if (toTest.equals(mos151)) {
            	   formSelect=151;
               }
               else if (toTest.equals(mos152)) {
            	   formSelect=152;
               }
               else if (toTest.equals(mos153)) {
            	   formSelect=153;
               }
               else if (toTest.equals(mos154)) {
            	   formSelect=154;
               }
               else if (toTest.equals(mos155)) {
            	   formSelect=155;
               }
               else if (toTest.equals(mos156)) {
            	   formSelect=156;
               }
               else if (toTest.equals(mos157)) {
            	   formSelect=157;
               }
               else if (toTest.equals(mos158)) {
            	   formSelect=158;
               }
               else if (toTest.equals(mos159)) {
            	   formSelect=159;
               }
               else if (toTest.equals(mos160)) {
            	   formSelect=160;
               }
               else if (toTest.equals(mos161)) {
            	   formSelect=161;
               }
            }

        public void onNothingSelected(AdapterView parent) {
          // Do nothing.
        }
        
    }
    
    
    public void graphClickHandler (View View) {
    	//Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/welfarecanada"));
    	//startActivity(browserIntent);
    	
    	int [] primY = new int [12];
    	int [] secY = new int [12];
    	int [] promoPoints = new int [12];
    	
    	// Retrieves Users Promotion Points
    	userPoints = 0;
    	EditText pointsString = (EditText) findViewById(R.id.userPoints);
    	if(pointsString.getText().toString().length() == 0){
    		userPoints = 0;
    	}
    	else {
    		try {
    			userPoints = Integer.parseInt(pointsString.getText().toString());
    		} catch(NumberFormatException nfe) {
    			//alertDialog(this);
    		}
    	}
    	
    	//Check what rank is selected
    	rankSelection = 0;// 0=SGT, 1=SSG
    	RadioButton toSGTSelect = (RadioButton) findViewById(R.id.toSarge);
    	RadioButton toSSGSelect = (RadioButton) findViewById(R.id.toStaffSarge);
    	if (toSGTSelect.isChecked()) {
    		rankSelection = 0;
    	}
    	else if (toSSGSelect.isChecked()) {
    		rankSelection = 1;
    	}
    	int[] userPointArray = {userPoints, userPoints, userPoints, userPoints, userPoints, userPoints, userPoints, userPoints, userPoints, userPoints, userPoints, userPoints};
    	
    	if (rankSelection == 0) {
    		InputStream inputStream = null;
			try {
				inputStream = getAssets().open("tosgt.txt");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		BufferedReader f = new BufferedReader(new InputStreamReader(inputStream));
    		lastYearGraph.importSelection(formSelect, userPointArray, f);
        	lastYearGraph toSGT = new lastYearGraph();
        	Intent lineIntent = toSGT.getIntent(this);
        	startActivity(lineIntent);
    	}
    	else if (rankSelection == 1) {
    		InputStream inputStream = null;
			try {
				inputStream = getAssets().open("tossg.txt");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		BufferedReader f = new BufferedReader(new InputStreamReader(inputStream));
    		lastYearGraph.importSelection(formSelect, userPointArray, f);
        	lastYearGraph toSGT = new lastYearGraph();
        	Intent lineIntent = toSGT.getIntent(this);
        	startActivity(lineIntent);
    	}
    	

    }
}