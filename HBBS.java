package BloodBankSystem;
	
	import java.awt.BorderLayout;

	import javax.swing.*;

	public class HBBS extends JFrame{
		JTabbedPane tabs=new JTabbedPane();
		
		//constructor
		
		public HBBS(String role, int userid){
			setTitle("HospitalBlooodBankSystem");
			setSize(900,600);
			setLayout(new BorderLayout());
			if(role.equalsIgnoreCase("admin")){
				tabs.add("users",new UserPanel());
				tabs.add("Transaction",new TransactionPanel());
				tabs.add("Donor",new DonorPanel());
				tabs.add("BloodStock",new BloodStockPanel());
				tabs.add("Recipient",new RecipientPanel());
				
				
			}
			
			else if(role.equalsIgnoreCase("users")){
				tabs.add("Donor",new TransactionPanel());
				tabs.add("Recipient",new RecipientPanel());
				
			}
			else if(role.equalsIgnoreCase("users")){
				tabs.add("BloodStock",new BloodStockPanel());
			}
			add(tabs,BorderLayout.CENTER);
			setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
	}
	}

