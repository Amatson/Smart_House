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

public class LivingRoomActivity extends AppCompatActivity {

    private Spinner spinner;
    private ToggleButton lightsButton;
    private boolean lightsState;
    private int temperatureSet = 22;
    private Button temperatureUpButton;
    private Button temperatureDownButton;
    private TextView temperatureView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_living_room);

        spinner = (Spinner) findViewById(R.id.livingroomSpinner);
        spinner.setSelection(2);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View view, int position, long row_id) {
                Intent intent;
                switch (position) {
                    case 0:
                        intent = new Intent(LivingRoomActivity.this, HomeActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        startActivity(intent);
                        spinner.setSelection(2);
                        break;
                    case 1:
                        intent = new Intent(LivingRoomActivity.this, MainRoomActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        startActivity(intent);
                        spinner.setSelection(2);
                        break;
                    case 2:
                        break;
                    case 3:
                        intent = new Intent(LivingRoomActivity.this, BedRoomActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        startActivity(intent);
                        spinner.setSelection(2);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // pass
            }
        });

        temperatureView = (TextView) findViewById(R.id.livingroomTemperatureSet);
        temperatureView.setText(String.valueOf(temperatureSet) + ' ');

        temperatureUpButton = (Button) findViewById(R.id.roomTemperatureUpButton);
        temperatureUpButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                temperatureSet += 1;
                temperatureView.setText(String.valueOf(temperatureSet) + ' ');
            }
        });
        temperatureDownButton = (Button) findViewById(R.id.roomTemperatureDownButton);
        temperatureDownButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                temperatureSet -= 1;
                temperatureView.setText(String.valueOf(temperatureSet) + ' ');
            }
        });

        lightsButton = (ToggleButton) findViewById(R.id.livingroomLightsButton);
        lightsButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                lightsButton.setChecked(lightsButton.isChecked());
                lightsState = lightsButton.isChecked();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (HomeActivity.roomLightingOverrideEnabled) {
            lightsButton.setChecked(false);
            lightsButton.setEnabled(false);
        } else {
            lightsButton.setChecked(lightsState);
            lightsButton.setEnabled(true);
        }

        if (HomeActivity.roomTemperatureOverrideEnabled) {
            temperatureView.setText(String.valueOf(HomeActivity.roomTemperatureOverrideValue) + ' ');
            temperatureUpButton.setEnabled(false);
            temperatureDownButton.setEnabled(false);
        }
        else {
            temperatureView.setText(String.valueOf(temperatureSet) + ' ');
            temperatureUpButton.setEnabled(true);
            temperatureDownButton.setEnabled(true);
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(LivingRoomActivity.this, HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
        spinner.setSelection(2);
    }
}
