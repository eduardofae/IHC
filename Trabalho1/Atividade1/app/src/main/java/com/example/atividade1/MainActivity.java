package com.example.atividade1;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
public class MainActivity extends AppCompatActivity {
    private EditText num1;
    private EditText num2;
    private Button   sum;
    private TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1 = (EditText) findViewById(R.id.Num1);   // ID from component
        num2 = (EditText) findViewById(R.id.Num2);   // ID from component
        sum  = (Button)   findViewById(R.id.Button); // ID from component
        res  = (TextView) findViewById(R.id.Result); // ID from component
        // The activity is created
    }

    public void sum(View view)
    {
        int n1, n2;
        try{
            n1 = Integer.parseInt(num1.getText().toString());
        }
        catch (Exception e){
            n1 = 0;
        }
        try{
            n2 = Integer.parseInt(num2.getText().toString());
        }
        catch (Exception e){
            n2 = 0;
        }
        res.setText(Integer.toString(n1 + n2));
        //code here
    }
}

