package com.example.administrator.fantasyfootball;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/*Nathan Camacho
    9/20/15
*Main Activity Class
* Implements the functionality of the Main Activity Android design
*
*/

public class MainActivity extends ActionBarActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    //Declaration of variables to be used throughout class
    public EditText outWins;
    public EditText outDraws;
    public EditText outLosses;

    public Spinner teamMainSpinner;

    public Button addTeam;
    public Button removeTeam;
    public Button toEditPlayers;
    public Button setWins;
    public Button setDraws;
    public Button setLosses;

    public EditText inTeamName;

    public ArrayList<String> teamNamesMain;
    public HashMap<String,Team> teams;

    public Team AllPlayers;
    public Team RedDevils;
    public Team Pilots;
    public Team FCBarcelona;
    public Team ManUnited;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing variables to appropriate widget
        outWins = (EditText) findViewById(R.id.outWins);
        outDraws = (EditText) findViewById(R.id.outDraws);
        outLosses = (EditText) findViewById(R.id.outLosses);
        inTeamName = (EditText) findViewById(R.id.inTeamName);

        addTeam = (Button) findViewById(R.id.addTeam);
        addTeam.setOnClickListener(this);
        removeTeam = (Button) findViewById(R.id.removeTeam);
        removeTeam.setOnClickListener(this);
        toEditPlayers = (Button) findViewById(R.id.toEditPlayers);
        toEditPlayers.setOnClickListener(this);
        setWins = (Button) findViewById(R.id.setWinsButton);
        setWins.setOnClickListener(this);
        setDraws = (Button) findViewById(R.id.setDrawsButton);
        setDraws.setOnClickListener(this);
        setLosses = (Button) findViewById(R.id.setLossesButton);
        setLosses.setOnClickListener(this);


        //Creating instances of Team class
        AllPlayers = new Team("All Players","0","0","0");
        Pilots = new Team("Pilots","4","2","1");
        RedDevils = new Team("Red Devils","3","1","2");
        FCBarcelona = new Team("FC Barcelona","0","3","2");
        ManUnited = new Team("Manchester United","6","0","0");

        //Adding teams to Teams Hashmap
        teams = new HashMap<String, Team>();
        teams.put(AllPlayers.getName(),AllPlayers);
        teams.put(Pilots.getName(), Pilots);
        teams.put(RedDevils.getName(),RedDevils);
        teams.put(FCBarcelona.getName(),FCBarcelona);
        teams.put(ManUnited.getName(),ManUnited);

        //Adding teams to arrayList for Spinner
        teamNamesMain = new ArrayList<String>();
        teamNamesMain.add(AllPlayers.getName());
        teamNamesMain.add(Pilots.getName());
        teamNamesMain.add(RedDevils.getName());
        teamNamesMain.add(FCBarcelona.getName());
        teamNamesMain.add(ManUnited.getName());

        //Implementing Spinner
        //Assigned the teamNames arrayList to this Spinner
        teamMainSpinner = (Spinner) findViewById(R.id.teamMainSpinner);
        ArrayAdapter<String> teamMainAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,teamNamesMain);
        teamMainSpinner.setAdapter(teamMainAdapter);
        teamMainSpinner.setOnItemSelectedListener(this);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View view) {

        //If toEditPlayers is clicked, create intent and send teamNames ArrayList, and teams Hashmap
        //to next activity
        if (view == toEditPlayers ) {

            Intent goToEditPlayers = new Intent(this,Edit_Players_Page.class);
            goToEditPlayers.putStringArrayListExtra("Team Names", teamNamesMain);
            goToEditPlayers.putExtra("Team Hashmap",teams);
            startActivity(goToEditPlayers);

            //If add team is clicked, create a temp team object, add it to the teamNames ArrayList
            //and put it in the teams Hashmap
        }
        if (view == addTeam){

            Team teamTemp = new Team(inTeamName.getText().toString(),"0","0","0");
            teamNamesMain.add(inTeamName.getText().toString());
            teams.put(inTeamName.getText().toString(), teamTemp);
            inTeamName.setText("");

            //If remove team is clicked, remove from arrayList and Hashmap
        }
        if (view == removeTeam){

            teamNamesMain.remove(inTeamName.getText().toString());
            teams.remove(inTeamName.getText().toString());
            inTeamName.setText("");

        }

            //If any of the setter buttons are clicked, create a temp team object and assign it the value
            //of the name selected from the spinner. Then set the appropriate variable using the setter methods
        if (view == setWins) {

            Team tTemp = teams.get(teamMainSpinner.getSelectedItem().toString());
            tTemp.setWins(outWins.getText().toString());
        }
        if (view == setDraws) {

            Team tTemp = teams.get(teamMainSpinner.getSelectedItem().toString());
            tTemp.setDraws(outDraws.getText().toString());
        }

        if (view == setLosses) {

            Team tTemp = teams.get(teamMainSpinner.getSelectedItem().toString());
            tTemp.setLosses(outLosses.getText().toString());
        }



    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        //if the teamMainSpinner is used, display the attributes of the appropriate team selected
        if (adapterView == teamMainSpinner) {

            Team tTemp = teams.get(teamMainSpinner.getSelectedItem().toString());
            outWins.setText(tTemp.getWins());
            outDraws.setText(tTemp.getDraws());
            outLosses.setText(tTemp.getLosses());

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}
