package tuomastiira.smarthouse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

public class BedRoomActivity extends AppCompatActivity {

    private Spinner spinner;
    private ToggleButton lights;
    private boolean lightsState;
    private int temperatureSet = 20;
    private Button temperatureUp;
    private Button temperatureDown;
    private TextView temperatureView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bed_room);

        spinner = (Spinner) findViewById(R.id.bedroomSpinner);
        spinner.setSelection(3);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View view, int position, long row_id) {
                Intent intent;
                switch (position) {
                    case 0:
                        intent = new Intent(BedRoomActivity.this, HomeActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        startActivity(intent);
                        spinner.setSelection(3);
                        break;
                    case 1:
                        intent = new Intent(BedRoomActivity.this, MainRoomActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        startActivity(intent);
                        spinner.setSelection(3);
                        break;
                    case 2:
                        intent = new Intent(BedRoomActivity.this, LivingRoomActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        startActivity(intent);
                        spinner.setSelection(3);
                        break;
                    case 3:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // pass
            }
        });

        temperatureView = (TextView) findViewById(R.id.bedroomTemperatureSet);
        temperatureView.setText(String.valueOf(temperatureSet) + ' ');

        temperatureUp = (Button) findViewById(R.id.bedroomTemperatureUpButton);
        temperatureUp.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                temperatureSet += 1;
                temperatureView.setText(String.valueOf(temperatureSet) + ' ');
            }
        });
        temperatureDown = (Button) findViewById(R.id.bedroomTemperatureDownButton);
        temperatureDown.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                temperatureSet -= 1;
                temperatureView.setText(String.valueOf(temperatureSet) + ' ');
            }
        });

        lights = (ToggleButton) findViewById(R.id.bedroomLightsButton);
        lights.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                lights.setChecked(lights.isChecked());
                lightsState = lights.isChecked();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (HomeActivity.roomLightingOverrided) {
            lights.setChecked(false);
            lights.setEnabled(false);
        }
        else {
            lights.setChecked(lightsState);
            lights.setEnabled(true);
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(BedRoomActivity.this, HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
        spinner.setSelection(3);
    }
}
