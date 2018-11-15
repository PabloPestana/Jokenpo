package com.android.pablopestana.jokenpo;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionarPedra(View view){
        this.opcaoSelecionada("pedra");

    }
    public void selecionarPapel(View view){
        this.opcaoSelecionada("papel");

    }
    public void selecionarTesoura(View view){
        this.opcaoSelecionada("tesoura");

    }
    int placar = 0;

    public void opcaoSelecionada(String escolhaUsuario){

        ImageView imageResultado = (ImageView) findViewById(R.id.imageResultado);
        TextView textoResultado = findViewById(R.id.textResultado);
        TextView textoPlacar = findViewById(R.id.textPlacar);

        String[] opcoes = {"pedra", "papel", "tesoura"};
        int numero = new Random().nextInt(3);
        String escolhaApp = opcoes[numero];

        switch (escolhaApp){
            case "pedra":
                imageResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imageResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imageResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if (
                (escolhaApp == "pedra" && escolhaUsuario=="tesoura") ||

                (escolhaApp == "papel" && escolhaUsuario=="pedra") ||

                (escolhaApp == "tesoura" && escolhaUsuario=="papel")
                ){
            //App ganhador
            textoResultado.setText("Você perdeu!");
            placar = placar - 1;
            textoPlacar.setText(String.valueOf(placar));


        }
        else if (

                (escolhaApp == "tesoura" && escolhaUsuario=="pedra") ||
                (escolhaApp == "pedra" && escolhaUsuario=="papel") ||
                (escolhaApp == "papel" && escolhaUsuario=="tesoura")
                ){
            //User ganhador
            textoResultado.setText("Você ganhou!");
            placar = placar + 1;
            textoPlacar.setText(String.valueOf(placar));

        }
        else {
            //empate
            textoResultado.setText("Empate!");
        }

    }

}
