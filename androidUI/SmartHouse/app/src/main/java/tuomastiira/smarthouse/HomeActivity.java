package tuomastiira.smarthouse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

public class HomeActivity extends AppCompatActivity {

    private int outsideTemperature = 16;
    private int outsideHumidity = 40;
    private ToggleButton allDoors;
    private ToggleButton frontDoor;
    private ToggleButton backDoor;
    private ToggleButton roomLightingOverride;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);

        spinner = (Spinner) findViewById(R.id.homeSpinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View view, int position, long row_id) {
                switch (position) {
                    case 0:
                        break;
                    case 1:
                        Intent intent = new Intent(HomeActivity.this, MainRoomActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        startActivity(intent);
                        spinner.setSelection(0);
                        break;
                    case 2:
                        intent = new Intent(HomeActivity.this, LivingRoomActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        startActivity(intent);
                        spinner.setSelection(0);
                        break;
                    case 3:
                        intent = new Intent(HomeActivity.this, BedRoomActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        startActivity(intent);
                        spinner.setSelection(0);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }

        });

        TextView outsideTemperatureView = (TextView) findViewById(R.id.outsideTemperatureView);
        outsideTemperatureView.setText(String.valueOf(outsideTemperature));
        TextView outsideHumidityView = (TextView) findViewById(R.id.outsideHumidityView);
        outsideHumidityView.setText(String.valueOf(outsideHumidity));

        allDoors = (ToggleButton) findViewById(R.id.allDoorsButton);
        allDoors.setOnClickListener(new ToggleButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleDoor((ToggleButton) v.findViewById(R.id.allDoorsButton));
            }
        });
        frontDoor = (ToggleButton) findViewById(R.id.frontDoorButton);
        frontDoor.setOnClickListener(new ToggleButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleDoor((ToggleButton) v.findViewById(R.id.frontDoorButton));
            }
        });
        backDoor = (ToggleButton) findViewById(R.id.backDoorButton);
        backDoor.setOnClickListener(new ToggleButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleDoor((ToggleButton) v.findViewById(R.id.backDoorButton));
            }
        });

        roomLightingOverride = (ToggleButton) findViewById(R.id.roomLightingOverrideButton);
        roomLightingOverride.setOnClickListener(new ToggleButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleRoomLightingOverride();
            }
        });
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }

    private void toggleDoor(ToggleButton toggleButton) {
        switch (toggleButton.getId()) {
            case R.id.allDoorsButton:
                frontDoor.setChecked(allDoors.isChecked());
                backDoor.setChecked(allDoors.isChecked());
                break;
            case R.id.frontDoorButton:
                frontDoor.setChecked(frontDoor.isChecked());
                break;
            case R.id.backDoorButton:
                backDoor.setChecked(backDoor.isChecked());
                break;
        }
        allDoors.setChecked(frontDoor.isChecked() || backDoor.isChecked());
    }

    private void toggleRoomLightingOverride() {
        roomLightingOverride.setChecked(roomLightingOverride.isChecked());
    }

    public boolean getRoomLightingOverrideState() {
        return roomLightingOverride.isChecked();
    }
}
