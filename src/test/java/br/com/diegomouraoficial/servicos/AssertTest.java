package br.com.diegomouraoficial.servicos;

import br.com.diegomouraoficial.entidades.Usuario;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


@QuarkusTest
public class AssertTest {

    @Test
    public void test() {

        // Verifica se a condicao eh verdadeira
        assertTrue(true);
        assertFalse(false);

        // Compara dois valores para verifica se sao iguais. Equals (eh igual a)
        assertEquals(1,1, "Erro de comparacao");

        // Nos tipos double e float ef recomendavel fornecer o valor delta
        assertEquals(0.51234, 0.512, 0.001);
        assertEquals(Math.PI, 3.14, 0.01);

        // Comparando tipos primitivos e objetos, conhecidos como classes Wrappers
        int i = 5;  // tipo primitivo
        Integer i2 = 5; // objetos
        assertEquals(Integer.valueOf(i), i2); // passando o tipo primitivo para objetos
        assertEquals(i, i2.intValue()); // passando objeto para o tipo primitivo

        // Comparando String
        assertEquals("bola", "bola");
        assertNotEquals("bola", "casa");

        /* Comparando se os objetos sao iguais. Nesse caso a classe precisa
         ter o equals e o hash Code
         */
        Usuario u1 = new Usuario("Usuario 1");
        Usuario u2 = new Usuario("Usuario 1");
        Usuario u3 = u2;
        Usuario u4 = null;

        assertEquals(u1, u2);

        // Verifica se duas referencia apontam para o mesmo objeto. Same (mesmo (a))
        assertSame(u3, u2);
        assertNotSame(u1, u2); // apesar de serem objetos iguais, sao de instancias diferentes
        assertNull(u4);
        assertNotNull(u2);






    }
}
