package com.example.etrainbooking.TrainController;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.etrainbooking.APIClient;
import com.example.etrainbooking.APIInterface;
import com.example.etrainbooking.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScheduleView extends AppCompatActivity {

    private RecyclerView recyclerView;
    private APIInterface apiInterface;
    private ScheduleAdapter scheduleAdapter;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_view);

        context =this;

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        apiInterface = APIClient.getClient().create(APIInterface.class);
        scheduleAdapter = new ScheduleAdapter(this);

        recyclerView.setAdapter(scheduleAdapter);

        List<Schedule> schedules = new ArrayList<>();

        schedules.add(new Schedule("1", "Colombo port", "Kalutara", "10.00AM", "11.30AM", "2023.10.20",true));
        schedules.add(new Schedule("2", "Colombo port", "Kandy", "08.00AM", "11.30AM", "2023.10.20",true));
        schedules.add(new Schedule("3", "Kalutara", "Galle", "11.00AM", "02.30PM", "2023.10.20",true));
        schedules.add(new Schedule("4", "Matara", "Kalutara", "10.00AM", "11.30AM", "2023.10.20",true));
        schedules.add(new Schedule("5", "Colombo port", "Kalutara", "10.00AM", "11.30AM", "2023.10.20",true));

        scheduleAdapter.setSchedules(schedules);

        // Fetch schedules from the API
//        Call<List<Schedule>> call = apiInterface.getSchedules();
//        call.enqueue(new Callback<List<Schedule>>() {
//            @Override
//            public void onResponse(Call<List<Schedule>> call, Response<List<Schedule>> response) {
//                if (response.isSuccessful()) {
//                    List<Schedule> schedules = response.body();
//                    scheduleAdapter.setSchedules(schedules);
//                } else {
//                    // Handle error response
//                    Toast.makeText(ScheduleView.this, "Error fetching schedules", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Schedule>> call, Throwable t) {
//                Log.e("API_CALL", "API call failed");
//                Log.e("API_CALL_URL", call.request().url().toString());
//                Log.e("API_CALL_ERROR", t.getMessage());
//                // Handle network or other errors
//                Toast.makeText(ScheduleView.this, "Network error", Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}
