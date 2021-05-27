package com.example.paint;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import petrov.kristiyan.colorpicker.ColorPicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    private Button saveButton, chooseColor;
    private TextView taskText;
    private DrawingView drawingView;
    ArrayList<String> colors = new ArrayList<>();

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeUI();
        setListeners();
        colors.add("#000000");
        colors.add("#808080");
        colors.add("#C0C0C0");
        colors.add("#FFFFFF");
        colors.add("#FF00FF");
        colors.add("#800080");
        colors.add("#FF0000");
        colors.add("#800000");
        colors.add("#FFFF00");
        colors.add("#808000");
        colors.add("#00FF00");
        colors.add("#008000");
        colors.add("#00FFFF");
        colors.add("#008080");
        colors.add("#0000FF");
        colors.add("#000080");
    }

    private void setListeners() {
        taskText.setOnClickListener(this);
        saveButton.setOnClickListener(this);
        chooseColor.setOnClickListener(this);
    }

    private void initializeUI() {
        drawingView = findViewById(R.id.scratch_pad);
        saveButton = findViewById(R.id.save_button);
        taskText = findViewById(R.id.taskText);
        chooseColor = findViewById(R.id.chooseColor);
    }

    @Override public void onClick(View view) {
        switch (view.getId()) {
            case R.id.save_button:
                drawingView.saveImage(Environment.getExternalStorageDirectory().toString(), "pic_" + new Date(),
                        Bitmap.CompressFormat.PNG, 100);
                drawingView.clear();
                break;
            case R.id.taskText:
                taskText.setText(getRandomTask());
                break;
            case R.id.chooseColor:
                final ColorPicker colorPicker = new ColorPicker(MainActivity.this);
                colorPicker.setColors(colors);
                colorPicker.setOnChooseColorListener(new ColorPicker.OnChooseColorListener() {
                    @Override
                    public void onChooseColor(int position,int color) {
                        // put code
                        drawingView.setPenColor(color);
                    }
                    @Override
                    public void onCancel(){
                        // put code
                    }
                }).show();
            default:
                break;
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

    }

    @Override public void onStartTrackingTouch(SeekBar seekBar) {
        //Intentionally Empty
    }

    @Override public void onStopTrackingTouch(SeekBar seekBar) {
        //Intentionally Empty
    }

    public String getRandomTask(){
        Random rand = new Random();
        List<String> tasks = new ArrayList<>();
        tasks.add("Подземный кит выпругнул из-под земли");
        tasks.add("Вид с 144 этажа");
        tasks.add("Зубы вампира");
        tasks.add("Деньги пришельцев");
        tasks.add("Ключ от всех дверей");
        return tasks.get(rand.nextInt(5));
    }

}