package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // 0 = x
    //1 = O
    //2 = null
    Boolean gameactive = true;
    int activePlayer = 0;
    int []gamestate ={2,2,2,2,2,2,2,2,2};
    int [][] winpositions ={{0,1,2},{3,4,5},{6,7,8},
            {0,4,8},{2,4,6},
            {0,3,6},{1,4,7},{2,5,8}
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
public void playerTap(View view){
    ImageView img = (ImageView)view;
    int tappedImage=Integer.parseInt(img.getTag().toString());
    if(gamestate[tappedImage]==2&&gameactive == true)
    {
        gamestate[tappedImage]=activePlayer;
        img.setTranslationY(-1000f);
        if(activePlayer==0)
        {  img.setImageResource(R.drawable.x);
            activePlayer =1;
        }
        else
        {  img.setImageResource(R.drawable.o);
            activePlayer =0;
        }
        img.animate().translationYBy(1000f).setDuration(300);
    }

for(int[] wp:winpositions)
{
    if(gamestate[wp[0]]==gamestate[wp[1]]&&
            gamestate[wp[1]]==gamestate[wp[2]]&& gamestate[wp[1]]!=2)
    { gameactive =false;
        if(gamestate[wp[1]]==0){
        Toast.makeText(this,"X has win the game ",Toast.LENGTH_LONG).show();
    }
       else{Toast.makeText(this,"O has win the game ",Toast.LENGTH_LONG).show();}



    }


}
}


}
