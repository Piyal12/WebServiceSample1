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

public class GetCreditInfoDataByFilterEnterpriseTest extends TestBase
{
    private static final Logger LOG = LoggerFactory.getLogger(GetCreditInfoDataByFilterEnterpriseTest.class);
    public static final String SERVICE_NAME = "creditinfofilterEnterprise";

    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator",groups = {"positive","sanity","regression"},description ="Get credit info data filter by Enterprise")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CREDIT, serviceName = GetCreditInfoDataByFilterEnterpriseTest.SERVICE_NAME, testName = "credit_info_filter_enterprise", testGroup = "p0")
    public void credit_info_filter_enterprise_test(HashMap<String, String> data) throws Exception
    {
        WebService rest = Ws.get(ServiceGroup.CREDIT, GetCreditInfoDataByFilterEnterpriseTest.SERVICE_NAME, TestBase.ENV,data);
        MatcherAssert.assertThat(rest.getResponse().body().asString(), JsonSchemaValidator.matchesJsonSchema(new File(rest.getSession().getSchemaFile())));
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        LOG.info("Status:" + rest.getStatus());
        Assert.assertEquals(rest.getStatus(), 200, "The expected status is " + 200 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertTrue(rest.getResponse().body().jsonPath().getBoolean("success"), "Getting credit filter by enterprise failed");
        LOG.info("\n" + rest.getResponse().prettyPeek());
    }
}
