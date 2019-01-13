package tema3_ioc;

import classesIoc.Client;
import classesIoc.Sector;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

public class GestorClients implements Serializable {

    private EntityManager em = null;

    public GestorClients(EntityManager em) {
        this.em = em;
    }

    public void inserirClient(Client client) {
        // Iniciam la transacció (p.116)
        em.getTransaction().begin();

        // Feim persistent el client que ens passen per paràmetre, inserint una nova fila (p.114)
        em.persist(client);

        // Confirmam la transacció (p.116)
        em.getTransaction().commit();
        System.out.println("S'ha inserit un nou client.\n");

    }

    public void modificarClient(Client client) {
        em.getTransaction().begin();

        try {
            // Modifiquem la fila ja existent amb les noves dades del client que ens passen per paràmetre  (p.115)
            client = em.merge(client);

            em.getTransaction().commit();
            System.out.println("S'han modificat les dades del client amb ID " + client.getId() + ".\n");

        } catch (Exception e) {
            System.out.println("ERROR al intentar modificat les dades del client amb ID " + client.getId());
            System.out.println(e.getMessage());
        }
    }

    public void eliminarClient(int id) {
        Client client = null;
        em.getTransaction().begin();

        try {
            client = em.find(Client.class, id);
            em.remove(client);
            em.getTransaction().commit();
            System.out.println("S'ha eliminat el client amb ID " + id + ".\n");

        } catch (Exception e) {
            System.out.println("ERROR al intentar eliminar el client amb id " + id);
            System.out.println(e.getMessage());
            if (client == null) {
                System.out.println("El client amb id " + id + " no existeix.\n");
            }
        }
    }

    public Client cercarClientPerId(int id) {
        Client c = em.find(Client.class, id);

        if (c != null) {
            System.out.println("S'ha trobat un client amb id " + id + ".\n");
        } else {
            System.out.println("NO s'ha trobat cap client amb id " + id + ".\n");
        }

        return c;
    }

    public Client cercarClientPerNif(String nif) {
        Client c = null;
        Query q = em.createNamedQuery("Client.clientPerNif", Client.class);
        q.setParameter("nif", nif);
        c = (Client) q.getSingleResult();

        return c;
    }

    public List<Client> cercarClientsPerCadena(String cadena) {
        List<Client> l;
        Query q = em.createNamedQuery("Client.clientsPerNom", Client.class);
        q.setParameter("nom", "%" + cadena + "%");
        l = q.getResultList();

        return l;
    }

    public List<Client> cercarClientsPerSector(Sector sector) {
        Query q = em.createNamedQuery("Client.clientsPerSector", Client.class);
        q.setParameter("sector", sector.getId());

        return q.getResultList();
    }

    public void inserirSector(Sector sector) {
        // Iniciam la transacció (p.116)
        em.getTransaction().begin();

        // Feim persistent el client que ens passen per paràmetre, inserint una nova fila (p.114)
        em.persist(sector);

        // Confirmam la transacció (p.116)
        em.getTransaction().commit();
        System.out.println("S'ha inserit un nou sector.\n");

    }

}
