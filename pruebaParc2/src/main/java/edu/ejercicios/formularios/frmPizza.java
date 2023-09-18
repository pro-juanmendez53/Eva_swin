package edu.ejercicios.formularios;

import base.Pizza;
import base.Topping;
import edu.ejercicios.especialidades.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class frmPizza
{    //ACA SE CREAN LOS OBJETOS HECHOS EN EL FORMULARIO
    private JPanel jpanelPrincipal;
    private JComboBox comBoxToppings;
    private JTextField txtPizza;
    private JButton btnAddIngrediente;
    private JLabel lblTotal;
    private JList lista1;
    private JButton btnPreparar;
    private JComboBox comboBoxPizzas;
    private JButton btnSeleccionarPizza;
    private JRadioButton pequeñaRadioButton;
    private JRadioButton medianaRadioButton;
    private JRadioButton grandeRadioButton;
    private JButton btnActualizarPrice;
    private JButton quitarExtrasButton;
    //FINAL

    private DefaultListModel modeloLista = new DefaultListModel();

    private List<Topping> ingredientes = new ArrayList();

    private List<Pizza> Pizzas = new ArrayList<>();


    private double total;
    public JPanel getJpanelPrincipal() {
        return jpanelPrincipal;
    }

    private double preciofinal = 0.0;


    public frmPizza()
    {
        cargarToppings();

        PizzaTocino PizzaEspe1 = new PizzaTocino("Pizza de Tocino", 50);
        PizzaPollo PizzaEspe2 = new PizzaPollo("Pizza de Pollo", 45);
        PizzaLomito PizzaEspe3 = new PizzaLomito("Pizza de Lomito", 60);
        PizzaBuffalo PizzaEspe4 = new PizzaBuffalo("Pizza Salsa Buffalo", 55);
        PizzaItaliana PizzaEspe5 = new PizzaItaliana("Pizza Italiana", 45);

        comboBoxPizzas.addItem(PizzaEspe1);
        comboBoxPizzas.addItem(PizzaEspe2);
        comboBoxPizzas.addItem(PizzaEspe3);
        comboBoxPizzas.addItem(PizzaEspe4);
        comboBoxPizzas.addItem(PizzaEspe5);


        //ACCIONES QUE TIENEN LOS BOTONES DEL FORMULARIO
        comBoxToppings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IngredientesMostrar((Pizza) comboBoxPizzas.getSelectedItem());
            }
        });


        btnAddIngrediente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Topping ingredientes = (Topping) comBoxToppings.getSelectedItem();
                modeloLista.addElement(ingredientes);
                lista1.setModel(modeloLista);

                preciofinal += ingredientes.getPrice();
                lblTotal.setText(String.valueOf(preciofinal));

            }
        });


        btnPreparar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pizza pizza = new Pizza(txtPizza.getText());
                Topping topi;
                for (int i = 0; i < lista1.getModel().getSize(); i++) {
                    topi = (Topping) lista1.getModel().getElementAt(i);
                    pizza.addTopping(topi);
                }
                pizza.prepare();
            }
        });


        btnSeleccionarPizza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pizza Pizzas = (Pizza) comboBoxPizzas.getSelectedItem();
                modeloLista.addElement(Pizzas);
                lista1.setModel(modeloLista);
                txtPizza.setText(Pizzas.getName());

                btnSeleccionarPizza.setEnabled(false);

                double precioActualizado = PrecioActualizado(Pizzas);

                preciofinal = Pizzas.getPrice() + precioActualizado;
                lblTotal.setText(String.valueOf(preciofinal));

            }
        });


        pequeñaRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                preciofinal = preciofinal;
                lblTotal.setText(String.valueOf(preciofinal));
                medianaRadioButton.setSelected(false);
                grandeRadioButton.setSelected(false);

            }
        });


        medianaRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                preciofinal = preciofinal + 15;
                lblTotal.setText(String.valueOf(preciofinal));
                pequeñaRadioButton.setSelected(false);
                grandeRadioButton.setSelected(false);

            }
        });


        grandeRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                preciofinal = preciofinal + 30;
                lblTotal.setText(String.valueOf(preciofinal));
                pequeñaRadioButton.setSelected(false);
                medianaRadioButton.setSelected(false);

            }
        });

        //FINALIZA ACCION DE BOTONES
    }

    //METODOS PARA OPERACIONES DE FORMULARIO

    //METODO PARA PRECARGAR UNOS TOPPINGS PARA SELECCIONAR
    private void cargarToppings() {
        ingredientes.add(new Topping("Hongos", 4.55));
        ingredientes.add(new Topping("Tomate", 2.55));
        ingredientes.add(new Topping("Cebolla", 6.55));
        ingredientes.add(new Topping("Salchica", 10.55));
        ingredientes.add(new Topping("Arandanos", 14.55));
        ingredientes.add(new Topping("Chetos", 11.55));


        DefaultComboBoxModel model = new DefaultComboBoxModel(ingredientes.toArray());
        comBoxToppings.setModel(model);

    }

    private void IngredientesMostrar(Pizza pizza) {
        modeloLista.clear();
        for (Topping topping : pizza.getToppings()) {
            modeloLista.addElement(topping);
        }
        lista1.setModel(modeloLista);

        PrecioActualizado(pizza);
    }
//metodo para ir evaluando el precio dependiendo la pizza y los toppings seleccionados
    private double PrecioActualizado(Pizza pizza) {
        double costo = 0.0;
        for (Topping topping : pizza.getToppings()) {
            costo += topping.getPrice();
        }
        lblTotal.setText(String.valueOf(costo));
        return costo;
    }



    //FINALIZAN METODOS


}
