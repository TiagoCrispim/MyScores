package pt.ipleiria.estg.dei.amsi.myscores.activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import pt.ipleiria.estg.dei.amsi.myscores.R;
import pt.ipleiria.estg.dei.amsi.myscores.classes.User;
import pt.ipleiria.estg.dei.amsi.myscores.singletonClasses.SingletonUsers;

public class Register extends AppCompatActivity {
    private EditText inputUsername, inputNome, inputEmail, inputNacionalidade, inputDataNascimento, inputPassword;
    private Button buttonRegistar;
    private View mProgressView;
    private View mRegistoFormView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        inputUsername = (EditText) findViewById(R.id.username);
        inputNome = (EditText) findViewById(R.id.nome);
        inputDataNascimento = (EditText) findViewById(R.id.dataNascimento);
        inputEmail = (EditText) findViewById(R.id.email);
        inputNacionalidade = (EditText) findViewById(R.id.nacionalidade);
        inputPassword = (EditText) findViewById(R.id.password);

        this.buttonRegistar = findViewById(R.id.buttonRegistar);

        mProgressView = findViewById(R.id.login_progress);

        this.buttonRegistar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registarNovoUser();
            }
        });

        mProgressView = findViewById(R.id.registo_progress);
        mRegistoFormView = findViewById(R.id.registo_form);

    }

    public void registarNovoUser() {

        showProgress(true);

        String username = this.inputUsername.getText().toString();
        String nome = this.inputNome.getText().toString();
        String email = this.inputEmail.getText().toString();
        String nacionalidade = this.inputNacionalidade.getText().toString();
        String dataNascimento = this.inputDataNascimento.getText().toString();
        String password = this.inputPassword.getText().toString();

        SingletonUsers.getInstance(getApplicationContext()).registoAPI(username, nome, dataNascimento, email, nacionalidade, password, getApplicationContext());

        (new Handler()).postDelayed(new Runnable() {
            @Override
            public void run() {
                checkRegister();
            }
        },5000);

    }

    public void checkRegister(){
        String dados = SingletonUsers.getInstance(this).returnDadosRegisto();

        if ( dados == null){
            Toast.makeText(this, "Something's Wrong", Toast.LENGTH_LONG).show();
            showProgress(false);
        }else{
            showProgress(false);
            Intent loginActivity = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(loginActivity);
        }

    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mRegistoFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mRegistoFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mRegistoFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mRegistoFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }

}
