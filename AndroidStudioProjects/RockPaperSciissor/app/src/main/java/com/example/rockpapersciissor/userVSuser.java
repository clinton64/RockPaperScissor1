package com.example.rockpapersciissor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;
public class userVSuser extends AppCompatActivity implements View.OnClickListener {

        private Button btnRock,btnPaper,btnScissor,btnNewGame ;
        private ImageView userImage , computerImage ;
        TextView tv_score ;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_user_vsuser);
            btnRock = (Button) findViewById(R.id.button1);
            btnPaper = (Button) findViewById(R.id.button2);
            btnScissor = (Button) findViewById(R.id.button3);
            btnNewGame = (Button) findViewById(R.id.newGame);
            userImage = (ImageView) findViewById(R.id.imageView2) ;
            computerImage = (ImageView) findViewById(R.id.imageView3) ;
            tv_score = (TextView) findViewById(R.id.score) ;

            btnRock.setOnClickListener(this);
            btnPaper.setOnClickListener(this);
            btnScissor.setOnClickListener(this);
            btnNewGame.setOnClickListener(this);
            userImage.setOnClickListener(this);
            computerImage.setOnClickListener(this);
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }
        int compScore = 0 , userScore = 0;
        public String calculate(String playerChoice){
            Random ran = new Random();
            int compNum = ran.nextInt(3) ;
            String computerChoice = "" ;
            if(  compNum == 0 )
            {
                computerChoice = "rock";
                computerImage.setImageResource(R.drawable.rock);
            }
            else if(compNum == 1)
            {
                computerChoice = "scissor";
                computerImage.setImageResource(R.drawable.scissors);
            }
            else if(compNum == 2)
            {
                computerChoice = "paper";
                computerImage.setImageResource(R.drawable.paper);
            }

            if(computerChoice == playerChoice){
                return "It's a tie!" ;
            }
            else if(computerChoice == "rock" && playerChoice == "paper"){
                userScore++ ;
                return "You win!" ;
            }
            else if(computerChoice == "rock" && playerChoice == "scissor"){
                compScore++ ;
                return "You lose!" ;
            }
            else if(computerChoice == "paper" && playerChoice == "rock"){
                compScore++ ;
                return  "You lose!" ;
            }
            else if(computerChoice == "paper" && playerChoice == "scissor"){
                userScore++ ;
                return  "You win!" ;
            }
            else if(computerChoice == "scissor" && playerChoice == "rock"){
                userScore++ ;
                return  "You win!" ;
            }
            else if(computerChoice == "scissor" && playerChoice == "paper"){
                compScore++ ;
                return "You lose!" ;
            }
            else{
                return  "Not sure." ;
            }
        }

        String player;
        @Override
        public void onClick(View view) {

            if (view.getId() == R.id.button1) {
                player = "rock" ;
                userImage.setImageResource(R.drawable.rock);
            }
            else if (view.getId() == R.id.button2) {
                player = "paper" ;
                userImage.setImageResource(R.drawable.paper);
            }
            else if (view.getId() == R.id.button3) {
                player = "scissor" ;
                userImage.setImageResource(R.drawable.scissors);
            }
            else if(view.getId() == R.id.newGame){
                compScore = 0 ;
                userScore = 0 ;
            }
            String message = calculate(player) ;
            Toast.makeText(com.example.rockpapersciissor.userVSuser.this, message ,Toast.LENGTH_SHORT).show();
            tv_score.setText("Your Score :" + Integer.toString(userScore) + "\n Computer Score :" + Integer.toString(compScore)) ;
        }
    }
