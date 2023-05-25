package org.java.demo.controller;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.java.demo.pojo.Movie;
import org.java.demo.pojo.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

	@GetMapping("/")
	public String getHome(Model model) {
		
		model.addAttribute("name", "Guybrush");
		
		return "index";
	}
	
	@GetMapping("/movies")
	public String getMovies(Model model) {
		
//		String mts = "";
//		for (Movie m : getBestMovie()) {
//			
//			mts += m.getTitle() + ", ";
//		}
//		mts = mts.substring(0, mts.length() - 2);
		
		String mts = "";
		Iterator<Movie> it = getBestMovie().iterator();
		while(it.hasNext()) {
			
			mts += it.next().getTitle();
			
			if (it.hasNext())
				mts += ", ";
		}
		
		model.addAttribute("titles", mts);
		
		return "titles";
	}
	
	@GetMapping("/songs")
	public String getSongs(Model model) {
		
		String sts = "";
		Iterator<Song> it = getBestSong().iterator();
		while(it.hasNext()) {
			
			sts += it.next().getTitle();
			
			if (it.hasNext()) 
				sts += ", ";
		}
		model.addAttribute("titles", sts);
		
		return "titles";
	}
	
	@GetMapping("/movies/{id}")
	public String getMovie(Model model, @PathVariable("id") int id) {

		String resT = null;
		for (Movie m : getBestMovie()) 
			if (m.getId() == id) 
				resT = m.getTitle();
		
		if (resT != null)
			model.addAttribute("titles", resT);
		else 
			model.addAttribute("titles", "no movie found");
		
//		Movie resM = null;
//		for (Movie m : getBestMovie())
//			if (m.getId() == id)
//				resM = m;
//		
//		if (resM != null)
//			model.addAttribute("titles", resM.getTitle());
//		else 
//			model.addAttribute("titles", "no movie found");
		
		return "titles";
	}
	
	@GetMapping("/songs/{id}")
	public String getSong(Model model, @PathVariable("id") int id) {
		
		Song resS = null;
		for (Song s : getBestSong())
			if (s.getId() == id)
				resS = s;
		
		if (resS != null)
			model.addAttribute("titles", resS.getTitle());
		
		return "titles";
	}
	
	private List<Movie> getBestMovie() {
		
		return Arrays.asList(new Movie[] {
				new Movie(1, "movie 1"),
				new Movie(2, "movie 2"),
				new Movie(3, "movie 3"),
				new Movie(4, "movie 4"),
				new Movie(5, "mio titolo 5")
		});
	}
	private List<Song> getBestSong() {
		
		return Arrays.asList(new Song[] {
				new Song(1, "song 1"),
				new Song(2, "song 2"),
				new Song(3, "song 3"),
				new Song(4, "song 4"),
				new Song(5, "song 5")
		});
	}
}
