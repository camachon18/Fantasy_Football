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

import java.util.ArrayList;


public class Edit_Players_Page extends ActionBarActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener{


    public EditText inPlayerGoals;
    public EditText inPlayerAssists;
    public EditText inPlayerSaves;
    public EditText inPlayerYellowCards;
    public EditText inPlayerRedCards;
    public EditText inPlayerFouls;
    public EditText inPlayerPosition;
    public EditText inPlayerNumber;
    public EditText inPlayerName;

    public Button addGoal;
    public Button addAssist;
    public Button addSave;
    public Button addYellowCard;
    public Button addRedCard;
    public Button addFoul;
    public Button addPlayer;
    public Button removePlayer;
    public Button switchPlayer;
    public Button toMainFromEdit;
    public Button toSimulateGame;

    public Spinner teamEditSpinner;
    public Spinner playerEditSpinner;
    public Spinner switchTeamSpinner;

    public Intent receiveTeamNames;
    public ArrayList<String> teamNamesEdit;
    public ArrayList<String> allPlayers;

    public Player NateCamacho;
    public Player ReddSantos;
    public Player DanielRaikes;
    public Player ChrisChang;
    public Player TimSawtelle;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit__players__page);

        inPlayerGoals = (EditText) findViewById(R.id.inPlayerGoals);
        inPlayerAssists = (EditText) findViewById(R.id.inPlayerAssists);
        inPlayerSaves = (EditText) findViewById(R.id.inPlayerSaves);
        inPlayerYellowCards = (EditText) findViewById(R.id.inPlayerYC);
        inPlayerRedCards = (EditText) findViewById(R.id.inPlayerRC);
        inPlayerFouls = (EditText) findViewById(R.id.inPlayerFouls);
        inPlayerPosition = (EditText) findViewById(R.id.inPlayerPosition);
        inPlayerNumber = (EditText) findViewById(R.id.inPlayerNumber);
        inPlayerName = (EditText) findViewById(R.id.inPlayerName);

        addGoal = (Button) findViewById(R.id.addGoal);
        addGoal.setOnClickListener(this);
        addAssist = (Button) findViewById(R.id.addGoal);
        addAssist.setOnClickListener(this);
        addSave = (Button) findViewById(R.id.addGoal);
        addSave.setOnClickListener(this);
        addYellowCard = (Button) findViewById(R.id.addGoal);
        addYellowCard.setOnClickListener(this);
        addRedCard = (Button) findViewById(R.id.addGoal);
        addRedCard.setOnClickListener(this);
        addFoul = (Button) findViewById(R.id.addGoal);
        addFoul.setOnClickListener(this);
        addPlayer = (Button) findViewById(R.id.addGoal);
        addPlayer.setOnClickListener(this);
        removePlayer = (Button) findViewById(R.id.addGoal);
        removePlayer.setOnClickListener(this);
        switchPlayer = (Button) findViewById(R.id.addGoal);
        switchPlayer.setOnClickListener(this);
        toMainFromEdit = (Button) findViewById(R.id.addGoal);
        toMainFromEdit.setOnClickListener(this);
        toSimulateGame = (Button) findViewById(R.id.toSimulateGame);
        toSimulateGame.setOnClickListener(this);

        NateCamacho = new Player("Nate Camacho", "CB",14,3,1,0,2,0,8);
        ReddSantos = new Player("Redd Santos", "CM",14,3,1,0,2,0,8);
        DanielRaikes = new Player("Daniel Raikes", "CM",14,3,1,0,2,0,8);
        ChrisChang = new Player("Chris Chang", "GK",14,3,1,0,2,0,8);
        TimSawtelle = new Player("Tim Sawtelle", "ST",14,3,1,0,2,0,8);


        allPlayers = new ArrayList<String>();
        allPlayers.add(NateCamacho.getName());
        allPlayers.add(ReddSantos.getName());
        allPlayers.add(DanielRaikes.getName());
        allPlayers.add(ChrisChang.getName());
        allPlayers.add(TimSawtelle.getName());

        teamNamesEdit = new ArrayList<String>();
        teamNamesEdit = getIntent().getStringArrayListExtra("Team Names");

        teamEditSpinner = (Spinner) findViewById(R.id.teamEditSpinner);
        ArrayAdapter<String> teamEditAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,teamNamesEdit);
        teamEditSpinner.setAdapter(teamEditAdapter);
        teamEditSpinner.setOnItemSelectedListener(this);
        playerEditSpinner = (Spinner) findViewById(R.id.playerEditSpinner);
        ArrayAdapter<String> playerEditAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,allPlayers);
        playerEditSpinner.setAdapter(playerEditAdapter);
        playerEditSpinner.setOnItemSelectedListener(this);
        switchTeamSpinner = (Spinner) findViewById(R.id.switchTeamSpinner);
        ArrayAdapter<String> switchTeamAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,teamNamesEdit);
        switchTeamSpinner.setAdapter(switchTeamAdapter);
        switchTeamSpinner.setOnItemSelectedListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit__players__page, menu);
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

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
