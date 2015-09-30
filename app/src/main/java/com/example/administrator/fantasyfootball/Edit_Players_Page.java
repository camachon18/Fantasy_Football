package com.example.administrator.fantasyfootball;


import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
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
import java.util.HashMap;

/*
* Nathan Camacho
 * 9/20/15
 * Edit Players (second activity) class.
 * Implements the functionality of the Edit Players Page android design
*/
public class Edit_Players_Page extends ActionBarActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener{

    //Declaration of variables to be used throughout program
    public EditText inPlayerGoals;
    public EditText inPlayerAssists;
    public EditText inPlayerSaves;
    public EditText inPlayerYellowCards;
    public EditText inPlayerRedCards;
    public EditText inPlayerFouls;
    public EditText inPlayerPosition;
    public EditText inPlayerNumber;
    public EditText inPlayerName;

    public Button setGoal;
    public Button setAssist;
    public Button setSave;
    public Button setYellowCard;
    public Button setRedCard;
    public Button setFoul;
    public Button addPlayer;
    public Button removePlayer;
    public Button switchPlayer;//not implemented
    public Button toMainFromEdit;
    public Button setPosition;
    public Button setNumber;

    public Spinner teamEditSpinner;
    public Spinner playerEditSpinner;
    public Spinner switchTeamSpinner;

    public ArrayList<String> teamNamesEdit;
    public ArrayList<String> allPlayers;

    public Player NateCamacho;
    public Player ReddSantos;
    public Player DanielRaikes;
    public Player ChrisChang;
    public Player TimSawtelle;

    public HashMap<String,Player> players;
    public HashMap<String,Team> teams2;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit__players__page);

        //Initializing variables to appropriate widget
        inPlayerGoals = (EditText) findViewById(R.id.inPlayerGoals);
        inPlayerAssists = (EditText) findViewById(R.id.inPlayerAssists);
        inPlayerSaves = (EditText) findViewById(R.id.inPlayerSaves);
        inPlayerYellowCards = (EditText) findViewById(R.id.inPlayerYC);
        inPlayerRedCards = (EditText) findViewById(R.id.inPlayerRC);
        inPlayerFouls = (EditText) findViewById(R.id.inPlayerFouls);
        inPlayerPosition = (EditText) findViewById(R.id.inPlayerPosition);
        inPlayerNumber = (EditText) findViewById(R.id.inPlayerNumber);
        inPlayerName = (EditText) findViewById(R.id.inPlayerName);

        setGoal = (Button) findViewById(R.id.setGoal);
        setGoal.setOnClickListener(this);
        setAssist = (Button) findViewById(R.id.setAssist);
        setAssist.setOnClickListener(this);
        setSave = (Button) findViewById(R.id.setSave);
        setSave.setOnClickListener(this);
        setYellowCard = (Button) findViewById(R.id.setYellowCard);
        setYellowCard.setOnClickListener(this);
        setRedCard = (Button) findViewById(R.id.setRedCard);
        setRedCard.setOnClickListener(this);
        setFoul = (Button) findViewById(R.id.setFoul);
        setFoul.setOnClickListener(this);
        addPlayer = (Button) findViewById(R.id.addPlayer);
        addPlayer.setOnClickListener(this);
        removePlayer = (Button) findViewById(R.id.removePlayer);
        removePlayer.setOnClickListener(this);
        switchPlayer = (Button) findViewById(R.id.switchPlayer);
        switchPlayer.setOnClickListener(this);
        toMainFromEdit = (Button) findViewById(R.id.toMainFromEdit);
        toMainFromEdit.setOnClickListener(this);
        setPosition = (Button) findViewById(R.id.setPositionButton);
        setPosition.setOnClickListener(this);
        setNumber = (Button) findViewById(R.id.setNumberButton);
        setNumber.setOnClickListener(this);

        //Creating instances of Player class
        NateCamacho = new Player("Nate Camacho", "CB","14","3","1","0","2","0","8");
        ReddSantos = new Player("Redd Santos", "CM","1","0","2","0","4","3","9");
        DanielRaikes = new Player("Daniel Raikes", "CM","6","8","1","0","6","0","5");
        ChrisChang = new Player("Chris Chang", "GK","4","3","2","0","1","6","0");
        TimSawtelle = new Player("Tim Sawtelle", "ST","15","7","1","9","2","3","8");
        //putting them in player hashmap
        players = new HashMap<String, Player>();
        players.put(NateCamacho.getName(), NateCamacho);
        players.put(ReddSantos.getName(), ReddSantos);
        players.put(DanielRaikes.getName(), DanielRaikes);
        players.put(ChrisChang.getName(), ChrisChang);
        players.put(TimSawtelle.getName(), TimSawtelle);

        //adding players to arrayList
        allPlayers = new ArrayList<String>();
        allPlayers.add(NateCamacho.getName());
        allPlayers.add(ReddSantos.getName());
        allPlayers.add(DanielRaikes.getName());
        allPlayers.add(ChrisChang.getName());
        allPlayers.add(TimSawtelle.getName());

        //Receiving data from Main Activity, the teamNames arrayList and the Teams hashmap
        teamNamesEdit = new ArrayList<String>();
        teamNamesEdit = getIntent().getStringArrayListExtra("Team Names");
        teams2 = new HashMap<String, Team>();
        teams2 = (HashMap<String, Team>) getIntent().getSerializableExtra("Team Hashmap");


        //Initializing spinners and assigning appropriate arrayList to spinner
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

        //If add player is clicked, create a temp player object, add it to the playerNames ArrayList
        //and put it in the players Hashmap
        if (view == addPlayer) {

            Player playerTemp = new Player(inPlayerName.getText().toString(),"DF","0","0","0","0","0","0","0");
            allPlayers.add(inPlayerName.getText().toString());
            players.put(inPlayerName.getText().toString(), playerTemp);
            inPlayerName.setText("");
        }
        //If remove player is clicked, remove from arrayList and Hashmap
        if (view == removePlayer) {

            allPlayers.remove(inPlayerName.getText().toString());
            players.remove(inPlayerName.getText().toString());
            inPlayerName.setText("");

        }
        //go back to Main Activity
        if (view == toMainFromEdit) {

            finish();

        }
        //If any of the setter buttons are clicked, create a temp player object and assign it the value
        //of the name selected from the spinner. Then set the appropriate variable using the setter methods
        if (view == setGoal) {

            Player pTemp = players.get(playerEditSpinner.getSelectedItem().toString());
            pTemp.setGoals(inPlayerGoals.getText().toString());
        }
        if (view == setAssist) {

            Player pTemp = players.get(playerEditSpinner.getSelectedItem().toString());
            pTemp.setAssists(inPlayerAssists.getText().toString());
        }
        if (view == setSave) {

            Player pTemp = players.get(playerEditSpinner.getSelectedItem().toString());
            pTemp.setSaves(inPlayerSaves.getText().toString());
        }
        if (view == setYellowCard) {

            Player pTemp = players.get(playerEditSpinner.getSelectedItem().toString());
            pTemp.setYellowCards(inPlayerYellowCards.getText().toString());
        }
        if (view == setRedCard) {

            Player pTemp = players.get(playerEditSpinner.getSelectedItem().toString());
            pTemp.setRedCards(inPlayerRedCards.getText().toString());
        }
        if (view == setFoul) {

            Player pTemp = players.get(playerEditSpinner.getSelectedItem().toString());
            pTemp.setFouls(inPlayerFouls.getText().toString());
        }
        if (view == setPosition) {

            Player pTemp = players.get(playerEditSpinner.getSelectedItem().toString());
            pTemp.setPosition(inPlayerPosition.getText().toString());
        }
        if (view == setNumber) {

            Player pTemp = players.get(playerEditSpinner.getSelectedItem().toString());
            pTemp.setNumber(inPlayerNumber.getText().toString());
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        //if the player Spinner is used, display the attributes of the appropriate player selected
        if (adapterView == playerEditSpinner) {

            Player pTemp = players.get(playerEditSpinner.getSelectedItem().toString());
            inPlayerGoals.setText(pTemp.getGoals());
            inPlayerAssists.setText(pTemp.getAssists());
            inPlayerSaves.setText(pTemp.getSaves());
            inPlayerYellowCards.setText(pTemp.getYellowCards());
            inPlayerRedCards.setText(pTemp.getRedCards());
            inPlayerFouls.setText(pTemp.getFouls());
            inPlayerPosition.setText(pTemp.getPosition());
            inPlayerNumber.setText(pTemp.getNumber());

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
