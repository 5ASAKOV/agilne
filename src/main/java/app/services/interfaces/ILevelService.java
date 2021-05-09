package app.services.interfaces;

import java.util.List;
import app.dto.CreateLevelDTO;
import app.dto.LevelDTO;

public interface ILevelService {

	public List<LevelDTO> getAllLevels();
	public LevelDTO findLevelById(Integer id);
	public LevelDTO createLevel(CreateLevelDTO newLevel);
	public LevelDTO updateLevel(LevelDTO levelToUpdate);
	public void delete(Integer id);
}
