package secondary.customerService;

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

public class UpdateCustomerSiteByIdNegative extends TestBase {
    private static final Logger LOG = LoggerFactory.getLogger(UpdateCustomerSiteByIdNegative.class);
    public static final String SERVICE_NAME = "updateCustomerSiteById";

    //Pass mandate fields as empty to update Customer Site
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator", groups = {"negative","regression"}, description = "Pass mandate fields as empty to update Customer Site")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = UpdateCustomerSiteByIdNegative.SERVICE_NAME, testName = "updateCustomerSiteWithMandateFieldEmpty", testGroup = "p1",
    attributeName = "customerAliasId",dataConstraint = DataConstraint.FOR_SPECIFIED,dataType = DataType.NULL)
    public void updateCustomerSiteWithMandateFieldEmptyTest(HashMap<String, String> data) {
        LOG.info(new Gson().newBuilder().setPrettyPrinting().create().toJson(data));
        WebService rest = Ws.put(ServiceGroup.CUSTOMER,UpdateCustomerSiteByIdNegative.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
    }

    //Pass mandate fields with invalid datatype to update Customer Site
    @Test(enabled = true, dataProviderClass = TestDataProvider.class, dataProvider = "TestDataGenerator", groups = {"negative","regression"}, description = "Pass mandate fields with invalid datatype to update Customer office")
    @Annotation.TestRun(serviceGroup = ServiceGroup.CUSTOMER, serviceName = UpdateCustomerSiteByIdNegative.SERVICE_NAME, testName = "updateCustomerSiteWithMandateFieldInvalidDatatype", testGroup = "p1")
    public void updateCustomerSiteWithMandateFieldInvalidDatatypeTest(HashMap<String, String> data) {
        LOG.info(new Gson().newBuilder().setPrettyPrinting().create().toJson(data));
        WebService rest = Ws.put(ServiceGroup.CUSTOMER,UpdateCustomerSiteByIdNegative.SERVICE_NAME, TestBase.ENV, data);
        LOG.info("API Before Parameterize:" + rest.getSession().getAPI());
        LOG.info("API After Parameterize:" + rest.getParameterize(rest.getSession().getAPI(), rest.getTestData()));
        Assert.assertEquals(rest.getStatus(), 400, "The expected status is " + 400 + ". But actual is " + rest.getStatus() + ".");
    }
}