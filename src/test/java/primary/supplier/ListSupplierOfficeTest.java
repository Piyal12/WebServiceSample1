package primary.supplier;

import io.restassured.module.jsv.JsonSchemaValidator;
import org.hamcrest.MatcherAssert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.im.service.common.ServiceGroup;
import com.im.service.rest.WebService;
import com.im.service.util.ws.Ws;
import com.im.service.util.listener.*;

import common.TestBase;

import java.io.File;


public class ListSupplierOfficeTest extends TestBase {
	private static final Logger LOG = LoggerFactory.getLogger(ListSupplierOfficeTest.class); 
	public static final String SERVICE_NAME = "listSupplierOffice"; 
	@Test (enabled=true,groups = {"regression","sanity","positive"},description = "ListSupplierOfficeTest with all valid params")
	public void listSupplierOfficeDetailsTest() {
		WebService rest = Ws.get(ServiceGroup.SUPPLIER,ListSupplierOfficeTest.SERVICE_NAME,TestBase.ENV,TOKEN);
		LOG.info("Status:" + rest.getStatus());
		Assert.assertEquals(rest.getStatus(), 200, "The expected status is "+200+". But actual is "+rest.getStatus()+".");
		Assert.assertTrue(rest.getResponse().body().jsonPath().getBoolean("success") , "list supplier office failed");
		MatcherAssert.assertThat(rest.getResponse().body().asString(), JsonSchemaValidator.matchesJsonSchema(new File(rest.getSession().getSchemaFile())));
		LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
	}
}