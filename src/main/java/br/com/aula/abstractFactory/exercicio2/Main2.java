package br.com.aula.abstractFactory.exercicio2;

import br.com.aula.Util;
import br.com.aula.abstractFactory.exercicio2.enums.Calzone;
import br.com.aula.abstractFactory.exercicio2.factory.OrderFactory;
import br.com.aula.abstractFactory.exercicio2.interfaces.Massa;
import br.com.aula.abstractFactory.exercicio2.model.Order;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class Main2 {

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 10; i++) {
            LocalDate currentDate = Util.localDateBetween(2019, 2019);
            Optional<Order> pedidoOptional = OrderFactory.create(currentDate);
            if (pedidoOptional.isPresent()){
                System.out.println("======== PEDIDO ========");
                Order pedido = pedidoOptional.get();
                System.out.println("PIZZARIA: "+pedido.getPizzaria().getNome());
                System.out.println("Data: "+formatter(pedido.getDateOrder()));
                System.out.println("PRODUCTS: ");
                pedido.getProducts().forEach(massa -> {
                    System.out.println( (isCalzone(massa) ? "Calzone of " : "Pizza of ") + massa.getFlavor());
                    System.out.println(">> INGREDIENTS <<");
                    massa.getIngredients().forEach(System.out::println);
                });
            }else{
                System.out.println("================");
                System.out.println("Não existem pizzarias abertas na data "+formatter(currentDate));
                System.out.println("================");
            }
        }
    }

    private static String formatter(LocalDate localDate){
        return localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    private static boolean isCalzone(Massa massa){
        return massa instanceof Calzone;
    }
}