package pt.ipleiria.estg.dei.amsi.myscores;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Register extends AppCompatActivity {

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
