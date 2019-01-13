package tema3_ioc;

import classesIoc.Client;
import classesIoc.Sector;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

public class Tema3_IOC {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Tema3_IOCPU");
        EntityManager em = emf.createEntityManager();

        GestorClients gestor = new GestorClients(em);

        /* Mètode per inserir clients 
        Client client1 = new Client();
        Client client2 = new Client();
        Client client3 = new Client();
        Client client4 = new Client();
        Client client5 = new Client();
        Client client6 = new Client();

        gestor.inserirClient(client1);
        gestor.inserirClient(client2);
        gestor.inserirClient(client3);
        gestor.inserirClient(client4);
        gestor.inserirClient(client5);
        gestor.inserirClient(client6);
         */
 /* Mètodes per cercar clients per id i modificar clients  
        Client client1 = gestor.cercarClientPerId(1);
        Client client2 = gestor.cercarClientPerId(2);
        Client client3 = gestor.cercarClientPerId(3);
        Client client4 = gestor.cercarClientPerId(4);        
        client1.setNom("Luciano");        
        client2.setNom("Pepe");        
        client3.setNom("Sofia");        
        client4.setNom("Ana");
        gestor.modificarClient(client1);
        gestor.modificarClient(client2);
        gestor.modificarClient(client3);
        gestor.modificarClient(client4);
         */
 /* Mètode per cercar clients per nif 
        Client c1 = gestor.cercarClientPerId(4);
        c1.setNom("Mariana");
        c1.setNif("11222333-A");
        gestor.modificarClient(c1);
        Client c2 = gestor.cercarClientPerNif("11222333-A");
        System.out.println("El client amb el nif " + c2.getNif() + " es diu " + c2.getNom());
         */
 /* Exemple 1 per cercar el clients que tenen al seu nom un determinat String 
        String cadena = "ia";
        List<Client> l = gestor.cercarClientsPerCadena(cadena);
        
        if (l.size() == 0) {
            System.out.println("No hi ha cap client que tingui la cadena " + cadena + " al nom seu nom.");
        } else {
            System.out.println("LLISTAT de clients amb la cadena " + cadena + " al nom:");

            for (int i = 0; i < l.size(); i++) {
                System.out.println(l.get(i).getNom());
            }
        }
         */
 /* Exemple 2 per cercar el clients que tenen al seu nom un determinat String 
        String cadena = "xxx";
        List<Client> l = gestor.cercarClientsPerCadena(cadena);
        
        if (l.size() == 0) {
            System.out.println("No hi ha cap client que tingui la cadena " + cadena + " al nom seu nom.");
        } else {
            System.out.println("LLISTAT de clients amb la cadena " + cadena + " al nom:");

            for (int i = 0; i < l.size(); i++) {
                System.out.println(l.get(i).getNom());
            }
        }
         */
 /* Exemple 1 per cercar la llista de clients d'un sector 
        Sector s1 = new Sector("Sector 1");
        Sector s2 = new Sector("Sector 2");
        Sector s3 = new Sector("Sector 3");
        
        gestor.inserirSector(s1);
        gestor.inserirSector(s2);
        gestor.inserirSector(s3);
        
        Client c1 = gestor.cercarClientPerId(1);        
        Client c2 = gestor.cercarClientPerId(2);        
        Client c3 = gestor.cercarClientPerId(3);        
        Client c4 = gestor.cercarClientPerId(4);
        
        c1.setSector(s3);        
        c2.setSector(s3);        
        c3.setSector(s3);        
        c4.setSector(s2);
        
        gestor.modificarClient(c1);        
        gestor.modificarClient(c2);       
        gestor.modificarClient(c3);       
        gestor.modificarClient(c4);
        
        List<Client> l = gestor.cercarClientsPerSector(s3);
        
        if (l.size() == 0) {
            System.out.println("No hi ha cap client al sector amb ID " + s3.getId());
        } else {
            System.out.println("LLISTAT de clients al sector amb ID " + s3.getId());
            for (int i = 0; i < l.size(); i++) {
                System.out.println(l.get(i).getNom());
            }
        }
         */
 /* Exemple 2 per cercar la llista de clients d'un sector 
        Sector s1 = em.find(Sector.class, "Sector 1");
        
        List<Client> l = gestor.cercarClientsPerSector(s1);
        
        if (l.size() == 0) {
            System.out.println("No hi ha cap client al sector amb ID " + s1.getId());
        } else {
            System.out.println("LLISTAT de clients al sector amb ID " + s1.getId());
            for (int i = 0; i < l.size(); i++) {
                System.out.println(l.get(i).getNom());
            }
        }
         */
 /* Exemple per eliminar client 
        gestor.eliminarClient(1);
        */
    }

}
