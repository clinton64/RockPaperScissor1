package com.example.rockpapersciissor;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button singleP , doubleP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        singleP = (Button)findViewById(R.id.buttonNextPage1) ;
        doubleP = (Button)findViewById(R.id.buttonNextPage2);

        singleP.setOnClickListener(this);
        doubleP.setOnClickListener(this);
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

    String player;
    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.buttonNextPage1) {
            openUserVsComp() ;
        }
        if (view.getId() == R.id.buttonNextPage1) {
            openUserVsUser() ;
        }


    }
    public void openUserVsComp(){
        Intent intent = new Intent(this , USERvSCOMPUTER.class) ;
        startActivity(intent);
    }
    public void openUserVsUser(){
        Intent intent = new Intent(this , USERvSCOMPUTER.class) ;
        startActivity(intent);
    }

}
