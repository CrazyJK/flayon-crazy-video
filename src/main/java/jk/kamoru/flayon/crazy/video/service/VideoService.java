package jk.kamoru.flayon.crazy.video.service;

import java.util.List;

import jk.kamoru.flayon.crazy.video.domain.Actress;
import jk.kamoru.flayon.crazy.video.domain.Search;
import jk.kamoru.flayon.crazy.video.domain.Studio;
import jk.kamoru.flayon.crazy.video.domain.Tag;
import jk.kamoru.flayon.crazy.video.domain.Video;

/**
 * <pre>
 * Service list
 * 
 *  1. video list at specific limited
 *  2. a video detail info
 *  3. all studio list
 *  4. a studio detail info
 *  5. all actress list
 *  6. a actress detail info
 *  7. all tag list
 *  8. a tag detail list
 *  9. patch video info
 * 10. patch studio info
 * 11. patch actress info
 * 12. patch tag info
 * </pre>
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
