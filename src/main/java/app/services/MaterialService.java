package app.services;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dto.CreateMaterialDTO;
import app.dto.IntensityDTO;
import app.dto.LevelDTO;
import app.dto.MaterialDTO;
import app.jpa.Intensity;
import app.jpa.Level;
import app.jpa.Material;
import app.repository.MaterialRepository;
import app.services.interfaces.IMaterialService;

@Service
public class MaterialService implements IMaterialService {
	
	@Autowired
	MaterialRepository materialRepository;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public List<MaterialDTO> getAllMaterials() {
		List<Material> materials = this.materialRepository.findAll();
		List<MaterialDTO> dtos = new ArrayList<MaterialDTO>();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		for(Material material : materials) {
			dtos.add(this.modelMapper.map(material, MaterialDTO.class));
        }
		return dtos;
	}

	@Override
	public MaterialDTO findMaterialById(Integer id) {
		Material material = this.materialRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Material with that ID does not exist!"));
        return this.modelMapper.map(material, MaterialDTO.class);
	}

	@Override
	public MaterialDTO createMaterial(CreateMaterialDTO newMaterial) {
		Material material = new Material();
		material.setAuthorName(newMaterial.getAuthorName());
		material.setAuthorSurname(newMaterial.getAuthorSurname());
		material.setDate(newMaterial.getDate());
		material.setPublisher(newMaterial.getPublisher());
		material.setPublisherCity(newMaterial.getPublisherCity());
		
		material = this.materialRepository.save(material);
		return this.modelMapper.map(material, MaterialDTO.class); 
	}

	@Override
	public MaterialDTO updateMaterial(MaterialDTO materialToUpdate) {
		Material material = this.materialRepository.findById(materialToUpdate.getId()).orElseThrow(() -> new EntityNotFoundException("Material with that ID does not exist!"));
		material = this.modelMapper.map(materialToUpdate, Material.class);

		material = this.materialRepository.save(material);

        return this.modelMapper.map(materialToUpdate, MaterialDTO.class);
	}

	@Override
	public void delete(Integer id) {
		this.materialRepository.deleteById(id);				
		
	}

}
