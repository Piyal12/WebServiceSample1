package common;

import com.im.service.common.Config;
import com.im.service.common.ServiceGroup;

public class TestConfig {
	
	private static String CONF_DIR = System.getProperty("user.dir")+"/src/test/resources/config/";
	private static String TEST_DATA_DIR = System.getProperty("user.dir")+"/src/test/resources/testdata/";
	private static String POST_BODY_DIR = System.getProperty("user.dir")+"/src/test/resources/reqbody/";
	private static String CONTRACT_DIR = System.getProperty("user.dir")+"/src/test/resources/contract/";
	private static String TEST_HTML_REPORT_DIR = System.getProperty("user.dir")+"/target/htmlreport/";
	
	public static String COMMANDLINE_ENV = "WSTAF";

	public static void init () {
		
		/*
		 * Add the login credentials for Authentication token
		 */
		
		Config.CONF_FILE_LIST.put(ServiceGroup.CREDENTIAL, CONF_DIR+"credential.ini"); 

		
		/*
		 * ServiceName to the <ServiceGroup>.ini config file mapping
		 */
		
		Config.CONF_FILE_LIST.put(ServiceGroup.LOGIN, CONF_DIR+"login.ini");
		Config.CONF_FILE_LIST.put(ServiceGroup.SUPPLIER, CONF_DIR+"supplier.ini");
		Config.CONF_FILE_LIST.put(ServiceGroup.DASHBOARD, CONF_DIR+ "dashboard.ini");
		Config.CONF_FILE_LIST.put(ServiceGroup.INVOICE, CONF_DIR+ "invoice.ini");
		Config.CONF_FILE_LIST.put(ServiceGroup.QUOTE, CONF_DIR+ "quotation.ini");
		Config.CONF_FILE_LIST.put(ServiceGroup.CREDIT, CONF_DIR+"credit.ini");
		Config.CONF_FILE_LIST.put(ServiceGroup.TRIP, CONF_DIR+"trip.ini");
		Config.CONF_FILE_LIST.put(ServiceGroup.CUSTOMER, CONF_DIR+"customer.ini");
		Config.CONF_FILE_LIST.put(ServiceGroup.GROUP5, CONF_DIR+"kyc.ini");
		Config.CONF_FILE_LIST.put(ServiceGroup.PRODUCT, CONF_DIR+"product.ini");
		Config.CONF_FILE_LIST.put(ServiceGroup.GROUP1, CONF_DIR+"inquiry.ini");
		Config.CONF_FILE_LIST.put(ServiceGroup.DEAL, CONF_DIR+"deal.ini");

		Config.CONF_FILE_LIST.put(ServiceGroup.CATALOG, CONF_DIR+"catalogue.ini");

		/*
		 *  Application to Test Data directory mapping
		 */
	
		Config.TEST_DATA_DIR_LIST.put(ServiceGroup.LOGIN, TEST_DATA_DIR+"login/");
		Config.TEST_DATA_DIR_LIST.put(ServiceGroup.SUPPLIER, TEST_DATA_DIR+"supplier/");
		Config.TEST_DATA_DIR_LIST.put(ServiceGroup.DASHBOARD, TEST_DATA_DIR+"dashboard/");
		Config.TEST_DATA_DIR_LIST.put(ServiceGroup.INVOICE, TEST_DATA_DIR+"invoice/");
		Config.TEST_DATA_DIR_LIST.put(ServiceGroup.QUOTE, TEST_DATA_DIR+"quotation/");
		Config.TEST_DATA_DIR_LIST.put(ServiceGroup.CUSTOMER, TEST_DATA_DIR+"customer/");
		Config.TEST_DATA_DIR_LIST.put(ServiceGroup.CREDIT, TEST_DATA_DIR+"credit/");
		Config.TEST_DATA_DIR_LIST.put(ServiceGroup.TRIP, TEST_DATA_DIR+"trip/");
		Config.TEST_DATA_DIR_LIST.put(ServiceGroup.GROUP5, TEST_DATA_DIR+"kyc/");
		Config.TEST_DATA_DIR_LIST.put(ServiceGroup.PRODUCT, TEST_DATA_DIR+"product/");
		Config.TEST_DATA_DIR_LIST.put(ServiceGroup.GROUP1, TEST_DATA_DIR+"inquiry/");
		Config.TEST_DATA_DIR_LIST.put(ServiceGroup.CATALOG, TEST_DATA_DIR+"catalogue/");
		Config.TEST_DATA_DIR_LIST.put(ServiceGroup.DEAL, TEST_DATA_DIR+"deal/");
		/*
		 *  Application to Post Body directory mapping (directory with json files)
		 */
		
		Config.REQUEST_BODY_DIR_LIST.put(ServiceGroup.LOGIN, POST_BODY_DIR+"login/");
		Config.REQUEST_BODY_DIR_LIST.put(ServiceGroup.SUPPLIER, POST_BODY_DIR+"supplier/");
		Config.REQUEST_BODY_DIR_LIST.put(ServiceGroup.DASHBOARD, POST_BODY_DIR+"dashboard/");
		Config.REQUEST_BODY_DIR_LIST.put(ServiceGroup.INVOICE, POST_BODY_DIR+"invoice/");
		Config.REQUEST_BODY_DIR_LIST.put(ServiceGroup.QUOTE, POST_BODY_DIR+"quotation/");
		Config.REQUEST_BODY_DIR_LIST.put(ServiceGroup.CUSTOMER, POST_BODY_DIR+"customer/");
		Config.REQUEST_BODY_DIR_LIST.put(ServiceGroup.CREDIT, POST_BODY_DIR+"credit/");
		Config.REQUEST_BODY_DIR_LIST.put(ServiceGroup.TRIP, POST_BODY_DIR+"trip/");
		Config.REQUEST_BODY_DIR_LIST.put(ServiceGroup.GROUP5, POST_BODY_DIR+"kyc/");
		Config.REQUEST_BODY_DIR_LIST.put(ServiceGroup.PRODUCT, POST_BODY_DIR+"product/");
		Config.REQUEST_BODY_DIR_LIST.put(ServiceGroup.CATALOG, POST_BODY_DIR+"catalogue/");
		Config.REQUEST_BODY_DIR_LIST.put(ServiceGroup.GROUP1, POST_BODY_DIR+"inquiry/");
		Config.REQUEST_BODY_DIR_LIST.put(ServiceGroup.DEAL, POST_BODY_DIR+"deal/");

		/*
		 *  Application to Schema Body directory mapping (directory with json files)
		 */
		Config.CONTRACT_DIR_LIST.put(ServiceGroup.SUPPLIER, CONTRACT_DIR+"supplier/");
		Config.CONTRACT_DIR_LIST.put(ServiceGroup.LOGIN, CONTRACT_DIR+"login/");
		Config.CONTRACT_DIR_LIST.put(ServiceGroup.DASHBOARD, CONTRACT_DIR+"dashboard/");
		Config.CONTRACT_DIR_LIST.put(ServiceGroup.INVOICE, CONTRACT_DIR+"invoice/");
		Config.CONTRACT_DIR_LIST.put(ServiceGroup.QUOTE, CONTRACT_DIR+"quotation/");
		Config.CONTRACT_DIR_LIST.put(ServiceGroup.CUSTOMER, CONTRACT_DIR+"customer/");
		Config.CONTRACT_DIR_LIST.put(ServiceGroup.CREDIT, CONTRACT_DIR+"credit/");
		Config.CONTRACT_DIR_LIST.put(ServiceGroup.TRIP, CONTRACT_DIR+"trip/");
		Config.CONTRACT_DIR_LIST.put(ServiceGroup.GROUP5, CONTRACT_DIR+"kyc/");
		Config.CONTRACT_DIR_LIST.put(ServiceGroup.PRODUCT, CONTRACT_DIR+"product/");
		Config.CONTRACT_DIR_LIST.put(ServiceGroup.CATALOG, CONTRACT_DIR+"catalogue/");

		Config.CONTRACT_DIR_LIST.put(ServiceGroup.GROUP1, CONTRACT_DIR+"inquiry/");
		Config.CONTRACT_DIR_LIST.put(ServiceGroup.DEAL, CONTRACT_DIR+"deal/");


		/*
		 *  Initialize HTML Report
		 */
		
		Config.htmlReportInit(TestConfig.TEST_HTML_REPORT_DIR);
	}
	
	public static void conclude() {
		Config.generateHtmlReport();
	}
	
	
}