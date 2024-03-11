package devandroid.ssg.appgaseta.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import devandroid.ssg.appgaseta.R;
import devandroid.ssg.appgaseta.apoio.UtilGasEta;

public class GasEtaActivity extends AppCompatActivity {

    //UtilGasEta utilGasEta = new UtilGasEta();
    EditText editGasolina;
    EditText editEtanol;
    TextView txtResultado;
    Button btnCalcular;
    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_gaseta);

        //utilGasEta.MetodoEstatico();
        //UtilGasEta.MetodoNaoEstatico();

        editGasolina = findViewById(R.id.editGasolina);
        editEtanol = findViewById(R.id.editEtanol);

        txtResultado = findViewById(R.id.txtResultado);

        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        btnCalcular.setOnClickListener(new View.OnClickListener(){
                                           @Override
            public void onClick(View v) {


               }
            });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GasEtaActivity.this, "Volte Sempre!", Toast.LENGTH_LONG).show();
                finish();

            }
        });



                Toast.makeText(GasEtaActivity.this, UtilGasEta.calcularMelhorOpcao(5.10, 3.50), Toast.LENGTH_LONG).show();


    }
}
