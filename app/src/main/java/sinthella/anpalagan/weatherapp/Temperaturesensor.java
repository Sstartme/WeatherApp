package sinthella.anpalagan.weatherapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

    public class Temperaturesensor extends AppCompatActivity implements SensorEventListener, temperaturesensore {
        private SensorManager sensorManager;
        private TextView textView;
        private Sensor tempSensor;
        private Boolean isTemperatureSsensoreAvailable;
        private ImageView imageIcon;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.temperaturesensor);

            textView = findViewById(R.id.temperatur_id);
            sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
            if (sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE) != null) {
                tempSensor = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
                isTemperatureSsensoreAvailable = true;
            } else {
                textView.setText("Temperature Sensor is not Availible");
                isTemperatureSsensoreAvailable = false;
            }
            imageIcon = findViewById(R.id.temperatur_id);
            textView = findViewById(R.id.temperatur_id);
            imageIcon.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    if (textView.getVisibility() == View.GONE) {
                        textView.setVisibility(View.VISIBLE);
                    } else {
                        textView.setVisibility(View.GONE);
                    }
                }
            });
        }

        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            textView.setText(sensorEvent.values[0] + " °C");
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }

        @Override
        protected void onResume() {
            super.onResume();
            if (isTemperatureSsensoreAvailable) {
                sensorManager.registerListener(this, tempSensor, sensorManager.SENSOR_DELAY_NORMAL);
            }
        }

        @Override
        protected void onPause() {
            super.onPause();
            if (isTemperatureSsensoreAvailable) {
                sensorManager.unregisterListener(this);
            }
        }
    }
}
