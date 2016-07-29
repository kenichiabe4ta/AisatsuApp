package jp.techacademy.kenichi.abe.aisatsuapp;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;
import java.util.Calendar;
public class MainActivity extends AppCompatActivity {

    TextView mTextView;
    String Message="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.textView);
    }

    public void showTimePickerDialog(View v){
        Calendar calendar = Calendar.getInstance();
        int chour = calendar.get(Calendar.HOUR_OF_DAY);
        int cminute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Message = SetMassage(hourOfDay);
                        Log.d("test","設定時刻="+hourOfDay+":"+minute);
                    }
                },
                chour,      // TimePickerDialogを表示した時間を初期値にセット
                cminute,
                true);
        timePickerDialog.show();
    }

    private String SetMassage(int h){
        String Message="";
        if( (h>=2)&&(h<=9) ){
            Message="おはよう";
        }else if( (h>=10)&&(h<=17) ){
            Message="こんにちは";
        }else {
            Message="こんばんは";
        }
        return Message;
    }

    public void DisplayMessage(View v){
        if(Message != "" ){
            mTextView.setText(Message);
            Log.d("test",Message);
        }
    }
}
