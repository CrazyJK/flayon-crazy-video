package jk.kamoru.flayon.crazy.video.source;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jk.kamoru.flayon.crazy.video.VideoException;
import jk.kamoru.flayon.crazy.video.VideoUtils;
import jk.kamoru.flayon.crazy.video.domain.Video;
import jk.kamoru.flayon.crazy.video.domain.Video.Actress;
import jk.kamoru.flayon.crazy.video.domain.Video.Studio;

public class FileBasedVideoSource implements VideoSource {

	String[] paths;
	Map<String, Video> videoMap = new HashMap<>();
	Map<String, Studio> studioMap = new HashMap<>();
	Map<String, Actress> actressMap = new HashMap<>();
	
	public FileBasedVideoSource(String...paths) {
		this.paths = paths;
	}
	
	public void load() {
		try {
			List<File> listFiles = VideoUtils.listFiles(paths);
			for (File file : listFiles) {
				VideoFactory.Result result = VideoFactory.parse(file);
				Video video = null;
				Studio studio = null;
				List<Actress> actressList = new ArrayList<>();
				
				if (studioMap.containsKey(result.studio)) {
					studio = studioMap.get(result.studio);
				} else {
					studio = VideoFactory.newStudio(result.studio);
					studioMap.put(result.studio, studio);
				}
				
				for (String actressName : result.actressList) {
					Actress actress = null;
					if (actressMap.containsKey(actressName)) {
						actress = actressMap.get(actressName);
					} else {
						actress = VideoFactory.newActress(actressName);
						actressMap.put(actressName, actress);
					}
					actressList.add(actress);
				}
				
				
				if (videoMap.containsKey(result.opus)) {
					video = videoMap.get(result.opus);
				} else {
					video = VideoFactory.newVideo(result, studio, actressList, file);
					videoMap.put(result.opus, video);
				}
				
			}
		} catch (IOException e) {
			throw new VideoException("listFiles Error", e);
		}
	}
	
	@Override
	public Collection<Video> listVideo() {
		return videoMap.values();
	}

	@Override
	public Collection<Studio> listStudio() {
		return studioMap.values();
	}

	@Override
	public Collection<Actress> listActress() {
		return actressMap.values();
	}

}
