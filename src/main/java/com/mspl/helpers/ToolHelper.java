package com.mspl.helpers;

import com.mspl.dpd.entity.ToolMasterEntity;
import com.mspl.dpd.persistance.EntityPersistanceImpl;
import com.mspl.dto.ToolDTO;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;
import org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean;

import javax.persistence.EntityManager;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by naveen.krishnan on 23-07-2014.
 */
public class ToolHelper {

    public static List<ToolDTO> getToolsFromDB ( ) {

        return convertJsonToObject ( ) ;

    }

    public static ToolDTO getToolFromDB ( ) {

        ToolDTO toolDTO = new ToolDTO ( ) ;
        return toolDTO ;

    }

    private static List convertJsonToObject ( ) {
        ObjectMapper mapper = new ObjectMapper();
        List<ToolDTO> toolResponceDTO = new ArrayList<ToolDTO>() ;
        try {
            //toolDTO = mapper.readValue(new File("C:\\dev\\bootcamp\\docs\\tools.json"), ToolDTO.class);
           /* File jsonFile = new File ( "C:\\Users\\r.ramprakash\\json\\tools.json" ) ;
            list = mapper.readValue ( jsonFile ,
                    TypeFactory.defaultInstance().constructCollectionType(List.class,
                            ToolDTO.class));*/

        EntityManager em = EntityPersistanceImpl.getToolingEntityManager();
            em.getTransaction().begin();
            List toolEntityList = em.createQuery("FROM ToolMasterEntity tm").getResultList();
            for (int index = 0 ; index < toolEntityList.size() ; index++){
                ToolMasterEntity toolMasterEntity = (ToolMasterEntity) toolEntityList.get(index);
                ToolDTO toolDTO = new ToolDTO ( ) ;
                //toolDTO.setToolId(toolMasterEntity.getToolNumber());
                toolDTO.setToolName(toolMasterEntity.getToolName());
                toolDTO.setPatternMaterial(toolMasterEntity.getPtdMaterial());
                toolDTO.setPatternCavity(toolMasterEntity.getPtdCavity());
                toolDTO.setPatternQuantity(toolMasterEntity.getPtdQuantity());
                toolDTO.setCbMaterial(toolMasterEntity.getCbMaterial());
                toolDTO.setCbCavity(toolMasterEntity.getCbCavity());
                toolDTO.setCbQuantity(toolMasterEntity.getCbQuantity());
                toolDTO.setPlateMaterial(toolMasterEntity.getMbMaterial());
                toolDTO.setPlateCavity(toolMasterEntity.getMbCavity());
                toolDTO.setPatternQuantity(toolMasterEntity.getMbQuantity());
                toolDTO.setToolingCost(toolMasterEntity.getToolingCost());
                toolDTO.setProductGroup(toolMasterEntity.getProductGroup());
                toolResponceDTO.add(index,toolDTO);
            }

        } catch ( Exception exception ) {
            exception.printStackTrace();
        }

        return toolResponceDTO;
    }

    public static String updateVendorForTool ( String toolID, String vendorName ) {

        System.out.println ( "ToolID >>-- " + toolID + " <><><> " + "VendorName >>-- " + vendorName ) ;
        if ( true ) {
            //TODO get the toolid, vendor information and update the values into database
            //TODO Add date and time details of updation
            //TODO Once updation is success, send back the toolID which got updated
            return toolID ;
        }
        return null ;
    }

    public static void main ( String[] ar ) {

        ArrayList toolDTOs = ( ArrayList ) ToolHelper.convertJsonToObject() ;
        System.out.println ( toolDTOs.size() ) ;

    }

}