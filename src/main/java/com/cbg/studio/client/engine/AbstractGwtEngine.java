/**
 * 
 */
package com.cbg.studio.client.engine;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlexTable;
import com.googlecode.gwtgl.array.Float32Array;
import com.googlecode.gwtgl.binding.WebGLBuffer;
import com.googlecode.gwtgl.binding.WebGLProgram;
import com.googlecode.gwtgl.binding.WebGLRenderingContext;
import com.googlecode.gwtgl.binding.WebGLShader;

/**
 * @author Xif
 * 
 */
public abstract class AbstractGwtEngine extends FlexTable {
	protected WebGLRenderingContext glContext;
	protected WebGLProgram shaderProgram;
	protected int vertexPositionAttribute;
	protected WebGLBuffer vertexBuffer;

	/**
	 * Constructs a new instance of a GwtGL example with a launch button and a
	 * Canvas to render on.
	 */
	protected AbstractGwtEngine() {
		final Canvas webGLCanvas = Canvas.createIfSupported();
		webGLCanvas.setCoordinateSpaceHeight(500);
		webGLCanvas.setCoordinateSpaceWidth(500);
		glContext = (WebGLRenderingContext) webGLCanvas
				.getContext("experimental-webgl");
		if (glContext == null) {
			Window.alert("Sorry, Your Browser doesn't support WebGL!");
		}
		glContext.viewport(0, 0, 1024, 768);
		this.add(webGLCanvas);
	}

	public void initialize() {
		initShaders();
		glContext.clearColor(0.0f, 0.0f, 0.0f, 1.0f);
		glContext.clearDepth(1.0f);
		glContext.enable(WebGLRenderingContext.DEPTH_TEST);
		glContext.depthFunc(WebGLRenderingContext.LEQUAL);
		initBuffers();
	}

	public void initShaders() {
		WebGLShader fragmentShader = getShader(
				WebGLRenderingContext.FRAGMENT_SHADER, EngineResources.INSTANCE
						.getFragmentShader().getText());
		WebGLShader vertexShader = getShader(
				WebGLRenderingContext.VERTEX_SHADER, EngineResources.INSTANCE
						.getVertexShader().getText());

		shaderProgram = glContext.createProgram();
		glContext.attachShader(shaderProgram, vertexShader);
		glContext.attachShader(shaderProgram, fragmentShader);
		glContext.linkProgram(shaderProgram);

		if (!glContext.getProgramParameterb(shaderProgram,
				WebGLRenderingContext.LINK_STATUS)) {
			throw new RuntimeException("Could not initialise shaders");
		}

		glContext.useProgram(shaderProgram);

		vertexPositionAttribute = glContext.getAttribLocation(shaderProgram,
				"vertexPosition");
		glContext.enableVertexAttribArray(vertexPositionAttribute);
	}

	private WebGLShader getShader(int type, String source) {
		WebGLShader shader = glContext.createShader(type);

		glContext.shaderSource(shader, source);
		glContext.compileShader(shader);

		if (!glContext.getShaderParameterb(shader,
				WebGLRenderingContext.COMPILE_STATUS)) {
			throw new RuntimeException(glContext.getShaderInfoLog(shader));
		}

		return shader;
	}

	private void initBuffers() {
		vertexBuffer = glContext.createBuffer();
		glContext.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, vertexBuffer);
		float[] vertices = new float[] { 0.0f, 1.0f, -5.0f, // first vertex
				-1.0f, -1.0f, -5.0f, // second vertex
				1.0f, -1.0f, -5.0f // third vertex
		};
		glContext.bufferData(WebGLRenderingContext.ARRAY_BUFFER,
				Float32Array.create(vertices),
				WebGLRenderingContext.STATIC_DRAW);
	}

	public abstract void drawScene();

	protected float[] createPerspectiveMatrix(int fieldOfViewVertical,
			float aspectRatio, float minimumClearance, float maximumClearance) {
		float top = minimumClearance
				* (float) Math.tan(fieldOfViewVertical * Math.PI / 360.0);
		float bottom = -top;
		float left = bottom * aspectRatio;
		float right = top * aspectRatio;

		float X = 2 * minimumClearance / (right - left);
		float Y = 2 * minimumClearance / (top - bottom);
		float A = (right + left) / (right - left);
		float B = (top + bottom) / (top - bottom);
		float C = -(maximumClearance + minimumClearance)
				/ (maximumClearance - minimumClearance);
		float D = -2 * maximumClearance * minimumClearance
				/ (maximumClearance - minimumClearance);

		return new float[] { X, 0.0f, A, 0.0f, 0.0f, Y, B, 0.0f, 0.0f, 0.0f, C,
				-1.0f, 0.0f, 0.0f, D, 0.0f };
	};
}
