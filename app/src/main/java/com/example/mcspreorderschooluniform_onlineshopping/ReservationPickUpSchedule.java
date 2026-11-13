package com.example.mcspreorderschooluniform_onlineshopping;


import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ReservationPickUpSchedule extends AppCompatActivity {

    private EditText etReservationDate;
    private EditText etPickupTime;
    private EditText etStudentId;
    private EditText etPickupDate;
    private Button btnSchedulePickup;

    private final SimpleDateFormat dateFormat =
            new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_pick_up_schedule);

        etReservationDate = findViewById(R.id.etReservationDate);
        etPickupTime = findViewById(R.id.etPickupTime);
        etStudentId = findViewById(R.id.etStudentId);
        etPickupDate = findViewById(R.id.etPickupDate);
        btnSchedulePickup = findViewById(R.id.btnSchedulePickup);

        etReservationDate.setOnClickListener(v ->
                showReservationDatePicker());

        etPickupTime.setOnClickListener(v ->
                showTimePicker());

        etPickupDate.setOnClickListener(v ->
                showPickupDatePicker());

        btnSchedulePickup.setOnClickListener(v ->
                schedulePickup());
    }

    private Calendar getToday() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar;
    }

    private void showReservationDatePicker() {

        Calendar today = getToday();

        DatePickerDialog datePicker = new DatePickerDialog(
                this,
                (view, year, month, dayOfMonth) -> {

                    Calendar selectedDate = Calendar.getInstance();
                    selectedDate.set(year, month, dayOfMonth);
                    selectedDate.set(Calendar.HOUR_OF_DAY, 0);
                    selectedDate.set(Calendar.MINUTE, 0);
                    selectedDate.set(Calendar.SECOND, 0);
                    selectedDate.set(Calendar.MILLISECOND, 0);

                    String formattedDate =
                            dateFormat.format(selectedDate.getTime());

                    etReservationDate.setText(formattedDate);
                    etReservationDate.setError(null);

                    String pickupDate =
                            etPickupDate.getText().toString().trim();

                    if (!pickupDate.isEmpty()) {
                        try {
                            Date pickup = dateFormat.parse(pickupDate);

                            if (pickup != null &&
                                    pickup.before(selectedDate.getTime())) {
                                etPickupDate.setText("");
                                Toast.makeText(
                                        this,
                                        "Please select a new pickup date.",
                                        Toast.LENGTH_SHORT
                                ).show();
                            }
                        } catch (ParseException e) {
                            etPickupDate.setText("");
                        }
                    }
                },
                today.get(Calendar.YEAR),
                today.get(Calendar.MONTH),
                today.get(Calendar.DAY_OF_MONTH)
        );

        datePicker.getDatePicker().setMinDate(today.getTimeInMillis());
        datePicker.show();
    }

    private void showPickupDatePicker() {

        String reservationDate =
                etReservationDate.getText().toString().trim();

        if (reservationDate.isEmpty()) {
            etReservationDate.setError(
                    "Please select reservation date first."
            );
            etReservationDate.requestFocus();

            Toast.makeText(
                    this,
                    "Select reservation date first.",
                    Toast.LENGTH_SHORT
            ).show();

            return;
        }

        Calendar minimumDate = getToday();

        try {
            Date date = dateFormat.parse(reservationDate);

            if (date != null) {
                minimumDate.setTime(date);
            }

        } catch (ParseException e) {
            Toast.makeText(
                    this,
                    "Invalid reservation date.",
                    Toast.LENGTH_SHORT
            ).show();
            return;
        }

        DatePickerDialog datePicker = new DatePickerDialog(
                this,
                (view, year, month, dayOfMonth) -> {

                    Calendar selectedDate = Calendar.getInstance();
                    selectedDate.set(year, month, dayOfMonth);
                    selectedDate.set(Calendar.HOUR_OF_DAY, 0);
                    selectedDate.set(Calendar.MINUTE, 0);
                    selectedDate.set(Calendar.SECOND, 0);
                    selectedDate.set(Calendar.MILLISECOND, 0);

                    etPickupDate.setText(
                            dateFormat.format(selectedDate.getTime())
                    );

                    etPickupDate.setError(null);
                },
                minimumDate.get(Calendar.YEAR),
                minimumDate.get(Calendar.MONTH),
                minimumDate.get(Calendar.DAY_OF_MONTH)
        );

        datePicker.getDatePicker().setMinDate(
                minimumDate.getTimeInMillis()
        );

        datePicker.show();
    }

    private void showTimePicker() {

        Calendar calendar = Calendar.getInstance();

        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePicker = new TimePickerDialog(
                this,
                (view, selectedHour, selectedMinute) -> {

                    Calendar selectedTime = Calendar.getInstance();

                    selectedTime.set(Calendar.HOUR_OF_DAY, selectedHour);
                    selectedTime.set(Calendar.MINUTE, selectedMinute);

                    SimpleDateFormat timeFormat =
                            new SimpleDateFormat(
                                    "hh:mm a",
                                    Locale.getDefault()
                            );

                    String formattedTime =
                            timeFormat.format(selectedTime.getTime());

                    etPickupTime.setText(formattedTime);
                    etPickupTime.setError(null);
                },
                hour,
                minute,
                false
        );

        timePicker.show();
    }

    private void schedulePickup() {

        String reservationDate =
                etReservationDate.getText().toString().trim();

        String pickupTime =
                etPickupTime.getText().toString().trim();

        String studentId =
                etStudentId.getText().toString().trim();

        String pickupDate =
                etPickupDate.getText().toString().trim();

        if (reservationDate.isEmpty()) {
            etReservationDate.setError("Select reservation date.");
            etReservationDate.requestFocus();
            return;
        }

        if (pickupTime.isEmpty()) {
            etPickupTime.setError("Select pickup time.");
            etPickupTime.requestFocus();
            return;
        }

        if (studentId.isEmpty()) {
            etStudentId.setError("Enter your Student ID.");
            etStudentId.requestFocus();
            return;
        }

        if (!studentId.matches("[0-9]+")) {
            etStudentId.setError("Student ID must contain numbers only.");
            etStudentId.requestFocus();
            return;
        }

        if (pickupDate.isEmpty()) {
            etPickupDate.setError("Select pickup date.");
            etPickupDate.requestFocus();
            return;
        }

        try {
            Date reservation = dateFormat.parse(reservationDate);
            Date pickup = dateFormat.parse(pickupDate);
            Date today = getToday().getTime();

            if (reservation == null || pickup == null) {
                Toast.makeText(
                        this,
                        "Invalid date. Please try again.",
                        Toast.LENGTH_SHORT
                ).show();
                return;
            }

            if (reservation.before(today)) {
                etReservationDate.setError(
                        "Reservation date cannot be in the past."
                );
                return;
            }

            if (pickup.before(reservation)) {
                etPickupDate.setError(
                        "Pickup date cannot be before reservation date."
                );
                return;
            }

        } catch (ParseException e) {
            Toast.makeText(
                    this,
                    "Date format error. Please select dates again.",
                    Toast.LENGTH_SHORT
            ).show();
            return;
        }

        String confirmationMessage =
                "Please check your reservation details:\n\n" +
                        "Reservation Date: " + reservationDate + "\n\n" +
                        "Pickup Time: " + pickupTime + "\n\n" +
                        "Student ID: " + studentId + "\n\n" +
                        "Pickup Date: " + pickupDate;

        new AlertDialog.Builder(this)
                .setTitle("Confirm Pickup Schedule")
                .setMessage(confirmationMessage)
                .setPositiveButton("Confirm", (dialog, which) -> {

                    Toast.makeText(
                            ReservationPickUpSchedule.this,
                            "Pickup schedule confirmed successfully!",
                            Toast.LENGTH_LONG
                    ).show();

                    etReservationDate.setText("");
                    etPickupTime.setText("");
                    etStudentId.setText("");
                    etPickupDate.setText("");

                })
                .setNegativeButton("Edit Details", (dialog, which) -> {
                    dialog.dismiss();
                })
                .setCancelable(false)
                .show();
    }
}