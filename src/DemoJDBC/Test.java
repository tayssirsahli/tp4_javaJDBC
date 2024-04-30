package DemoJDBC;

import java.util.ArrayList;
import java.util.List;

import jDBCProjet.beans.Client;
import jDBCProjet.connexion.Connexion;
import jDBCProjet.service.Clientservices;

public class Test {

	public static void main(String[] args) {
			Connexion.getConn();
			Clientservices c=new Clientservices();
			//c.create(new Client("saif","ben saad"));
			List<Client> l = new ArrayList<>();
			l = c.findAll();
			for (int i=0;i<l.size();i++) {
				System.out.println("id: "+l.get(i).getId() + "\n nom: " +l.get(i).getNom() +"\n prenom: "+ l.get(i).getPrenom());
			}
			Client newClient=null;
			
			int clientId = 3; 
	        Client foundClient = c.findById(clientId);
	        if (foundClient != null) {
	            newClient = new Client(foundClient.getId(), foundClient.getNom(), foundClient.getPrenom());
	            System.out.println("New Client: " + newClient);
	            
	            boolean updated = c.update(foundClient);
		        if (updated) {
		            System.out.println("Client with ID " + clientId + " updated successfully.");
		        } else {
		            System.out.println("Failed to update client with ID " + clientId + ".");
		        }
	        } else {
	            System.out.println("Client with ID " + clientId + " not found.");
	        }
			
		//System.out.println(c.delete(newClient));
	        
	        
	   

	}

}
