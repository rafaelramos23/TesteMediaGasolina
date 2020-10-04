package com.example.extelas;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btTelaMedia, btCalculaMedia, btVoltarInicio, btVoltarInicio2,btCalcCombustivel, btTelaCombustivel;
    EditText edP1, edProjeto, edListas, edGasosa, edEtanol;
    TextView txResultado, txCombustivel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        carregaTelaInicial();
    }

    private void carregaTelaInicial(){
        setContentView(R.layout.activity_main);
        carregaWidgetsInicio();
        eventoTelas();
    }
    private void carregaWidgetsInicio(){
        btTelaMedia=(Button)findViewById(R.id.btnTelaMedia);
        btTelaCombustivel=(Button)findViewById(R.id.btnTelaCombustivel);

    }

    private void carregaWidgetsMedia(){
        edP1 = (EditText)findViewById(R.id.edtP1);
        edProjeto = (EditText)findViewById(R.id.edtProjeto);
        edListas = (EditText) findViewById(R.id.edtLista);
        txResultado = (TextView)findViewById(R.id.txtResulMedia);
        btCalculaMedia = (Button)findViewById(R.id.btnCalcMedia);
        btVoltarInicio = (Button)findViewById(R.id.btnvoltar);
        calculaMedia();

    }

    private void carregaWidgetsCombustivel(){
            edGasosa = (EditText)findViewById(R.id.edtGasolina);
            edEtanol = (EditText)findViewById(R.id.edtEtanol);
            txCombustivel = (TextView)findViewById(R.id.txtResulCombustivel);
            btCalcCombustivel = (Button)findViewById(R.id.btnCalcCombustivel);
            btVoltarInicio2 = (Button)findViewById(R.id.btnvoltar2);
            calculaCombustivel();
    }

    private void eventoTelas(){
        btTelaMedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.telamedia);
                carregaWidgetsMedia();
            }
        });

        btTelaCombustivel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_combustivel);
                carregaWidgetsCombustivel();
            }
        });


    }

    private void calculaMedia(){
        btCalculaMedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double notaP1, notaProjeto, pontosLista, mediaFinal;
                notaP1 = Double.parseDouble(edP1.getText().toString());
                notaProjeto = Double.parseDouble(edProjeto.getText().toString());
                pontosLista = Double.parseDouble(edListas.getText().toString());

                if (pontosLista>3){
                        txResultado.setTextColor(Color.GREEN);
                        txResultado.setText(String.valueOf("A Pontuação Máxima em lista é de 3 pontos"));
                }
                else {
                    mediaFinal = (notaP1 * 0.3) + (notaProjeto * 0.5) + pontosLista;


                    if (mediaFinal >= 5) {
                        txResultado.setTextColor(Color.BLUE);
                        txResultado.setText(String.valueOf("Média Final: " + mediaFinal + " Aluno Aprovado"));
                    }
                    else {
                        txResultado.setTextColor(Color.RED);
                        txResultado.setText(String.valueOf("Média Final: " + mediaFinal + " Aluno Reprovado"));
                    }
                }
            }
        });
        btVoltarInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carregaTelaInicial();
            }
        });
    }

    private void calculaCombustivel(){
        btCalcCombustivel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double gasolina, etanol, resultado;
                gasolina = Double.parseDouble(edGasosa.getText().toString());
                etanol = Double.parseDouble(edEtanol.getText().toString());
                resultado = etanol/gasolina;

                if (resultado<0.7){
                    txCombustivel.setTextColor(Color.BLUE);
                    txCombustivel.setText((String.valueOf((Math.round(resultado*100))+"%, é indicado o abastecimento com Etanol")));
                }
                else {
                    txCombustivel.setTextColor(Color.GREEN);
                    txCombustivel.setText((String.valueOf((Math.round(resultado*100))+"%, é indicado o abastecimento com Gasolina")));
                }
                }

        });
        btVoltarInicio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carregaTelaInicial();
            }
        });
    }

}
