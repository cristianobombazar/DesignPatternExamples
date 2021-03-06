package net.unibave.designpattersnexample.abstractfactory.model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import net.unibave.designpattersnexample.abstractfactory.interfaces.Massa;

public class Pizzaria {

    private String nome;
    private List<DayOfWeek> daysClosed = Collections.singletonList(DayOfWeek.SUNDAY);
    private Map<DayOfWeek, List<Massa>> massasOfDay;

    private Pizzaria(String nome, Map<DayOfWeek, List<Massa>> massasOfDay) {
        this.nome = nome;
        this.massasOfDay = massasOfDay;
    }

    public static Pizzaria of(String nome, Map<DayOfWeek, List<Massa>> massasOfDay) {
        return new Pizzaria(nome, massasOfDay);
    }

    public String getNome() {
        return nome;
    }

    public List<Massa> getAvaliableMassa(LocalDate localDate){
        return massasOfDay.get(localDate.getDayOfWeek());
    }

    public boolean isClosed(LocalDate localDate){
        return daysClosed.contains(localDate.getDayOfWeek());
    }

}
