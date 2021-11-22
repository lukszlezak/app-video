package lukszlezak.appvideo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import lukszlezak.appvideo.dao.entity.VideoCassette;

@Repository
public interface VideoCassetteRepo extends CrudRepository<VideoCassette, Long>{

}
