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

public class HomeActivity extends AppCompatActivity {

    public static boolean roomLightingOverrideEnabled = false;
    public static boolean roomTemperatureOverrideEnabled = false;
    public static int roomTemperatureOverrideValue = 20;

    private Spinner spinner;
    private ToggleButton allDoorsButton;
    private ToggleButton frontDoorButton;
    private ToggleButton backDoorButton;
    private ToggleButton roomLightingOverrideButton;
    private ToggleButton roomTemperatureOverrideButton;
    private Button roomTemperatureUpButton;
    private Button roomTemperatureDownButton;
    private TextView roomTemperatureView;

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

        allDoorsButton = (ToggleButton) findViewById(R.id.allDoorsButton);
        allDoorsButton.setOnClickListener(new ToggleButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleDoor((ToggleButton) v.findViewById(R.id.allDoorsButton));
            }
        });
        frontDoorButton = (ToggleButton) findViewById(R.id.frontDoorButton);
        frontDoorButton.setOnClickListener(new ToggleButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleDoor((ToggleButton) v.findViewById(R.id.frontDoorButton));
            }
        });
        backDoorButton = (ToggleButton) findViewById(R.id.backDoorButton);
        backDoorButton.setOnClickListener(new ToggleButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleDoor((ToggleButton) v.findViewById(R.id.backDoorButton));
            }
        });

        roomLightingOverrideButton = (ToggleButton) findViewById(R.id.roomLightingOverrideButton);
        roomLightingOverrideButton.setOnClickListener(new ToggleButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleRoomLightingOverride();
            }
        });

        roomTemperatureOverrideButton = (ToggleButton) findViewById(R.id.roomTemperatureOverrideButton);
        roomTemperatureOverrideButton.setOnClickListener(new ToggleButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleRoomTemperatureOverride();
            }
        });

        roomTemperatureView = (TextView) findViewById(R.id.roomTemperatureSet);
        roomTemperatureView.setText(String.valueOf(roomTemperatureOverrideValue) + ' ');
        roomTemperatureUpButton = (Button) findViewById(R.id.roomTemperatureUpButton);
        roomTemperatureUpButton.setEnabled(false);
        roomTemperatureUpButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                roomTemperatureOverrideValue += 1;
                roomTemperatureView.setText(String.valueOf(roomTemperatureOverrideValue) + ' ');
            }
        });
        roomTemperatureDownButton = (Button) findViewById(R.id.roomTemperatureDownButton);
        roomTemperatureDownButton.setEnabled(false);
        roomTemperatureDownButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                roomTemperatureOverrideValue -= 1;
                roomTemperatureView.setText(String.valueOf(roomTemperatureOverrideValue) + ' ');
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
                frontDoorButton.setChecked(allDoorsButton.isChecked());
                backDoorButton.setChecked(allDoorsButton.isChecked());
                break;
            case R.id.frontDoorButton:
                frontDoorButton.setChecked(frontDoorButton.isChecked());
                break;
            case R.id.backDoorButton:
                backDoorButton.setChecked(backDoorButton.isChecked());
                break;
        }
        allDoorsButton.setChecked(frontDoorButton.isChecked() || backDoorButton.isChecked());
    }

    private void toggleRoomLightingOverride() {
        roomLightingOverrideButton.setChecked(roomLightingOverrideButton.isChecked());
        roomLightingOverrideEnabled = roomLightingOverrideButton.isChecked();
    }

    private void toggleRoomTemperatureOverride() {
        roomTemperatureOverrideButton.setChecked(roomTemperatureOverrideButton.isChecked());
        roomTemperatureOverrideEnabled = roomTemperatureOverrideButton.isChecked();
        roomTemperatureUpButton.setEnabled(roomTemperatureOverrideButton.isChecked());
        roomTemperatureDownButton.setEnabled(roomTemperatureOverrideButton.isChecked());
    }
}
