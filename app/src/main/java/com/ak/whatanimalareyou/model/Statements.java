package com.ak.whatanimalareyou.model;

import com.ak.whatanimalareyou.R;

/**
 * Created by AK on 07/03/2017.
 */

public class Statements {
    public static final int STRONGLY_AGREE=5;
    public static final int AGREE=4;
    public static final int NOT_SURE=3;
    public static final int DISAGREE=2;
    public static final int STRONGLY_DISAGREE=1;

    private Statement[] mStatements;
    public Statements(){
        mStatements=new Statement[5];
        mStatements[0]=new Statement("Engaging in social activities is what life is about.", STRONGLY_AGREE,  R.drawable.dolphin,"dolphin", false );
        mStatements[1]=new Statement("I like taking things slowly.", STRONGLY_AGREE,R.drawable.elephant,"elephant", false );
        mStatements[2]=new Statement("Meat is good for you.", STRONGLY_AGREE,R.drawable.tiger,"tiger", false );
        mStatements[3]=new Statement("Solitude is a virtue.", STRONGLY_AGREE,  R.drawable.redpanda, "redpanda",false );
        mStatements[4]=new Statement("Being playful is the way forward.", STRONGLY_AGREE, R.drawable.monkey, "monkey",true );
    }
    public Statement getStatement(int num){
        return mStatements[num];
    }
}
