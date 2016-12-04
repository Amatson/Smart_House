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

public class MainRoomActivity extends AppCompatActivity {

    private Spinner spinner;
    private ToggleButton lights;
    private boolean lightsState;
    private int temperatureSet = 21;
    private Button temperatureUp;
    private Button temperatureDown;
    private TextView temperatureView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_room);

        spinner = (Spinner) findViewById(R.id.mainroomSpinner);
        spinner.setSelection(1);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View view, int position, long row_id) {
                switch (position) {
                    case 0:
                        Intent intent = new Intent(MainRoomActivity.this, HomeActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        startActivity(intent);
                        spinner.setSelection(1);
                        break;
                    case 1:
                        break;
                    case 2:
                        intent = new Intent(MainRoomActivity.this, LivingRoomActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        startActivity(intent);
                        spinner.setSelection(1);
                        break;
                    case 3:
                        intent = new Intent(MainRoomActivity.this, BedRoomActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        startActivity(intent);
                        spinner.setSelection(1);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // pass
            }
        });

        temperatureView = (TextView) findViewById(R.id.mainroomTemperatureSet);
        temperatureView.setText(String.valueOf(temperatureSet) + ' ');

        temperatureUp = (Button) findViewById(R.id.mainroomTemperatureUpButton);
        temperatureUp.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                temperatureSet += 1;
                temperatureView.setText(String.valueOf(temperatureSet) + ' ');
            }
        });
        temperatureDown = (Button) findViewById(R.id.mainroomTemperatureDownButton);
        temperatureDown.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                temperatureSet -= 1;
                temperatureView.setText(String.valueOf(temperatureSet) + ' ');
            }
        });

        lights = (ToggleButton) findViewById(R.id.mainroomLightsButton);
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
        Intent intent = new Intent(MainRoomActivity.this, HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
        spinner.setSelection(1);
    }
}
