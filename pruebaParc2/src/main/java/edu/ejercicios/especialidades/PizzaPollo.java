package edu.ejercicios.especialidades;

import base.Pizza;
import base.Topping;

public class PizzaPollo extends Pizza
{
    public PizzaPollo(String name, double price, Topping... toppings) {
        super(name, price, toppings);

        IngredientesPorDefecto();
    }
    private void IngredientesPorDefecto(){
        super.addTopping(new Topping("Dados", 5));
        super.addTopping(new Topping("Cebolla", 6));
        super.addTopping(new Topping("Pimiento", 8));
    }





}
