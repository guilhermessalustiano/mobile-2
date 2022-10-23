package com.example.dadoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myButtonListenerMethod();
        rangeListener();
        imagem();
    }

    public void rangeListener(){
        SeekBar seekBarTest = findViewById(R.id.seekBar);
        final TextView textRetorno =  findViewById(R.id.resultadoDado);
        final ImageView imageDado = findViewById(R.id.imagemDado);

        seekBarTest.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                float scale = ((progress / 100.0f) + 1);
                imageDado.setScaleX(scale);
                imageDado.setScaleY(scale);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                imageDado.setVisibility(View.VISIBLE);
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                imageDado.setVisibility(View.INVISIBLE);
                final Button botao = findViewById(R.id.botaoMostrarDado);
                if(botao.getText() == "Esconder dado") {
                    botao.setText("Mostrar dado");
                }
            }
        });
    }

    public void imagem() {
        final ImageView imageDado = findViewById(R.id.imagemDado);
        final Button botao = findViewById(R.id.botaoMostrarDado);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(imageDado.getVisibility()==View.INVISIBLE) {
                    imageDado.setVisibility(View.VISIBLE);
                    botao.setText("Esconder dado");
                } else {
                    imageDado.setVisibility(View.INVISIBLE);
                    botao.setText("Mostrar dado");
                }
                //botao.setText(imageDado.getVisibility());
            }
        });
    }

    public void myButtonListenerMethod() {
        Button botao = findViewById(R.id.botaoRolarDado);
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rand = new Random();
                int resultadoRand = rand.nextInt(6) + 1;
                TextView textoRetorno = findViewById(R.id.resultadoDado);
                textoRetorno.setText("Resultado: " + Integer.toString(resultadoRand));
                ImageView imagemDado = findViewById(R.id.imagemDado);
                switch (resultadoRand) {
                    case 1:
                        imagemDado.setImageResource(R.drawable.f1);
                        break;
                    case 2:
                        imagemDado.setImageResource(R.drawable.f2);
                        break;
                    case 3:
                        imagemDado.setImageResource(R.drawable.f3);
                        break;
                    case 4:
                        imagemDado.setImageResource(R.drawable.f4);
                        break;
                    case 5:
                        imagemDado.setImageResource(R.drawable.f5);
                        break;
                    case 6:
                        imagemDado.setImageResource(R.drawable.f6);
                        break;
                }
            }
        });
    }
}