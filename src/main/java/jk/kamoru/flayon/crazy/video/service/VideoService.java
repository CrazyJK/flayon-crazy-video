package jk.kamoru.flayon.crazy.video.service;

import java.util.List;

import jk.kamoru.flayon.crazy.video.domain.Search;
import jk.kamoru.flayon.crazy.video.domain.Tag;
import jk.kamoru.flayon.crazy.video.domain.Video;
import jk.kamoru.flayon.crazy.video.domain.Video.Actress;
import jk.kamoru.flayon.crazy.video.domain.Video.Studio;

/**
 * Service list<br>
 * 
 * <ol>
 * Video
 * <li> video list at specific limited
 * <li> a video detail info
 * <li> patch video info
 * </ol>
 * 
 * <ol>
 * Studio
 * <li> all studio list
 * <li> a studio detail info
 * <li> patch studio info
 * </ol>
 *  
 * <ol>
 * Actress
 * <li> all actress list
 * <li> a actress detail info
 * <li> patch actress info
 * </ol>
 *  
 * <ol>
 * Tag
 * <li> all tag list
 * <li> a tag detail list
 * <li> patch tag info
 * </ol>
 *  
 */
public interface VideoService {

	List<Video> videoList(Search search);
	
	Video video(String opus);
	
	List<Studio> studioList(Search search);
	
	Studio studio(String name);
	
	List<Actress> actressList(Search search);
	
	Actress actress(String name);
	
	List<Tag> tagList(Search search);
	
	Tag tag(String name);
	
	void patch(Video video);
	
	void patch(Studio studio);
	
	void patch(Actress actress);

	void patch(Tag tag);
	
}
