package com.example.parte2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor light;
    private Sensor grav;
    private TextView lightValue;
    private TextView gravValue;
    private Button getGPSBtn;

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor sensor = event.sensor;
        if(sensor.getType() == Sensor.TYPE_LIGHT)
        {
            lightValue.setText("Light Intensity:\n" + event.values[0]);
        }

        if(sensor.getType() == Sensor.TYPE_GRAVITY)
        {
            gravValue.setText("Gravity:\n" + event.values[0]);
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lightValue = (TextView)findViewById(R.id.light);
        sensorManager = (SensorManager)
                getSystemService(Context.SENSOR_SERVICE);
        light = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        if(light != null)
        {
            sensorManager.registerListener(MainActivity.this, light,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }else
        {
            lightValue.setText("Light sensor not supported");
        }

        gravValue = (TextView)findViewById(R.id.grav);
        grav = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);
        if(grav != null)
        {
            sensorManager.registerListener(MainActivity.this, grav,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }else
        {
            gravValue.setText("Ambient Temperature sensor not supported");
        }

        getGPSBtn = (Button) findViewById(R.id.getGPSBtn);
        ActivityCompat.requestPermissions(MainActivity.this, new
                String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 123);
        getGPSBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GPSTracker g = new GPSTracker(getApplicationContext());
                Location l = g.getLocation();
                if (l != null) {
                    double lat = l.getLatitude();
                    double longi = l.getLongitude();
                    Toast.makeText(getApplicationContext(), "LAT: " + lat + "\nLONG: " +
                            longi, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}