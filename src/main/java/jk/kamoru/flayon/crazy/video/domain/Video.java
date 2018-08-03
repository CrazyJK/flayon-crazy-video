package jk.kamoru.flayon.crazy.video.domain;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Video {

	Studio studio;
	String opus;
	String title;
	List<Actress> actressList;
	String release;
	List<Tag> tagList;
	
	List<File> videoFiles = new ArrayList<>();
	File coverFile;
	List<File> subtitlesFiles = new ArrayList<>();
	File infoFile;
	
	public void addVideoFile(File file) {
		videoFiles.add(file);
	}
	
	public void addSubtitlesFile(File file) {
		subtitlesFiles.add(file);
	}
	
	
	@Data
	public static class Studio {
		String name;
		String company;
		String url;
	}

	@Data
	public static class Actress {
		String name;
		String localName;
		String birth;
		String height;
		String body;
		String debut;
	}

}
