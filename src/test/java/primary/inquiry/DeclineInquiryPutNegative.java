package primary.inquiry;

import com.google.gson.Gson;
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
/*
*/

public class DeclineInquiryPutNegative extends TestBase {
    private static final Logger LOG = LoggerFactory.getLogger(DeclineInquiryPutNegative.class);
    public static final String SERVICE_NAME = "declineInquiry";

    @Annotation.TestData(attributeName = "inquiryId",value = "")
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator")
    @Annotation.TestRun(serviceGroup = ServiceGroup.GROUP1, serviceName = DeclineInquiryPutNegative.SERVICE_NAME,dataType = DataType.NUMERIC, dataConstraint = DataConstraint.FOR_SPECIFIED, attributeName = "inquiryId")
    public void declineInquiryPassNumbers(HashMap<String, String> data) throws Exception {
        LOG.info(new Gson().newBuilder().setPrettyPrinting().create().toJson(data));
        WebService rest = Ws.put(ServiceGroup.GROUP1, DeclineInquiryPutNegative.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 404, "The expected status is " + 404 + ". But actual is " + rest.getStatus() + ".");
        //Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success"), "Decline inquiry failed");
       // LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
    }

    @Annotation.TestData(attributeName = "inquiryId",value = "")
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator")
    @Annotation.TestRun(serviceGroup = ServiceGroup.GROUP1, serviceName = DeclineInquiryPutNegative.SERVICE_NAME,dataType = DataType.NULL, dataConstraint = DataConstraint.FOR_SPECIFIED, attributeName = "inquiryId")
    public void declineInquiryPassNull(HashMap<String, String> data) throws Exception {
        LOG.info(new Gson().newBuilder().setPrettyPrinting().create().toJson(data));
        WebService rest = Ws.put(ServiceGroup.GROUP1, DeclineInquiryPutNegative.SERVICE_NAME, TestBase.ENV ,data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 404, "The expected status is " + 404 + ". But actual is " + rest.getStatus() + ".");
        //Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success"), "Decline inquiry failed");
        // LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
    }

    @Annotation.TestData(attributeName = "inquiryId",value = "")
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator")
    @Annotation.TestRun(serviceGroup = ServiceGroup.GROUP1, serviceName = DeclineInquiryPutNegative.SERVICE_NAME,dataType = DataType.ALPHA_NUMERIC, dataConstraint = DataConstraint.FOR_SPECIFIED, attributeName = "inquiryId")
    public void declineInquiryPassAlphaNumbers(HashMap<String, String> data) throws Exception {
        LOG.info(new Gson().newBuilder().setPrettyPrinting().create().toJson(data));
        WebService rest = Ws.put(ServiceGroup.GROUP1, DeclineInquiryPutNegative.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 404, "The expected status is " + 404 + ". But actual is " + rest.getStatus() + ".");
        //Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success"), "Decline inquiry failed");
        // LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
    }

    @Annotation.TestData(attributeName = "inquiryId",value = "")
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator")
    @Annotation.TestRun(serviceGroup = ServiceGroup.GROUP1, serviceName = DeclineInquiryPutNegative.SERVICE_NAME,dataType = DataType.UNASSIGNED, dataConstraint = DataConstraint.FOR_SPECIFIED, attributeName = "inquiryId")
    public void declineInquiryUnassigned(HashMap<String, String> data) throws Exception {
        LOG.info(new Gson().newBuilder().setPrettyPrinting().create().toJson(data));
        WebService rest = Ws.put(ServiceGroup.GROUP1, DeclineInquiryPutNegative.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 404, "The expected status is " + 404 + ". But actual is " + rest.getStatus() + ".");
        //Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success"), "Decline inquiry failed");
        // LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
    }
    @Annotation.TestData(attributeName = "inquiryId",value = "INQR22990")
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator")
    @Annotation.TestRun(serviceGroup = ServiceGroup.GROUP1, serviceName = DeclineInquiryPutNegative.SERVICE_NAME)
    public void declineInquiryInvalidId(HashMap<String, String> data) throws Exception {
        LOG.info(new Gson().newBuilder().setPrettyPrinting().create().toJson(data));
        WebService rest = Ws.put(ServiceGroup.GROUP1, DeclineInquiryPutNegative.SERVICE_NAME, TestBase.ENV,data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 500, "The expected status is " + 500 + ". But actual is " + rest.getStatus() + ".");
        Assert.assertFalse(rest.getResponse().body().jsonPath().getBoolean("success"), "Decline inquiry failed");
        LOG.info("\n" + rest.getResponse().jsonPath().prettyPeek());
    }


}
