package com.example.atividade2;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
public class MainActivity2 extends AppCompatActivity {
    private TextView res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        res  = (TextView) findViewById(R.id.Result); // ID from component
        String data = getIntent().getStringExtra("data");
        res.setText(data);
        // The activity is created
    }
}

