package controller;

import model.Time;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class ControllerTime {

    private Time time;
    private List<Time> timesCampeonato= new ArrayList<Time>();

    public ControllerTime(){

    }

    public void leituraTimes(){
        URL url = getClass().getResource("times.txt");
        File file = new File(url.getPath());
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String st;
        try {
            while ((st = br.readLine()) != null)
               if (isLinhaDeTime(st)){
                this.criaListaDeTimes(st);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        chamarTabela(timesCampeonato);
    }

    /*Verifica se é uma linha que possui nome de time*/
    public  boolean isLinhaDeTime(String linha){

        return ( linha.contains(";"));
    }

    /*Cria a lista de times do campeonato*/
    public void criaListaDeTimes(String linha) {

        String [] palavras = linha.split("\\s+");
        String nomeDoTime = palavras[0];
        String sedeTime = palavras[palavras.length-1];
        time = new Time(nomeDoTime,sedeTime);
        timesCampeonato.add(time);
    }

    public void chamarTabela(List timesCampeonato){
        ControllerCampeonato controllerCampeonato = new ControllerCampeonato(timesCampeonato);
        controllerCampeonato.gerarTabela();

    }
}




