package primary.dashboard;

import com.im.service.common.ServiceGroup;
import com.im.service.rest.WebService;
import com.im.service.util.ws.Ws;
import common.TestBase;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.hamcrest.MatcherAssert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class GetDealListTest extends TestBase {
    private static final Logger LOG = LoggerFactory.getLogger(GetDealListTest.class);


    public static final String SERVICE_NAME = "getDealList";




    //@Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator")

    // @Annotation.TestRun(serviceGroup = ServiceGroup.GROUP1,  serviceName = GetDealDetailsTest.SERVICE_NAME, testName="retailer_valid_data_test", testGroup="p0"
    @Test
    public void getDealListTest () throws Exception {

        WebService rest = Ws.get(ServiceGroup.DASHBOARD, GetDealListTest.SERVICE_NAME, TestBase.ENV);

        LOG.info("Status:" + rest.getStatus());



        MatcherAssert.assertThat(rest.getResponse().body().asString(), JsonSchemaValidator.matchesJsonSchema(new File(rest.getSession().getSchemaFile())));
        Assert.assertEquals(rest.getStatus(), 200, "The expected status is "+200+". But actual is "+rest.getStatus()+".");

        Assert.assertTrue(rest.getResponse().body().jsonPath().getBoolean("success") , "Deal List fetched");




        LOG.info(rest.getResponse().asString());

    }
}
