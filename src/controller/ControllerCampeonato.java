package controller;

import model.Time;

import java.util.*;

public class ControllerCampeonato {

    private List<Time> timesCampeonato;
    private List<Time> tabelaCampeonato;
    private List<String> locaisPartidasDoTurno = new ArrayList<>();


    public ControllerCampeonato(){

    }

    public ControllerCampeonato(List timesCampeonato){

        this.timesCampeonato = timesCampeonato;
        this.tabelaCampeonato = new ArrayList<>(timesCampeonato);
    }

    public void gerarTabela(){

        System.out.println("PRIMEIRO TURNO\n");

        this.gerarTabelaAux(false);

        System.out.println("\nSEGUNDO TURNO\n");
        this.gerarTabelaAux(true);

        printTabelaCampeonato();
    }

    public void gerarTabelaAux(boolean rodadaDeVolta){

        String resultadoPartida;
        int t = timesCampeonato.size();
        int m = timesCampeonato.size() / 2;
        for (int i = 0; i < t - 1; i++) {
            System.out.print((i + 1) + "a rodada: \n ");
            for (int j = 0; j < m; j++) {
                //Teste para ajustar o mando de campo
                if(rodadaDeVolta==false) {

                    if (j % 2 == 1 || i % 2 == 1 && j == 0) {
                        resultadoPartida = timesCampeonato.get(j) + " " + this.golsPartida() + " vs " + this.golsPartida() + " " + timesCampeonato.get(t - j - 1);
                        this.pontuacaoPartida(resultadoPartida, String.valueOf(timesCampeonato.get(j)), String.valueOf(timesCampeonato.get(t - j - 1)));
                        System.out.print(timesCampeonato.get(t - j - 1) + " " + this.golsPartida() + " vs " + this.golsPartida() + " " + timesCampeonato.get(j) + " " + "-" + " " + timesCampeonato.get(t - j - 1).getLocalSede() + "\n");
                        locaisPartidasDoTurno.add(timesCampeonato.get(t - j - 1).getLocalSede());
                    }
                    else
                        resultadoPartida = timesCampeonato.get(j) + " " + this.golsPartida() + " vs " + this.golsPartida() + " " + timesCampeonato.get(t - j - 1);
                        this.pontuacaoPartida(resultadoPartida, String.valueOf(timesCampeonato.get(j)), String.valueOf(timesCampeonato.get(t - j - 1)));
                        System.out.print(timesCampeonato.get(j) + " " + this.golsPartida() + " vs " + this.golsPartida() + " " + timesCampeonato.get(t - j - 1) + " " + "-" + " " + timesCampeonato.get(j).getLocalSede() + "\n");
                        locaisPartidasDoTurno.add(timesCampeonato.get(j).getLocalSede());
                }
                else{
                    if (j % 2 == 1 || i % 2 == 1 && j == 0){
                        resultadoPartida = timesCampeonato.get(j) + " " + this.golsPartida() + " vs " + this.golsPartida() + " " + timesCampeonato.get(t - j - 1);
                        this.pontuacaoPartida(resultadoPartida, String.valueOf(timesCampeonato.get(j)),String.valueOf(timesCampeonato.get(t - j - 1)));
                        System.out.print(timesCampeonato.get(j) + " " + this.golsPartida() + " vs " + this.golsPartida() + " " + timesCampeonato.get(t - j - 1) + " " + "-" + " " + timesCampeonato.get(j).getLocalSede() + "\n");
                    }
                    else
                        resultadoPartida = timesCampeonato.get(j) + " " + this.golsPartida() + " vs " + this.golsPartida() + " " + timesCampeonato.get(t - j - 1);
                        this.pontuacaoPartida(resultadoPartida, String.valueOf(timesCampeonato.get(j)),String.valueOf(timesCampeonato.get(t - j - 1)));
                        System.out.print(timesCampeonato.get(t - j - 1) + " " + this.golsPartida() + " vs " + this.golsPartida() + " " + timesCampeonato.get(j) + " " + "-" + " " + timesCampeonato.get(t - j - 1).getLocalSede() + "\n");
                }
            }

            this.parseDosLocaisDasPartidasEmTurnosEVerificaSeTemRodadaDupla(locaisPartidasDoTurno);
            System.out.println();
            //Gira os clubes no sentido horário, mantendo o primeiro no lugar
            timesCampeonato.add(1, timesCampeonato.remove(timesCampeonato.size()-1));
        }
    }

    public void pontuacaoPartida(String resultadoPartida, String timeCasa, String timeVisitante){

        String timeDaCasa = timeCasa;
        String timeDeFora = timeVisitante;
        String [] palavras = resultadoPartida.split("\\s+");
        String golsTimeCasa = palavras[1];
        String golsTimeVisitante = palavras[3];
        int golsDoTimeDaCasa = Integer.parseInt(golsTimeCasa);
        int golsDoTimeVisitante = Integer.parseInt(golsTimeVisitante);

        if (golsDoTimeDaCasa > golsDoTimeVisitante){
            this.pontuacaoCampeonato(timeDaCasa,3,timeDeFora ,0);
        }
        else if (golsDoTimeDaCasa < golsDoTimeVisitante){
            this.pontuacaoCampeonato(timeDaCasa,0,timeDeFora ,3);
        }
        else
            this.pontuacaoCampeonato(timeDaCasa,1,timeDeFora ,1);

    }

    public void pontuacaoCampeonato(String nomeTimeCasa, int pontoMandante, String nomeTimeVisitante, int pontoVisita){

        int posicaoTimecasa = getTimeNaTabela(nomeTimeCasa);
        int posicaoVisitante = getTimeNaTabela(nomeTimeVisitante);

        Time timeCasa = tabelaCampeonato.get(posicaoTimecasa);
        timeCasa.setPontoCampeonato(timeCasa.getPontoCampeonato() + pontoMandante);

        Time timeVisitante = tabelaCampeonato.get(posicaoVisitante);
        timeVisitante.setPontoCampeonato(timeVisitante.getPontoCampeonato() + pontoVisita);

    }

    private void printTabelaCampeonato() {

        System.out.println("\n-------------------- TABELA --------------------\n");
        System.out.println("NOME : PONTOS\n");
        Collections.sort (tabelaCampeonato, new ControllerComparadorDeTimes());

        for(int i= tabelaCampeonato.size()-1; i >= 0; i--){
            System.out.println(tabelaCampeonato.get(i).getNome() + " : " + tabelaCampeonato.get(i).getPontoCampeonato());
        }
        System.out.println("\n--------------------------------------------------");
        System.out.println("\n" + tabelaCampeonato.get(tabelaCampeonato.size()-1).getNome() + " " + "CAMPEÃO!!!!");

    }

    public int getTimeNaTabela(String nomeTime){

        for (int i = 0; i < tabelaCampeonato.size(); i++) {
            if (tabelaCampeonato.get(i).toString().equals(nomeTime)){
                return i;
            }
        }
        return -1;
    }

    public String golsPartida(){

        int valor = new Random().nextInt(4);
        String gols = String.valueOf(valor);
        return gols;
    }


    public List parseDosLocaisDasPartidasEmTurnosEVerificaSeTemRodadaDupla(List locaisPartidasDoTurno ){

        int contJogoRJ = 0;
        int contJogoSP = 0;
        List<String> turno = locaisPartidasDoTurno.subList(locaisPartidasDoTurno.size()-4, locaisPartidasDoTurno.size()-1);
        for (int j = 0; j < turno.size(); j ++){
            if (turno.get(j).equals("RJ")){
                contJogoRJ++;
            }
            else if (turno.get(j).equals("SP")){
                contJogoSP++;
            }
        }
        if ((contJogoRJ > 1)||(contJogoSP > 1))
        System.out.println("RODADA DUPLA");
        return turno;
    }
}
