package newPromoCalc.miller;

import newPromoCalc.miller.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

public class E6CalculatorActivity extends Activity {
	
int error;
	
	/** Sub Category Totals*/
	private int milTraining;
	private int awards;
	private int milEd;
	private int civEd;
	private int pointsTotal;
	
	/**Military Training Variables*/
	private int deployMonths;
	private int apftScore;
	private int weapQual;
	private int formSelect;
	
	private int weapQualPoints;
	private int apftPoints;
	private int monthsDeployPoints;
	
	private String weap1 = "DA Form 3595-R or 5790-R";
	private String weap2 = "DA Form 85-R w/ M249 MG";
	private String weap3 = "DA Form 85-R w/ M240B/M60";
	private String weap4 = "DA Form 88";
	private String weap5 = "DA Form 5704 or 5704-R";
	private String weap6 = "DA Form 7304-R";
	private String weap7 = "CID Form";
	private String weap8 = "FLVA Form 19-10";

	
	
	/**Awards and Decorations Variables*/
	private int soldMedalPlus;
	private int bronzeStar;
	private int bronzeStarV;
	private int purpHeart;
	private int airMedal;
	private int airMedalV;
	private int AAM;
	private int JSAAM;
	private int DMSM;
	private int MSM;
	private int JSCOM;
	private int arcom;
	private int arcomV;
	private int GCM;
	private int RCAAM;
	private int armedForces;
	private int volunteer;
	private int COA;
	private int comInBad;
	private int exInBad;
	private int comMedBad;
	private int comActBad;
	private int exFieldMedBad;
	private int presServBad;
	private int vicePresServBad;
	private int drillBad;
	private int paraRiggerBad;
	private int diverBad;
	private int pathfinderBad;
	private int airAssBad;
	private int airCrewBad;
	private int secDefServBad;
	private int jointChiefBad;
	private int armyStaffBad;
	private int spaceBad;
	private int tombGuardBad;
	private int paraLevel;
	private int eodLevel;
	private int recruiterLevel;
	private int airborneAdvantage;
	private int driverandMechBad;
	
	/**Military Education Variables*/
	private int resPoints;
	private int ePoints;
	private int rangerSchool;
	private int specForcesCourse;
	private int sapperCourse;
	private int armyMaintManage;
	private int prescribedLoadListClerk;
	private int motorPoolManage;
	private int genOperCourse;
	private int fuelHandlersCourse;
	private int basicWeldingCourse;
	private int forkliftOperatorCourse;
	private int busDriverCourse;
	private int unitSupplyClerkCourse;
	private int unitSupplyManageCourse;
	private int unitArmorCourse;
	private int CBRNDefCourse;
	private int unitPostalClerkCourse;
	private int diskOperatingSystem;
	private int wordProcessingCourse;
	private int databaseManageCourse;
	private int unitLevelLogistics;
	private int accpHours;
	private int milResidentTrainingHours;
	private int alc;
	private int alcCommandants;
	private int alcHonor;
	
	/**Civilian Education Variables*/
	private int semesterHours;
	private int techCerts;
	private int defLanTests;
	private int degCompletion;
    /** Called when the activity is first created. */
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createSpinner1();
    }
    public void createSpinner1 () {
    	setContentView(R.layout.e6_main);
        Spinner spinner = (Spinner) findViewById(R.id.e6weapCardSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.weapQualCards, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new MyOnItemSelectedListener());
    }
    public class MyOnItemSelectedListener implements OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent,
            View view, int pos, long id) {
        	   String toTest = parent.getItemAtPosition(pos).toString();
               if (toTest.equals(weap1)) {
            	   formSelect=1;
               }
               else if (toTest.equals(weap2)) {
            	   formSelect=2;
               }
               else if (toTest.equals(weap3)) {
            	   formSelect=3;
               }
               else if (toTest.equals(weap4)) {
            	   formSelect=4;
               }
               else if (toTest.equals(weap5)) {
            	   formSelect=5;
               }
               else if (toTest.equals(weap6)) {
            	   formSelect=6;
               }
               else if (toTest.equals(weap7)) {
            	   formSelect=7;
               }
               else if (toTest.equals(weap8)) {
            	   formSelect=8;
               }
            }

        public void onNothingSelected(AdapterView parent) {
          // Do nothing.
        }
        
    }
    public void alertDialog (E6CalculatorActivity E6CalculatorActivity){
    	final AlertDialog alertDialog;
    	alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Calculation Error");
        alertDialog.setMessage("Please make sure you entered only whole numbers. Example: 1, 3, 15, 123.");
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface dialog, int which) {
            return;
        } });
    	alertDialog.show();
    	error++;
    }
    
    public void WEAPONalertDialog (E6CalculatorActivity E6CalculatorActivity){
    	final AlertDialog alertDialog;
    	alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Weapon Score Error");
        alertDialog.setMessage("Please ensure you have entered a valid score for the selected weapon Card");
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface dialog, int which) {
            return;
        } });
    	alertDialog.show();
    	error++;
    }
    
    public void TOTALalertDialog (E6CalculatorActivity E6CalculatorActivity){
    	if (error > 0) {
    		return;
    	}
    	else {
    	final AlertDialog overallDialog;
		overallDialog = new AlertDialog.Builder(this).create();
		overallDialog.setTitle("Total Points");
		overallDialog.setMessage("Military Training: (" + milTraining + "), Awards: (" + awards + "), Militay Education: (" + milEd + "), Civilian Education: ("+ civEd + ") = Total Points:" + pointsTotal);
		overallDialog.setButton("Modify Points", new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface dialog, int which) {
        	  milTraining = 0;
          	  awards = 0;
          	  milEd = 0;
          	  civEd = 0;
        	  pointsTotal = 0;
            return;
        } });
		overallDialog.setButton2("Reset", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            	milTraining = 0;
            	awards = 0;
            	milEd = 0;
            	civEd = 0;
            	pointsTotal = 0;
          		setContentView(R.layout.e6_main);
          		createSpinner1();
          } });
		overallDialog.show();
    	}
    }
    
public void calcClickHandler (View View) {
    	
    	error = 0;
    	milTraining = 0;
    	awards = 0;
    	milEd = 0;
    	civEd = 0;
    	pointsTotal = 0;
    	/** Calculates APFT Points based on user input */
    	apftScore = 0;
    	EditText apftString = (EditText) findViewById(R.id.e6apftScore);
    	if(apftString.getText().toString().length() == 0){
    		apftScore = 179;
    	}
    	else {
    		try {
    			apftScore = Integer.parseInt(apftString.getText().toString());
    		} catch(NumberFormatException nfe) {
    			alertDialog(this);
    		}
    	}
    	if (apftScore < 180) {
    		apftPoints = 0;
    	}
    	else if (apftScore >= 180 && apftScore <= 183) {
    		apftPoints = 15;
    	}
    	else if (apftScore >= 184 && apftScore <= 186) {
    		apftPoints = 16;
    	}
    	else if (apftScore == 187 || apftScore == 188) {
    		apftPoints = 17;
    	}
    	else if (apftScore == 189 || apftScore == 190) {
    		apftPoints = 18;
    	}
    	//sdfghsdfgsdrgdfgsdfg 
    	else if (apftScore == 191 || apftScore == 192) {
    		apftPoints = 19;
    	}
    	else if (apftScore == 193 || apftScore == 194) {
    		apftPoints = 20;
    	}
    	else if (apftScore == 195 || apftScore == 196) {
    		apftPoints = 21;
    	}
    	else if (apftScore == 197 || apftScore == 198) {
    		apftPoints = 22;
    	}
    	else if (apftScore == 199 || apftScore == 200) {
    		apftPoints = 23;
    	}
    	else if (apftScore == 201 || apftScore == 202) {
    		apftPoints = 24;
    	}
    	else if (apftScore == 203 || apftScore == 204) {
    		apftPoints = 25;
    	}
    	else if (apftScore == 205 || apftScore == 206) {
    		apftPoints = 26;
    	}
    	else if (apftScore == 207 || apftScore == 208) {
    		apftPoints = 27;
    	}
    	else if (apftScore == 209 || apftScore == 210) {
    		apftPoints = 28;
    	}
    	else if (apftScore == 211 || apftScore == 212) {
    		apftPoints = 29;
    	}
    	else if (apftScore == 213 || apftScore == 214) {
    		apftPoints = 30;
    	}
    	else if (apftScore == 215 || apftScore == 216) {
    		apftPoints = 31;
    	}
    	else if (apftScore == 217 || apftScore == 218) {
    		apftPoints = 32;
    	}
    	else if (apftScore == 219 || apftScore == 220) {
    		apftPoints = 33;
    	}
    	else if (apftScore == 221 || apftScore == 222) {
    		apftPoints = 34;
    	}
    	else if (apftScore == 223 || apftScore == 224) {
    		apftPoints = 35;
    	}
    	else if (apftScore == 225 || apftScore == 226) {
    		apftPoints = 36;
    	}
    	else if (apftScore == 227 || apftScore == 228) {
    		apftPoints = 37;
    	}
    	else if (apftScore == 229 || apftScore == 230) {
    		apftPoints = 38;
    	}
    	else if (apftScore == 231 || apftScore == 232) {
    		apftPoints = 39;
    	}
    	else if (apftScore == 233 || apftScore == 234) {
    		apftPoints = 40;
    	}
    	else if (apftScore == 235 || apftScore == 236) {
    		apftPoints = 41;
    	}
    	else if (apftScore >= 237 && apftScore <= 289) {
    		apftPoints = apftScore - 195;
    	}
    	else if (apftScore == 290 || apftScore == 291) {
    		apftPoints = 95;
    	}
    	else if (apftScore == 292 || apftScore == 293) {
    		apftPoints = 96;
    	}
    	else if (apftScore == 294 || apftScore == 295) {
    		apftPoints = 97;
    	}
    	else if (apftScore == 296 || apftScore == 297) {
    		apftPoints = 98;
    	}
    	else if (apftScore == 298 || apftScore == 299) {
    		apftPoints = 99;
    	}
    	else if (apftScore == 300) {
    		apftPoints = 100;
    	}
    	
    	/** Calculates Deployment Points based on user input */
    	deployMonths = 0;
    	EditText deployString = (EditText) findViewById(R.id.e6deployMonths);
    	if(deployString.getText().toString().length() == 0){
    		deployMonths = 0;
    	}
    	else {
    		try {
    			deployMonths = Integer.parseInt(deployString.getText().toString());
    		} catch(NumberFormatException nfe) {
    			alertDialog(this);
    		}
    	}
    	monthsDeployPoints = deployMonths*2;
    	//Makes sure that the deployment points don't go over the 60 max.
    	if (monthsDeployPoints > 60) {
    		monthsDeployPoints = 60;
    	}
    	
    	/** Calculates Weapon Qualification Points based on user input
    	     This was easily the most difficult thing for me to figure out...
    	     Only because I forgot to add the click listener into the main method... */
    	weapQual = 0;
    	EditText weapQualString = (EditText) findViewById(R.id.e6weapScore);
    	if(weapQualString.getText().toString().length() == 0){
    		weapQual = 0;
    	}
    	else {
    		try {
    			weapQual = Integer.parseInt(weapQualString.getText().toString());
    		} catch(NumberFormatException nfe) {
    			WEAPONalertDialog(this);
    		}
    	}
    	if (weapQual == 0) {
    		
    	}
    	else {
    	while (formSelect==1) {
    		if (weapQual>40|weapQual<23) {
    			WEAPONalertDialog(this);
    			break;
    		}
    		else if (weapQual==40){
    			weapQualPoints=100;
    		}
    		else if (weapQual==39){
    			weapQualPoints=98;
    		}
    		else if (weapQual==38){
    			weapQualPoints=96;
    		}
    		else if (weapQual==37){
    			weapQualPoints=94;
    		}
    		else if (weapQual==36){
    			weapQualPoints=92;
    		}
    		else if (weapQual==35){
    			weapQualPoints=86;
    		}
    		else if (weapQual==34){
    			weapQualPoints=80;
    		}
    		else if (weapQual==33){
    			weapQualPoints=74;
    		}
    		else if (weapQual==32){
    			weapQualPoints=68;
    		}
    		else if (weapQual==31){
    			weapQualPoints=62;
    		}
    		else if (weapQual==30){
    			weapQualPoints=56;
    		}
    		else if (weapQual==29){
    			weapQualPoints=52;
    		}
    		else if (weapQual==28){
    			weapQualPoints=48;
    		}
    		else if (weapQual==27){
    			weapQualPoints=44;
    		}
    		else if (weapQual==26){
    			weapQualPoints=40;
    		}
    		else if (weapQual==25){
    			weapQualPoints=36;
    		}
    		else if (weapQual==24){
    			weapQualPoints=32;
    		}
    		else if (weapQual==23){
    			weapQualPoints=28;
    		}
    		break;
    	}
    	
    	while (formSelect==2) {
    		if (weapQual!=201|weapQual!=199|weapQual!=197|weapQual!=195|weapQual!=193|weapQual!=189|weapQual!=186|weapQual!=182|weapQual!=180
    				|weapQual!=178|weapQual!=176|weapQual!=174|weapQual!=172|weapQual!=170|weapQual!=168|weapQual!=166|weapQual!=164|weapQual!=161|weapQual!=158) {
    			WEAPONalertDialog(this);
    			break;
    		}
    		else if (weapQual==201){
    			weapQualPoints=100;
    		}
    		else if (weapQual==199){
    			weapQualPoints=96;
    		}
    		else if (weapQual==197){
    			weapQualPoints=92;
    		}
    		else if (weapQual==195){
    			weapQualPoints=88;
    		}
    		else if (weapQual==193){
    			weapQualPoints=84;
    		}
    		else if (weapQual==189){
    			weapQualPoints=80;
    		}
    		else if (weapQual==186){
    			weapQualPoints=76;
    		}
    		else if (weapQual==182){
    			weapQualPoints=72;
    		}
    		else if (weapQual==180){
    			weapQualPoints=68;
    		}
    		else if (weapQual==178){
    			weapQualPoints=64;
    		}
    		else if (weapQual==176){
    			weapQualPoints=60;
    		}
    		else if (weapQual==174){
    			weapQualPoints=56;
    		}
    		else if (weapQual==172){
    			weapQualPoints=52;
    		}
    		else if (weapQual==170){
    			weapQualPoints=48;
    		}
    		else if (weapQual==168){
    			weapQualPoints=44;
    		}
    		else if (weapQual==166){
    			weapQualPoints=40;
    		}
    		else if (weapQual==164){
    			weapQualPoints=36;
    		}
    		else if (weapQual==161){
    			weapQualPoints=32;
    		}
    		else if (weapQual==158){
    			weapQualPoints=28;
    		}
    		break;
    	}
    	
    	while (formSelect==3) {
    		if (weapQual!=227|weapQual!=225|weapQual!=223|weapQual!=221|weapQual!=218|weapQual!=215|weapQual!=212|weapQual!=209|weapQual!=206
    				|weapQual!=203|weapQual!=201|weapQual!=198|weapQual!=196|weapQual!=193|weapQual!=191|weapQual!=188|weapQual!=186|weapQual!=183|weapQual!=180) {
    			WEAPONalertDialog(this);
    			break;
    		}
    		else if (weapQual==227){
    			weapQualPoints=100;
    		}
    		else if (weapQual==225){
    			weapQualPoints=96;
    		}
    		else if (weapQual==223){
    			weapQualPoints=92;
    		}
    		else if (weapQual==221){
    			weapQualPoints=88;
    		}
    		else if (weapQual==218){
    			weapQualPoints=84;
    		}
    		else if (weapQual==215){
    			weapQualPoints=80;
    		}
    		else if (weapQual==212){
    			weapQualPoints=76;
    		}
    		else if (weapQual==209){
    			weapQualPoints=72;
    		}
    		else if (weapQual==206){
    			weapQualPoints=68;
    		}
    		else if (weapQual==203){
    			weapQualPoints=64;
    		}
    		else if (weapQual==201){
    			weapQualPoints=60;
    		}
    		else if (weapQual==198){
    			weapQualPoints=56;
    		}
    		else if (weapQual==196){
    			weapQualPoints=52;
    		}
    		else if (weapQual==193){
    			weapQualPoints=48;
    		}
    		else if (weapQual==191){
    			weapQualPoints=44;
    		}
    		else if (weapQual==188){
    			weapQualPoints=40;
    		}
    		else if (weapQual==186){
    			weapQualPoints=36;
    		}
    		else if (weapQual==183){
    			weapQualPoints=32;
    		}
    		else if (weapQual==180){
    			weapQualPoints=28;
    		}
    		break;
    	}
    	
    	while (formSelect==4) {
    		if (weapQual>30|weapQual<16) {
    			WEAPONalertDialog(this);
    			break;
    		}
    		else if (weapQual==30){
    			weapQualPoints=100;
    		}
    		else if (weapQual==29){
    			weapQualPoints=98;
    		}
    		else if (weapQual==28){
    			weapQualPoints=96;
    		}
    		else if (weapQual==27){
    			weapQualPoints=88;
    		}
    		else if (weapQual==26){
    			weapQualPoints=80;
    		}
    		else if (weapQual==25){
    			weapQualPoints=74;
    		}
    		else if (weapQual==24){
    			weapQualPoints=68;
    		}
    		else if (weapQual==23){
    			weapQualPoints=60;
    		}
    		else if (weapQual==22){
    			weapQualPoints=52;
    		}
    		else if (weapQual==21){
    			weapQualPoints=48;
    		}
    		else if (weapQual==20){
    			weapQualPoints=44;
    		}
    		else if (weapQual==19){
    			weapQualPoints=40;
    		}
    		else if (weapQual==18){
    			weapQualPoints=36;
    		}
    		else if (weapQual==17){
    			weapQualPoints=32;
    		}
    		else if (weapQual==16){
    			weapQualPoints=28;
    		}
    		break;
    	}
    	
        while (formSelect==5) {
    		if (weapQual>40|weapQual<24) {
    			WEAPONalertDialog(this);
    			break;
    		}
    		else if (weapQual==40){
    			weapQualPoints=100;
    		}
    		else if (weapQual==39){
    			weapQualPoints=95;
    		}
    		else if (weapQual==38){
    			weapQualPoints=91;
    		}
    		else if (weapQual==37){
    			weapQualPoints=86;
    		}
    		else if (weapQual==36){
    			weapQualPoints=82;
    		}
    		else if (weapQual==35){
    			weapQualPoints=77;
    		}
    		else if (weapQual==34){
    			weapQualPoints=73;
    		}
    		else if (weapQual==33){
    			weapQualPoints=68;
    		}
    		else if (weapQual==32){
    			weapQualPoints=64;
    		}
    		else if (weapQual==31){
    			weapQualPoints=59;
    		}
    		else if (weapQual==30){
    			weapQualPoints=55;
    		}
    		else if (weapQual==29){
    			weapQualPoints=50;
    		}
    		else if (weapQual==28){
    			weapQualPoints=46;
    		}
    		else if (weapQual==27){
    			weapQualPoints=41;
    		}
    		else if (weapQual==26){
    			weapQualPoints=37;
    		}
    		else if (weapQual==25){
    			weapQualPoints=32;
    		}
    		else if (weapQual==24){
    			weapQualPoints=28;
    		}
    		break;
    	}
        while (formSelect==6) {
    		if (weapQual!=106|weapQual!=105|weapQual!=104|weapQual!=102|weapQual!=100|weapQual!=96|weapQual!=94|weapQual!=90|weapQual!=89
    				|weapQual!=87|weapQual!=85|weapQual!=83|weapQual!=81|weapQual!=80|weapQual!=79|weapQual!=77|weapQual!=75|weapQual!=73|weapQual!=70) {
    			WEAPONalertDialog(this);
    			break;
    		}
    		else if (weapQual==106){
    			weapQualPoints=100;
    		}
    		else if (weapQual==105){
    			weapQualPoints=96;
    		}
    		else if (weapQual==104){
    			weapQualPoints=92;
    		}
    		else if (weapQual==102){
    			weapQualPoints=88;
    		}
    		else if (weapQual==100){
    			weapQualPoints=84;
    		}
    		else if (weapQual==96){
    			weapQualPoints=80;
    		}
    		else if (weapQual==94){
    			weapQualPoints=76;
    		}
    		else if (weapQual==90){
    			weapQualPoints=72;
    		}
    		else if (weapQual==89){
    			weapQualPoints=68;
    		}
    		else if (weapQual==87){
    			weapQualPoints=64;
    		}
    		else if (weapQual==85){
    			weapQualPoints=60;
    		}
    		else if (weapQual==83){
    			weapQualPoints=56;
    		}
    		else if (weapQual==81){
    			weapQualPoints=52;
    		}
    		else if (weapQual==80){
    			weapQualPoints=48;
    		}
    		else if (weapQual==79){
    			weapQualPoints=44;
    		}
    		else if (weapQual==77){
    			weapQualPoints=40;
    		}
    		else if (weapQual==75){
    			weapQualPoints=36;
    		}
    		else if (weapQual==73){
    			weapQualPoints=32;
    		}
    		else if (weapQual==70){
    			weapQualPoints=28;
    		}
    		break;
    	}
        while (formSelect==7) {
    		if (weapQual!=300|weapQual!=294|weapQual!=290|weapQual!=286|weapQual!=284|weapQual!=280|weapQual!=278|weapQual!=276|weapQual!=274
    				|weapQual!=270|weapQual!=266|weapQual!=262|weapQual!=258|weapQual!=256|weapQual!=254|weapQual!=252|weapQual!=248|weapQual!=244|weapQual!=241
    				|weapQual!=237|weapQual!=233|weapQual!=229|weapQual!=225|weapQual!=221|weapQual!=217|weapQual!=213|weapQual!=211) {
    			WEAPONalertDialog(this);
    			break;
    		}
    		else if (weapQual==300){
    			weapQualPoints=100;
    		}
    		else if (weapQual==294){
    			weapQualPoints=98;
    		}
    		else if (weapQual==290){
    			weapQualPoints=96;
    		}
    		else if (weapQual==286){
    			weapQualPoints=94;
    		}
    		else if (weapQual==284){
    			weapQualPoints=92;
    		}
    		else if (weapQual==280){
    			weapQualPoints=90;
    		}
    		else if (weapQual==278){
    			weapQualPoints=88;
    		}
    		else if (weapQual==276){
    			weapQualPoints=86;
    		}
    		else if (weapQual==274){
    			weapQualPoints=83;
    		}
    		else if (weapQual==270){
    			weapQualPoints=80;
    		}
    		else if (weapQual==266){
    			weapQualPoints=77;
    		}
    		else if (weapQual==262){
    			weapQualPoints=74;
    		}
    		else if (weapQual==258){
    			weapQualPoints=71;
    		}
    		else if (weapQual==256){
    			weapQualPoints=68;
    		}
    		else if (weapQual==254){
    			weapQualPoints=65;
    		}
    		else if (weapQual==252){
    			weapQualPoints=62;
    		}
    		else if (weapQual==248){
    			weapQualPoints=59;
    		}
    		else if (weapQual==244){
    			weapQualPoints=56;
    		}
    		else if (weapQual==241){
    			weapQualPoints=53;
    		}
    		else if (weapQual==237){
    			weapQualPoints=50;
    		}
    		else if (weapQual==233){
    			weapQualPoints=47;
    		}
    		else if (weapQual==229){
    			weapQualPoints=44;
    		}
    		else if (weapQual==225){
    			weapQualPoints=41;
    		}
    		else if (weapQual==221){
    			weapQualPoints=38;
    		}
    		else if (weapQual==217){
    			weapQualPoints=35;
    		}
    		else if (weapQual==213){
    			weapQualPoints=32;
    		}
    		else if (weapQual==211){
    			weapQualPoints=28;
    		}
    		break;
    	}
        while (formSelect==8) {
    		if (weapQual>50|weapQual<35) {
    			WEAPONalertDialog(this);
    			break;
    		}
    		else if (weapQual==50){
    			weapQualPoints=100;
    		}
    		else if (weapQual==49){
    			weapQualPoints=96;
    		}
    		else if (weapQual==48){
    			weapQualPoints=92;
    		}
    		else if (weapQual==47){
    			weapQualPoints=88;
    		}
    		else if (weapQual==46){
    			weapQualPoints=82;
    		}
    		else if (weapQual==45){
    			weapQualPoints=78;
    		}
    		else if (weapQual==44){
    			weapQualPoints=72;
    		}
    		else if (weapQual==43){
    			weapQualPoints=68;
    		}
    		else if (weapQual==42){
    			weapQualPoints=62;
    		}
    		else if (weapQual==41){
    			weapQualPoints=58;
    		}
    		else if (weapQual==40){
    			weapQualPoints=52;
    		}
    		else if (weapQual==39){
    			weapQualPoints=48;
    		}
    		else if (weapQual==38){
    			weapQualPoints=42;
    		}
    		else if (weapQual==37){
    			weapQualPoints=38;
    		}
    		else if (weapQual==36){
    			weapQualPoints=32;
    		}
    		else if (weapQual==35){
    			weapQualPoints=28;
    		}
    		break;
    	}
    	}
        /* This will calculate the total points that the Soldier receives in the "Military Training" category */
        milTraining = weapQualPoints + apftPoints + monthsDeployPoints;
        /* Ensures Soldier does not exceed the 255 allowed */
    	if (milTraining > 255) {
    		milTraining = 255;
    	}
    	
    	
    	/* Beginning the Awards and Decorations calculations. First will be the medals, followed by the badges */
    	
    	//Calculates Soldier's Medal & Higher
    	soldMedalPlus = 0;
    	EditText soldMedalString = (EditText) findViewById(R.id.e6soldMedalPlus);
    	if(soldMedalString.getText().toString().length() == 0){
    		soldMedalPlus = 0;
    	}
    	else {
    		try {
    			soldMedalPlus = Integer.parseInt(soldMedalString.getText().toString());
    			soldMedalPlus = soldMedalPlus*40;
    		} catch(NumberFormatException nfe) {
    			alertDialog(this);
    		}
    	}
    	awards = awards + soldMedalPlus;
    	
    	//Calculates Bronze Star w/ V Device
    	bronzeStarV = 0;
    	EditText bronzeVString = (EditText) findViewById(R.id.e6bronzeStarV);
    	if(bronzeVString.getText().toString().length() == 0){
    		bronzeStarV = 0;
    	}
    	else {
    		try {
    			bronzeStarV = Integer.parseInt(bronzeVString.getText().toString());
    			bronzeStarV = bronzeStarV*35;
    		} catch(NumberFormatException nfe) {
    			alertDialog(this);
    		}
    	}
    	awards = awards + bronzeStarV;
    	
    	//Calculates Bronze Star
    	bronzeStar = 0;
    	EditText bronzeString = (EditText) findViewById(R.id.e6bronzeStar);
    	if(bronzeString.getText().toString().length() == 0){
    		bronzeStar = 0;
    	}
    	else {
    		try {
    			bronzeStar = Integer.parseInt(bronzeString.getText().toString());
    			bronzeStar = bronzeStar*30;
    		} catch(NumberFormatException nfe) {
    			alertDialog(this);
    		}
    	}
    	awards = awards + bronzeStar;

    	// Calculates Purple Heart
    	purpHeart = 0;
    	EditText purpString = (EditText) findViewById(R.id.e6purpHeart);
    	if(purpString.getText().toString().length() == 0){
    		purpHeart = 0;
    	}
    	else {
    		try {
    			purpHeart = Integer.parseInt(purpString.getText().toString());
    			purpHeart = purpHeart*30;
    		} catch(NumberFormatException nfe) {
    			alertDialog(this);
    		}
    	}
    	awards = awards + purpHeart;

    	// Calculates Air Medal w/ V Device
    	airMedalV = 0;
    	EditText airVString = (EditText) findViewById(R.id.e6airMedalV);
    	if(airVString.getText().toString().length() == 0){
    		airMedalV = 0;
    	}
    	else {
    		try {
    			airMedalV = Integer.parseInt(airVString.getText().toString());
    			airMedalV = airMedalV*25;
    		} catch(NumberFormatException nfe) {
    			alertDialog(this);
    		}
    	}
    	awards = awards + airMedalV; 

    	// Calculates Air Medal
    	airMedal = 0;
    	EditText airString = (EditText) findViewById(R.id.e6airMedal);
    	if(airString.getText().toString().length() == 0){
    		airMedal = 0;
    	}
    	else {
    		try {
    			airMedal = Integer.parseInt(airString.getText().toString());
    			airMedal = airMedal*20;
    		} catch(NumberFormatException nfe) {
    			alertDialog(this);
    		}
    	}
    	awards = awards + airMedal;
    	
    	// Calculates Defense Merit. Service Medal
    	DMSM = 0;
    	EditText DMSMString = (EditText) findViewById(R.id.e6DMSM);
    	if(DMSMString.getText().toString().length() == 0){
    		DMSM = 0;
    	}
    	else {
    		try {
    			DMSM = Integer.parseInt(DMSMString.getText().toString());
    			DMSM = DMSM*25;
    		} catch(NumberFormatException nfe) {
    			alertDialog(this);
    		}
    	}
    	awards = awards + DMSM;
    	
    	// Calculates Merit. Service Medal
    	MSM = 0;
    	EditText MSMString = (EditText) findViewById(R.id.e6MSM);
    	if(MSMString.getText().toString().length() == 0){
    		MSM = 0;
    	}
    	else {
    		try {
    			MSM = Integer.parseInt(MSMString.getText().toString());
    			MSM = MSM*25;
    		} catch(NumberFormatException nfe) {
    			alertDialog(this);
    		}
    	}
    	awards = awards + MSM;

    	// Calculates ARCOM w/ V Device
    	arcomV = 0;
    	EditText arcomVString = (EditText) findViewById(R.id.e6ARCOMV);
    	if(arcomVString.getText().toString().length() == 0){
    		arcomV = 0;
    	}
    	else {
    		try {
    			arcomV = Integer.parseInt(arcomVString.getText().toString());
    			arcomV = arcomV*25;
    		} catch(NumberFormatException nfe) {
    			alertDialog(this);
    		}
    	}
    	awards = awards + arcomV;
    	
    	// Calculates ARCOM
    	arcom = 0;
    	EditText arcomString = (EditText) findViewById(R.id.e6ARCOM);
    	if(arcomString.getText().toString().length() == 0){
    		arcom = 0;
    	}
    	else {
    		try {
    			arcom = Integer.parseInt(arcomString.getText().toString());
    			arcom = arcom*20;
    		} catch(NumberFormatException nfe) {
    			alertDialog(this);
    		}
    	}
    	awards = awards + arcom;

    	// Calculates Joint Service Commendation Medal
    	JSCOM = 0;
    	EditText JSCOMString = (EditText) findViewById(R.id.e6JSCOM);
    	if(JSCOMString.getText().toString().length() == 0){
    		JSCOM = 0;
    	}
    	else {
    		try {
    			JSCOM = Integer.parseInt(JSCOMString.getText().toString());
    			JSCOM = JSCOM*20;
    		} catch(NumberFormatException nfe) {
    			alertDialog(this);
    		}
    	}
    	awards = awards + JSCOM;

    	// Calculates Army Achievement Medal
    	AAM = 0;
    	EditText AAMString = (EditText) findViewById(R.id.e6AAM);
    	if(AAMString.getText().toString().length() == 0){
    		AAM = 0;
    	}
    	else {
    		try {
    			AAM = Integer.parseInt(AAMString.getText().toString());
    			AAM = AAM*10;
    		} catch(NumberFormatException nfe) {
    			alertDialog(this);
    		}
    	}
    	awards = awards + AAM;

    	// Calculates Joint Service Achievement Medal
    	JSAAM = 0;
    	EditText JSAAMString = (EditText) findViewById(R.id.e6JSAAM);
    	if(JSAAMString.getText().toString().length() == 0){
    		JSAAM = 0;
    	}
    	else {
    		try {
    			JSAAM = Integer.parseInt(JSAAMString.getText().toString());
    			JSAAM = JSAAM*10;
    		} catch(NumberFormatException nfe) {
    			alertDialog(this);
    		}
    	}
    	awards = awards + JSAAM;

    	// Calculates Reserve Component Achievement Medal
    	RCAAM = 0;
    	EditText RCAAMString = (EditText) findViewById(R.id.e6RCAAM);
    	if(RCAAMString.getText().toString().length() == 0){
    		RCAAM = 0;
    	}
    	else {
    		try {
    			RCAAM = Integer.parseInt(RCAAMString.getText().toString());
    			RCAAM = RCAAM*10;
    		} catch(NumberFormatException nfe) {
    			alertDialog(this);
    		}
    	}
    	awards = awards + RCAAM;

    	// Calculates Armed Forces Reserve Medal
    	armedForces = 0;
    	EditText armedForcesString = (EditText) findViewById(R.id.e6AFRM);
    	if(armedForcesString.getText().toString().length() == 0){
    		armedForces = 0;
    	}
    	else {
    		try {
    			armedForces = Integer.parseInt(armedForcesString.getText().toString());
    			armedForces = armedForces*10;
    		} catch(NumberFormatException nfe) {
    			alertDialog(this);
    		}
    	}
    	awards = awards + armedForces;

    	// Calculates Good Conduct Medal
    	GCM = 0;
    	EditText GCMString = (EditText) findViewById(R.id.e6GCM);
    	if(GCMString.getText().toString().length() == 0){
    		GCM = 0;
    	}
    	else {
    		try {
    			GCM = Integer.parseInt(GCMString.getText().toString());
    			GCM = GCM*10;
    		} catch(NumberFormatException nfe) {
    			alertDialog(this);
    		}
    	}
    	awards = awards + GCM;

    	// Calculates Outstanding Volunteer Service Medal
    	volunteer = 0;
    	EditText volunteerString = (EditText) findViewById(R.id.e6volunteer);
    	if(volunteerString.getText().toString().length() == 0){
    		volunteer = 0;
    	}
    	else {
    		try {
    			volunteer = Integer.parseInt(volunteerString.getText().toString());
    			volunteer = volunteer*10;
    		} catch(NumberFormatException nfe) {
    			alertDialog(this);
    		}
    	}
    	awards = awards + volunteer;

    	// Calculates Certificates of Achievement, limit of 20 points
    	COA = 0;
    	EditText COAString = (EditText) findViewById(R.id.e6COA);
    	if(COAString.getText().toString().length() == 0){
    		COA = 0;
    	}
    	else {
    		try {
    			COA = Integer.parseInt(COAString.getText().toString());
    			if (COA > 4) {
    				COA = 4;
    			}
    			COA = COA*5;
    		} catch(NumberFormatException nfe) {
    			alertDialog(this);
    		}
    	}
    	awards = awards + COA;
    	
    	// Checking if Combat Infantry Badge is checked
    	comInBad = 0;
    	CheckBox comInBadCheck = (CheckBox) findViewById(R.id.e6CIB);
    	if (comInBadCheck.isChecked()) {
    		comInBad = 30;
    	}
    	else {
    		comInBad = 0;
    	}
    	awards = awards + comInBad;
    	
    	//Checking if Combat Medic Badge is checked
    	comMedBad = 0;
    	CheckBox comMedBadCheck = (CheckBox) findViewById(R.id.e6CMB);
    	if (comMedBadCheck.isChecked()) {
    		comMedBad = 30;
    	}
    	else {
    		comMedBad = 0;
    	}
    	awards = awards + comMedBad;
    	
    	//Checking if Expert Infantry Badge is checked
    	exInBad = 0;
    	CheckBox exInBadCheck = (CheckBox) findViewById(R.id.e6EIB);
    	if (exInBadCheck.isChecked()) {
    		exInBad = 30;
    	}
    	else {
    		exInBad = 0;
    	}
    	awards = awards + exInBad;
    	
    	//Checking if Combat Action Badge is checked
    	comActBad = 0;
    	CheckBox comActBadCheck = (CheckBox) findViewById(R.id.e6CAB);
    	if (comActBadCheck.isChecked()) {
    		comActBad = 30;
    	}
    	else {
    		comActBad = 0;
    	}
    	awards = awards + comActBad;
    	
    	//Checking if Expert Field Medical Badge is checked
    	exFieldMedBad = 0;
    	CheckBox exFieldMedBadCheck = (CheckBox) findViewById(R.id.e6EFMB);
    	if (exFieldMedBadCheck.isChecked()) {
    		exFieldMedBad = 30;
    	}
    	else {
    		exFieldMedBad = 0;
    	}
    	awards = awards + exFieldMedBad;
    	
    	//Checking if Presidential Service Badge is checked
    	presServBad = 0;
    	CheckBox presServBadCheck = (CheckBox) findViewById(R.id.e6presService);
    	if (presServBadCheck.isChecked()) {
    		presServBad = 15;
    	}
    	else {
    		presServBad = 0;
    	}
    	awards = awards + presServBad;
    	
    	//Checking if Vice Presidential Service Badge is checked
    	vicePresServBad = 0;
    	CheckBox vicePresServBadCheck = (CheckBox) findViewById(R.id.e6vpService);
    	if (vicePresServBadCheck.isChecked()) {
    		vicePresServBad = 15;
    	}
    	else {
    		vicePresServBad = 0;
    	}
    	awards = awards + vicePresServBad;
    	
    	//Checking if Drill Sergeant Badge is checked
    	drillBad = 0;
    	CheckBox drillBadCheck = (CheckBox) findViewById(R.id.e6drill);
    	if (drillBadCheck.isChecked()) {
    		drillBad = 15;
    	}
    	else {
    		drillBad = 0;
    	}
    	awards = awards + drillBad;
    	
    	//Checking if Parachute Rigger Badge is checked
    	paraRiggerBad = 0;
    	CheckBox paraRiggerBadCheck = (CheckBox) findViewById(R.id.e6rigger);
    	if (paraRiggerBadCheck.isChecked()) {
    		paraRiggerBad = 10;
    	}
    	else {
    		paraRiggerBad = 0;
    	}
    	awards = awards + paraRiggerBad;
    	
    	//Checking if Diver Badge is checked
    	diverBad = 0;
    	CheckBox diverBadCheck = (CheckBox) findViewById(R.id.e6diver);
    	if (diverBadCheck.isChecked()) {
    		diverBad = 10;
    	}
    	else {
    		diverBad = 0;
    	}
    	awards = awards + diverBad;
    	
    	//Checking if Pathfinder Badge is checked
    	pathfinderBad = 0;
    	CheckBox pathfinderBadCheck = (CheckBox) findViewById(R.id.e6pathfinder);
    	if (pathfinderBadCheck.isChecked()) {
    		pathfinderBad = 10;
    	}
    	else {
    		pathfinderBad = 0;
    	}
    	awards = awards + pathfinderBad;
    	
    	//Checking if Aircraft Crew Badge is checked
    	airCrewBad = 0;
    	CheckBox airCrewBadCheck = (CheckBox) findViewById(R.id.e6airCrew);
    	if (airCrewBadCheck.isChecked()) {
    		airCrewBad = 10;
    	}
    	else {
    		airCrewBad = 0;
    	}
    	awards = awards + airCrewBad;
    	
    	//Checking if Air Assault Badge is checked
    	airAssBad = 0;
    	CheckBox airAssBadCheck = (CheckBox) findViewById(R.id.e6airAss);
    	if (airAssBadCheck.isChecked()) {
    		airAssBad = 10;
    	}
    	else {
    		airAssBad = 0;
    	}
    	awards = awards + airAssBad;
    	
    	//Checking if Space Badge is checked
    	spaceBad = 0;
    	CheckBox spaceBadCheck = (CheckBox) findViewById(R.id.e6space);
    	if (spaceBadCheck.isChecked()) {
    		spaceBad = 10;
    	}
    	else {
    		spaceBad = 0;
    	}
    	awards = awards + spaceBad;
    	
    	//Checking if Tomb Guard Badge is checked
    	tombGuardBad = 0;
    	CheckBox tombGuardBadCheck = (CheckBox) findViewById(R.id.e6tombGuard);
    	if (tombGuardBadCheck.isChecked()) {
    		tombGuardBad = 10;
    	}
    	else {
    		tombGuardBad = 0;
    	}
    	awards = awards + tombGuardBad;
    	
    	//Checking if Secretary of Defense Service Badge is checked
    	secDefServBad = 0;
    	CheckBox secDefServBadCheck = (CheckBox) findViewById(R.id.e6SecDef);
    	if (secDefServBadCheck.isChecked()) {
    		secDefServBad = 10;
    	}
    	else {
    		secDefServBad = 0;
    	}
    	awards = awards + secDefServBad;
    	
    	//Checking if Joint Chiefs of Staff Service Badge is checked
    	jointChiefBad = 0;
    	CheckBox jointChiefBadCheck = (CheckBox) findViewById(R.id.e6JStaff);
    	if (jointChiefBadCheck.isChecked()) {
    		jointChiefBad = 10;
    	}
    	else {
    		jointChiefBad = 0;
    	}
    	awards = awards + jointChiefBad;
    	
    	//Checking if Army Staff Badge is checked
    	armyStaffBad = 0;
    	CheckBox armyStaffBadCheck = (CheckBox) findViewById(R.id.e6AStaff);
    	if (armyStaffBadCheck.isChecked()) {
    		armyStaffBad = 10;
    	}
    	else {
    		armyStaffBad = 0;
    	}
    	awards = awards + armyStaffBad;
    	
    	//Checking if Airborne Advantage is checked
    	airborneAdvantage = 0;
    	CheckBox airborneAdvantageCheck = (CheckBox) findViewById(R.id.e6airAdvan);
    	if (airborneAdvantageCheck.isChecked()) {
    		airborneAdvantage = 10;
    	}
    	else {
    		airborneAdvantage = 0;
    	}
    	awards = awards + airborneAdvantage;
    	
    	//Checking if Driver and Mechanic Badge is checked
    	driverandMechBad = 0;
    	CheckBox driverandMechBadCheck = (CheckBox) findViewById(R.id.e6drivers);
    	if (driverandMechBadCheck.isChecked()) {
    		driverandMechBad = 10;
    	}
    	else {
    		driverandMechBad = 0;
    	}
    	awards = awards + driverandMechBad;
    	
    	//Check if Parachutist's Badge LVL is selected
    	paraLevel = 0;
    	RadioButton paraButtonBasic = (RadioButton) findViewById(R.id.e6paraBasic);
    	RadioButton paraButtonSenior = (RadioButton) findViewById(R.id.e6paraSenior);
    	RadioButton paraButtonMaster = (RadioButton) findViewById(R.id.e6paraMaster);
    	if (paraButtonBasic.isChecked()) {
    		paraLevel = 10;
    	}
    	else if (paraButtonSenior.isChecked()) {
    		paraLevel = 15;
    	}
    	else if (paraButtonMaster.isChecked()) {
    		paraLevel = 20;
    	}
    	else {
    		paraLevel = 0;
    	}
    	awards = awards + paraLevel;
    	
    	//Check if EOD Badge LVL is selected
    	eodLevel = 0;
    	RadioButton eodLevelButtonBasic = (RadioButton) findViewById(R.id.e6eodBasic);
    	RadioButton eodLevelButtonSenior = (RadioButton) findViewById(R.id.e6eodSenior);
    	RadioButton eodLevelButtonMaster = (RadioButton) findViewById(R.id.e6eodMaster);
    	if (eodLevelButtonBasic.isChecked()) {
    		eodLevel = 10;
    	}
    	else if (eodLevelButtonSenior.isChecked()) {
    		eodLevel = 15;
    	}
    	else if (eodLevelButtonMaster.isChecked()) {
    		eodLevel = 20;
    	}
    	else {
    		eodLevel = 0;
    	}
    	awards = awards + eodLevel;
    	
    	//Check if Recruiter Badge LVL is selected
    	recruiterLevel = 0;
    	RadioButton recruiterLevelButtonBasic = (RadioButton) findViewById(R.id.e6recruitBasic);
    	RadioButton recruiterLevelButtonGold = (RadioButton) findViewById(R.id.e6recruitGold);
    	RadioButton recruiterLevelButtonMaster = (RadioButton) findViewById(R.id.e6recruitMaster);
    	if (recruiterLevelButtonBasic.isChecked()) {
    		recruiterLevel = 10;
    	}
    	else if (recruiterLevelButtonGold.isChecked()) {
    		recruiterLevel = 15;
    	}
    	else if (recruiterLevelButtonMaster.isChecked()) {
    		recruiterLevel = 20;
    	}
    	else {
    		recruiterLevel = 0;
    	}
    	awards = awards + recruiterLevel;
    	
    	// Sets the max points available for e6 awards to 165
    	if (awards > 165) {
    		awards = 165;
    	}
    	
    	/* Beginning the Military Education calculations */
    	
    	//Checking if alc Graduate is checked
    	alc = 0;
    	CheckBox alcCheck = (CheckBox) findViewById(R.id.e6alcGrad);
    	if (alcCheck.isChecked()) {
    		alc = 90;
    	}
    	else {
    		alc = 0;
    	}
    	milEd = milEd + alc;
    	
    	//Checking if alc Commandant's List is checked
    	alcCommandants = 0;
    	CheckBox alcCommandantsCheck = (CheckBox) findViewById(R.id.e6commList);
    	if (alcCommandantsCheck.isChecked()) {
    		alcCommandants = 11;
    	}
    	else {
    		alcCommandants = 0;
    	}
    	milEd = milEd + alcCommandants;
    	
    	//Checking if alc Distinguished Honor or Leadership Award is checked
    	alcHonor = 0;
    	CheckBox alcHonorCheck = (CheckBox) findViewById(R.id.e6distGrad);
    	if (alcHonorCheck.isChecked()) {
    		alcHonor = 11;
    	}
    	else {
    		alcHonor = 0;
    	}
    	milEd = milEd + alcHonor;
    	
    	//Checking if Ranger School is checked
    	rangerSchool = 0;
    	CheckBox rangerSchoolCheck = (CheckBox) findViewById(R.id.e6ranger);
    	if (rangerSchoolCheck.isChecked()) {
    		rangerSchool = 40;
    	}
    	else {
    		rangerSchool = 0;
    	}
    	resPoints = resPoints + rangerSchool;
    	
    	//Checking if Special Forces Qualification Course is checked
    	specForcesCourse = 0;
    	CheckBox specForcesCourseCheck = (CheckBox) findViewById(R.id.e6specForces);
    	if (specForcesCourseCheck.isChecked()) {
    		specForcesCourse = 40;
    	}
    	else {
    		specForcesCourse = 0;
    	}
    	resPoints = resPoints + specForcesCourse;
    	
    	//Checking if Sapper Qualification Course is checked
    	sapperCourse = 0;
    	CheckBox sapperCourseCheck = (CheckBox) findViewById(R.id.e6sapper);
    	if (sapperCourseCheck.isChecked()) {
    		sapperCourse = 40;
    	}
    	else {
    		sapperCourse = 0;
    	}
    	resPoints = resPoints + sapperCourse;
    	
    	//Checking if Army Maint. Management Course is checked
    	armyMaintManage = 0;
    	CheckBox armyMaintManageCheck = (CheckBox) findViewById(R.id.e6AMMSC);
    	if (armyMaintManageCheck.isChecked()) {
    		armyMaintManage = 10;
    	}
    	else {
    		armyMaintManage = 0;
    	}
    	resPoints = resPoints + armyMaintManage;
    	
    	//Checking if Prescribed Load Course is checked
    	prescribedLoadListClerk = 0;
    	CheckBox prescribedLoadListClerkCheck = (CheckBox) findViewById(R.id.e6PLLC);
    	if (prescribedLoadListClerkCheck.isChecked()) {
    		prescribedLoadListClerk = 10;
    	}
    	else {
    		prescribedLoadListClerk = 0;
    	}
    	resPoints = resPoints + prescribedLoadListClerk;
    	
    	//Checking if Motor Pool Management Course is checked
    	motorPoolManage = 0;
    	CheckBox motorPoolManageCheck = (CheckBox) findViewById(R.id.e6MPOP);
    	if (motorPoolManageCheck.isChecked()) {
    		motorPoolManage = 10;
    	}
    	else {
    		motorPoolManage = 0;
    	}
    	resPoints = resPoints + motorPoolManage;
    	
    	//Checking if Generator Operator Course is checked
    	genOperCourse = 0;
    	CheckBox genOperCourseCheck = (CheckBox) findViewById(R.id.e6GenOp);
    	if (genOperCourseCheck.isChecked()) {
    		genOperCourse = 10;
    	}
    	else {
    		genOperCourse = 0;
    	}
    	resPoints = resPoints + genOperCourse;
    	
    	//Checking if Fuel Handlers Course is checked
    	fuelHandlersCourse = 0;
    	CheckBox fuelHandlersCourseCheck = (CheckBox) findViewById(R.id.e6fuelHandle);
    	if (fuelHandlersCourseCheck.isChecked()) {
    		fuelHandlersCourse = 10;
    	}
    	else {
    		fuelHandlersCourse = 0;
    	}
    	resPoints = resPoints + fuelHandlersCourse;
    	
    	//Checking if Basic Welding Course is checked
    	basicWeldingCourse = 0;
    	CheckBox basicWeldingCourseCheck = (CheckBox) findViewById(R.id.e6basicWeld);
    	if (basicWeldingCourseCheck.isChecked()) {
    		basicWeldingCourse = 10;
    	}
    	else {
    		basicWeldingCourse = 0;
    	}
    	resPoints = resPoints + basicWeldingCourse;
    	
    	//Checking if Forklift Operator Course is checked
    	forkliftOperatorCourse = 0;
    	CheckBox forkliftOperatorCourseCheck = (CheckBox) findViewById(R.id.e6forkOp);
    	if (forkliftOperatorCourseCheck.isChecked()) {
    		forkliftOperatorCourse = 10;
    	}
    	else {
    		forkliftOperatorCourse = 0;
    	}
    	resPoints = resPoints + forkliftOperatorCourse;
    	
    	//Checking if Bus Driver Course is checked
    	busDriverCourse = 0;
    	CheckBox busDriverCourseCheck = (CheckBox) findViewById(R.id.e6busDrive);
    	if (busDriverCourseCheck.isChecked()) {
    		busDriverCourse = 10;
    	}
    	else {
    		busDriverCourse = 0;
    	}
    	resPoints = resPoints + busDriverCourse;
    	
    	//Checking if Unit Supply Clerk Course is checked
    	unitSupplyClerkCourse = 0;
    	CheckBox unitSupplyClerkCourseCheck = (CheckBox) findViewById(R.id.e6unitSupply);
    	if (unitSupplyClerkCourseCheck.isChecked()) {
    		unitSupplyClerkCourse = 10;
    	}
    	else {
    		unitSupplyClerkCourse = 0;
    	}
    	resPoints = resPoints + unitSupplyClerkCourse;
    	
    	//Checking if Unit Supply Management Course is checked
    	unitSupplyManageCourse = 0;
    	CheckBox unitSupplyManageCourseCheck = (CheckBox) findViewById(R.id.e6unitSupplyOps);
    	if (unitSupplyManageCourseCheck.isChecked()) {
    		unitSupplyManageCourse = 10;
    	}
    	else {
    		unitSupplyManageCourse = 0;
    	}
    	resPoints = resPoints + unitSupplyManageCourse;
    	
    	//Checking if Unit Armorer Course is checked
    	unitArmorCourse = 0;
    	CheckBox unitArmorCourseCheck = (CheckBox) findViewById(R.id.e6unitArmor);
    	if (unitArmorCourseCheck.isChecked()) {
    		unitArmorCourse = 10;
    	}
    	else {
    		unitArmorCourse = 0;
    	}
    	resPoints = resPoints + unitArmorCourse;
    	
    	//Checking if CBRN Defense Course is checked
    	CBRNDefCourse = 0;
    	CheckBox CBRNDefCourseCheck = (CheckBox) findViewById(R.id.e6CBRNDef);
    	if (CBRNDefCourseCheck.isChecked()) {
    		CBRNDefCourse = 10;
    	}
    	else {
    		CBRNDefCourse = 0;
    	}
    	resPoints = resPoints + CBRNDefCourse;
    	
    	//Checking if Unit Postal Clerk Course is checked
    	unitPostalClerkCourse = 0;
    	CheckBox unitPostalClerkCourseCheck = (CheckBox) findViewById(R.id.e6unitPostal);
    	if (unitPostalClerkCourseCheck.isChecked()) {
    		unitPostalClerkCourse = 10;
    	}
    	else {
    		unitPostalClerkCourse = 0;
    	}
    	resPoints = resPoints + unitPostalClerkCourse;
    	
    	//Checking if Disk Operating System Course is checked
    	diskOperatingSystem = 0;
    	CheckBox diskOperatingSystemCheck = (CheckBox) findViewById(R.id.e6diskOp);
    	if (diskOperatingSystemCheck.isChecked()) {
    		diskOperatingSystem = 10;
    	}
    	else {
    		diskOperatingSystem = 0;
    	}
    	resPoints = resPoints + diskOperatingSystem;
    	
    	//Checking if Word Processing Course is checked
    	wordProcessingCourse = 0;
    	CheckBox wordProcessingCourseCheck = (CheckBox) findViewById(R.id.e6wordProcess);
    	if (wordProcessingCourseCheck.isChecked()) {
    		wordProcessingCourse = 10;
    	}
    	else {
    		wordProcessingCourse = 0;
    	}
    	resPoints = resPoints + wordProcessingCourse;
    	
    	//Checking if Database Management Course is checked
    	databaseManageCourse = 0;
    	CheckBox databaseManageCourseCheck = (CheckBox) findViewById(R.id.e6dataManage);
    	if (databaseManageCourseCheck.isChecked()) {
    		databaseManageCourse = 10;
    	}
    	else {
    		databaseManageCourse = 0;
    	}
    	resPoints = resPoints + databaseManageCourse;
    	
    	//Checking if Unit Logistics Course is checked
    	unitLevelLogistics = 0;
    	CheckBox unitLevelLogisticsCheck = (CheckBox) findViewById(R.id.e6unitLog);
    	if (unitLevelLogisticsCheck.isChecked()) {
    		unitLevelLogistics = 10;
    	}
    	else {
    		unitLevelLogistics = 0;
    	}
    	resPoints = resPoints + unitLevelLogistics;
    	
    	//Calculates Resident Military Education Points
    	milResidentTrainingHours = 0;
    	EditText milResidentTrainingHoursString = (EditText) findViewById(R.id.e6otherResHours);
    	if(milResidentTrainingHoursString.getText().toString().length() == 0){
    		milResidentTrainingHours = 0;
    	}
    	else {
    		try {
    			milResidentTrainingHours = Integer.parseInt(milResidentTrainingHoursString.getText().toString());
    			milResidentTrainingHours = milResidentTrainingHours/10;
    		} catch(NumberFormatException nfe) {
    			alertDialog(this);
    		}
    	}
    	resPoints = resPoints + milResidentTrainingHours;
    	
    	//Calculates ACCP Military Education Points
    	accpHours = 0;
    	EditText accpHoursString = (EditText) findViewById(R.id.e6accpHours);
    	if(accpHoursString.getText().toString().length() == 0){
    		accpHours = 0;
    	}
    	else {
    		try {
    			accpHours = Integer.parseInt(accpHoursString.getText().toString());
    			accpHours = accpHours/5;
    		} catch(NumberFormatException nfe) {
    			alertDialog(this);
    		}
    	}
    	ePoints = ePoints + accpHours;
    	
    	
    	
    	// 84 points is max allowed for e6 in resident and eLearning Points
    	if (resPoints > 84) {
    		resPoints = 84;
    	}
    	if (ePoints > 84) {
    		ePoints = 84;
    	}
    	milEd = milEd + resPoints + ePoints;
    	
    	
    	
    	/* Beginning calculations for "Civilian Education" category */
    	
    	//Calculates Semester Hour Points
    	semesterHours = 0;
    	EditText semesterHoursString = (EditText) findViewById(R.id.e6semHours);
    	if(semesterHoursString.getText().toString().length() == 0){
    		semesterHours = 0;
    	}
    	else {
    		try {
    			semesterHours = Integer.parseInt(semesterHoursString.getText().toString());
    		} catch(NumberFormatException nfe) {
    			alertDialog(this);
    		}
    	}
    	civEd = civEd + semesterHours;
    	
    	//Calculates Technical Certifications Points
    	techCerts = 0;
    	EditText techCertsString = (EditText) findViewById(R.id.e6techCerts);
    	if(techCertsString.getText().toString().length() == 0){
    		techCerts = 0;
    	}
    	else {
    		try {
    			techCerts = Integer.parseInt(techCertsString.getText().toString());
    			techCerts = techCerts*10;
    		} catch(NumberFormatException nfe) {
    			alertDialog(this);
    		}
    	}
    	if (techCerts > 50) {
    		techCerts = 50;
    	}
    	civEd = civEd + techCerts;
    	
    	//Calculates Language Proficiency Test Points
    	defLanTests = 0;
    	EditText defLanTestsString = (EditText) findViewById(R.id.e6dlpt);
    	if(defLanTestsString.getText().toString().length() == 0){
    		defLanTests = 0;
    	}
    	else {
    		try {
    			defLanTests = Integer.parseInt(defLanTestsString.getText().toString());
    			defLanTests = defLanTests*10;
    		} catch(NumberFormatException nfe) {
    			alertDialog(this);
    		}
    	}
    	civEd = civEd + defLanTests;
    	
    	//Checking if Degree Completion is checked
    	degCompletion = 0;
    	CheckBox degCompletionCheck = (CheckBox) findViewById(R.id.e6degCompletion);
    	if (degCompletionCheck.isChecked()) {
    		degCompletion = 10;
    	}
    	else {
    		degCompletion = 0;
    	}
    	civEd = civEd + degCompletion;
    	
    	if (civEd > 100) {
    		civEd = 100;
    	}
    	
    	pointsTotal = milTraining + awards + milEd + civEd;
    	if (error == 0) {
    		TOTALalertDialog(this);
    	}
    	
    	
    }
}