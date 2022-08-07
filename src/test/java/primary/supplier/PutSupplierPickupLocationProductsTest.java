package primary.supplier;

import java.io.File;
import java.util.HashMap;

import io.restassured.module.jsv.JsonSchemaValidator;
import org.hamcrest.MatcherAssert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.im.service.common.ServiceGroup;
import com.im.service.common.Annotation.TestRun;
import com.im.service.rest.WebService;
import com.im.service.util.dataprovider.TestDataProvider;
import com.im.service.util.listener.HtmlReportListener;
import com.im.service.util.listener.TestListener;
import com.im.service.util.ws.Ws;

import common.TestBase;

public class PutSupplierPickupLocationProductsTest extends TestBase {
	private static final Logger LOG = LoggerFactory.getLogger(PutSupplierPickupLocationProductsTest.class); 
	public static final String SERVICE_NAME = "putSupplierPickupLocationProducts"; 
	@Test (enabled=true, dataProviderClass=TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"regression","sanity","positive"},description = "PutSupplierPickupLocationProductsTest with all valid params")
	@TestRun (serviceGroup = ServiceGroup.SUPPLIER,  serviceName = PutSupplierPickupLocationProductsTest.SERVICE_NAME,testName="SupplierProducts",testGroup="p0")
	public void putSupplierLocnProductsTest (HashMap <String, String> data){
		WebService rest = Ws.put(ServiceGroup.SUPPLIER,PutSupplierPickupLocationProductsTest.SERVICE_NAME,TestBase.ENV,TOKEN,data);
		LOG.info("Status:" + rest.getStatus());
		Assert.assertEquals(rest.getStatus(), 200, "The expected status is "+200+". But actual is "+rest.getStatus()+".");
		Assert.assertTrue(rest.getResponse().body().jsonPath().getBoolean("success") , "putSupplierLocnProducts failed");
		MatcherAssert.assertThat(rest.getResponse().body().asString(), JsonSchemaValidator.matchesJsonSchema(new File(rest.getSession().getSchemaFile())));
		LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
	}
}