package secondary.supplier;

import com.im.service.common.Annotation.TestRun;
import com.im.service.common.DataConstraint;
import com.im.service.common.DataType;
import com.im.service.common.ServiceGroup;
import com.im.service.rest.WebService;
import com.im.service.util.dataprovider.TestDataProvider;
import com.im.service.util.listener.HtmlReportListener;
import com.im.service.util.listener.TestListener;
import com.im.service.util.ws.Ws;
import common.TestBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.HashMap;


public class EditSupplierOfficeTest extends TestBase{
	private static final Logger LOG = LoggerFactory.getLogger(EditSupplierOfficeTest.class); 
	public static final String SERVICE_NAME = "editSupplierOffice"; 
	@Test (enabled=true, dataProviderClass=TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"negative","regression"},description = "EditSupplierOfficeTest with invalid http method")
	@TestRun (serviceGroup = ServiceGroup.SUPPLIER,  serviceName = EditSupplierOfficeTest.SERVICE_NAME,testName="editSuppOffice",testGroup="p0")
	public void invalidHttpMethod_Test (HashMap <String, String> data){
		WebService rest = Ws.post(ServiceGroup.SUPPLIER,EditSupplierOfficeTest.SERVICE_NAME,TestBase.ENV,data);
		LOG.info("Status:" + rest.getStatus());
		Assert.assertEquals(rest.getStatus(), 405, "The expected status is "+405+". But actual is "+rest.getStatus()+".");
		LOG.info("\n" + rest.getResponse().body().prettyPeek());
	}
	@Test (enabled=true, dataProviderClass=TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"negative","regression"},description = "EditSupplierOfficeTest with invalid Supplier ID")
	@TestRun (serviceGroup = ServiceGroup.SUPPLIER,  serviceName = EditSupplierOfficeTest.SERVICE_NAME,testName="invalidSuppID",testGroup="p1")
	public void invalidSuppID_Test (HashMap <String, String> data){
		WebService rest = Ws.put(ServiceGroup.SUPPLIER,EditSupplierOfficeTest.SERVICE_NAME,TestBase.ENV,data);
		LOG.info("Status:" + rest.getStatus());
		Assert.assertEquals(rest.getStatus(), 500, "The expected status is "+500+". But actual is "+rest.getStatus()+".");
		LOG.info("\n" + rest.getResponse().body().prettyPeek());
	}
	@Test (enabled=true, dataProviderClass=TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"negative","regression"},description = "EditSupplierOfficeTest with invalid KYC Id")
	@TestRun (serviceGroup = ServiceGroup.SUPPLIER,  serviceName = EditSupplierOfficeTest.SERVICE_NAME,testName="invalidKycID",testGroup="p2")
	public void invalidKycID_Test (HashMap <String, String> data){
		WebService rest = Ws.put(ServiceGroup.SUPPLIER,EditSupplierOfficeTest.SERVICE_NAME,TestBase.ENV,data);
		LOG.info("Status:" + rest.getStatus());
		Assert.assertEquals(rest.getStatus(), 400, "The expected status is "+400+". But actual is "+rest.getStatus()+".");
		LOG.info("\n" + rest.getResponse().body().prettyPeek());
	}
	@Test (enabled=true, dataProviderClass=TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"negative","regression"},description = "EditSupplierOfficeTest with KYC Id as null")
	@TestRun (serviceGroup = ServiceGroup.SUPPLIER,  serviceName = EditSupplierOfficeTest.SERVICE_NAME,testName="invalidKycID",testGroup="p2",attributeName = "kycId",dataConstraint = DataConstraint.FOR_SPECIFIED,dataType = DataType.NULL)
	public void nullAsKycID_Test (HashMap <String, String> data){
		WebService rest = Ws.put(ServiceGroup.SUPPLIER,EditSupplierOfficeTest.SERVICE_NAME,TestBase.ENV,data);
		LOG.info("Status:" + rest.getStatus());
		Assert.assertEquals(rest.getStatus(), 400, "The expected status is "+400+". But actual is "+rest.getStatus()+".");
		LOG.info("\n" + rest.getResponse().body().prettyPeek());
	}
}

