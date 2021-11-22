package lukszlezak.appvideo.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lukszlezak.appvideo.dao.entity.VideoCassette;
import lukszlezak.appvideo.service.VideoCassetteService;

@RestController
@RequestMapping("/api/cassetts")
public class VideoCassetteApi {
	private VideoCassetteService videoCassettes;
	
	@Autowired
	public VideoCassetteApi(VideoCassetteService videoCassettes) {
		this.videoCassettes = videoCassettes;
	}
	
	@GetMapping("/all")
	public Iterable<VideoCassette> getAll() {
		return videoCassettes.findAll();
	}
	
	@GetMapping
	public Optional<VideoCassette> getById(@RequestParam Long id) {	
		return videoCassettes.findById(id);
	}
	
	@PostMapping
	public VideoCassette addVideo(@RequestBody VideoCassette videoCassette) {
		return videoCassettes.save(videoCassette);
	}
	
	@PutMapping
	public VideoCassette editVideo(@RequestBody VideoCassette videoCassette) {
		return videoCassettes.save(videoCassette);
	}
	
	@DeleteMapping
	public void deleteVideo(@RequestParam Long id) {
		videoCassettes.deleteById(id);
	}
}