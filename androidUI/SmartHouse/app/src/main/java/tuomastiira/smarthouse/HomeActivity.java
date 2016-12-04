package tuomastiira.smarthouse;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

public class HomeActivity extends AppCompatActivity {

    private int outsideTemperature = 16;
    private int outsideHumidity = 40;
    private ToggleButton allDoors;
    private ToggleButton frontDoor;
    private ToggleButton backDoor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);

        TextView outsideTemperatureView = (TextView) findViewById(R.id.outsideTemperatureView);
        outsideTemperatureView.setText(String.valueOf(this.outsideTemperature));
        TextView outsideHumidityView = (TextView) findViewById(R.id.outsideHumidityView);
        outsideHumidityView.setText(String.valueOf(this.outsideHumidity));

        this.allDoors = (ToggleButton) findViewById(R.id.allDoorsLockedButton);
        this.allDoors.setOnClickListener(new ToggleButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleDoor((ToggleButton) v.findViewById(R.id.allDoorsLockedButton));
            }
        });
        this.frontDoor = (ToggleButton) findViewById(R.id.frontDoorLockedButton);
        this.frontDoor.setOnClickListener(new ToggleButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleDoor((ToggleButton) v.findViewById(R.id.frontDoorLockedButton));
            }
        });
        this.backDoor = (ToggleButton) findViewById(R.id.backDoorLockedButton);
        this.backDoor.setOnClickListener(new ToggleButton.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleDoor((ToggleButton) v.findViewById(R.id.backDoorLockedButton));
            }
        });
    }

    private void toggleDoor(ToggleButton toggleButton) {
        switch (toggleButton.getId()) {
            case R.id.allDoorsLockedButton:
                this.frontDoor.setChecked(this.allDoors.isChecked());
                this.backDoor.setChecked(this.allDoors.isChecked());
                break;
            case R.id.frontDoorLockedButton:
                this.frontDoor.setChecked(this.frontDoor.isChecked());
                break;
            case R.id.backDoorLockedButton:
                this.backDoor.setChecked(this.backDoor.isChecked());
                break;
        }
        this.allDoors.setChecked(this.frontDoor.isChecked() || this.backDoor.isChecked());
    }
}
