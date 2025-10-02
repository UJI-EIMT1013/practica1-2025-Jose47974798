package practica1;

import java.util.*;

public class Practica1 {

    //EJERCICIO 1

    public static Set<Integer> multiplos(Iterator<Integer> it) {
        List<Integer> elementos = new ArrayList<>();
        while (it.hasNext()) {
            elementos.add(it.next()); // recorre y guarda elementos
        }

        Set<Integer> resultado = new HashSet<>();

        for (int i = 0; i < elementos.size(); i++) {
            int a = elementos.get(i);

            if (a != 0) { // ignorar ceros
                for (int j = 0; j < elementos.size(); j++) {
                    if (i != j) { // no compararse consigo mismo
                        int b = elementos.get(j);
                        if (b != 0 && a % b == 0) {
                            resultado.add(a);
                        }
                    }
                }
            }
        }
        return resultado;
    }

    //EJERCICIO2
    public static void separate (Set<Integer> cuadrados, Set<Integer> noCuadrados)  {
        Set<Integer> todos = new HashSet<>();
        todos.addAll(cuadrados);
        todos.addAll(noCuadrados);

        Set<Integer> nuevosCuadrados = new HashSet<>();
        Set<Integer> nuevosNo = new HashSet<>();

        for (Integer x : todos) {
            boolean esCuadrado = false;
            for (Integer y : todos) {
                if (y * y == x) { // si x es cuadrado de y
                    esCuadrado = true;
                    break;
                }
            }
            if (esCuadrado) {
                nuevosCuadrados.add(x);
            } else {
                nuevosNo.add(x);
            }
        }

        // Modificamos los conjuntos de entrada según el resultado
        cuadrados.clear();
        cuadrados.addAll(nuevosCuadrados);

        noCuadrados.clear();
        noCuadrados.addAll(nuevosNo);
    }

    //EJERCICIO 3
    public static<T> Collection<Set<T>> divideInSets (Iterator<T> it) {
        List<T> elementos = new ArrayList<>();
        while (it.hasNext()) {
            elementos.add(it.next());
        }

        List<Set<T>> resultado = new ArrayList<>();
        Set<T> actual = new HashSet<>();

        for (T elem : elementos) {
            if (actual.contains(elem)) {
                // cerramos conjunto y empezamos uno nuevo con el repetido
                resultado.add(actual);
                actual = new HashSet<>();
                actual.add(elem);
            } else {
                actual.add(elem);
            }
        }
        if (!actual.isEmpty()) {
            resultado.add(actual);
        }
        return resultado;
    }

    //EJERCICIO 4
    public static<T> Collection<Set<T>> coverageSet2 (Set<T> u,ArrayList<Set<T>> col) {
        ArrayList<Set<T>> resultado = new ArrayList<>();
        for (int i = 0; i < col.size(); i++) {
            for (int j = i + 1; j < col.size(); j++) {
                Set<T> union = new HashSet<>();
                union.addAll(col.get(i));
                union.addAll(col.get(j));
                if (union.equals(u)) {
                    resultado.add(col.get(i));
                    resultado.add(col.get(j));
                    return resultado;
                }
            }
        }
        return resultado; // siempre un ArrayList
    }
}