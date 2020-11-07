package com.example.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ProgressBar pb1;
    EditText editText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        init();
    }

    private void init(){
        RadioGroup rg = findViewById(R.id.rg1);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                Toast toast = Toast.makeText(MainActivity.this,"您投票的景点是：" + radioButton.getText(),Toast.LENGTH_LONG);
                toast.show();
            }
        });

        Button b1 = findViewById(R.id.bu1);
        Button b2 = findViewById(R.id.bu2);
        Button b3 = findViewById(R.id.bu3);
        pb1 = findViewById(R.id.pb1);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        pb1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.bu1:
                updateProgress(true);
                break;
            case R.id.bu2:
                updateProgress(false);
                break;
            case R.id.bu3:
                onSubmitConfirm();
                break;
        }
    }

    public void updateProgress(boolean plus){
        int progress = pb1.getProgress();
        if(plus){
            progress += 10;
        }
        else {
            progress -= 10;
        }
        pb1.setProgress(progress);
    }

    private void onSubmitConfirm(){
        AlertDialog ad;
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("普通对话框")
                .setIcon(R.mipmap.ic_launcher)
                .setMessage("是否确定提交")
                .setNegativeButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        onSubmit();
                    }
                })
                .setPositiveButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
    }

    private void onSubmit(){
        editText = findViewById(R.id.et1);
        System.out.println(editText.getText());
        editText.setText("");
    }
}
