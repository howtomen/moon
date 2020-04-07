package keys;

public class devKey {
//	private String loginEmail = "sakura_saki321@yahoo.com";
//	private String loginPassword = "password";
//	private String loginCustomerName = "Katherine He";
//	private String invoiceFileName = "IN161574.pdf";
//	private String downloadLocation = "C:\\Users\\hekat\\Downloads";
	
	private String loginEmail = "testtesttest2345@test.com";
	private String loginPassword = "123456";
	private String loginCustomerName = "John Smith";
	private String invoiceFileName = "IN170879.pdf";
	private String downloadLocation = "C:\\Users\\hekat\\Downloads";
	
	private String MySQLUsername = "root";
	private String MySQLPassword = "$kipBeat456";
	private int MySQLPort = 3306;
	
	private String saveRecorderAt = "C:\\Users\\hekat\\Videos\\Automated Tests";

	
	// Login Methods
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
		return invoiceFileName;
	}
	
	public String getdownloadLocation() {
		return downloadLocation;
	}
	
	
	// SQL Methods
	public String getMySQLUsername() {
		return MySQLUsername;
	}
	
	public String getMySQLPassword() {
		return MySQLPassword;
	}
	
	public int getMySQLPort() {
		return MySQLPort;
	}
	
	
	// Save Recorder at
	public String getRecordingPath() {
		return saveRecorderAt;
	}
	
}
