package com.mspl.dpd.util;

import com.mspl.dpd.bo.service.ToolService;
import com.mspl.dto.ToolDTO;
import com.mspl.support.ConstantProperties;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class ToolsToExcelConverterTest implements ConstantProperties {

    @Mock
    private ToolsToExcelConverter converter;
    @Mock private ToolService service;
    private ByteArrayOutputStream outStream;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        outStream = new ByteArrayOutputStream();
        converter = new ToolsToExcelConverter(service);
    }

    @Test
    public void checkExcelSheetHeaderContent() throws Exception {
        when(service.listAllTools()).thenReturn(hardCodedData());
        XSSFRow toolsHeaderRow = getToolsExcelRow(4);
        assertThat(toolsHeaderRow.getCell(0).getStringCellValue(), CoreMatchers.equalTo("S.No"));
        assertThat(toolsHeaderRow.getCell(1).getStringCellValue(), CoreMatchers.equalTo("Tooling No"));
        assertThat(toolsHeaderRow.getCell(2).getStringCellValue(), CoreMatchers.equalTo("Product Group"));
        assertThat(toolsHeaderRow.getCell(3).getStringCellValue(), CoreMatchers.equalTo("Tooling Name"));
        assertThat(toolsHeaderRow.getCell(4).getStringCellValue(), CoreMatchers.equalTo("PATTERN/  TOOLING / DIE MATERIAL"));
        assertThat(toolsHeaderRow.getCell(5).getStringCellValue(), CoreMatchers.equalTo("# of Cavity "));
        assertThat(toolsHeaderRow.getCell(6).getStringCellValue(), CoreMatchers.equalTo("Qty"));
        assertThat(toolsHeaderRow.getCell(7).getStringCellValue(), CoreMatchers.equalTo("CORE BOX MATERIAL"));
        assertThat(toolsHeaderRow.getCell(8).getStringCellValue(), CoreMatchers.equalTo("# of Cavity "));
        assertThat(toolsHeaderRow.getCell(9).getStringCellValue(), CoreMatchers.equalTo("Qty"));
        assertThat(toolsHeaderRow.getCell(10).getStringCellValue(), CoreMatchers.equalTo("Match Plate / Base Plate Material"));
        assertThat(toolsHeaderRow.getCell(11).getStringCellValue(), CoreMatchers.equalTo("Qty"));
        assertThat(toolsHeaderRow.getCell(12).getStringCellValue(), CoreMatchers.equalTo("Available At"));
        assertThat(toolsHeaderRow.getCell(13).getStringCellValue(), CoreMatchers.equalTo("Tooling Cost"));
    }

    @Test
    public void checkExcelSheetSingleRecordRowContent() throws IOException, InvalidFormatException {
        when(service.listAllTools()).thenReturn(hardCodedData());
        XSSFRow toolsRecordRow = getToolsExcelRow(5);
        assertThat((int) toolsRecordRow.getCell(0).getNumericCellValue(), CoreMatchers.equalTo(1));
        assertThat(toolsRecordRow.getCell(1).getStringCellValue(), CoreMatchers.equalTo("DN-100"));
        assertThat(toolsRecordRow.getCell(2).getStringCellValue(), CoreMatchers.equalTo("RGSV"));
        assertThat(toolsRecordRow.getCell(3).getStringCellValue(), CoreMatchers.equalTo("Tool Name"));
        assertThat(toolsRecordRow.getCell(4).getStringCellValue(), CoreMatchers.equalTo("ALU"));
        assertThat((int)toolsRecordRow.getCell(5).getNumericCellValue(), CoreMatchers.equalTo(2));
        assertThat((int)toolsRecordRow.getCell(6).getNumericCellValue(), CoreMatchers.equalTo(5));
        assertThat(toolsRecordRow.getCell(7).getStringCellValue(), CoreMatchers.equalTo("IRON"));
        assertThat((int)toolsRecordRow.getCell(8).getNumericCellValue(), CoreMatchers.equalTo(2));
        assertThat((int)toolsRecordRow.getCell(9).getNumericCellValue(), CoreMatchers.equalTo(0));
        assertThat(toolsRecordRow.getCell(10).getStringCellValue(), CoreMatchers.equalTo("WOOD"));
        assertThat((int)toolsRecordRow.getCell(11).getNumericCellValue(), CoreMatchers.equalTo(1));
        assertThat(toolsRecordRow.getCell(12).getStringCellValue(), CoreMatchers.equalTo("AMEX"));
        assertThat((double)toolsRecordRow.getCell(13).getNumericCellValue(), CoreMatchers.equalTo(20000.00));
    }

    private List<ToolDTO> hardCodedData() {
        ArrayList<ToolDTO> dtos = new ArrayList<ToolDTO>(1);
        ToolDTO dto = new ToolDTO();
        dto.setSerialNo(1);
        dto.setToolNumber("DN-100");
        dto.setProductGroup("RGSV");
        dto.setToolName("Tool Name");
        dto.setPatternMaterial("ALU");
        dto.setPatternCavity(2);
        dto.setPatternQuantity(5);
        dto.setCbMaterial("IRON");
        dto.setCbCavity(2);
        dto.setCbQuantity(0);
        dto.setPlateMaterial("WOOD");
        dto.setPlateQuantity(1);
        dto.setVendor("AMEX");
        dto.setToolingCost(20000.00);
        dtos.add(dto);
        return dtos;
    }

    private XSSFRow getToolsExcelRow(int rowIndex) throws IOException, InvalidFormatException {
        converter.convertRecordsToExcel(outStream);
        Workbook workbook = new XSSFWorkbook(new ByteArrayInputStream(outStream.toByteArray()));
        XSSFSheet sheet = (XSSFSheet) workbook.getSheet(TOOLS_EXCEL_TEMPLATE_NAME);
        return sheet.getRow(rowIndex);
    }
}