import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Nodo {
    public final Integer valor;
    public final List<Integer> adyacentes;

    public Nodo(Integer valor,Integer ...adyacentes) {
        this.valor = valor;
        this.adyacentes = new ArrayList<>(Arrays.asList(adyacentes));
    }
}
