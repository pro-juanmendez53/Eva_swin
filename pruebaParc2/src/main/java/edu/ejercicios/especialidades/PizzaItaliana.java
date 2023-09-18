package edu.ejercicios.especialidades;

import base.Pizza;
import base.Topping;

public class PizzaItaliana extends Pizza
{

    public PizzaItaliana(String name, double price, Topping... toppings) {
        super(name, price, toppings);
        IngredientesPorDefecto();

    }
    private void IngredientesPorDefecto() {
        super.addTopping(new Topping("salsa", 2));
    }


}
