package com.example.paint;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.pes.androidmaterialcolorpickerdialog.ColorPicker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    private Button penButton, eraserButton, penColorButton, backgroundColorButton, clearButton;
    private TextView taskText;
    private DrawingView drawingView;
    private SeekBar penSizeSeekBar, eraserSizeSeekBar;
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeUI();
        setListeners();
    }

    private void setListeners() {
//        penButton.setOnClickListener(this);
//        eraserButton.setOnClickListener(this);
//        penColorButton.setOnClickListener(this);
//        backgroundColorButton.setOnClickListener(this);
//        penSizeSeekBar.setOnSeekBarChangeListener(this);
//        eraserSizeSeekBar.setOnSeekBarChangeListener(this);
        clearButton.setOnClickListener(this);
        taskText.setOnClickListener(this);
    }

    private void initializeUI() {
        drawingView = findViewById(R.id.scratch_pad);
//        penButton = findViewById(R.id.pen_button);
//        eraserButton = findViewById(R.id.eraser_button);
//        penColorButton = findViewById(R.id.pen_color_button);
//        backgroundColorButton = findViewById(R.id.background_color_button);
//        penSizeSeekBar = findViewById(R.id.pen_size_seekbar);
//        eraserSizeSeekBar = findViewById(R.id.eraser_size_seekbar);
        clearButton = findViewById(R.id.clear_button);
        taskText = findViewById(R.id.taskText);
    }

    @Override public void onClick(View view) {
        switch (view.getId()) {
            case R.id.taskText:
                taskText.setText(getRandomTask());
                break;
//            case R.id.pen_button:
//                drawingView.initializePen();
//                break;
//            case R.id.eraser_button:
//                drawingView.initializeEraser();
//                break;
            case R.id.clear_button:
                drawingView.clear();
                break;
//            case R.id.pen_color_button:
//                final ColorPicker colorPicker = new ColorPicker(MainActivity.this, 100, 100, 100);
//                colorPicker.setCallback(
//                        color -> {
//                            drawingView.setPenColor(color);
//                            colorPicker.dismiss();
//                        });
//                colorPicker.show();
//                break;
//            case  R.id.pen_collor_button:
//                ColorSheet().colorPicker(
//                        colors = colors,
//                        drawingView = { color ->
//                                // Handle color
//                        })
//                        .show(supportFragmentManager)
//                        break;
//            case R.id.background_color_button:
//                final ColorPicker backgroundColorPicker = new ColorPicker(MainActivity.this, 100, 100, 100);
//                backgroundColorPicker.setCallback(
//                        color -> {
//                            drawingView.setBackgroundColor(color);
//                            backgroundColorPicker.dismiss();
//                        });
//                backgroundColorPicker.show();
//                break;
            default:
                break;
        }
    }

    @Override public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
//        int seekBarId = seekBar.getId();
//        if (seekBarId == R.id.pen_size_seekbar) {
//            drawingView.setPenSize(i);
//        } else if (seekBarId == R.id.eraser_size_seekbar) {
//            drawingView.setEraserSize(i);
//        }
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
        tasks.add("Нарисуй рыбу");
        tasks.add("Нарисуй подвал");
        tasks.add("Нарисуй калитку");
        tasks.add("Нарисуй себя");
        tasks.add("Нарисуй абырвалг");

        return tasks.get(rand.nextInt(5));
    }

}