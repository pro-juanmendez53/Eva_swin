package edu.ejercicios.especialidades;

import base.Pizza;
import base.Topping;

public class PizzaTocino extends Pizza
{
    public PizzaTocino(String name, double price, Topping... toppings) {
        super(name, price, toppings);
        IngredientesPorDefecto();

    }
    private void IngredientesPorDefecto() {
        super.addTopping(new Topping("tocino", 4));
    }



}


