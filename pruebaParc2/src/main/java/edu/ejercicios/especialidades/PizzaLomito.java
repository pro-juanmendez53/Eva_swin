package edu.ejercicios.especialidades;

import base.Pizza;
import base.Topping;

public class PizzaLomito extends Pizza
{
    public PizzaLomito(String name, double price, Topping... toppings) {
        super(name, price, toppings);
        IngredientesPorDefecto();

    }
    private void IngredientesPorDefecto() {
        super.addTopping(new Topping("Lomito", 7));
    }


}
