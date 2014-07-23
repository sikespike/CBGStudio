/**
 * 
 */
package com.cbg.studio.client.engine;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;


/**
 * @author Steffen Schfer
 * 
 */
public interface EngineResources extends ClientBundle {

	/** The instance of the Resources ClientBundle. */
	public static EngineResources INSTANCE = GWT.create(EngineResources.class);
	
	/**
	 * The fragment shader to use in the example.
	 * 
	 * @return the source of the fragment shader.
	 */
	@Source(value = { "fragment-shader.shader" })
	TextResource getFragmentShader();

	/**
	 * The vertex shader to use in the example.
	 * 
	 * @return the source of the vertex shader.
	 */
	@Source(value = { "vertex-shader.shader" })
	TextResource getVertexShader();

	/**
	 * The texture to use in the example.
	 * 
	 * @return the image to use as texture.
	 */
	// @Source(value = { "texture.png" })
	// ImageResource texture();

}