package com.example.atividade3;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.EditText;
public class MainActivity extends AppCompatActivity  implements SensorEventListener {
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private EditText X;
    private EditText Y;
    private EditText Z;

    private int GRANDE = 15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        X = (EditText) findViewById(R.id.X);   // ID from component
        Y = (EditText) findViewById(R.id.Y);   // ID from component
        Z = (EditText) findViewById(R.id.Z);   // ID from component
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }
    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor sensor = event.sensor;
        if(sensor.getType()== Sensor.TYPE_ACCELEROMETER) {
            float sensorX = event.values[0];
            float sensorY = event.values[1];
            float sensorZ = event.values[2];
            X.setHint(Float.toString(sensorX));
            Y.setHint(Float.toString(sensorY));
            Z.setHint(Float.toString(sensorZ));

            if(sensorX >= GRANDE || sensorX <= -GRANDE || sensorY >= GRANDE || sensorY <= -GRANDE || sensorZ >= GRANDE || sensorZ <= -GRANDE){
                Intent i = new Intent(this, MainActivity2.class);
                startActivity(i);
            }
        }
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy)
    {

    }
}

