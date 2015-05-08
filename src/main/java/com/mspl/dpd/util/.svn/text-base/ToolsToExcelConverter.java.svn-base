package com.mspl.dpd.util;

import com.mspl.dpd.bo.service.ToolService;
import com.mspl.dto.ToolDTO;
import com.mspl.support.ConstantProperties;
import net.sf.jxls.transformer.XLSTransformer;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by r.ramprakash on 8/1/2014.
 */

@Service
public class ToolsToExcelConverter implements ConstantProperties {

    private final ToolService toolService;

    @Autowired
    public ToolsToExcelConverter(ToolService toolService){
        this.toolService = toolService;
    }

    public void convertRecordsToExcel(OutputStream outputStream) throws IOException, InvalidFormatException {
        List<ToolDTO> allTools = this.toolService.listAllTools();
        java.util.Map toolDataMap = new HashMap();
        toolDataMap.put("tools",allTools);
        toolDataMap.put("currentDate",new Date().toString());
        InputStream srcStream = new ClassPathResource(TOOLS_EXCEL_TEMPLATE_FILE).getInputStream();
        Workbook workbook = new XLSTransformer().transformXLS(srcStream, toolDataMap);
        workbook.write(outputStream);
        outputStream.flush();
    }
}