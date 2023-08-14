package sg.edu.rp.c346.id21023395.demodialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {

    Button btnDemo1, btnDemo2, btnDemo3, btnEx3, btnDemo4, btnDemo5;
    TextView tvDemo2, tvDemo3, tvEx3, tvDemo4, tvDemo5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDemo1 = findViewById(R.id.buttonDemo1);
        tvDemo2 = findViewById(R.id.textViewDemo2);
        btnDemo2 = findViewById(R.id.buttonDemo2);
        tvDemo3 = findViewById(R.id.textViewDemo3);
        btnDemo3 = findViewById(R.id.buttonDemo3);
        tvEx3 = findViewById(R.id.textViewEx3);
        btnEx3 = findViewById(R.id.buttonEx3);
        tvDemo4 = findViewById(R.id.textViewDemo4);
        btnDemo4 = findViewById(R.id.buttonDemo4);
        tvDemo5 = findViewById(R.id.textViewDemo5);
        btnDemo5 = findViewById(R.id.buttonDemo5);

        btnDemo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the Dialog Builder
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                // Set the dialog details
/*                myBuilder.setTitle("Demo 1 - Simple Dialog");
                myBuilder.setMessage("I can develop Android App.");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Close", null);*/

                myBuilder.setTitle("Congratulations");
                myBuilder.setMessage("You have completed a simple Dialog Box");
                myBuilder.setCancelable(true);
                myBuilder.setPositiveButton("DISMISS", null);

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        btnDemo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setTitle("Demo 2 Buttons Dialog");
                myBuilder.setMessage("Select  one of the Buttons below.");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvDemo2.setText("You have selected Positive.");
                    }
                });
                myBuilder.setNeutralButton("CANCEL", null);
                myBuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvDemo2.setText("You have selected Negative.");

                    }
                });
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        btnDemo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Inflate the input.xml layout file
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input, null);

                // Obtain the UI component in the input .xml layout
                // It needs to be defined as "final", so it can be used in the onclick() method
                final EditText etInput = viewDialog.findViewById(R.id.editTextInput);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog); // set the view of the dialog
                myBuilder.setTitle("Demo 3 Text Input Dialog");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvDemo3.setText(etInput.getText().toString());
                    }
                });
                myBuilder.setNeutralButton("CANCEL", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        btnEx3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Inflate the input.xml layout file
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.inputex3, null);

                // Obtain the UI component in the input .xml layout
                // It needs to be defined as "final", so it can be used in the onclick() method
                final EditText etInput1 = viewDialog.findViewById(R.id.editTextInputnum1);
                final EditText etInput2 = viewDialog.findViewById(R.id.editTextInputnum2);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog); // set the view of the dialog
                myBuilder.setTitle("EXERCISE 3");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int num1 = Integer.parseInt(etInput1.getText().toString());
                        int num2 = Integer.parseInt(etInput2.getText().toString());
                        int total = num1 + num2;
                        tvEx3.setText("The sum is " + total);
                    }
                });
                myBuilder.setNeutralButton("CANCEL", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        btnDemo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the Listener to set the date

                DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        tvDemo4.setText("Date: " + dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                };

                // Create the Date Picker Dialog
                Calendar calendar = Calendar.getInstance();
                int currentYear = calendar.get(Calendar.YEAR);
                int currentMonth = calendar.get(Calendar.MONTH);
                int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this,
                        myDateListener, currentYear, currentMonth, currentDay);
                myDateDialog.show();
            }
        });

        btnDemo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the Listener to set the time
                TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        tvDemo5.setText("Time: " + hourOfDay + ":" + minute);
                    }
                };

                // Create the Time Picker Dialog
                Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Singapore"));
                int currentHour = calendar.get(Calendar.HOUR);
                int currentMin = calendar.get(Calendar.MINUTE);
                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this,
                        myTimeListener, currentHour, currentMin, false);
                myTimeDialog.show();
            }
        });
    }
}