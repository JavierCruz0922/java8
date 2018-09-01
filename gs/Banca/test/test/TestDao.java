package test;

import dao.DomicilioDao;
import domain.Domicilio;

import java.util.Optional;

public class TestDao {
    public static void main(String[] args) {
        DomicilioDao domicilioDao = new DomicilioDao();

        domicilioDao.getConnection();

        Domicilio domicilio = new Domicilio.Builder()
                .numero(4)
                .calle("Av. San Miguel")
                .colonia("Londres")
                .estado("Colima")
                .codigoPostal(93850)
                .build();

        System.out.println("--- Add ---");
        domicilioDao.add(domicilio);

        System.out.println("--- Update ---");
        domicilioDao.update(domicilio);
        System.out.println(domicilio);

        System.out.println("--- Find ---");
        Optional<Domicilio> findDao = domicilioDao.find(2);
        findDao.ifPresent(System.out::println);

        System.out.println("--- Find All ---");
        domicilioDao.findAll().forEach(System.out::println);

        System.out.println("--- Delete ---");

        domicilioDao.closeConnection();
    }
}
