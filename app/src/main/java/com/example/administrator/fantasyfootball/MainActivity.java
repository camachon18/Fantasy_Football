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


public class MainActivity extends ActionBarActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {


    public TextView outWins;
    public TextView outDraws;
    public TextView outLosses;

    public Spinner teamMainSpinner;

    public Button addTeam;
    public Button removeTeam;
    public Button toEditPlayers;

    public EditText inTeamName;

    public ArrayList<String> teamNamesMain;
    public HashMap<String,Player> teams;

    public Team RedDevils;
    public Team Pilots;
    public Team FCBarcelona;
    public Team ManUnited;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        outWins = (TextView) findViewById(R.id.outWins);
        outDraws = (TextView) findViewById(R.id.outDraws);
        outLosses = (TextView) findViewById(R.id.outLosses);
        inTeamName = (EditText) findViewById(R.id.inTeamName);

        addTeam = (Button) findViewById(R.id.addTeam);
        addTeam.setOnClickListener(this);
        removeTeam = (Button) findViewById(R.id.removeTeam);
        removeTeam.setOnClickListener(this);
        toEditPlayers = (Button) findViewById(R.id.toEditPlayers);
        toEditPlayers.setOnClickListener(this);

        Pilots = new Team("Pilots",4,2,1);
        RedDevils = new Team("Red Devils",3,1,2);
        FCBarcelona = new Team("FC Barcelona",0,3,2);
        ManUnited = new Team("Manchester United",6,0,0);


        teamNamesMain = new ArrayList<String>();
        teamNamesMain.add(Pilots.getName());
        teamNamesMain.add(RedDevils.getName());
        teamNamesMain.add(FCBarcelona.getName());
        teamNamesMain.add(ManUnited.getName());

        //outWins.setText((int) Pilots.getWins());
        //outDraws.setText(Pilots.getDraws());
        //outLosses.setText(Pilots.getLosses());


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

        if (view == toEditPlayers ) {

            Intent goToEditPlayers = new Intent(this,Edit_Players_Page.class);
            goToEditPlayers.putStringArrayListExtra("Team Names", teamNamesMain);
            startActivity(goToEditPlayers);

        }
        if (view == addTeam){

            teamNamesMain.add(inTeamName.getText().toString());
            inTeamName.setText("");

        }
        if (view == removeTeam){

            teamNamesMain.remove(inTeamName.getText().toString());
            inTeamName.setText("");

        }


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}
