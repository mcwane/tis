package com.mspl.controller;

import com.mspl.dpd.util.ToolsToExcelConverter;
import com.mspl.support.ConstantProperties;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by r.ramprakash on 8/5/2014.
 */
@RestController
@RequestMapping ( "/tools" )
public class ToolsExcelConverterController implements ConstantProperties {

    private final ToolsToExcelConverter toolsToExcelConverter;

    @Autowired
    public ToolsExcelConverterController(ToolsToExcelConverter toolsToExcelConverter ){
        this.toolsToExcelConverter = toolsToExcelConverter;
    }

    @RequestMapping(value = "/excelexport", method = RequestMethod.GET,produces ="application/vnd.ms-excel")
    public void exportToolsListToExcelSheet(HttpServletResponse response) throws IOException, InvalidFormatException {
        response.setContentType(TOOLS_EXCEL_CONTENT_TYPE);
        response.setHeader("Content-Disposition", "inline; filename=Master-List-Of-Toolings.xlsx");
        this.toolsToExcelConverter.convertRecordsToExcel(response.getOutputStream());
    }
}
