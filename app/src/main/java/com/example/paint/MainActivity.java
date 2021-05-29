package com.example.paint;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import petrov.kristiyan.colorpicker.ColorPicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    private ImageButton chooseColor;
    private TextView taskText;
    private ImageButton saveButton;
    private DrawingView drawingView;
    ArrayList<String> tasks = new ArrayList<>();
    ArrayList<String> colors = new ArrayList<>();
    int i = 1;

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
        tasks.add("Подземный кит выпругнул из-под земли");
        tasks.add("Вид с 144 этажа");
        tasks.add("Зубы вампира");
        tasks.add("Деньги пришельцев");
        tasks.add("Ключ от всех дверей");
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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.save_button:
                drawingView.saveImage(Environment.getExternalStorageDirectory().toString(), "pic_" + new Date(),
                        Bitmap.CompressFormat.PNG, 100);
                drawingView.clear();
                break;
            case R.id.taskText:
                taskText.setText(tasks.get(i));
                if (i < tasks.size() - 1) {
                    i++;
                } else {
                    i = 0;
                }
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
}