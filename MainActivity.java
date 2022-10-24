package br.com.bq.multiactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public void openActivity(View view, Class myClass){
        Intent intent = new Intent( packageContext: this, myClass);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button abre_second_activity = findViewById(R.id.abre_second_activity);
        abre_second_activity.setOnClickListener(new View.OnClickListener(){
        });
    }
}
