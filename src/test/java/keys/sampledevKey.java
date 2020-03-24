package keys;

// To protect our username and password and prevent us from switching back and forth code
// Create a copy of this java file to this folder
// Rename file to devKey.java (so it will be part of the .gitignore)

public class sampledevKey {
	private String loginEmail = "";
	private String loginPassword = "";
	private String loginCustomerName = "";
	private String InvoiceFileName = ""; 		// example "IN161574.pdf"
	private String downloadLocation = "";		// example "C:\\Users\\hekat\\Downloads"

	
	public String getValidWebEmail() {
		return loginEmail;
	}
	
	public String getValidWebPassword() {
		return loginPassword;
	}
	
	public String getCustomerName() {
		return loginCustomerName;
	}
	
	public String getInvoiceFileName() {
		return InvoiceFileName;
	}
	
	public String getdownloadLocation() {
		return downloadLocation;
	}
}
