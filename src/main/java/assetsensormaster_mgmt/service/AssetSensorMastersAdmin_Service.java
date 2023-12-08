package assetsensormaster_mgmt.service;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import assetsensormaster_mgmt.model.dto.AssetSensorMaster_DTO;
import assetsensormaster_mgmt.model.master.AssetSensorMaster;
import assetsensormaster_mgmt.model.repo.AssetSensorMastersAdmin_Repo;

@Service("assetSensorMastersAdminServ")
public class AssetSensorMastersAdmin_Service implements I_AssetSensorMastersAdmin_Service
{
	@Autowired
	public AssetSensorMastersAdmin_Repo assetSensorMastersAdminRepo;

	// private static final Logger logger =
	// LoggerFactory.getLogger(CostCalcServ.class);

	public AssetSensorMaster_DTO newAssetSensor(AssetSensorMaster_DTO lMasters) {
		AssetSensorMaster AssetSensorMaster = assetSensorMastersAdminRepo.save(this.setAssetSensor(lMasters));
		lMasters = getAssetSensorMaster_DTO(AssetSensorMaster);
		return lMasters;
	}

	public ArrayList<AssetSensorMaster_DTO> getAllAssetSensors() {
		ArrayList<AssetSensorMaster> assetSensorList = (ArrayList<AssetSensorMaster>) assetSensorMastersAdminRepo.findAll();
		ArrayList<AssetSensorMaster_DTO> lMasterss = assetSensorList != null ? this.getAssetSensorMaster_DTOs(assetSensorList) : null;
		return lMasterss;
	}

	public ArrayList<AssetSensorMaster_DTO> getSelectAssetSensors(ArrayList<Long> ids) {
		ArrayList<AssetSensorMaster> lMasters = (ArrayList<AssetSensorMaster>) assetSensorMastersAdminRepo.findAllById(ids);
		ArrayList<AssetSensorMaster_DTO> assetSensorMaster_DTOs = lMasters != null ? this.getAssetSensorMaster_DTOs(lMasters) : null;
		return assetSensorMaster_DTOs;
	}
	
	public void updAssetSensor(AssetSensorMaster_DTO lMaster) 
	{
		AssetSensorMaster assetSensorMaster = this.setAssetSensor(lMaster);
		
		if (assetSensorMastersAdminRepo.existsById(lMaster.getSensorAssetSeqNo())) 
		{
			assetSensorMastersAdminRepo.save(assetSensorMaster);
		}
		return;
	}

	public void delAllAssetSensors() {
		assetSensorMastersAdminRepo.deleteAll();
	}

	public void delSelectAssetSensors(ArrayList<Long> assetSensorMasterPKs)
	{
		if (assetSensorMasterPKs != null) {
			assetSensorMastersAdminRepo.deleteAllById(assetSensorMasterPKs);
		}
	}

	private ArrayList<AssetSensorMaster_DTO> getAssetSensorMaster_DTOs(ArrayList<AssetSensorMaster> lMasters) {
		AssetSensorMaster_DTO lDTO = null;
		ArrayList<AssetSensorMaster_DTO> lMasterDTOs = new ArrayList<AssetSensorMaster_DTO>();
		for (int i = 0; i < lMasters.size(); i++) {
			lDTO = getAssetSensorMaster_DTO(lMasters.get(i));
			lMasterDTOs.add(lDTO);
		}
		return lMasterDTOs;
	}

	private AssetSensorMaster_DTO getAssetSensorMaster_DTO(AssetSensorMaster lMaster) 
	{
		AssetSensorMaster_DTO lDTO = new AssetSensorMaster_DTO();
		lDTO.setSensorAssetSeqNo(lMaster.getSensorAssetSeqNo());
		lDTO.setAssetSeqNo(lMaster.getAssetSeqNo());
		lDTO.setLocationSeqNo(lMaster.getSensorLocationSeqNo());
		lDTO.setSensorLocationSeqNo(lMaster.getSensorLocationSeqNo());
		lDTO.setResourceSeqNo(lMaster.getResourceSeqNo());
		lDTO.setSensorResourceSeqNo(lMaster.getSensorResourceSeqNo());
		return lDTO;
	}

	private AssetSensorMaster setAssetSensor(AssetSensorMaster_DTO lDTO) {
		AssetSensorMaster lMaster = new AssetSensorMaster();		 
		lMaster.setAssetSeqNo(lDTO.getAssetSeqNo());
		lMaster.setLocationSeqNo(lDTO.getLocationSeqNo());
		lMaster.setSensorLocationSeqNo(lDTO.getSensorLocationSeqNo());
		lMaster.setResourceSeqNo(lDTO.getResourceSeqNo());
		lMaster.setSensorResourceSeqNo(lDTO.getSensorResourceSeqNo());
		return lMaster;
	}

}
