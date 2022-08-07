package secondary.supplier;

import com.im.service.common.Environment;
import com.im.service.common.ServiceGroup;
import com.im.service.rest.WebService;
import com.im.service.session.Session;
import com.im.service.session.SessionProperties;
import com.im.service.util.ws.Ws;
import common.TestBase;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.hamcrest.MatcherAssert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;


public class ListSupplierPickupLocationTest extends TestBase {
	private static final Logger LOG = LoggerFactory.getLogger(ListSupplierPickupLocationTest.class);
	public static final String SERVICE_NAME = "listSupplierPickupLocation";
	@Test (enabled=true,groups = {"negative","regression"},description = "ListSupplierPickupLocationTest with invalid http method")
	public void invalid_httpMethod_test () {
		Session session = new Session(SessionProperties.newProperties(ServiceGroup.SUPPLIER).environment(Environment.DEV).serviceName(GetSupplierKycTest.SERVICE_NAME).build());
		WebService rest = new WebService(session);
		rest.post();
		LOG.info("Status:" + rest.getStatus());
		Assert.assertEquals(rest.getStatus(), 412, "The expected status is "+412+". But actual is "+rest.getStatus()+".");
		LOG.info("\n" + rest.getResponse().body().prettyPeek());
	}
}