package devandroid.ssg.appgaseta.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import devandroid.ssg.appgaseta.R;
import devandroid.ssg.appgaseta.apoio.UtilGasEta;
import devandroid.ssg.appgaseta.controller.CombustivelController;
import devandroid.ssg.appgaseta.model.Combustivel;

public class GasEtaActivity extends AppCompatActivity {

    //UtilGasEta utilGasEta = new UtilGasEta();
    CombustivelController controller;
    Combustivel combustivelGasolina;
    Combustivel combustivelEtanol;
    EditText editGasolina;
    EditText editEtanol;
    TextView txtResultado;
    Button btnCalcular;
    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;
    double precoGasolina;
    double precoEtanol;
    String recomendacao;

    List<Combustivel> dados;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_gaseta);

        controller = new CombustivelController(GasEtaActivity.this);
        dados = controller.getListaDados();

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

                boolean isDadosOk = true;

                 if(TextUtils.isEmpty(editGasolina.getText())){
                     editGasolina.setError("* Dados Obrigatório *");
                     editGasolina.requestFocus();
                     isDadosOk = false;
                 }
                 if(TextUtils.isEmpty(editEtanol.getText())){
                     editEtanol.setError("* Dados Obrigatório *");
                     editEtanol.requestFocus();
                     isDadosOk = false;
                 }
                 if(isDadosOk){
                      // calcular gasolina vs etanol
                     precoGasolina = Double.parseDouble(editGasolina.getText().toString());
                     precoEtanol = Double.parseDouble(editEtanol.getText().toString());

                     recomendacao = UtilGasEta.calcularMelhorOpcao(precoGasolina,precoEtanol);

                     txtResultado.setText(recomendacao);

                     btnSalvar.setEnabled(true);  // Abilita o Buttom Salvar.

                 }else{
                     Toast.makeText(GasEtaActivity.this, "Favor,digite os Dados Obrigatórios ...", Toast.LENGTH_LONG).show();

                     btnSalvar.setEnabled(false);  // Desabilita o Buttom Salvar.

                 }

               }
            });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editGasolina.setText("");
                editEtanol.setText("");

                btnSalvar.setEnabled(false); // Desabilita o Bottom salvar.

                controller.limpar();
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                combustivelGasolina = new Combustivel();
                combustivelEtanol = new Combustivel();

                combustivelGasolina.setNomeDoCombustivel("Gasolina");
                combustivelGasolina.setPrecoDoCombustivel(precoGasolina);

                combustivelEtanol.setNomeDoCombustivel("Etanol");
                combustivelEtanol.setPrecoDoCombustivel(precoEtanol);

                combustivelGasolina.setRecomendacao(UtilGasEta.calcularMelhorOpcao(precoGasolina,precoEtanol));
                combustivelEtanol.setRecomendacao(UtilGasEta.calcularMelhorOpcao(precoGasolina,precoEtanol));

                controller.salvar(combustivelGasolina);
                //controller.salvar(combustivelEtanol);

            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GasEtaActivity.this, "Boa Ecônomia..", Toast.LENGTH_LONG).show();
                finish();

            }
        });



                Toast.makeText(GasEtaActivity.this, UtilGasEta.calcularMelhorOpcao(5.10, 3.50), Toast.LENGTH_LONG).show();


    }
}
