package app.services.interfaces;

import java.util.List;
import app.dto.CreateIntensityDTO;
import app.dto.IntensityDTO;

public interface IIntensityService {

	public List<IntensityDTO> getAllIntensities();
	public IntensityDTO findIntensityById(Integer id);
	public IntensityDTO createIntensity(CreateIntensityDTO newIntensity);
	public IntensityDTO updateIntensity(IntensityDTO intensityToUpdate);
	public void delete(Integer id);
}
