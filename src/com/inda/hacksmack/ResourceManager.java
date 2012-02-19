/**
 * 
 */
package com.inda.hacksmack;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.tiled.TiledMap;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Handles resources that are loaded from external sources. 
 */
public class ResourceManager {
	  private static final String resourceFolder = "src/content/";
	  private static ResourceManager _instance;
	  static {  try {  _instance = new ResourceManager(); } catch (SlickException e) { throw new RuntimeException("Failed to load resources." + e.getMessage());}}
	  private HashMap<String, Image> imageMap;
	  private HashMap<String, Sound> soundMap;
	  private HashMap<String, SpriteSheet> tilesetMap;
	  
	  
	  private ResourceManager() throws SlickException {
		  	imageMap = new HashMap<String, Image>();
		  	soundMap = new HashMap<String, Sound>();
		  	tilesetMap = new HashMap<String, SpriteSheet>();
		  	
		  	InputStream is;
		  	try{
		  		File file = new File(resourceFolder + "content.xml");
		  		is = new FileInputStream(file);
		  	} catch(IOException e){
		  		throw new SlickException("Cannot open resourcefile.", e);
		  	}
		  	
		  	loadResources(is);
	  }
	 
	  
	  
	  public final static ResourceManager getInstance(){
	     return _instance;
	  }
	  
	  
	  private void loadResources(InputStream is) throws SlickException {
		  
		  
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder docBuilder = null;
			try {
				docBuilder = docBuilderFactory.newDocumentBuilder();
			} catch (ParserConfigurationException e) {
				throw new SlickException("Could not load resources", e);
			}
			Document doc = null;
	        try {
				doc = docBuilder.parse (is);
			} catch (SAXException e) {
				throw new SlickException("Could not load resources", e);
			} catch (IOException e) {
				throw new SlickException("Could not load resources", e);
			}
	        doc.getDocumentElement ().normalize ();
	        
	        NodeList listResources = doc.getElementsByTagName("content");
	        
	        int totalResources = listResources.getLength();
	        
	 
	        for(int resourceIdx = 0; resourceIdx < totalResources; resourceIdx++){
	 
	        	Node resourceNode = listResources.item(resourceIdx);
	 
	        	if(resourceNode.getNodeType() == Node.ELEMENT_NODE){
	        		
	        		Element resourceElement = (Element)resourceNode;
	 
	        		String type = resourceElement.getAttribute("type");
	 
	        		if(type.equals("image")){
	        			
	        			addToImageMap(resourceElement.getAttribute("id"), resourceElement.getTextContent());
	        			
	        		}else if(type.equals("sound")){
	        			
	        			addToSoundMap(resourceElement.getAttribute("id"), resourceElement.getTextContent());
	        		}else if(type.equals("tileset")){
	        			
	        			addToTilesetMap(resourceElement.getAttribute("id"), resourceElement.getTextContent());
	        		}   else {
	        			
	        			throw new SlickException("Invalid resource type, type: " + type);
	        			
	        		}
	        	}
	        }
	  }
	  
	  
	  private void addToTilesetMap(String id, String path) throws SlickException {
		  if(id == null || path == null)
			  throw new SlickException("Image load failed. id:" +id + " path: "+ path);
		  SpriteSheet tileset;
		  try{
			  
			  tileset = new SpriteSheet(new Image(resourceFolder + path), 32, 32); // dirty image load but what the heck
		  } catch (SlickException e){
			  throw new SlickException("Tileset file doesnt exist. id: " + id + " path: "+ path, e);
		  }
		  
		  this.tilesetMap.put(id, tileset);
	}



	private void addToImageMap(String id, String path) throws SlickException{
		  if(id == null || path == null)
			  throw new SlickException("Image load failed. id:" +id + " path: "+ path);
		  Image image;
		  try{
			image = new Image(resourceFolder + path);
		  } catch (SlickException e){
			  throw new SlickException("Image file doesnt exist. id: " + id + " path: "+ path, e);
		  }
		  
		  this.imageMap.put(id, image);
		  
	  }
	  
	  private void addToSoundMap(String id, String path) throws SlickException{
		  if(id == null || path == null)
			  throw new SlickException("Sound load failed. id:" +id + " path: "+ path);

		  Sound sound;
		  try{
			sound = new Sound(resourceFolder + path);
		  } catch (SlickException e){
			  throw new SlickException("Sound file doesnt exist. id: " + id + " path: "+ path, e);
		  }
		  this.soundMap.put(id, sound);
	  }
	  
	  public Image getImage(String id){
		  return imageMap.get(id);
	  }
	  
	  public Sound getSound(String id){
		  return soundMap.get(id);
	  }



	public SpriteSheet getTileset(String string) {
		if(!tilesetMap.containsKey(string)){
			throw new RuntimeException("Tried to load a tileset that doesnt exist: " + string);
		}
		return tilesetMap.get(string);
	}



	/**
	 * TODO: Not cached
	 */
	public TiledMap getTiledMap(String id) {
		try {
			return new TiledMap(new FileInputStream("src/content/maps/test.tmx"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new RuntimeException("Could not load tiled map: " + id);
	}
  
}