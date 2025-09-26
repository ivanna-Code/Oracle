package Agenda_Oracle;
import javax.swing.*; //Todo lo de ventanas.
import javax.swing.table.DefaultTableColumnModel; //Modelo para manejar filas/columnas en la tabla mediante el codigo
import java.awt.*; //Componentes gráficos (layouts, colores, etc.).
import java.awt.event.*; //Para manejar acciones, ejemplar cuando presionas un botón).
import javax.swing.table.DefaultTableModel;

public class Agenda extends JFrame{ //La clase es una ventana ahora.
    private JTable tabla;
    private DefaultTableModel modelo; //se encarga de agregar/borrar filas de la tabla.
    private JTextField txtHora, txtMateria, txtTarea, txtImportancia, txtFecha; //Seran las cajitas de texto donde escribes hora, materia, etc.
    
    public Agenda(){
        setTitle("Agenda de Tareas");
        setSize(800,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //EXIT → terminar programa.
        setLocationRelativeTo(null); //Centra la ventana en la pantalla.
        
        //Columnas de la tabla
        String[] columnas = {"Hora", "Materia", "Tarea", "Importancia", "Fecha de entrega"};
        modelo = new DefaultTableModel(columnas, 0); 
        tabla = new JTable(modelo); 
        JScrollPane scroll = new JScrollPane(tabla); 
        
        //Panel de inputs (cajitas + etiquetas)
        JPanel panelInputs = new JPanel(new GridLayout(2, 5, 5, 5)); 
        
        //Cajitas de texto vacías
        txtHora = new JTextField();
        txtMateria = new JTextField();
        txtTarea = new JTextField();
        txtImportancia = new JTextField(); 
        txtFecha = new JTextField();
        //Cajitas de texto vacías

        //Etiquetas fila 1
        panelInputs.add(new JLabel("Hora"));
        panelInputs.add(new JLabel("Materia"));
        panelInputs.add(new JLabel("Tarea"));
        panelInputs.add(new JLabel("Importancia"));
        panelInputs.add(new JLabel("Fecha entrega"));
        //Etiquetas fila 1
        
        //Cajitas fila 2
        panelInputs.add(txtHora);
        panelInputs.add(txtMateria);
        panelInputs.add(txtTarea);
        panelInputs.add(txtImportancia);
        panelInputs.add(txtFecha);
        //Etiquetas fila 2

        //Panel de botones
        JButton btnAgregar = new JButton("Agregar tarea");
        JButton btnBorrar = new JButton("Borrar tarea");
        JPanel panelBotones = new JPanel(); 
        panelBotones.add(btnAgregar);
        panelBotones.add(btnBorrar);
        //Panel de botones

        //Acción del botón Agregar
        btnAgregar.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent e) {
                String[] fila = {
                    txtHora.getText(), 
                    txtMateria.getText(),
                    txtTarea.getText(),
                    txtImportancia.getText(), 
                    txtFecha.getText(),
                };
                modelo.addRow(fila);
                //Limpiar inputs con este comando (.setText)
                txtHora.setText("");
                txtMateria.setText("");
                txtTarea.setText("");
                txtImportancia.setText("");
                txtFecha.setText("");
             }
        }); 
        //Acción del botón Borrar
        btnBorrar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int filaSeleccionada = tabla.getSelectedRow();
                if (filaSeleccionada != -1){
                    modelo.removeRow(filaSeleccionada);
                }else{
                     JOptionPane.showMessageDialog(null, "Selecciona una fila para borrar.");
                }
            }
        });
        
        //Layout (acomodo de todo)
        setLayout(new BorderLayout());
        add(scroll, BorderLayout.CENTER);
        add(panelInputs, BorderLayout.NORTH);
        add(panelBotones, BorderLayout.SOUTH);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Agenda().setVisible(true);
        });
    //NOTAS:
    //MEJORARA EL DISEÑO
    //COLOR
    //INTERACCION Y INTERFAZ
    }
}



