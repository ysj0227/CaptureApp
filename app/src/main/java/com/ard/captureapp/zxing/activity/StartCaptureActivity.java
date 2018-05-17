package com.ard.captureapp.zxing.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ard.captureapp.R;


/**
 * Created by Administrator on 2016/7/11.
 */
public class StartCaptureActivity extends Activity {
    TextView tv=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zxing_start_layout);
        tv= (TextView) findViewById(R.id.zxing_text);
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartCaptureActivity.this, CaptureActivity.class);
                startActivityForResult(intent, 0x1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK&&data!=null){
            Bundle bundle=data.getExtras();
            tv.setText(bundle.getString("result"));
        }
    }
}
