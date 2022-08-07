package primary.dashboard;

import com.google.gson.Gson;
import com.im.service.common.Annotation;
import com.im.service.common.ServiceGroup;
import com.im.service.rest.WebService;
import com.im.service.util.dataprovider.TestDataProvider;
import com.im.service.util.ws.Ws;
import common.TestBase;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.hamcrest.MatcherAssert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import primary.customerService.CreateCustomer;
import primary.quotation.CreateQuotationTest;

import java.io.File;
import java.util.HashMap;

public class CreateDealTest extends TestBase {
    private static final Logger LOG = LoggerFactory.getLogger(CreateDealTest.class);
    public static final String SERVICE_NAME = "createDeal";
    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator")
    @Annotation.TestRun(serviceGroup = ServiceGroup.DASHBOARD,  serviceName = CreateDealTest.SERVICE_NAME, testName="valid_deal_data", testGroup="p0")
    public void createDealTest (HashMap<String, String> data) throws Exception {

        LOG.info(new Gson().newBuilder().setPrettyPrinting().create().toJson(data));
        WebService rest = Ws.post(ServiceGroup.DASHBOARD, CreateDealTest.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("Status:" + rest.getStatus());
        MatcherAssert.assertThat(rest.getResponse().body().asString(), JsonSchemaValidator.matchesJsonSchema(new File(rest.getSession().getSchemaFile())));
        Assert.assertEquals(rest.getStatus(), 200, "The expected status is "+200+". But actual is "+rest.getStatus()+".");
        Assert.assertTrue(rest.getResponse().body().jsonPath().getBoolean("success") , "Deal created");
        LOG.info(rest.getResponse().asString());


    }
}
