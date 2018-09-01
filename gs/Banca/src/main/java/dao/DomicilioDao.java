package dao;

import dao.interfaces.Dao;
import domain.Domicilio;
import utilities.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

public class DomicilioDao extends ConnectionDB implements Dao<Domicilio> {

    private final String FIND_ALL = "{call findAllDomicilio()}";
    private final String ADD = "{call addDomicilio(?,?,?,?)}";
    private final String UPDATE = "{call updateDomicilio(?,?,?,?,?)}";
    private final String FIND = "{call findDomicilio(?)}";
    private final String DELETE = "{call deleteDomicilio(?)}";

    @Override
    public Optional<Domicilio> find(long id) {
        Optional<Domicilio> domicilio = Optional.empty();
        try {
            CallableStatement stmt = connection().prepareCall(FIND);
            stmt.setInt(1, (int)id);
            ResultSet resultSet = stmt.executeQuery();
            while(resultSet.next()){
                domicilio = Optional.of(new Domicilio.Builder()
                        .numero(resultSet.getInt("FINUMERO"))
                        .calle(resultSet.getString("FCCALLE"))
                        .colonia(resultSet.getString("FCCOLONIA"))
                        .estado(resultSet.getString("FCESTADO"))
                        .codigoPostal(resultSet.getInt("FICODIGOPOSTAL"))
                        .build());
            }
            resultSet.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return domicilio;
    }

    @Override
    public ArrayList<Domicilio> findAll() {
        ArrayList<Domicilio> clientes = new ArrayList<>();
        try {
            CallableStatement stmt = connection().prepareCall(FIND_ALL);
            //stmt.setInt(1, 1);
            ResultSet resultSet = stmt.executeQuery();
            while(resultSet.next()){
                Domicilio cliente = new Domicilio.Builder()
                        .numero(resultSet.getInt("FINUMERO"))
                        .calle(resultSet.getString("FCCALLE"))
                        .colonia(resultSet.getString("FCCOLONIA"))
                        .estado(resultSet.getString("FCESTADO"))
                        .codigoPostal(resultSet.getInt("FICODIGOPOSTAL"))
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
    public void add(Domicilio domicilio) {
        try {
            CallableStatement stmt = connection().prepareCall(ADD);
            stmt.setString(1, domicilio.getCalle());
            stmt.setString(2, domicilio.getColonia());
            stmt.setString(3, domicilio.getEstado());
            stmt.setInt(4, domicilio.getCodigoPostal());
            ResultSet resultSet = stmt.executeQuery();
            while(resultSet.next()){
                domicilio.setNumero(resultSet.getInt(1));
            }
            resultSet.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Domicilio domicilio) {
        if(domicilio.getNumero() != -1){
            Optional<Domicilio> dom = find(domicilio.getNumero());
            if(dom.isPresent()){
                try {
                    CallableStatement stmt = connection().prepareCall(UPDATE);
                    stmt.setInt(1, domicilio.getNumero());
                    stmt.setString(2, domicilio.getCalle());
                    stmt.setString(3, domicilio.getColonia());
                    stmt.setString(4, domicilio.getEstado());
                    stmt.setInt(5, domicilio.getCodigoPostal());
                    ResultSet resultSet = stmt.executeQuery();
                    while(resultSet.next()){
                        domicilio = new Domicilio.Builder()
                                .numero(resultSet.getInt("FINUMERO"))
                                .calle(resultSet.getString("FCCALLE"))
                                .colonia(resultSet.getString("FCCOLONIA"))
                                .estado(resultSet.getString("FCESTADO"))
                                .codigoPostal(resultSet.getInt("FICODIGOPOSTAL"))
                                .build();
                    }
                    resultSet.close();
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }else{
                System.out.println("Lo sentimos, el domicilio no esta registrado.");
            }
        }else{
            System.out.println("Lo sentimos, El domicilio no contiene un numero unico.");
        }
    }

    @Override
    public void delete(Domicilio domicilio) {
        if(domicilio.getNumero() != -1){
            Optional<Domicilio> dom = this.find(domicilio.getNumero());
            if(dom.isPresent()){
                try {
                    CallableStatement stmt = connection().prepareCall(DELETE);
                    stmt.setInt(1, domicilio.getNumero());
                    ResultSet resultSet = stmt.executeQuery();
                    while(resultSet.next()){
                        domicilio = new Domicilio.Builder()
                                .numero(resultSet.getInt("FINUMERO"))
                                .calle(resultSet.getString("FCCALLE"))
                                .colonia(resultSet.getString("FCCOLONIA"))
                                .estado(resultSet.getString("FCESTADO"))
                                .codigoPostal(resultSet.getInt("FICODIGOPOSTAL"))
                                .build();
                    }
                    resultSet.close();
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
