package com.ak.whatanimalareyou.UI;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ak.whatanimalareyou.R;

public class YouAreActivity extends AppCompatActivity {

    private RelativeLayout rLayout;
    private Button mButton;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_are);
        rLayout=(RelativeLayout) findViewById(R.id.activity_you_are);
        mButton=(Button) findViewById(R.id.playAgainButton);

        int imageId=getIntent().getIntExtra("ImageID",-1);
        String name=getIntent().getStringExtra("AnimalName");
        Drawable drawable;
        if (imageId==-1) {
            drawable = getResources().getDrawable(R.drawable.human);
            Toast.makeText(this, "You are a human",Toast.LENGTH_LONG).show();
        }
        else {
            drawable = getResources().getDrawable(imageId);
            if(name.equals("elephant"))
                Toast.makeText(this, "You are an"+name,Toast.LENGTH_LONG).show();
            else
                Toast.makeText(this, "You are a "+name,Toast.LENGTH_LONG).show();
        }
        rLayout.setBackground(drawable);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

}
