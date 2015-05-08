package com.mspl.dpd.bo.impl;

import com.mspl.dpd.dao.repository.ToolRepository;
import com.mspl.dpd.entity.ToolMasterEntity;
import com.mspl.dpd.entity.ToolsVendorMapEntity;
import com.mspl.dto.ToolDTO;
import junit.framework.Assert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class ToolServiceImplTest {

    public static final String TOOL_NAME = "tool_name";
    private ToolServiceImpl service;
    @Mock private ToolRepository mockRepository;
    private ArrayList<ToolMasterEntity> listWithOneEntity;
    private ToolMasterEntity entity;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        service = new ToolServiceImpl(mockRepository);
        entity = prepareEntity();
        listWithOneEntity = new ArrayList<ToolMasterEntity>(1);
        listWithOneEntity.add(entity);
    }

    private ToolMasterEntity prepareEntity() {
        ToolMasterEntity entity = new ToolMasterEntity();
        entity.setCbCavity(2);
        entity.setToolName(TOOL_NAME);
        entity.setToolsVendorMapEntity(new ArrayList<ToolsVendorMapEntity>(1));
        return entity;
    }

    @Test
    public void testListAllTools_whenRepositoryReturnsNoEntities_shouldReturnAnEmptyDtoList() throws Exception {
        when(mockRepository.listAllTools()).thenReturn(new ArrayList<ToolMasterEntity>());
        List<ToolDTO> dtoList = service.listAllTools();
        assertNotNull(dtoList);
        assertThat(dtoList.size(), equalTo(0));
    }

    @Test
    public void testListAllTools_whenRepositoryReturnsAndEntity_dtoWithSameValuesShouldBeReturned() throws Exception {
        when(mockRepository.listAllTools()).thenReturn(listWithOneEntity);
        List<ToolDTO> dtoList = service.listAllTools();
        assertNotNull(dtoList);
        assertThat(dtoList.size(), equalTo(1));
        ToolDTO dto = dtoList.get(0);
        assertThat(dto.getCbCavity(), equalTo(2));
        assertThat(dto.getToolName(), equalTo(TOOL_NAME));
    }
}