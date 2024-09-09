package org.example;
import lombok.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
@Builder
@ToString

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example-unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();
//Creo Clientes
            Cliente c1 = Cliente.builder().Nombre("Juan").Apellido("Perez").DNI(27923212).build();
            Domicilio dom1 = Domicilio.builder().NombreCalle("Patricias Argentinas").numero(720).build();
            c1.setDomicilio(dom1); //Cliente domicilio
            dom1.setCliente(c1); //Domicilio cliente
            entityManager.persist(c1);
            entityManager.persist(dom1);


//Busca el domicilio cuya id sea 1
            Domicilio domicilio = entityManager.find(Domicilio.class, 1L);
//Busca al cliente cuya id sea 1
            Cliente cliente = entityManager.find(Cliente.class, 1L);
//Muestra el DNI del cliente asociado al domicilio con id 1
            System.out.println("Cliente de domicilio: " + domicilio.getCliente().getDNI());
//Muestra el Nombre de la calle asociado al cliente cuyo id es 1
            System.out.println("Domicilio de Cliente: " + cliente.getDomicilio().getNombreCalle());

//EntityManager flush y commit
            entityManager.flush();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }

        entityManager.close();
        entityManagerFactory.close();

    }
}
