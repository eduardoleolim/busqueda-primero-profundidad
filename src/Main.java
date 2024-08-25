import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        // GRAFO
        List<Nodo> grafo = Arrays.asList(
                new Nodo(1, 2),
                new Nodo(2, 1, 3, 9),
                new Nodo(3, 2, 4),
                new Nodo(4, 3, 5, 11),
                new Nodo(5, 4),
                new Nodo(6, 7, 13),
                new Nodo(7, 6, 14),
                new Nodo(8, 9),
                new Nodo(9, 2, 8, 16),
                new Nodo(10, 17),
                new Nodo(11, 4, 18),
                new Nodo(12, 19),
                new Nodo(13, 6, 20),
                new Nodo(14, 7, 21),
                new Nodo(15, 16, 22),
                new Nodo(16, 9, 15),
                new Nodo(17, 10, 18, 24),
                new Nodo(18, 11, 17, 25),
                new Nodo(19, 12, 26),
                new Nodo(20, 13, 27),
                new Nodo(21, 14, 28),
                new Nodo(22, 15, 29),
                new Nodo(23, 24),
                new Nodo(24, 17, 23, 31),
                new Nodo(25, 18, 26),
                new Nodo(26, 19, 25, 33),
                new Nodo(27, 20, 34),
                new Nodo(28, 21, 35),
                new Nodo(29, 22, 30),
                new Nodo(30, 29),
                new Nodo(31, 24, 32),
                new Nodo(32, 31, 39),
                new Nodo(33, 26, 34),
                new Nodo(34, 27, 33),
                new Nodo(35, 28, 42),
                new Nodo(36, 37, 43),
                new Nodo(37, 36, 38),
                new Nodo(38, 37, 39),
                new Nodo(39, 32, 38),
                new Nodo(40, 41, 47),
                new Nodo(41, 40, 42, 48),
                new Nodo(42, 35, 49),
                new Nodo(43, 36, 44),
                new Nodo(44, 43, 45),
                new Nodo(45, 44, 46),
                new Nodo(46, 45, 47),
                new Nodo(47, 40, 46),
                new Nodo(48, 41),
                new Nodo(49, 42)
        );

        Integer inicio = 8;
        Integer fin = 49;

        List<Integer> rutaEncontrada = busquedaPrimeroProfundidad(grafo, inicio, fin);

        if (!Objects.equals(rutaEncontrada.get(rutaEncontrada.size() - 1), fin)) {
            System.out.println("No se encontró la ruta para llega a el nodo <" + fin + ">");
        } else {
            System.out.println("Ruta encontrada:\n" + rutaEncontrada);
        }

    }

    private static List<Integer> busquedaPrimeroProfundidad(List<Nodo> grafo, Integer inicio, Integer fin) {
        List<Boolean> nodosVisitados = new ArrayList<>();
        for (int i = 0; i < grafo.size(); i++) {
            nodosVisitados.add(i, false);
        }
        List<Integer> ruta = new ArrayList<>();
        ruta.add(inicio);

        return busquedaPrimeroProfundidadRecursivo(grafo, ruta, fin, nodosVisitados);
    }

    private static List<Integer> busquedaPrimeroProfundidadRecursivo(
            List<Nodo> grafo,
            List<Integer> ruta,
            Integer fin,
            List<Boolean> nodosVisitados
    ) {
        Integer valorNodoVisitado = ruta.get(ruta.size() - 1);
        nodosVisitados.set(valorNodoVisitado - 1, true);
        if (valorNodoVisitado.equals(fin)) {
            return ruta;
        }

        Nodo nodo = grafo.get(valorNodoVisitado - 1);

        for (Integer valorNodoAdyacente : nodo.adyacentes) {
            Boolean adyacenteVisitado = nodosVisitados.get(valorNodoAdyacente - 1);

            if (!adyacenteVisitado) {
                List<Integer> rutaCopia = new ArrayList<>(ruta);
                rutaCopia.add(valorNodoAdyacente);
                List<Boolean> nodosVisitadosCopia = new ArrayList<>(nodosVisitados);
                List<Integer> rutaNueva = busquedaPrimeroProfundidadRecursivo(grafo, rutaCopia, fin, nodosVisitadosCopia);
                if (Objects.equals(rutaNueva.get(rutaNueva.size() - 1), fin)) {
                    return rutaNueva;
                }
            }
        }

        return ruta;
    }
}