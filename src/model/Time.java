package model;

public class Time {

    private String nome;
    private String localSede;
    private int pontoCampeonato;

    public Time(){

    }

    public Time(String nome, String localSede) {
        this.nome = nome;
        this.localSede = localSede;
    }

    public Time(String nome, int pontoCampeonato) {
        this.nome = nome;
        this.pontoCampeonato = pontoCampeonato;
    }


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getLocalSede() {
        return localSede;
    }
    public void setLocalSede(String localSede) {
        this.localSede = localSede;
    }

    @Override
    public String toString() {
        return (this.getNome()+
                this.getLocalSede()
        );
    }

    public int getPontoCampeonato() {
        return pontoCampeonato;
    }

    public void setPontoCampeonato(int pontoCampeonato) {
        this.pontoCampeonato = pontoCampeonato;
    }
}