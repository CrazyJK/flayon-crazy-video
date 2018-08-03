package jk.kamoru.flayon.crazy.video;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.io.FilenameUtils;

public class VideoUtils {

	private static final String ALLOWED_SUFFIX = VIDEO.VIDEO_SUFFIX + VIDEO.COVER_SUFFIX + VIDEO.SUBTITLES_SUFFIX;
	
	public static List<File> listFiles(String[] paths) throws IOException {
		List<File> found = new ArrayList<>();
		
		for (String path : paths) {
			Files.walkFileTree(Paths.get(path), new SimpleFileVisitor<Path>() {

				@Override
			    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
			        Objects.requireNonNull(file);
			        Objects.requireNonNull(attrs);

			        if (attrs.isRegularFile()) {
			        	String suffix = FilenameUtils.getExtension(file.toFile().getName());
			        	if (ALLOWED_SUFFIX.contains(suffix)) {
			        		found.add(file.toFile());
			        	}
			        }
			        
			        return FileVisitResult.CONTINUE;
			    }

			});
		}
		return found;
	}

}
