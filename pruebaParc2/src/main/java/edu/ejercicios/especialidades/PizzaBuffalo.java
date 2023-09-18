package edu.ejercicios.especialidades;

import base.Pizza;
import base.Topping;

public class PizzaBuffalo extends Pizza
{
    public PizzaBuffalo(String name, double price, Topping... toppings) {
        super(name, price, toppings);
        IngredientesPorDefecto();

    }
    private void IngredientesPorDefecto() {
        super.addTopping(new Topping("salsa", 4));
    }

}
