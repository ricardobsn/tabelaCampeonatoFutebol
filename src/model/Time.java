package model;

public class Time {

    private String nome;
    private String localSede;
    private int pontoCampeonato;

    public Time(String nome, String localSede) {
        this.nome = nome;
        this.localSede = localSede;
    }


    public String getNome() {
        return nome;
    }
    public String getLocalSede() {
        return localSede;
    }

    @Override
    public String toString() {
        return (this.getNome()
        );
    }

    public int getPontoCampeonato() {
        return pontoCampeonato;
    }

    public void setPontoCampeonato(int pontoCampeonato) {
        this.pontoCampeonato = pontoCampeonato;
    }
}