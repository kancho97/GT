package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.TestLooperManager;
import android.widget.ImageView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import android.os.Handler;
import android.os.Message;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    int count = 0;
    TextView text;
    Handler mHandler = new Handler(){
        public void handleMessage(Message msg){
            text = (TextView)findViewById(R.id.textView);
            count++;
            text.setText(String.valueOf(count));
            mHandler.removeMessages(0);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button)findViewById(R.id.button);
        btn.setOnLongClickListener(new Button.OnLongClickListener(){
            public boolean onLongClick(View v){
                mHandler.sendEmptyMessageDelayed(0, 100);
                return false;
            }

        });
    }
    public void mOnclick(View v){
        text = (TextView)findViewById(R.id.textView);
        count++;
        text.setText(String.valueOf(count));
        mHandler.removeMessages(0);
        if (count == 10){
            Toast.makeText(getApplicationContext(), "끝",Toast.LENGTH_SHORT).show();
            text = (TextView)findViewById(R.id.textView);
            count=0;
            text.setText(String.valueOf(count));
        }
    }
}