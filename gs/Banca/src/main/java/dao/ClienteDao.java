package dao;

import dao.interfaces.Dao;
import domain.Cliente;
import utilities.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;

public class ClienteDao extends ConnectionDB implements Dao<Cliente> {

    @Override
    public Optional<Cliente> find(long id) {
        return Optional.empty();
    }

    @Override
    public ArrayList<Cliente> findAll() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        try {
            String query = "{call findAllDomicilio()}";
            CallableStatement stmt = super.connection().prepareCall(query);
            //stmt.setInt(1, 1);
            ResultSet resultSet = stmt.executeQuery();
            while(resultSet.next()){
                Cliente cliente = new Cliente.Builder()
                        .numero(resultSet.getInt("FINUMERO"))
                        .build();
                clientes.add(cliente);
            }
            resultSet.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    @Override
    public void add(Cliente cliente) {
    }

    @Override
    public void update(Cliente cliente) {
    }

    @Override
    public void delete(Cliente cliente) {
    }
}
