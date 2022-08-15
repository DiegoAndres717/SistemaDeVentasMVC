package ViewModels;

import Conexion.Consultar;
import Libreria.*;
import Models.TClientes;
import java.awt.Color;
import java.util.*;
import javax.swing.*;
import java.sql.*;
import java.util.stream.Collectors;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

/**
 *
 * @author ¡Diego Andres Salas!
 */
public final class ClienteVM extends Consultar {

    private String _accion = "insert";
    private final ArrayList<JLabel> _label;
    private final ArrayList<JTextField> _teTextField;
    private final JCheckBox _checkBoxCredito;
    private final JTable _tablaCliente;
    private DefaultTableModel modelo1;
    private final JSpinner _spinnerPaginas;
    private int _idCliente = 0;
    private int _reg_por_pagina = 10;
    private int _num_pagina = 1;
    private int seccion;
    private Paginador<TClientes> _paginadorClientes;

    public ClienteVM(Object[] objets, ArrayList<JLabel> label, ArrayList<JTextField> textfield) {
        _label = label;
        _teTextField = textfield;
        _checkBoxCredito = (JCheckBox) objets[0];
        _tablaCliente = (JTable) objets[1];
        _spinnerPaginas = (JSpinner) objets[2];
        registraClientes();
    }

    // <editor-fold defaultstate="collapsed" desc="CODIGO DE Registrar Clientes">
    public void registraClientes() {
        if (_teTextField.get(0).getText().equals("")) {
            _label.get(0).setText("Ingrese Identificación");
            _label.get(0).setForeground(Color.RED);
            _teTextField.get(0).requestFocus();
        } else {
            if (_teTextField.get(1).getText().equals("")) {
                _label.get(1).setText("Ingrese Nombres");
                _label.get(1).setForeground(Color.RED);
                _teTextField.get(1).requestFocus();
            } else {
                if (_teTextField.get(2).getText().equals("")) {
                    _label.get(2).setText("Ingrese Apellidos");
                    _label.get(2).setForeground(Color.RED);
                    _teTextField.get(2).requestFocus();
                } else {
                    if (_teTextField.get(3).getText().equals("")) {
                        _label.get(3).setText("Ingrese Email");
                        _label.get(3).setForeground(Color.red);
                        _teTextField.get(3).requestFocus();
                    } else {
                        if (!Objetos.eventos.isEmail(_teTextField.get(3).getText())) {
                            _label.get(3).setText("Ingrese un Email válido");
                            _label.get(3).setForeground(Color.RED);
                            _teTextField.get(3).requestFocus();
                        } else {
                            if (_teTextField.get(4).getText().equals("")) {
                                _label.get(4).setText("Ingrese un Telefono");
                                _label.get(4).setForeground(Color.RED);
                                _teTextField.get(4).requestFocus();
                            } else {
                                if (_teTextField.get(5).getText().equals("")) {
                                    _label.get(5).setText("Ingrese la Dirección");
                                    _label.get(5).setForeground(Color.red);
                                    _teTextField.get(5).requestFocus();
                                } else {
                                    int count;
                                    List<TClientes> listaEmail = clientes().stream().filter(
                                            u -> u.getEmail().equals(_teTextField.get(3).getText())).collect(Collectors.toList());
                                    count = listaEmail.size();
                                    List<TClientes> Lisident = clientes().stream().filter(
                                            u -> u.getIdentificacion().equals(_teTextField.get(0).getText())).collect(Collectors.toList());
                                    count += Lisident.size();
                                    try {
                                        switch (_accion) {
                                            case "insert" -> {
                                                if (count == 0) {
                                                    Insert();
                                                } else {
                                                    if (!listaEmail.isEmpty()) {
                                                        _label.get(3).setText("El Email ya está registrado");
                                                        _label.get(3).setForeground(Color.red);
                                                        _teTextField.get(3).requestFocus();
                                                    }
                                                    if (!Lisident.isEmpty()) {
                                                        _label.get(0).setText("Numero de identificación ya registrado");
                                                        _label.get(0).setForeground(Color.red);
                                                        _teTextField.get(0).requestFocus();
                                                    }
                                                }

                                            }
                                            case "update" -> {
                                                if (count == 2) {
                                                    if (listaEmail.get(0).getID() == _idCliente && Lisident.get(0).getID() == _idCliente) {
                                                        Insert();
                                                    } else {
                                                        if (Lisident.get(0).getID() != _idCliente) {
                                                            _label.get(0).setText("El NID ya esta registrado");
                                                            _label.get(0).setForeground(Color.red);
                                                            _teTextField.get(0).requestFocus();
                                                        }
                                                        if (listaEmail.get(0).getID() != _idCliente) {
                                                            _label.get(3).setText("El Email ya esta registrado");
                                                            _label.get(3).setForeground(Color.red);
                                                            _teTextField.get(3).requestFocus();
                                                        }
                                                    }
                                                } else {
                                                    if (count == 0) {
                                                        Insert();
                                                    } else {
                                                        if (!Lisident.isEmpty()) {
                                                            if (Lisident.get(0).getID() == _idCliente) {
                                                                Insert();
                                                            } else {
                                                                if (Lisident.get(0).getID() != _idCliente) {
                                                                    _label.get(0).setText("El NID ya esta registrado");
                                                                    _label.get(0).setForeground(Color.red);
                                                                    _teTextField.get(0).requestFocus();
                                                                }
                                                            }
                                                            if (!listaEmail.isEmpty()) {
                                                                if (listaEmail.get(0).getID() == _idCliente) {
                                                                    Insert();
                                                                } else {
                                                                    if (listaEmail.get(0).getID() != _idCliente) {
                                                                        _label.get(3).setText("El Email ya esta registrado");
                                                                        _label.get(3).setForeground(Color.red);
                                                                        _teTextField.get(3).requestFocus();
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    } catch (SQLException e) {
                                        JOptionPane.showMessageDialog(null, e);
                                    }
                                }
                            }
                        }

                    }

                }
            }
        }
    }

    private void Insert() throws SQLException {
        try {
            final QueryRunner qr = new QueryRunner(true);
            getConn().setAutoCommit(false);
            byte[] image = uploAddImage.getImageByte();
            if (image == null) {
                image = Objetos.uploaddimagen.getTransFoto(_label.get(6));
            }
            switch (_accion) {
                case "insert" -> {

                    String sqlCliente1 = "INSERT INTO tclientes(Identidad,Nombre, Apellido, Email,"
                            + " Telefono, Direccion, Credito, Fecha, Imagen)" + " VALUES(?,?,?,?,?,?,?,?,?)";
                    Object[] dataCliente1 = {
                        _teTextField.get(0).getText(),
                        _teTextField.get(1).getText(),
                        _teTextField.get(2).getText(),
                        _teTextField.get(3).getText(),
                        _teTextField.get(4).getText(),
                        _teTextField.get(5).getText(),
                        _checkBoxCredito.isSelected(),
                        new Calendario().getFecha(),
                        image,};

                    qr.insert(getConn(), sqlCliente1, new ColumnListHandler(), dataCliente1);
                    String sqlReport = "INSERT INTO treportes_clientes(deudaActual, fechaDeuda,"
                            + " ultimoPago,fechaPago,Ticket,fechaLimite,idCliente)"
                            + " VALUES(?, ?, ?, ?, ?,?,?)";
                    List<TClientes> cliente = clientes();
                    Object[] dataReport = {
                        0,
                        "--/--/--",
                        0,
                        "--/--/--",
                        "0000000000",
                        "--/--/--",
                        cliente.get(cliente.size() - 1).getID(),};
                    qr.insert(getConn(), sqlReport, new ColumnListHandler(), dataReport);
                }
                case "update" -> {
                    Object[] dataCliente2 = {
                        _teTextField.get(0).getText(),
                        _teTextField.get(1).getText(),
                        _teTextField.get(2).getText(),
                        _teTextField.get(3).getText(),
                        _teTextField.get(4).getText(),
                        _teTextField.get(5).getText(),
                        _checkBoxCredito.isSelected(),
                        image
                    };
                    
                    String sqlCliente2 = "UPDATE tclientes SET Identidad = ?,Nombre = ?, Apellido = ?," + ""
                            + "Email = ?,Telefono = ?, Direccion = ?, Credito = ?," 
                            + "Imagen = ? WHERE ID =" + _idCliente;
                    qr.update(getConn(), sqlCliente2, dataCliente2);
                }
            }
            getConn().commit();
            restablecer();
        } catch (SQLException e) {
            getConn().rollback();
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void buscarCliente(String campo) {
        List<TClientes> clientesFilter;
        String[] titulos = {"Id", "Identificación", "Nombres", "Apellidos", "Email", "Dirección", "Telefono", "Crédito", "Imagen"};
        modelo1 = new DefaultTableModel(null, titulos);
        int inicio = (_num_pagina - 1) * _reg_por_pagina;
        if (campo.equals("")) {
            clientesFilter = clientes().stream().skip(inicio).limit(_reg_por_pagina).collect(Collectors.toList());
        } else {
            clientesFilter = clientes().stream()
                    .filter(C -> C.getIdentificacion().startsWith(campo) || C.getNombre().startsWith(campo)
                    || C.getApellido().startsWith(campo))
                    .skip(inicio).limit(_reg_por_pagina)
                    .collect(Collectors.toList());
        }
        if (!clientesFilter.isEmpty()) {
            clientesFilter.forEach(item -> {
                Object[] registros = {
                    item.getID(),
                    item.getIdentificacion(),
                    item.getNombre(),
                    item.getApellido(),
                    item.getEmail(),
                    item.getDireccion(),
                    item.getTelefono(),
                    item.isCredito(),
                    item.getFecha()
                };
                modelo1.addRow(registros);
            });
        }
        _tablaCliente.setModel(modelo1);
        _tablaCliente.setRowHeight(30);//prpoporcionar un estilolto de 30
        _tablaCliente.getColumnModel().getColumn(0).setMaxWidth(0);//ocultar ciertas columnas
        _tablaCliente.getColumnModel().getColumn(0).setMaxWidth(0);
        _tablaCliente.getColumnModel().getColumn(0).setPreferredWidth(0);
        _tablaCliente.getColumnModel().getColumn(8).setMaxWidth(0);
        _tablaCliente.getColumnModel().getColumn(8).setMaxWidth(0);
        _tablaCliente.getColumnModel().getColumn(8).setPreferredWidth(0);
        _tablaCliente.getColumnModel().getColumn(7).setCellRenderer(new Render_Checkbox());
    }

    public void GetCliente() {
        _accion = "update";
        int filas = _tablaCliente.getSelectedRow();
        _idCliente = (Integer) modelo1.getValueAt(filas, 0);
        _teTextField.get(0).setText((String) modelo1.getValueAt(filas, 1));
        _teTextField.get(1).setText((String) modelo1.getValueAt(filas, 2));
        _teTextField.get(2).setText((String) modelo1.getValueAt(filas, 3));
        _teTextField.get(3).setText((String) modelo1.getValueAt(filas, 4));
        _teTextField.get(4).setText((String) modelo1.getValueAt(filas, 5));
        _teTextField.get(5).setText((String) modelo1.getValueAt(filas, 6));
        _checkBoxCredito.setSelected((boolean) modelo1.getValueAt(filas, 7));
        Objetos.uploaddimagen.byteImage(_label.get(6), (byte[]) modelo1.getValueAt(filas, 8));

    }

    public final void restablecer() {
        seccion = 1;
        _accion = "insert";
        _teTextField.get(0).setText("");
        _teTextField.get(1).setText("");
        _teTextField.get(2).setText("");
        _teTextField.get(3).setText("");
        _teTextField.get(4).setText("");
        _teTextField.get(5).setText("");
        _checkBoxCredito.setSelected(false);
        _checkBoxCredito.setForeground(new Color(102, 102, 102));
        _label.get(0).setText("Identificación");
        _label.get(0).setForeground(new Color(102, 102, 102));
        _label.get(1).setText("Nombres");
        _label.get(1).setForeground(new Color(102, 102, 102));
        _label.get(2).setText("Apellidos");
        _label.get(2).setForeground(new Color(102, 102, 102));
        _label.get(3).setText("Email");
        _label.get(3).setForeground(new Color(102, 102, 102));
        _label.get(4).setText("Telefono");
        _label.get(4).setForeground(new Color(102, 102, 102));
        _label.get(5).setText("Direccion");
        _label.get(5).setForeground(new Color(102, 102, 102));
        _label.get(6).setIcon(new ImageIcon(getClass().getClassLoader().getResource("Recursos/logo1.png")));
        listClientes = clientes();
        if (!listClientes.isEmpty()) {
            _paginadorClientes = new Paginador<>(listClientes, _label.get(7), _reg_por_pagina);
        }
        _paginadorClientes = new Paginador<>(listClientes, _label.get(7), _reg_por_pagina);

        SpinnerNumberModel model = new SpinnerNumberModel(10, 1, 100, 1);

        _spinnerPaginas.setModel(model);

        buscarCliente("");

    }
    // </editor-fold>
    private List<TClientes> listClientes;

    public void Paginador(String metodo) {
        switch (metodo) {
            case "Primero" -> {
                switch (seccion) {
                    case 1 -> {
                        if (!listClientes.isEmpty()) {
                            _num_pagina = _paginadorClientes.primero();
                        }
                    }
                }
            }
            case "Anterior" -> {
                switch (seccion) {
                    case 1 -> {
                        if (!listClientes.isEmpty()) {
                            _num_pagina = _paginadorClientes.anterior();
                        }
                    }
                }
            }
            case "Siguiente" -> {
                switch (seccion) {
                    case 1 -> {
                        if (!listClientes.isEmpty()) {
                            _num_pagina = _paginadorClientes.siguiente();
                        }
                    }
                }
            }
            case "Ultimo" -> {
                switch (seccion) {
                    case 1 -> {
                        if (!listClientes.isEmpty()) {
                            _num_pagina = _paginadorClientes.ultimo();
                        }
                    }
                }
            }
        }
        switch (seccion) {
            case 1 ->
                buscarCliente("");
        }

    }

    public void Registro_Paginas() {
        _num_pagina = 1;
        Number caja = (Number) _spinnerPaginas.getValue();
        _reg_por_pagina = caja.intValue();
        if (!listClientes.isEmpty()) {
            _paginadorClientes = new Paginador<>(listClientes, _label.get(7), _reg_por_pagina);
            buscarCliente("");
        }
    }

}
