package primary.inquiry;

import com.im.service.common.Annotation;
import com.im.service.common.DataConstraint;
import com.im.service.common.DataType;
import com.im.service.common.ServiceGroup;
import com.im.service.rest.WebService;
import com.im.service.util.dataprovider.TestDataProvider;
import com.im.service.util.ws.Ws;
import common.TestBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class CreateInquiryNegative extends TestBase {
    private static final Logger LOG = LoggerFactory.getLogger(CreateInquiryNegative.class);
    public static final String SERVICE_NAME = "createInquiry";

//    @Annotation.TestData(attributeName = "repId" , value = "CREP1305")
    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator")
    @Annotation.TestRun(serviceGroup = ServiceGroup.GROUP1,  serviceName = CreateInquiryNegative.SERVICE_NAME, testName="createInquiryTest", testGroup="p0",dataType = DataType.NUMERIC, dataConstraint = DataConstraint.FOR_SPECIFIED, attributeName = "repId")
    public void createInquiryPassNumberAsRepId (HashMap<String, String> data) throws Exception
    {
        WebService rest = Ws.post(ServiceGroup.GROUP1, CreateInquiryNegative.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 500, "The expected status is " + 500 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success"), "Create Inquiry failed");
        //LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
    }

    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator")
    @Annotation.TestRun(serviceGroup = ServiceGroup.GROUP1,  serviceName = CreateInquiryNegative.SERVICE_NAME, testName="createInquiryTest", testGroup="p0",dataType = DataType.ALPHABET, dataConstraint = DataConstraint.FOR_SPECIFIED, attributeName = "repId")
    public void createInquiryPassAlphaAsRepId (HashMap<String, String> data) throws Exception
    {
        WebService rest = Ws.post(ServiceGroup.GROUP1, CreateInquiryNegative.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 500, "The expected status is " + 500 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success"), "Create Inquiry failed");
        //LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
    }

    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator")
    @Annotation.TestRun(serviceGroup = ServiceGroup.GROUP1,  serviceName = CreateInquiryNegative.SERVICE_NAME, testName="createInquiryTest", testGroup="p0",dataType = DataType.ALPHA_NUMERIC, dataConstraint = DataConstraint.FOR_SPECIFIED, attributeName = "repId")
    public void createInquiryPassAlphaNumberAsRepId (HashMap<String, String> data) throws Exception
    {
        WebService rest = Ws.post(ServiceGroup.GROUP1, CreateInquiryNegative.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 500, "The expected status is " + 500 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success"), "Create Inquiry failed");
        //LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
    }

    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator")
    @Annotation.TestRun(serviceGroup = ServiceGroup.GROUP1,  serviceName = CreateInquiryNegative.SERVICE_NAME, testName="createInquiryTest", testGroup="p0",dataType = DataType.NULL, dataConstraint = DataConstraint.ONE_BY_ONE)
    public void createInquiryPassNullValues (HashMap<String, String> data) throws Exception
    {
        WebService rest = Ws.post(ServiceGroup.GROUP1, CreateInquiryNegative.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 500, "The expected status is " + 500 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success"), "Create Inquiry failed");
        //LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
    }

    @Test(enabled=true, dataProviderClass= TestDataProvider.class, dataProvider="TestDataGenerator")
    @Annotation.TestRun(serviceGroup = ServiceGroup.GROUP1,  serviceName = CreateInquiryNegative.SERVICE_NAME, testName="createInquiryTest", testGroup="p0",dataType = DataType.UNASSIGNED, dataConstraint = DataConstraint.ONE_BY_ONE)
    public void createInquiryPassUnassignedValue (HashMap<String, String> data) throws Exception
    {
        WebService rest = Ws.post(ServiceGroup.GROUP1, CreateInquiryNegative.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 500, "The expected status is " + 500 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success"), "Create Inquiry failed");
        //LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
    }
}
