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
import com.im.service.util.ws.Ws;
import com.im.service.util.dataprovider.TestDataProvider;
import com.im.service.util.listener.*;

import common.TestBase;

public class GetSupplierOfficeTest extends TestBase {
	private static final Logger LOG = LoggerFactory.getLogger(GetSupplierOfficeTest.class); 
	public static final String SERVICE_NAME = "getSupplierOffice"; 
	@Test (enabled=true, dataProviderClass=TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"regression","sanity","positive"},description = "GetSupplierOfficeTest with all valid params")
	@TestRun (serviceGroup = ServiceGroup.SUPPLIER,  serviceName = GetSupplierOfficeTest.SERVICE_NAME,testName="getSupplierOffice",testGroup="p0")
	public void getSupplierOfficeDetailsTest (HashMap <String, String> data){
		WebService rest = Ws.get(ServiceGroup.SUPPLIER,GetSupplierOfficeTest.SERVICE_NAME,TestBase.ENV,TOKEN,data);
		LOG.info("Status:" + rest.getStatus());
		Assert.assertEquals(rest.getStatus(), 200, "The expected status is "+200+". But actual is "+rest.getStatus()+".");
		Assert.assertTrue(rest.getResponse().body().jsonPath().getBoolean("success") , "SupplierOfficeDetails Failed");
		MatcherAssert.assertThat(rest.getResponse().body().asString(), JsonSchemaValidator.matchesJsonSchema(new File(rest.getSession().getSchemaFile())));
		LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
	}
}