package edu.ejercicios.especialidades;

import base.Pizza;
import base.Topping;

public class PizzaHongo extends Pizza
{
    public PizzaHongo(String name, double price, Topping... toppings) {
        super(name, price, toppings);
        IngredientesPorDefecto();

    }
    private void IngredientesPorDefecto() {
        super.addTopping(new Topping("hongos", 2));
    }

}
