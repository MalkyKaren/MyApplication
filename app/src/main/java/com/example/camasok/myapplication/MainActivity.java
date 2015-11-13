package com.example.camasok.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();

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

/**
 * Created by camasok on 10/26/2015.
 */


        private Button RollButton;
        private Button OkayButton;
        private EditText SEdit;
        private Button SAdd;
        private Button SMinus;
        private EditText PEdit;
        private Button PAdd;
        private Button Pminus;
        private EditText EEdit;
        private Button EAdd;
        private Button EMinus;
        private EditText CEdit;
        private Button CAdd;
        private Button CSub;
        private EditText IEdit;
        private Button IAdd;
        private Button IMinus;
        private EditText AEdit;
        private Button AAdd;
        private Button AMinus;
        private EditText LEdit;
        private Button LAdd;
        private Button LMinus;

        /**
         * Find the Views in the layout<br />
         * <br />
         * Auto-created on 2015-10-26 13:22:04 by Android Layout Finder
         * (http://www.buzzingandroid.com/tools/android-layout-finder)
         */
        private void findViews() {
            RollButton = (Button) findViewById( R.id.RollButton );
            OkayButton = (Button) findViewById( R.id.OkayButton );
            SEdit = (EditText) findViewById( R.id.SEdit );
            SAdd = (Button) findViewById( R.id.SAdd );
            SMinus = (Button) findViewById( R.id.SMinus );
            PEdit = (EditText) findViewById( R.id.PEdit );
            PAdd = (Button) findViewById( R.id.PAdd );
            Pminus = (Button) findViewById( R.id.Pminus );
            EEdit = (EditText) findViewById( R.id.EEdit );
            EAdd = (Button) findViewById( R.id.EAdd );
            EMinus = (Button)findViewById( R.id.EMinus );
            CEdit = (EditText)findViewById( R.id.CEdit );
            CAdd = (Button)findViewById( R.id.CAdd );
            CSub = (Button)findViewById( R.id.CSub );
            IEdit = (EditText)findViewById( R.id.IEdit );
            IAdd = (Button)findViewById( R.id.IAdd );
            IMinus = (Button)findViewById( R.id.IMinus );
            AEdit = (EditText)findViewById( R.id.AEdit );
            AAdd = (Button)findViewById( R.id.AAdd );
            AMinus = (Button)findViewById( R.id.AMinus );
            LEdit = (EditText)findViewById( R.id.LEdit );
            LAdd = (Button)findViewById( R.id.LAdd );
            LMinus = (Button)findViewById( R.id.LMinus );

            RollButton.setOnClickListener( this );
            OkayButton.setOnClickListener( this );
            SAdd.setOnClickListener( this );
            SMinus.setOnClickListener( this );
            PAdd.setOnClickListener( this );
            Pminus.setOnClickListener( this );
            EAdd.setOnClickListener( this );
            EMinus.setOnClickListener( this );
            CAdd.setOnClickListener( this );
            CSub.setOnClickListener( this );
            IAdd.setOnClickListener( this );
            IMinus.setOnClickListener( this );
            AAdd.setOnClickListener( this );
            AMinus.setOnClickListener( this );
            LAdd.setOnClickListener( this );
            LMinus.setOnClickListener( this );
        }



        @Override
        public void onClick(View v) {
            if ( v == RollButton ) {
                Random r = new Random();

                ArrayList<EditText> statList = new ArrayList<EditText>();
                statList.add(SEdit);
                statList.add(PEdit);
                statList.add(EEdit);
                statList.add(CEdit);
                statList.add(IEdit);
                statList.add(AEdit);
                statList.add(LEdit);


                for(int i = 0; i < 7; i++)
                {
                    String rand = Integer.toString(r.nextInt(10));
                    statList.get(i).setText(rand);
                }
            }
            if ( v == OkayButton ) {
                Context context = getApplicationContext();
                CharSequence text = "Thanks for trying!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                finish();
            }
            if ( v == SAdd ) {
                addButton(SEdit);
            }
            if ( v == SMinus ) {
               minusButton(SEdit);
            }
            if ( v == PAdd ) {
                addButton(PEdit);
            }
            if ( v == Pminus ) {
               minusButton(PEdit);
            }
            if ( v == EAdd ) {
                addButton(EEdit);
            }
            if ( v == EMinus ) {
                minusButton(EEdit);
            }
            if ( v == CAdd ) {
                addButton(CEdit);
            }
            if ( v == CSub ) {
                minusButton(CEdit);
            }
            if ( v == IAdd ) {
                addButton(IEdit);
            }
            if ( v == IMinus ) {
                minusButton(IEdit);
            }
            if ( v == AAdd ) {
                addButton(AEdit);
            }
            if ( v == AMinus ) {
                minusButton(AEdit);
            }
            if ( v == LAdd ) {
                addButton(LEdit);
            }
            if ( v == LMinus ) {
               minusButton(LEdit);
            }
        }

    public static void addButton(EditText stat)
    {
        if(!(stat.getText().toString().equals(""))) {
            int temp = Integer.parseInt(stat.getText().toString());
            temp = temp + 1;
            String newString = Integer.toString(temp);
            stat.setText(newString);
        }
       else
        {
            stat.setText(Integer.toString(1));
        }
    }

    public void minusButton(EditText stat)
    {

        if(!(stat.getText().toString().equals(""))) {

            int temp = Integer.parseInt(stat.getText().toString());

            if (temp == 0) {
                Context context = getApplicationContext();
                CharSequence text = "Your STAT cannot be less than zero.";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                stat.setText(Integer.toString(0));
            } else {
                temp = temp - 1;
               String newString = Integer.toString(temp);
                stat.setText(newString);
            }
        }
        else{
            stat.setText(Integer.toString(0));
        }
    }

    }



