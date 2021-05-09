package app.services.interfaces;

import java.util.List;
import app.dto.CreateMaterialDTO;
import app.dto.MaterialDTO;

public interface IMaterialService {

	public List<MaterialDTO> getAllMaterials();
	public MaterialDTO findMaterialById(Integer id);
	public MaterialDTO createMaterial(CreateMaterialDTO newMaterial);
	public MaterialDTO updateMaterial(MaterialDTO materialToUpdate);
	public void delete(Integer id);
}
