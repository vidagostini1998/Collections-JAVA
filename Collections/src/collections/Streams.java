/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collections;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.TreeMap;
import java.util.TreeSet;


/**
 *
 * @author vidag
 */
public class Streams {

    public static void main(String[] args) {
        System.out.println("--\tOrdem aleatória\t--");
        HashMap<Integer, Contato> agenda = new HashMap<>() {
            {
                put(1, new Contato("Simba", 5555));
                put(4, new Contato("Cami", 1111));
                put(3, new Contato("Jon", 2222));
            }
        };
        System.out.println(agenda);
        for (HashMap.Entry<Integer, Contato> entry : agenda.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }

        System.out.println("--\tOrdem Inserção\t--");
        LinkedHashMap<Integer, Contato> agenda1 = new LinkedHashMap<>() {
            {
                put(1, new Contato("Simba", 5555));
                put(4, new Contato("Cami", 1111));
                put(3, new Contato("Jon", 2222));
            }
        };
        System.out.println(agenda1);
        for (HashMap.Entry<Integer, Contato> entry : agenda1.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }

        System.out.println("--\tOrdem id\t--");
        TreeMap<Integer, Contato> agenda2 = new TreeMap<>(agenda);
        System.out.println(agenda2);
        for (HashMap.Entry<Integer, Contato> entry : agenda2.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }

        System.out.println("--\tOrdem número telefone\t--");
        //precisamos organizar os valores. Logo:
        /*Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(new Comparator<Map.Entry<Integer, Contato>>() {
            @Override
            public int compare(Map.Entry<Integer, Contato> cont1, Map.Entry<Integer, Contato> cont2) {
                return Integer.compare(cont1.getValue().getNumero(), cont2.getValue().getNumero());
            }
        });*/

 /*Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(Comparator.comparing(
                new Function<Map.Entry<Integer, Contato>, Integer>() {
                    @Override
                    public Integer apply(Map.Entry<Integer, Contato> cont) {
                        return cont.getValue().getNumero();
                    }
                }));*/
        TreeSet<HashMap.Entry<Integer, Contato>> set = new TreeSet<>(Comparator.comparing(cont -> cont.getValue().getNumero()));
        set.addAll(agenda.entrySet());
        for (HashMap.Entry<Integer, Contato> entry : set) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNumero()
                    + ": " + entry.getValue().getNome());
        }

        System.out.println("--\tOrdem nome contato\t--");
        //precisamos organizar os valores. Logo:
        TreeSet<HashMap.Entry<Integer, Contato>> set1 = new TreeSet<>(Comparator.comparing(cont -> cont.getValue().getNome()));
        set1.addAll(agenda.entrySet());
        //imprimindo usando forEach
        set1.forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue().getNome()));
    }

    class ComparatorOrdemNumerica implements Comparator<HashMap.Entry<Integer, Contato>> {

        @Override
        public int compare(HashMap.Entry<Integer, Contato> cont1, HashMap.Entry<Integer, Contato> cont2) {
            return Integer.compare(cont1.getValue().getNumero(), cont2.getValue().getNumero());
        }
    }

    class ComparatorOrdemNomeContato implements Comparator<HashMap.Entry<Integer, Contato>> {

        @Override
        public int compare(HashMap.Entry<Integer, Contato> cont1, HashMap.Entry<Integer, Contato> cont2) {
            return cont1.getValue().getNome().compareToIgnoreCase(cont2.getValue().getNome());
        }
    }

    public class Contato {

        private String nome;
        private Integer numero;

        public Contato(String nome, Integer numero) {
            this.nome = nome;
            this.numero = numero;
        }

        public String getNome() {
            return nome;
        }

        public Integer getNumero() {
            return numero;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Contato contato = (Contato) o;
            return nome.equals(contato.nome) && numero.equals(contato.numero);
        }

        @Override
        public int hashCode() {
            return Objects.hash(nome, numero);
        }

        @Override
        public String toString() {
            return "Contato{"
                    + "nome='" + nome + '\''
                    + ", numero='" + numero + '\''
                    + '}';
        }
    }
}
