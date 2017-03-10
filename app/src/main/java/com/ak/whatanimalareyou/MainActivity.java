package com.ak.whatanimalareyou;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.ak.whatanimalareyou.UI.YouAreActivity;
import com.ak.whatanimalareyou.model.Statement;
import com.ak.whatanimalareyou.model.Statements;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private Statements mStatements;
    private TextView mStatementTextView;
    private Button mButton;
    private RadioGroup mRadioGroup;
    private Map<Statement, Integer> mStatementMark;
    private int counter=0;
    private Statement mCurrentStatement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mStatementTextView=(TextView) findViewById(R.id.statementTextView);
        mButton=(Button) findViewById(R.id.button);
        mRadioGroup=(RadioGroup) findViewById(R.id.markRadioGroup);

        mStatementMark=new HashMap<>();
        loadStatement(counter);
    }
    public void onRadioButtonClicked(View v){

        int mark=-1;
        boolean checked=((RadioButton) v).isChecked();
        // Check which radio button was clicked
        switch(v.getId()) {
            case R.id.radio_agree:
                if (checked)
                    mark=Statements.AGREE;
                    break;
            case R.id.radio_strongly_agree:
                if (checked)
                    mark=Statements.STRONGLY_AGREE;
                    break;
            case R.id.radio_not_sure:
                if (checked)
                    mark=Statements.NOT_SURE;
                    break;
            case R.id.radio_disagree:
                if (checked)
                    mark=Statements.DISAGREE;
                    break;
            case R.id.radio_strongly_disagree:
                if (checked)
                    mark=Statements.STRONGLY_DISAGREE;
                    break;
        }
        mStatementMark.put(mCurrentStatement, mark);
    }
    private void loadStatement(int index){
        mStatements=new Statements();
        mCurrentStatement = mStatements.getStatement(index);
        mRadioGroup.clearCheck();
        counter++;
        mStatementTextView.setText(mCurrentStatement.toString());
        if(mCurrentStatement.isFinal()) {

            mButton.setText("Click To Find Out What Animal You Are!");
            mButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, YouAreActivity.class);
                    intent.putExtra("ImageID", findAnimalImageId());
                    intent.putExtra("AnimalName", getAnimalName());
                    startActivity(intent);
                }
            });
        }
        else {
            mButton.setText("NEXT");
            mButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    loadStatement(counter);

                }
            });


        }
    }

    private int findAnimalImageId(){

        int id=-1;

        for(Map.Entry<Statement,Integer> entry: mStatementMark.entrySet()){
            if (entry.getValue()==Statements.STRONGLY_AGREE || entry.getValue()==Statements.AGREE)
                id= entry.getKey().getImageId();
            }

        return id;
    }
    private String getAnimalName(){

        String name="";
        for(Map.Entry<Statement,Integer> entry: mStatementMark.entrySet()){
            if (entry.getValue()==Statements.STRONGLY_AGREE || entry.getValue()==Statements.AGREE)
                name = entry.getKey().getAnimal();
        }

        return name;
    }
    @Override
    protected void onResume(){
        super.onResume();
        counter=0;
        mStatementMark.clear();
        loadStatement(counter);

    }



}
