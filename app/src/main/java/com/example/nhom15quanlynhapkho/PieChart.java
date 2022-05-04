package com.example.nhom15quanlynhapkho;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import java.util.ArrayList;

public class PieChart extends AppCompatActivity {
    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);

        Button btnSendEmail = findViewById(R.id.btnSendMail);
        btnSendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailsend = "english12a4@gmail.com";
                String emailsubject = "Send Email";
                String  emailBody = "This is my test";

                Intent intent = new Intent(Intent.ACTION_SEND);

                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{emailsend});
                intent.putExtra(Intent.EXTRA_SUBJECT, new String[]{emailsubject});
                intent.putExtra(Intent.EXTRA_TEXT, new String[]{emailBody});

                intent.setType("message/rfc822");
                startActivity(intent);
            }
        });

        BarChart barChart = findViewById(R.id.pieChart);
        ArrayList<BarEntry> visitors = new ArrayList<>();
        // thong ke so luong vien cua gach ong o kho binh chanh tu nam 2017 -> 2021
        visitors.add(new BarEntry(2017,5000));
        visitors.add(new BarEntry(2018,2000));
        visitors.add(new BarEntry(2019,3000));
        visitors.add(new BarEntry(2020,4500));
        visitors.add(new BarEntry(2021,2700));

        BarDataSet barDataSet = new BarDataSet(visitors,"Nhân viên");
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(16f);

        BarData barData = new BarData(barDataSet);
        barChart.setFitBars(true);
        barChart.setData(barData);
        barChart.getDescription().setText("Thống kê số lượng viên của gạch ống tại kho Bình Chánh");
        barChart.animateY(2000);
    }
}