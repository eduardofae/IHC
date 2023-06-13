package com.example.atividade2;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
public class MainActivity extends AppCompatActivity {
    private EditText text;
    private Button   send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (EditText) findViewById(R.id.Text);   // ID from component
        send = (Button)   findViewById(R.id.Button); // ID from component
        // The activity is created
    }

    public void send(View view)
    {
        Intent i = new Intent(this, MainActivity2.class);
        i.putExtra("data", text.getText().toString());
        startActivity(i);
        //code here
    }
}

