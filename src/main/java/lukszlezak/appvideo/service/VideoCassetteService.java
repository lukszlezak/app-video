package lukszlezak.appvideo.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import lukszlezak.appvideo.dao.VideoCassetteRepo;
import lukszlezak.appvideo.dao.entity.VideoCassette;

@Service
public class VideoCassetteService {
	private VideoCassetteRepo videoCassetteRepo;

	@Autowired
	public VideoCassetteService(VideoCassetteRepo videoCassetteRepo) {
		this.videoCassetteRepo = videoCassetteRepo;
	}
	
	public Optional<VideoCassette> findById(Long id) {
		return videoCassetteRepo.findById(id);
	}
	
	public Iterable<VideoCassette> findAll() {
		return videoCassetteRepo.findAll();
	}
	
	public VideoCassette save(VideoCassette videoCassette) {
		return videoCassetteRepo.save(videoCassette);
	}
	
	public void deleteById(Long id) {
		videoCassetteRepo.deleteById(id);
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void fillDB() {
		save(new VideoCassette(1L, "Titanic", LocalDate.of(1995, 1, 1)));
		save(new VideoCassette(2L, "Pulp Fiction", LocalDate.of(1990, 2, 2)));
	}
}
