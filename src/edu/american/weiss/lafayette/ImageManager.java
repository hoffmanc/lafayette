package edu.american.weiss.lafayette;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.ByteArrayInputStream;
import java.io.RandomAccessFile;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

public class ImageManager {

	private static ImageManager instance;
	private Map<String, Image> cache;
	private Toolkit tk;
	
	static {
		instance = new ImageManager();
	}
	
	private ImageManager() {
		cache = new HashMap<String, Image>();
		tk = Toolkit.getDefaultToolkit();
	}
	
	public static ImageManager getInstance() {
		return instance;
	}
	
	public Object get(String id) {
		if (cache.containsKey(id)) {
			return cache.get(id);
		}
		return null;
	}
	
	public Image getImage(String id) {
		return (Image) get(id);
	}
	
	public Collection<Image> getImages() {
		return cache.values();
	}
	
	public void loadImage(String id, String path) {
		Image img = tk.getImage(path);
		if (img != null) {
			cache.put(id, img);
		}
	}
	
}
