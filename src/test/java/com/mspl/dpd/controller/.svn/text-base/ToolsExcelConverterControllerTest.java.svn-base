package com.mspl.dpd.controller;

import com.mspl.controller.ToolsExcelConverterController;
import com.mspl.dpd.util.ToolsToExcelConverter;
import com.mspl.support.ConstantProperties;
import junit.framework.Assert;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mock.web.MockHttpServletResponse;

import java.io.IOException;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


/**
 * Created by r.ramprakash on 8/5/2014.
 */
public class ToolsExcelConverterControllerTest implements ConstantProperties {

    @Mock
    private ToolsExcelConverterController mockToolsToExcelConverterController;

    private MockHttpServletResponse mockHttpServletResponse;

    @Mock
    private ToolsToExcelConverter mockToolsToExcelConverter;

    @Before
    public void setUp() throws Exception {
        mockHttpServletResponse = new MockHttpServletResponse();
        MockitoAnnotations.initMocks(this);
        mockToolsToExcelConverterController = new ToolsExcelConverterController(mockToolsToExcelConverter);
    }

    @Test
    public void checkExcelTemplateAvailableInClassPath() throws IOException{
        Assert.assertNotNull(new ClassPathResource(TOOLS_EXCEL_TEMPLATE_FILE).getURL());
    }

    @Test
    public void testController_expectContentTypeToBeSetAppropriately() throws IOException, InvalidFormatException {
        mockToolsToExcelConverterController.exportToolsListToExcelSheet(mockHttpServletResponse);
        assertThat(mockHttpServletResponse.getContentType(), equalTo(TOOLS_EXCEL_CONTENT_TYPE));
    }
}