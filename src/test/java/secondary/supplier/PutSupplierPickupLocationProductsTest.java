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
import io.restassured.module.jsv.JsonSchemaValidator;
import org.hamcrest.MatcherAssert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;

public class PutSupplierPickupLocationProductsTest extends TestBase {
	private static final Logger LOG = LoggerFactory.getLogger(PutSupplierPickupLocationProductsTest.class); 
	public static final String SERVICE_NAME = "putSupplierPickupLocationProducts"; 
	@Test (enabled=true, dataProviderClass=TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"negative","regression"},description = "PutSupplierPickupLocationProductsTest without passing Alias Id and measurement Id")
	@TestRun (serviceGroup = ServiceGroup.SUPPLIER,  serviceName = PutSupplierPickupLocationProductsTest.SERVICE_NAME,testName="withoutPassingAliasID_measurementID_Test",testGroup="p1")
	public void withoutPassingAliasID_measurementID_Test (HashMap <String, String> data){
		WebService rest = Ws.put(ServiceGroup.SUPPLIER,PutSupplierPickupLocationProductsTest.SERVICE_NAME,TestBase.ENV,TOKEN,data);
		LOG.info("Status:" + rest.getStatus());
		Assert.assertEquals(rest.getStatus(), 400, "The expected status is "+400+". But actual is "+rest.getStatus()+".");
		LOG.info("\n" + rest.getResponse().body().prettyPeek());
	}
	@Test (enabled=true, dataProviderClass=TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"negative","regression"},description = "PutSupplierPickupLocationProductsTest with AliasId as Alphanumeric")
	@TestRun (serviceGroup = ServiceGroup.SUPPLIER,  serviceName = PutSupplierPickupLocationProductsTest.SERVICE_NAME,testName="SupplierProducts",testGroup="p0",attributeName = "aliasId", dataConstraint = DataConstraint.FOR_SPECIFIED, dataType = DataType.ALPHA_NUMERIC)
	public void PassProduct_AliasIdAsAlphapnemeric_Test (HashMap <String, String> data){
		WebService rest = Ws.put(ServiceGroup.SUPPLIER,PutSupplierPickupLocationProductsTest.SERVICE_NAME,TestBase.ENV,TOKEN,data);
		LOG.info("Status:" + rest.getStatus());
		Assert.assertEquals(rest.getStatus(), 400, "The expected status is "+400+". But actual is "+rest.getStatus()+".");
		LOG.info("\n" + rest.getResponse().body().prettyPeek());
	}
	@Test (enabled=true, dataProviderClass=TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"negative","regression"},description = "PutSupplierPickupLocationProductsTest with Alias Id as null")
	@TestRun (serviceGroup = ServiceGroup.SUPPLIER,  serviceName = PutSupplierPickupLocationProductsTest.SERVICE_NAME,testName="SupplierProducts",testGroup="p0",attributeName = "aliasId", dataConstraint = DataConstraint.FOR_SPECIFIED, dataType = DataType.NULL)
	public void PassProduct_AliasIdAsNull_Test (HashMap <String, String> data){
		WebService rest = Ws.put(ServiceGroup.SUPPLIER,PutSupplierPickupLocationProductsTest.SERVICE_NAME,TestBase.ENV,TOKEN,data);
		LOG.info("Status:" + rest.getStatus());
		Assert.assertEquals(rest.getStatus(), 400, "The expected status is "+400+". But actual is "+rest.getStatus()+".");
		LOG.info("\n" + rest.getResponse().body().prettyPeek());
	}
	@Test (enabled=true, dataProviderClass=TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"negative","regression"},description = "PutSupplierPickupLocationProductsTest with invalid http method")
	@TestRun (serviceGroup = ServiceGroup.SUPPLIER,  serviceName = PutSupplierPickupLocationProductsTest.SERVICE_NAME,testName="SupplierProducts",testGroup="p0")
	public void invalid_HttpMethod_Test (HashMap <String, String> data){
		WebService rest=Ws.post(ServiceGroup.SUPPLIER,PutSupplierPickupLocationProductsTest.SERVICE_NAME,TestBase.ENV,data);
		LOG.info("Status:" + rest.getStatus());
		Assert.assertEquals(rest.getStatus(), 405, "The expected status is "+405+". But actual is "+rest.getStatus()+".");
		LOG.info("\n" + rest.getResponse().body().prettyPeek());
	}
}