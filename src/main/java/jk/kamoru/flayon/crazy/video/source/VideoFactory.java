package jk.kamoru.flayon.crazy.video.source;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FilenameUtils;

import jk.kamoru.flayon.crazy.video.VIDEO;
import jk.kamoru.flayon.crazy.video.domain.Video;
import jk.kamoru.flayon.crazy.video.domain.Video.Actress;
import jk.kamoru.flayon.crazy.video.domain.Video.Studio;
import lombok.Data;

public class VideoFactory {

	public static Result parse(File file) {
		
		return null;
	}

	@Data
	public static class Result {
		String studio;
		String opus;
		String title;
		List<String> actressList;
		String release;
	}

	public static Video newVideo(Result result, Studio studio, List<Actress> actressList, File file) {
		Video video = new Video();
		video.setStudio(studio);
		video.setOpus(result.opus);
		video.setTitle(result.title);
		video.setActressList(actressList);
		video.setRelease(result.release);
		
		String suffix = FilenameUtils.getExtension(file.getName());
		if (VIDEO.VIDEO_SUFFIX.contains(suffix)) {
			video.addVideoFile(file);
		} else if (VIDEO.COVER_SUFFIX.contains(suffix)) {
			video.setCoverFile(file);
		} else if (VIDEO.SUBTITLES_SUFFIX.contains(suffix)) {
			video.addSubtitlesFile(file);
		} else if (VIDEO.INFO_SUFFIX.contains(suffix)) {
			video.setInfoFile(file);
		}

		return video;
	}

	public static Studio newStudio(String name) {
		Studio studio = new Studio();
		studio.setName(name);
		return null;
	}

	public static Actress newActress(String name) {
		Actress actress = new Actress();
		actress.setName(name);
		return actress;
	}

}
