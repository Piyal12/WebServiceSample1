package secondary.supplier;

import com.im.service.common.Annotation.TestRun;
import com.im.service.common.ServiceGroup;
import com.im.service.rest.WebService;
import com.im.service.util.dataprovider.TestDataProvider;
import com.im.service.util.listener.HtmlReportListener;
import com.im.service.util.listener.TestListener;
import com.im.service.util.ws.Ws;
import common.TestBase;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.hamcrest.MatcherAssert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;



public class EditSupplierPickupLocationTest extends TestBase {
	private static final Logger LOG = LoggerFactory.getLogger(EditSupplierPickupLocationTest.class); 
	public static final String SERVICE_NAME = "editSupplierPickupLocation"; 
	@Test (enabled=true, dataProviderClass=TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"negative","regression"},description = "EditSupplierPickupLocationTest with Ph No as blank")
	@TestRun (serviceGroup = ServiceGroup.SUPPLIER,  serviceName = EditSupplierPickupLocationTest.SERVICE_NAME,testName="blank_PhNo_Test",testGroup="p1")
	public void blank_PhNo_Test (HashMap <String, String> data){
		WebService rest = Ws.put(ServiceGroup.SUPPLIER,EditSupplierPickupLocationTest.SERVICE_NAME,TestBase.ENV,TOKEN,data);
		LOG.info("Status:" + rest.getStatus());
		Assert.assertEquals(rest.getStatus(), 400, "The expected status is "+400+". But actual is "+rest.getStatus()+".");
		LOG.info("\n" + rest.getResponse().body().prettyPeek());
	}
	@Test (enabled=true, dataProviderClass=TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"negative","regression"},description = "EditSupplierPickupLocationTest with invalid mailid")
	@TestRun (serviceGroup = ServiceGroup.SUPPLIER,  serviceName = EditSupplierPickupLocationTest.SERVICE_NAME,testName="invalid_MailId_Test",testGroup="p2")
	public void invalid_MailId_Test (HashMap <String, String> data){
		WebService rest = Ws.put(ServiceGroup.SUPPLIER,EditSupplierPickupLocationTest.SERVICE_NAME,TestBase.ENV,TOKEN,data);
		LOG.info("Status:" + rest.getStatus());
		Assert.assertEquals(rest.getStatus(), 400, "The expected status is "+400+". But actual is "+rest.getStatus()+".");
		LOG.info("\n" + rest.getResponse().body().prettyPeek());
	}
	@Test (enabled=true, dataProviderClass=TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"negative","regression"},description = "EditSupplierPickupLocationTest with invalid KYC")
	@TestRun (serviceGroup = ServiceGroup.SUPPLIER,  serviceName = EditSupplierPickupLocationTest.SERVICE_NAME,testName="invalid_KYC_Test",testGroup="p3")
	public void invalid_KYC_Test (HashMap <String, String> data){
		WebService rest = Ws.put(ServiceGroup.SUPPLIER,EditSupplierPickupLocationTest.SERVICE_NAME,TestBase.ENV,TOKEN,data);
		LOG.info("Status:" + rest.getStatus());
		Assert.assertEquals(rest.getStatus(), 500, "The expected status is "+500+". But actual is "+rest.getStatus()+".");
		LOG.info("\n" + rest.getResponse().body().prettyPeek());
	}
	@Test (enabled=true, dataProviderClass=TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"negative","regression"},description = "EditSupplierPickupLocationTest invalid http method")
	@TestRun (serviceGroup = ServiceGroup.SUPPLIER,  serviceName = EditSupplierPickupLocationTest.SERVICE_NAME,testName="editSuppLocn",testGroup="p0")
	public void invalid_HttpMethod_Test (HashMap <String, String> data){
		WebService rest = Ws.post(ServiceGroup.SUPPLIER,EditSupplierPickupLocationTest.SERVICE_NAME,TestBase.ENV,data);
		LOG.info("Status:" + rest.getStatus());
		Assert.assertEquals(rest.getStatus(), 405, "The expected status is "+405+". But actual is "+rest.getStatus()+".");
		LOG.info("\n" + rest.getResponse().body().prettyPeek());
	}
}