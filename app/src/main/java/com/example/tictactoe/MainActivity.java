package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //0: yellow 1: red 2 : space
    int[]  gamestate = {2,2,2,2,2,2,2,2,2};

    int[][] winningpositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}} ;

    Integer activeplayer=0 ;

    boolean gameactive = true;

    public void dropin(View view ) {


        ImageView counter = (ImageView) view;

        counter.setTranslationY(-1500);

        int tappedcounter = Integer.parseInt(counter.getTag().toString());

        if( gamestate[tappedcounter] == 2 && gameactive){

            gamestate[tappedcounter] = activeplayer;

            if (activeplayer == 0) {
                counter.setImageResource(R.drawable.yellow);


                activeplayer = 1;
            } else {
                counter.setImageResource(R.drawable.red);


                activeplayer = 0;
            }

            counter.animate().rotation(300).translationYBy(1500).setDuration(300);
            for (int[] winningpositions : winningpositions) {
                if (gamestate[winningpositions[0]] == gamestate[winningpositions[1]] && gamestate[winningpositions[1]] == gamestate[winningpositions[2]] && gamestate[winningpositions[0]] != 2) {
                    gameactive = false;
                    String winner = "";
                    if (activeplayer == 1) {

                        winner = "yellow";

                    } else {
                        winner = "red";
                    }





                    Button button =(Button) findViewById(R.id.button);

                    TextView textView2 =(TextView) findViewById(R.id.textView2 );

                    button.setVisibility(View.VISIBLE);

                    textView2.setText(winner   + " has won");

                    button.setVisibility((View.VISIBLE));

                    textView2.setVisibility(View.VISIBLE);


                }
            }

        }

    }
    public void  playagain (View view ){



        Button button =(Button) findViewById(R.id.button);

        TextView textView2 =(TextView) findViewById(R.id.textView2 );

        button.setVisibility(View.INVISIBLE);

        textView2.setVisibility(View.INVISIBLE);

        GridLayout gridlayout = (GridLayout) findViewById(R.id.gridLayout);

        for(int i=0; i<gridlayout.getChildCount(); i++) {

            ImageView child = (ImageView) gridlayout.getChildAt(i);

            child.setImageDrawable(null);

        }
        for( int i =0 ; i<gamestate.length; i++) {
            gamestate [i] = 2;
        }

         activeplayer=0 ;

         gameactive = true;

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
