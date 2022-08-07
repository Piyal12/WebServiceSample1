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

public class GetSupplierPickupLocationTest extends TestBase {
	private static final Logger LOG = LoggerFactory.getLogger(GetSupplierPickupLocationTest.class); 
	public static final String SERVICE_NAME = "getSupplierPickupLocation"; 
	@Test (enabled=true, dataProviderClass=TestDataProvider.class, dataProvider="TestDataGenerator",groups = {"negative","regression"},description = "GetSupplierPickupLocationTest with invalid http method")
    @TestRun (serviceGroup = ServiceGroup.SUPPLIER,  serviceName = GetSupplierPickupLocationTest.SERVICE_NAME,testName="getSupplierPickupLocation",testGroup="p0") 
	public void invalid_httpMethod_test(HashMap <String, String> data) {
		WebService rest = Ws.post(ServiceGroup.SUPPLIER, GetSupplierOfficeTest.SERVICE_NAME, TestBase.ENV, data);
		LOG.info("Status:" + rest.getStatus());
		Assert.assertEquals(rest.getStatus(), 412, "The expected status is "+412+". But actual is "+rest.getStatus()+".");
		LOG.info("\n" + rest.getResponse().body().prettyPeek());
	}
}