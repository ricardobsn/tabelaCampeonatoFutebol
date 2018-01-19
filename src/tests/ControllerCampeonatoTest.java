package tests;

import controller.ControllerCampeonato;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;


public class ControllerCampeonatoTest {

    ControllerCampeonato controllerCampeonato = new ControllerCampeonato();

    @Test
    public void golsPartidaTest( ){

        String golsPartida = controllerCampeonato.golsPartida();
        int gols = Integer.valueOf(golsPartida);
        assertTrue(gols < 4);
    }

    @Test
    public void parseDosLocaisDasPartidasEmTurnosTest( ){

        List<String> jogosTurno = new ArrayList<>();
        jogosTurno.add("RJ");
        jogosTurno.add("SP");
        jogosTurno.add("MG");
        jogosTurno.add("SP");
        jogosTurno.add("RS");
        jogosTurno.add("RJ");
        System.out.println(jogosTurno);
        List<String> jogosRodada;
        jogosRodada = controllerCampeonato.parseDosLocaisDasPartidasEmTurnosEVerificaSeTemRodadaDupla(jogosTurno);
        assertThat(jogosRodada.size(), is(3));

    }

}
