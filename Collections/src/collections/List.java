/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 * @author vidag
 */
public class List {
    public static void main(String[] args) {
        ArrayList<Double> notas = new ArrayList<Double>();
        notas.add(7.0);
        notas.add(1.0);
        notas.add(2.0);
        notas.add(3.0);
        notas.add(5.0);
        
        System.out.println(notas.toString());
        System.out.println("Posição da nota 5: "+notas.indexOf(5d));
        
        System.out.println("Adicione na lista a nota 8 na posição 4: ");
        notas.add(4, 8d);
        System.out.println(notas);
        
        System.out.println("Substituir nota 5 pela 6: ");
        notas.set(notas.indexOf(5d),6.0);
        System.out.println(notas);
        
        System.out.println("verificar se a nota 5 esta na lista: " + notas.contains(5d));
        
        /*System.out.println("Exibir as notas na ordem em que foram informados: ");
        for (Double nota : notas) {
            System.out.println(nota);
        }*/
        
        System.out.println("Exiba a terceira nota adicionada: "+notas.get(2));
        
        System.out.println("Exiba a menor nota: "+Collections.min(notas));
        
        System.out.println("Exiba a mairo nota: " +Collections.max(notas));
        
        
        Iterator<Double> iterator = notas.iterator();
        Double soma = 0d;
        while(iterator.hasNext()){
            Double next = iterator.next();
            soma+=next;
        }
        System.out.println("Exiba a soma dos valores: " +soma);
        
        System.out.println("Exiba a media das notas: " + (soma/notas.size()));
        
        System.out.println("Remova a nota 1: ");
        notas.remove(1d);
        System.out.println(notas);
        
        System.out.println("Remova a nota na posição 0: ");
        notas.remove(0);
        System.out.println(notas);
        
        System.out.println("Remova as notas menores que 7: ");
        Iterator<Double> iterator1 = notas.iterator();
        while(iterator1.hasNext()){
            Double next = iterator1.next();
            if(next<7) iterator1.remove();
        }
        System.out.println(notas);
        
        System.out.println("Apagar a lista");
        notas.clear();
        System.out.println(notas);
        
        System.out.println("Verificar se lista esta vazia: "+notas.isEmpty());
            
    }
   
}
