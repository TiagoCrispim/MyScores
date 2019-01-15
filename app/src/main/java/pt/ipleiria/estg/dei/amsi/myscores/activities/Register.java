package pt.ipleiria.estg.dei.amsi.myscores.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import pt.ipleiria.estg.dei.amsi.myscores.R;

public class Register extends AppCompatActivity {
    private Button buttonRegistar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        
    }

    public void onClickRegistar(View view) {
        Intent loginActivity = new Intent(Register.this, LoginActivity.class);
        startActivity(loginActivity);
    }
}
