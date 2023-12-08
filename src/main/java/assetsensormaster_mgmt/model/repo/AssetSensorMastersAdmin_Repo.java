package assetsensormaster_mgmt.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import assetsensormaster_mgmt.model.master.AssetSensorMaster;

@Repository("assetSensorMastersAdminRepo")
public interface AssetSensorMastersAdmin_Repo extends JpaRepository<AssetSensorMaster, Long> 
{}