package assetsensormaster_mgmt.service;

import java.util.ArrayList;
import assetsensormaster_mgmt.model.dto.AssetSensorMaster_DTO;

public interface I_AssetSensorMastersAdmin_Service
{
    public AssetSensorMaster_DTO newAssetSensor(AssetSensorMaster_DTO assetSensorMaster_DTO);
    public ArrayList<AssetSensorMaster_DTO> getAllAssetSensors();
    public ArrayList<AssetSensorMaster_DTO> getSelectAssetSensors(ArrayList<Long> aList);
    public void updAssetSensor(AssetSensorMaster_DTO assetSensorMaster_DTO);    
    public void delAllAssetSensors();
    public void delSelectAssetSensors(ArrayList<Long> aList);
  }