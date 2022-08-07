package primary.credit;

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

import java.io.File;
import java.util.HashMap;

public class GetCustomerCreditInfoListRetailTest extends TestBase
{
    private static final Logger LOG = LoggerFactory.getLogger(GetCustomerCreditInfoListRetailTest.class);
    public static final String SERVICE_NAME = "customercreditinfolistRetail";

    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"positive","sanity","regression"},description ="Get customer credit info list for Retail")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CREDIT, serviceName = GetCustomerCreditInfoListRetailTest.SERVICE_NAME, testName = "get_credit_info_list_retail", testGroup = "p0")
    public void customer_credit_info_list_retail_test(HashMap<String, String> data) throws Exception
    {
        WebService rest = Ws.get(ServiceGroup.CREDIT, GetCustomerCreditInfoListRetailTest.SERVICE_NAME, TestBase.ENV,data);
        MatcherAssert.assertThat(rest.getResponse().body().asString(), JsonSchemaValidator.matchesJsonSchema(new File(rest.getSession().getSchemaFile())));
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("Status:" + rest.getStatus());
        Assert.assertEquals(rest.getStatus(), 200, "The expected status is " + 200 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertTrue(rest.getResponse().body().jsonPath().getBoolean("success"), "Getting Customer Credit Retail List failed");
        LOG.info("\n" + rest.getResponse().prettyPeek());
    }
}
