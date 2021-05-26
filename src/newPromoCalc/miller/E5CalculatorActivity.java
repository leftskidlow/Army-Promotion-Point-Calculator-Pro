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

public class E5CalculatorActivity extends Activity {
	
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
	private int wlc;
	private int wlcCommandants;
	private int wlcHonor;
	/* Used in E6 Calcuations
	private int alc;
	private int alcCommandants;
	private int alcHonor;
	*/
	
	/**Civilian Education Variables*/
	private int semesterHours;
	private int techCerts;
	private int defLanTests;
	private int degCompletion;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createSpinner1();
  //      AlertDialog.Builder builder = new AlertDialog.Builder(this);
   //     builder.setMessage("Are you sure you want to exit?")
    //           .setCancelable(false)
     //          .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
      //             public void onClick(DialogInterface dialog, int id) {
       //         	   E5CalculatorActivity.this.finish();
        //           }
         //      })
          //     .setNegativeButton("No", new DialogInterface.OnClickListener() {
           //        public void onClick(DialogInterface dialog, int id) {
            //            dialog.cancel();
             //      }
              // });
     //   AlertDialog alert = builder.create();	
    }
    
    public void createSpinner1 () {
    	setContentView(R.layout.e5_main);
        Spinner spinner = (Spinner) findViewById(R.id.e5weapCardSpinner);
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
   
    public void alertDialog (E5CalculatorActivity E5CalculatorActivity){
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
    
    public void WEAPONalertDialog (E5CalculatorActivity E5CalculatorActivity){
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
    
    public void TOTALalertDialog (E5CalculatorActivity E5CalculatorActivity){
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
          		setContentView(R.layout.e5_main);
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
    	EditText apftString = (EditText) findViewById(R.id.e5apftScore);
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
    	else if (apftScore >= 180) {
    		apftPoints = apftScore-140;
    	}
    	
    	/** Calculates Deployment Points based on user input */
    	deployMonths = 0;
    	EditText deployString = (EditText) findViewById(R.id.e5deployMonths);
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
    	//Makes sure that the deployment points don't go over the 30 max.
    	if (monthsDeployPoints > 30) {
    		monthsDeployPoints = 30;
    	}
    	
    	/** Calculates Weapon Qualification Points based on user input
    	     This was easily the most difficult thing for me to figure out...
    	     Only because I forgot to add the click listener into the main method... */
    	weapQual = 0;
    	EditText weapQualString = (EditText) findViewById(R.id.e5weapScore);
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
    			weapQualPoints=160;
    		}
    		else if (weapQual==39){
    			weapQualPoints=153;
    		}
    		else if (weapQual==38){
    			weapQualPoints=145;
    		}
    		else if (weapQual==37){
    			weapQualPoints=138;
    		}
    		else if (weapQual==36){
    			weapQualPoints=130;
    		}
    		else if (weapQual==35){
    			weapQualPoints=123;
    		}
    		else if (weapQual==34){
    			weapQualPoints=115;
    		}
    		else if (weapQual==33){
    			weapQualPoints=108;
    		}
    		else if (weapQual==32){
    			weapQualPoints=100;
    		}
    		else if (weapQual==31){
    			weapQualPoints=93;
    		}
    		else if (weapQual==30){
    			weapQualPoints=85;
    		}
    		else if (weapQual==29){
    			weapQualPoints=78;
    		}
    		else if (weapQual==28){
    			weapQualPoints=70;
    		}
    		else if (weapQual==27){
    			weapQualPoints=63;
    		}
    		else if (weapQual==26){
    			weapQualPoints=55;
    		}
    		else if (weapQual==25){
    			weapQualPoints=48;
    		}
    		else if (weapQual==24){
    			weapQualPoints=40;
    		}
    		else if (weapQual==23){
    			weapQualPoints=33;
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
    			weapQualPoints=160;
    		}
    		else if (weapQual==199){
    			weapQualPoints=152;
    		}
    		else if (weapQual==197){
    			weapQualPoints=145;
    		}
    		else if (weapQual==195){
    			weapQualPoints=138;
    		}
    		else if (weapQual==193){
    			weapQualPoints=131;
    		}
    		else if (weapQual==189){
    			weapQualPoints=124;
    		}
    		else if (weapQual==186){
    			weapQualPoints=117;
    		}
    		else if (weapQual==182){
    			weapQualPoints=110;
    		}
    		else if (weapQual==180){
    			weapQualPoints=103;
    		}
    		else if (weapQual==178){
    			weapQualPoints=96;
    		}
    		else if (weapQual==176){
    			weapQualPoints=89;
    		}
    		else if (weapQual==174){
    			weapQualPoints=82;
    		}
    		else if (weapQual==172){
    			weapQualPoints=75;
    		}
    		else if (weapQual==170){
    			weapQualPoints=68;
    		}
    		else if (weapQual==168){
    			weapQualPoints=61;
    		}
    		else if (weapQual==166){
    			weapQualPoints=54;
    		}
    		else if (weapQual==164){
    			weapQualPoints=47;
    		}
    		else if (weapQual==161){
    			weapQualPoints=40;
    		}
    		else if (weapQual==158){
    			weapQualPoints=33;
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
    			weapQualPoints=160;
    		}
    		else if (weapQual==225){
    			weapQualPoints=152;
    		}
    		else if (weapQual==223){
    			weapQualPoints=145;
    		}
    		else if (weapQual==221){
    			weapQualPoints=138;
    		}
    		else if (weapQual==218){
    			weapQualPoints=131;
    		}
    		else if (weapQual==215){
    			weapQualPoints=124;
    		}
    		else if (weapQual==212){
    			weapQualPoints=117;
    		}
    		else if (weapQual==209){
    			weapQualPoints=110;
    		}
    		else if (weapQual==206){
    			weapQualPoints=103;
    		}
    		else if (weapQual==203){
    			weapQualPoints=96;
    		}
    		else if (weapQual==201){
    			weapQualPoints=89;
    		}
    		else if (weapQual==198){
    			weapQualPoints=82;
    		}
    		else if (weapQual==196){
    			weapQualPoints=75;
    		}
    		else if (weapQual==193){
    			weapQualPoints=68;
    		}
    		else if (weapQual==191){
    			weapQualPoints=61;
    		}
    		else if (weapQual==188){
    			weapQualPoints=54;
    		}
    		else if (weapQual==186){
    			weapQualPoints=47;
    		}
    		else if (weapQual==183){
    			weapQualPoints=40;
    		}
    		else if (weapQual==180){
    			weapQualPoints=33;
    		}
    		break;
    	}
    	
    	while (formSelect==4) {
    		if (weapQual>30|weapQual<16) {
    			WEAPONalertDialog(this);
    			break;
    		}
    		else if (weapQual==30){
    			weapQualPoints=160;
    		}
    		else if (weapQual==29){
    			weapQualPoints=151;
    		}
    		else if (weapQual==28){
    			weapQualPoints=142;
    		}
    		else if (weapQual==27){
    			weapQualPoints=133;
    		}
    		else if (weapQual==26){
    			weapQualPoints=124;
    		}
    		else if (weapQual==25){
    			weapQualPoints=115;
    		}
    		else if (weapQual==24){
    			weapQualPoints=106;
    		}
    		else if (weapQual==23){
    			weapQualPoints=97;
    		}
    		else if (weapQual==22){
    			weapQualPoints=88;
    		}
    		else if (weapQual==21){
    			weapQualPoints=79;
    		}
    		else if (weapQual==20){
    			weapQualPoints=70;
    		}
    		else if (weapQual==19){
    			weapQualPoints=61;
    		}
    		else if (weapQual==18){
    			weapQualPoints=52;
    		}
    		else if (weapQual==17){
    			weapQualPoints=43;
    		}
    		else if (weapQual==16){
    			weapQualPoints=33;
    		}
    		break;
    	}
    	
        while (formSelect==5) {
    		if (weapQual>40|weapQual<24) {
    			WEAPONalertDialog(this);
    			break;
    		}
    		else if (weapQual==40){
    			weapQualPoints=160;
    		}
    		else if (weapQual==39){
    			weapQualPoints=152;
    		}
    		else if (weapQual==38){
    			weapQualPoints=144;
    		}
    		else if (weapQual==37){
    			weapQualPoints=136;
    		}
    		else if (weapQual==36){
    			weapQualPoints=128;
    		}
    		else if (weapQual==35){
    			weapQualPoints=120;
    		}
    		else if (weapQual==34){
    			weapQualPoints=112;
    		}
    		else if (weapQual==33){
    			weapQualPoints=104;
    		}
    		else if (weapQual==32){
    			weapQualPoints=96;
    		}
    		else if (weapQual==31){
    			weapQualPoints=88;
    		}
    		else if (weapQual==30){
    			weapQualPoints=80;
    		}
    		else if (weapQual==29){
    			weapQualPoints=72;
    		}
    		else if (weapQual==28){
    			weapQualPoints=64;
    		}
    		else if (weapQual==27){
    			weapQualPoints=56;
    		}
    		else if (weapQual==26){
    			weapQualPoints=48;
    		}
    		else if (weapQual==25){
    			weapQualPoints=40;
    		}
    		else if (weapQual==24){
    			weapQualPoints=33;
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
    			weapQualPoints=160;
    		}
    		else if (weapQual==105){
    			weapQualPoints=153;
    		}
    		else if (weapQual==104){
    			weapQualPoints=146;
    		}
    		else if (weapQual==102){
    			weapQualPoints=139;
    		}
    		else if (weapQual==100){
    			weapQualPoints=132;
    		}
    		else if (weapQual==96){
    			weapQualPoints=125;
    		}
    		else if (weapQual==94){
    			weapQualPoints=118;
    		}
    		else if (weapQual==90){
    			weapQualPoints=111;
    		}
    		else if (weapQual==89){
    			weapQualPoints=104;
    		}
    		else if (weapQual==87){
    			weapQualPoints=97;
    		}
    		else if (weapQual==85){
    			weapQualPoints=90;
    		}
    		else if (weapQual==83){
    			weapQualPoints=83;
    		}
    		else if (weapQual==81){
    			weapQualPoints=76;
    		}
    		else if (weapQual==80){
    			weapQualPoints=69;
    		}
    		else if (weapQual==79){
    			weapQualPoints=62;
    		}
    		else if (weapQual==77){
    			weapQualPoints=55;
    		}
    		else if (weapQual==75){
    			weapQualPoints=48;
    		}
    		else if (weapQual==73){
    			weapQualPoints=41;
    		}
    		else if (weapQual==70){
    			weapQualPoints=33;
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
    			weapQualPoints=160;
    		}
    		else if (weapQual==294){
    			weapQualPoints=155;
    		}
    		else if (weapQual==290){
    			weapQualPoints=150;
    		}
    		else if (weapQual==286){
    			weapQualPoints=145;
    		}
    		else if (weapQual==284){
    			weapQualPoints=141;
    		}
    		else if (weapQual==280){
    			weapQualPoints=136;
    		}
    		else if (weapQual==278){
    			weapQualPoints=131;
    		}
    		else if (weapQual==276){
    			weapQualPoints=126;
    		}
    		else if (weapQual==274){
    			weapQualPoints=122;
    		}
    		else if (weapQual==270){
    			weapQualPoints=117;
    		}
    		else if (weapQual==266){
    			weapQualPoints=112;
    		}
    		else if (weapQual==262){
    			weapQualPoints=107;
    		}
    		else if (weapQual==258){
    			weapQualPoints=103;
    		}
    		else if (weapQual==256){
    			weapQualPoints=98;
    		}
    		else if (weapQual==254){
    			weapQualPoints=93;
    		}
    		else if (weapQual==252){
    			weapQualPoints=88;
    		}
    		else if (weapQual==248){
    			weapQualPoints=84;
    		}
    		else if (weapQual==244){
    			weapQualPoints=79;
    		}
    		else if (weapQual==241){
    			weapQualPoints=74;
    		}
    		else if (weapQual==237){
    			weapQualPoints=69;
    		}
    		else if (weapQual==233){
    			weapQualPoints=65;
    		}
    		else if (weapQual==229){
    			weapQualPoints=60;
    		}
    		else if (weapQual==225){
    			weapQualPoints=55;
    		}
    		else if (weapQual==221){
    			weapQualPoints=50;
    		}
    		else if (weapQual==217){
    			weapQualPoints=46;
    		}
    		else if (weapQual==213){
    			weapQualPoints=40;
    		}
    		else if (weapQual==211){
    			weapQualPoints=33;
    		}
    		break;
    	}
        while (formSelect==8) {
    		if (weapQual>50|weapQual<35) {
    			WEAPONalertDialog(this);
    			break;
    		}
    		else if (weapQual==50){
    			weapQualPoints=160;
    		}
    		else if (weapQual==49){
    			weapQualPoints=152;
    		}
    		else if (weapQual==48){
    			weapQualPoints=144;
    		}
    		else if (weapQual==47){
    			weapQualPoints=135;
    		}
    		else if (weapQual==46){
    			weapQualPoints=127;
    		}
    		else if (weapQual==45){
    			weapQualPoints=119;
    		}
    		else if (weapQual==44){
    			weapQualPoints=110;
    		}
    		else if (weapQual==43){
    			weapQualPoints=102;
    		}
    		else if (weapQual==42){
    			weapQualPoints=94;
    		}
    		else if (weapQual==41){
    			weapQualPoints=85;
    		}
    		else if (weapQual==40){
    			weapQualPoints=77;
    		}
    		else if (weapQual==39){
    			weapQualPoints=69;
    		}
    		else if (weapQual==38){
    			weapQualPoints=60;
    		}
    		else if (weapQual==37){
    			weapQualPoints=52;
    		}
    		else if (weapQual==36){
    			weapQualPoints=43;
    		}
    		else if (weapQual==35){
    			weapQualPoints=33;
    		}
    		break;
    	}
    	}
        /* This will calculate the total points that the Soldier receives in the "Military Training" category */
        milTraining = weapQualPoints + apftPoints + monthsDeployPoints;
        /* Ensures Soldier does not exceed the 340 allowed */
    	if (milTraining > 340) {
    		milTraining = 340;
    	}
    	
    	
    	/* Beginning the Awards and Decorations calculations. First will be the medals, followed by the badges */
    	
    	//Calculates Soldier's Medal & Higher
    	soldMedalPlus = 0;
    	EditText soldMedalString = (EditText) findViewById(R.id.e5soldMedalPlus);
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
    	EditText bronzeVString = (EditText) findViewById(R.id.e5bronzeStarV);
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
    	EditText bronzeString = (EditText) findViewById(R.id.e5bronzeStar);
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
    	EditText purpString = (EditText) findViewById(R.id.e5purpHeart);
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
    	EditText airVString = (EditText) findViewById(R.id.e5airMedalV);
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
    	EditText airString = (EditText) findViewById(R.id.e5airMedal);
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
    	EditText DMSMString = (EditText) findViewById(R.id.e5DMSM);
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
    	EditText MSMString = (EditText) findViewById(R.id.e5MSM);
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
    	EditText arcomVString = (EditText) findViewById(R.id.e5ARCOMV);
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
    	EditText arcomString = (EditText) findViewById(R.id.e5ARCOM);
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
    	EditText JSCOMString = (EditText) findViewById(R.id.e5JSCOM);
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
    	EditText AAMString = (EditText) findViewById(R.id.e5AAM);
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
    	EditText JSAAMString = (EditText) findViewById(R.id.e5JSAAM);
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
    	EditText RCAAMString = (EditText) findViewById(R.id.e5RCAAM);
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
    	EditText armedForcesString = (EditText) findViewById(R.id.e5AFRM);
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
    	EditText GCMString = (EditText) findViewById(R.id.e5GCM);
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
    	EditText volunteerString = (EditText) findViewById(R.id.e5volunteer);
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
    	EditText COAString = (EditText) findViewById(R.id.e5COA);
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
    	CheckBox comInBadCheck = (CheckBox) findViewById(R.id.e5CIB);
    	if (comInBadCheck.isChecked()) {
    		comInBad = 30;
    	}
    	else {
    		comInBad = 0;
    	}
    	awards = awards + comInBad;
    	
    	//Checking if Combat Medic Badge is checked
    	comMedBad = 0;
    	CheckBox comMedBadCheck = (CheckBox) findViewById(R.id.e5CMB);
    	if (comMedBadCheck.isChecked()) {
    		comMedBad = 30;
    	}
    	else {
    		comMedBad = 0;
    	}
    	awards = awards + comMedBad;
    	
    	//Checking if Expert Infantry Badge is checked
    	exInBad = 0;
    	CheckBox exInBadCheck = (CheckBox) findViewById(R.id.e5EIB);
    	if (exInBadCheck.isChecked()) {
    		exInBad = 30;
    	}
    	else {
    		exInBad = 0;
    	}
    	awards = awards + exInBad;
    	
    	//Checking if Combat Action Badge is checked
    	comActBad = 0;
    	CheckBox comActBadCheck = (CheckBox) findViewById(R.id.e5CAB);
    	if (comActBadCheck.isChecked()) {
    		comActBad = 30;
    	}
    	else {
    		comActBad = 0;
    	}
    	awards = awards + comActBad;
    	
    	//Checking if Expert Field Medical Badge is checked
    	exFieldMedBad = 0;
    	CheckBox exFieldMedBadCheck = (CheckBox) findViewById(R.id.e5EFMB);
    	if (exFieldMedBadCheck.isChecked()) {
    		exFieldMedBad = 30;
    	}
    	else {
    		exFieldMedBad = 0;
    	}
    	awards = awards + exFieldMedBad;
    	
    	//Checking if Presidential Service Badge is checked
    	presServBad = 0;
    	CheckBox presServBadCheck = (CheckBox) findViewById(R.id.e5presService);
    	if (presServBadCheck.isChecked()) {
    		presServBad = 15;
    	}
    	else {
    		presServBad = 0;
    	}
    	awards = awards + presServBad;
    	
    	//Checking if Vice Presidential Service Badge is checked
    	vicePresServBad = 0;
    	CheckBox vicePresServBadCheck = (CheckBox) findViewById(R.id.e5vpService);
    	if (vicePresServBadCheck.isChecked()) {
    		vicePresServBad = 15;
    	}
    	else {
    		vicePresServBad = 0;
    	}
    	awards = awards + vicePresServBad;
    	
    	//Checking if Drill Sergeant Badge is checked
    	drillBad = 0;
    	CheckBox drillBadCheck = (CheckBox) findViewById(R.id.e5drill);
    	if (drillBadCheck.isChecked()) {
    		drillBad = 15;
    	}
    	else {
    		drillBad = 0;
    	}
    	awards = awards + drillBad;
    	
    	//Checking if Parachute Rigger Badge is checked
    	paraRiggerBad = 0;
    	CheckBox paraRiggerBadCheck = (CheckBox) findViewById(R.id.e5rigger);
    	if (paraRiggerBadCheck.isChecked()) {
    		paraRiggerBad = 10;
    	}
    	else {
    		paraRiggerBad = 0;
    	}
    	awards = awards + paraRiggerBad;
    	
    	//Checking if Diver Badge is checked
    	diverBad = 0;
    	CheckBox diverBadCheck = (CheckBox) findViewById(R.id.e5diver);
    	if (diverBadCheck.isChecked()) {
    		diverBad = 10;
    	}
    	else {
    		diverBad = 0;
    	}
    	awards = awards + diverBad;
    	
    	//Checking if Pathfinder Badge is checked
    	pathfinderBad = 0;
    	CheckBox pathfinderBadCheck = (CheckBox) findViewById(R.id.e5pathfinder);
    	if (pathfinderBadCheck.isChecked()) {
    		pathfinderBad = 10;
    	}
    	else {
    		pathfinderBad = 0;
    	}
    	awards = awards + pathfinderBad;
    	
    	//Checking if Aircraft Crew Badge is checked
    	airCrewBad = 0;
    	CheckBox airCrewBadCheck = (CheckBox) findViewById(R.id.e5airCrew);
    	if (airCrewBadCheck.isChecked()) {
    		airCrewBad = 10;
    	}
    	else {
    		airCrewBad = 0;
    	}
    	awards = awards + airCrewBad;
    	
    	//Checking if Air Assault Badge is checked
    	airAssBad = 0;
    	CheckBox airAssBadCheck = (CheckBox) findViewById(R.id.e5airAss);
    	if (airAssBadCheck.isChecked()) {
    		airAssBad = 10;
    	}
    	else {
    		airAssBad = 0;
    	}
    	awards = awards + airAssBad;
    	
    	//Checking if Space Badge is checked
    	spaceBad = 0;
    	CheckBox spaceBadCheck = (CheckBox) findViewById(R.id.e5space);
    	if (spaceBadCheck.isChecked()) {
    		spaceBad = 10;
    	}
    	else {
    		spaceBad = 0;
    	}
    	awards = awards + spaceBad;
    	
    	//Checking if Tomb Guard Badge is checked
    	tombGuardBad = 0;
    	CheckBox tombGuardBadCheck = (CheckBox) findViewById(R.id.e5tombGuard);
    	if (tombGuardBadCheck.isChecked()) {
    		tombGuardBad = 10;
    	}
    	else {
    		tombGuardBad = 0;
    	}
    	awards = awards + tombGuardBad;
    	
    	//Checking if Secretary of Defense Service Badge is checked
    	secDefServBad = 0;
    	CheckBox secDefServBadCheck = (CheckBox) findViewById(R.id.e5SecDef);
    	if (secDefServBadCheck.isChecked()) {
    		secDefServBad = 10;
    	}
    	else {
    		secDefServBad = 0;
    	}
    	awards = awards + secDefServBad;
    	
    	//Checking if Joint Chiefs of Staff Service Badge is checked
    	jointChiefBad = 0;
    	CheckBox jointChiefBadCheck = (CheckBox) findViewById(R.id.e5JStaff);
    	if (jointChiefBadCheck.isChecked()) {
    		jointChiefBad = 10;
    	}
    	else {
    		jointChiefBad = 0;
    	}
    	awards = awards + jointChiefBad;
    	
    	//Checking if Army Staff Badge is checked
    	armyStaffBad = 0;
    	CheckBox armyStaffBadCheck = (CheckBox) findViewById(R.id.e5AStaff);
    	if (armyStaffBadCheck.isChecked()) {
    		armyStaffBad = 10;
    	}
    	else {
    		armyStaffBad = 0;
    	}
    	awards = awards + armyStaffBad;
    	
    	//Checking if Airborne Advantage is checked
    	airborneAdvantage = 0;
    	CheckBox airborneAdvantageCheck = (CheckBox) findViewById(R.id.e5airAdvan);
    	if (airborneAdvantageCheck.isChecked()) {
    		airborneAdvantage = 10;
    	}
    	else {
    		airborneAdvantage = 0;
    	}
    	awards = awards + airborneAdvantage;
    	
    	//Checking if Driver and Mechanic Badge is checked
    	driverandMechBad = 0;
    	CheckBox driverandMechBadCheck = (CheckBox) findViewById(R.id.e5drivers);
    	if (driverandMechBadCheck.isChecked()) {
    		driverandMechBad = 10;
    	}
    	else {
    		driverandMechBad = 0;
    	}
    	awards = awards + driverandMechBad;
    	
    	//Check if Parachutist's Badge LVL is selected
    	paraLevel = 0;
    	RadioButton paraButtonBasic = (RadioButton) findViewById(R.id.e5paraBasic);
    	RadioButton paraButtonSenior = (RadioButton) findViewById(R.id.e5paraSenior);
    	RadioButton paraButtonMaster = (RadioButton) findViewById(R.id.e5paraMaster);
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
    	RadioButton eodLevelButtonBasic = (RadioButton) findViewById(R.id.e5eodBasic);
    	RadioButton eodLevelButtonSenior = (RadioButton) findViewById(R.id.e5eodSenior);
    	RadioButton eodLevelButtonMaster = (RadioButton) findViewById(R.id.e5eodMaster);
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
    	RadioButton recruiterLevelButtonBasic = (RadioButton) findViewById(R.id.e5recruitBasic);
    	RadioButton recruiterLevelButtonGold = (RadioButton) findViewById(R.id.e5recruitGold);
    	RadioButton recruiterLevelButtonMaster = (RadioButton) findViewById(R.id.e5recruitMaster);
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
    	
    	// Sets the max points available for E5 awards to 125
    	if (awards > 125) {
    		awards = 125;
    	}
    	
    	/* Beginning the Military Education calculations */
    	
    	//Checking if WLC Graduate is checked
    	wlc = 0;
    	CheckBox wlcCheck = (CheckBox) findViewById(R.id.e5wlcGrad);
    	if (wlcCheck.isChecked()) {
    		wlc = 80;
    	}
    	else {
    		wlc = 0;
    	}
    	milEd = milEd + wlc;
    	
    	//Checking if WLC Commandant's List is checked
    	wlcCommandants = 0;
    	CheckBox wlcCommandantsCheck = (CheckBox) findViewById(R.id.e5commList);
    	if (wlcCommandantsCheck.isChecked()) {
    		wlcCommandants = 12;
    	}
    	else {
    		wlcCommandants = 0;
    	}
    	milEd = milEd + wlcCommandants;
    	
    	//Checking if WLC Distinguished Honor or Leadership Award is checked
    	wlcHonor = 0;
    	CheckBox wlcHonorCheck = (CheckBox) findViewById(R.id.e5distGrad);
    	if (wlcHonorCheck.isChecked()) {
    		wlcHonor = 12;
    	}
    	else {
    		wlcHonor = 0;
    	}
    	milEd = milEd + wlcHonor;
    	
    	//Checking if Ranger School is checked
    	rangerSchool = 0;
    	CheckBox rangerSchoolCheck = (CheckBox) findViewById(R.id.e5ranger);
    	if (rangerSchoolCheck.isChecked()) {
    		rangerSchool = 40;
    	}
    	else {
    		rangerSchool = 0;
    	}
    	resPoints = resPoints + rangerSchool;
    	
    	//Checking if Special Forces Qualification Course is checked
    	specForcesCourse = 0;
    	CheckBox specForcesCourseCheck = (CheckBox) findViewById(R.id.e5specForces);
    	if (specForcesCourseCheck.isChecked()) {
    		specForcesCourse = 40;
    	}
    	else {
    		specForcesCourse = 0;
    	}
    	resPoints = resPoints + specForcesCourse;
    	
    	//Checking if Sapper Qualification Course is checked
    	sapperCourse = 0;
    	CheckBox sapperCourseCheck = (CheckBox) findViewById(R.id.e5sapper);
    	if (sapperCourseCheck.isChecked()) {
    		sapperCourse = 40;
    	}
    	else {
    		sapperCourse = 0;
    	}
    	resPoints = resPoints + sapperCourse;
    	
    	//Checking if Army Maint. Management Course is checked
    	armyMaintManage = 0;
    	CheckBox armyMaintManageCheck = (CheckBox) findViewById(R.id.e5AMMSC);
    	if (armyMaintManageCheck.isChecked()) {
    		armyMaintManage = 10;
    	}
    	else {
    		armyMaintManage = 0;
    	}
    	resPoints = resPoints + armyMaintManage;
    	
    	//Checking if Prescribed Load Course is checked
    	prescribedLoadListClerk = 0;
    	CheckBox prescribedLoadListClerkCheck = (CheckBox) findViewById(R.id.e5PLLC);
    	if (prescribedLoadListClerkCheck.isChecked()) {
    		prescribedLoadListClerk = 10;
    	}
    	else {
    		prescribedLoadListClerk = 0;
    	}
    	resPoints = resPoints + prescribedLoadListClerk;
    	
    	//Checking if Motor Pool Management Course is checked
    	motorPoolManage = 0;
    	CheckBox motorPoolManageCheck = (CheckBox) findViewById(R.id.e5MPOP);
    	if (motorPoolManageCheck.isChecked()) {
    		motorPoolManage = 10;
    	}
    	else {
    		motorPoolManage = 0;
    	}
    	resPoints = resPoints + motorPoolManage;
    	
    	//Checking if Generator Operator Course is checked
    	genOperCourse = 0;
    	CheckBox genOperCourseCheck = (CheckBox) findViewById(R.id.e5GenOp);
    	if (genOperCourseCheck.isChecked()) {
    		genOperCourse = 10;
    	}
    	else {
    		genOperCourse = 0;
    	}
    	resPoints = resPoints + genOperCourse;
    	
    	//Checking if Fuel Handlers Course is checked
    	fuelHandlersCourse = 0;
    	CheckBox fuelHandlersCourseCheck = (CheckBox) findViewById(R.id.e5fuelHandle);
    	if (fuelHandlersCourseCheck.isChecked()) {
    		fuelHandlersCourse = 10;
    	}
    	else {
    		fuelHandlersCourse = 0;
    	}
    	resPoints = resPoints + fuelHandlersCourse;
    	
    	//Checking if Basic Welding Course is checked
    	basicWeldingCourse = 0;
    	CheckBox basicWeldingCourseCheck = (CheckBox) findViewById(R.id.e5basicWeld);
    	if (basicWeldingCourseCheck.isChecked()) {
    		basicWeldingCourse = 10;
    	}
    	else {
    		basicWeldingCourse = 0;
    	}
    	resPoints = resPoints + basicWeldingCourse;
    	
    	//Checking if Forklift Operator Course is checked
    	forkliftOperatorCourse = 0;
    	CheckBox forkliftOperatorCourseCheck = (CheckBox) findViewById(R.id.e5forkOp);
    	if (forkliftOperatorCourseCheck.isChecked()) {
    		forkliftOperatorCourse = 10;
    	}
    	else {
    		forkliftOperatorCourse = 0;
    	}
    	resPoints = resPoints + forkliftOperatorCourse;
    	
    	//Checking if Bus Driver Course is checked
    	busDriverCourse = 0;
    	CheckBox busDriverCourseCheck = (CheckBox) findViewById(R.id.e5busDrive);
    	if (busDriverCourseCheck.isChecked()) {
    		busDriverCourse = 10;
    	}
    	else {
    		busDriverCourse = 0;
    	}
    	resPoints = resPoints + busDriverCourse;
    	
    	//Checking if Unit Supply Clerk Course is checked
    	unitSupplyClerkCourse = 0;
    	CheckBox unitSupplyClerkCourseCheck = (CheckBox) findViewById(R.id.e5unitSupply);
    	if (unitSupplyClerkCourseCheck.isChecked()) {
    		unitSupplyClerkCourse = 10;
    	}
    	else {
    		unitSupplyClerkCourse = 0;
    	}
    	resPoints = resPoints + unitSupplyClerkCourse;
    	
    	//Checking if Unit Supply Management Course is checked
    	unitSupplyManageCourse = 0;
    	CheckBox unitSupplyManageCourseCheck = (CheckBox) findViewById(R.id.e5unitSupplyOps);
    	if (unitSupplyManageCourseCheck.isChecked()) {
    		unitSupplyManageCourse = 10;
    	}
    	else {
    		unitSupplyManageCourse = 0;
    	}
    	resPoints = resPoints + unitSupplyManageCourse;
    	
    	//Checking if Unit Armorer Course is checked
    	unitArmorCourse = 0;
    	CheckBox unitArmorCourseCheck = (CheckBox) findViewById(R.id.e5unitArmor);
    	if (unitArmorCourseCheck.isChecked()) {
    		unitArmorCourse = 10;
    	}
    	else {
    		unitArmorCourse = 0;
    	}
    	resPoints = resPoints + unitArmorCourse;
    	
    	//Checking if CBRN Defense Course is checked
    	CBRNDefCourse = 0;
    	CheckBox CBRNDefCourseCheck = (CheckBox) findViewById(R.id.e5CBRNDef);
    	if (CBRNDefCourseCheck.isChecked()) {
    		CBRNDefCourse = 10;
    	}
    	else {
    		CBRNDefCourse = 0;
    	}
    	resPoints = resPoints + CBRNDefCourse;
    	
    	//Checking if Unit Postal Clerk Course is checked
    	unitPostalClerkCourse = 0;
    	CheckBox unitPostalClerkCourseCheck = (CheckBox) findViewById(R.id.e5unitPostal);
    	if (unitPostalClerkCourseCheck.isChecked()) {
    		unitPostalClerkCourse = 10;
    	}
    	else {
    		unitPostalClerkCourse = 0;
    	}
    	resPoints = resPoints + unitPostalClerkCourse;
    	
    	//Checking if Disk Operating System Course is checked
    	diskOperatingSystem = 0;
    	CheckBox diskOperatingSystemCheck = (CheckBox) findViewById(R.id.e5diskOp);
    	if (diskOperatingSystemCheck.isChecked()) {
    		diskOperatingSystem = 10;
    	}
    	else {
    		diskOperatingSystem = 0;
    	}
    	resPoints = resPoints + diskOperatingSystem;
    	
    	//Checking if Word Processing Course is checked
    	wordProcessingCourse = 0;
    	CheckBox wordProcessingCourseCheck = (CheckBox) findViewById(R.id.e5wordProcess);
    	if (wordProcessingCourseCheck.isChecked()) {
    		wordProcessingCourse = 10;
    	}
    	else {
    		wordProcessingCourse = 0;
    	}
    	resPoints = resPoints + wordProcessingCourse;
    	
    	//Checking if Database Management Course is checked
    	databaseManageCourse = 0;
    	CheckBox databaseManageCourseCheck = (CheckBox) findViewById(R.id.e5dataManage);
    	if (databaseManageCourseCheck.isChecked()) {
    		databaseManageCourse = 10;
    	}
    	else {
    		databaseManageCourse = 0;
    	}
    	resPoints = resPoints + databaseManageCourse;
    	
    	//Checking if Unit Logistics Course is checked
    	unitLevelLogistics = 0;
    	CheckBox unitLevelLogisticsCheck = (CheckBox) findViewById(R.id.e5unitLog);
    	if (unitLevelLogisticsCheck.isChecked()) {
    		unitLevelLogistics = 10;
    	}
    	else {
    		unitLevelLogistics = 0;
    	}
    	resPoints = resPoints + unitLevelLogistics;
    	
    	//Calculates Resident Military Education Points
    	milResidentTrainingHours = 0;
    	EditText milResidentTrainingHoursString = (EditText) findViewById(R.id.e5otherResHours);
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
    	EditText accpHoursString = (EditText) findViewById(R.id.e5accpHours);
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
    	
    	
    	
    	// 78 points is max allowed for E5 in resident and eLearning Points
    	if (resPoints > 78) {
    		resPoints = 78;
    	}
    	if (ePoints > 78) {
    		ePoints = 78;
    	}
    	milEd = milEd + resPoints + ePoints;
    	
    	
    	
    	/* Beginning calculations for "Civilian Education" category */
    	
    	//Calculates Semester Hour Points
    	semesterHours = 0;
    	EditText semesterHoursString = (EditText) findViewById(R.id.e5semHours);
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
    	EditText techCertsString = (EditText) findViewById(R.id.e5techCerts);
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
    	EditText defLanTestsString = (EditText) findViewById(R.id.e5dlpt);
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
    	CheckBox degCompletionCheck = (CheckBox) findViewById(R.id.e5degCompletion);
    	if (degCompletionCheck.isChecked()) {
    		degCompletion = 10;
    	}
    	else {
    		degCompletion = 0;
    	}
    	civEd = civEd + degCompletion;
    	
    	if (civEd > 75) {
    		civEd = 75;
    	}
    	
    	pointsTotal = milTraining + awards + milEd + civEd;
    	if (error == 0) {
    		TOTALalertDialog(this);
    	}
    	
    	
    }
    

    
    
}