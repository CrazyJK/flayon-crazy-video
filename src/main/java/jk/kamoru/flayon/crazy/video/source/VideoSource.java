package jk.kamoru.flayon.crazy.video.source;

import java.util.Collection;

import jk.kamoru.flayon.crazy.video.domain.Video;
import jk.kamoru.flayon.crazy.video.domain.Video.Actress;
import jk.kamoru.flayon.crazy.video.domain.Video.Studio;

public interface VideoSource {

	Collection<Video> listVideo();
	
	Collection<Studio> listStudio();
	
	Collection<Actress> listActress();

}
