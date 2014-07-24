/**
 * 
 */
package com.cbg.studio.client.engine;

import com.cbg.studio.client.engine.util.math.Vector3f;
import com.cbg.studio.client.gwt.typedarrays.client.Float32Array;
import com.cbg.studio.client.gwtgl.binding.WebGLBuffer;
import com.cbg.studio.client.gwtgl.binding.WebGLProgram;
import com.cbg.studio.client.gwtgl.binding.WebGLRenderingContext;
import com.cbg.studio.client.gwtgl.binding.WebGLShader;
import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FlowPanel;

/**
 * @author Xif
 * 
 */
public abstract class AbstractGwtEngine extends FlowPanel {
    protected WebGLRenderingContext glContext;
    protected WebGLProgram shaderProgram;
    protected int vertexPositionAttribute;
    protected WebGLBuffer vertexBuffer;
    
    protected Camera camera;

    /**
     * Constructs a new instance of a GwtGL example with a launch button and a
     * Canvas to render on.
     */
    protected AbstractGwtEngine() {
        final Canvas webGLCanvas = Canvas.createIfSupported();
        webGLCanvas.setCoordinateSpaceWidth(640);
        webGLCanvas.setCoordinateSpaceHeight(480);
        webGLCanvas.setWidth("640px");
        webGLCanvas.setHeight("480px");
        glContext = (WebGLRenderingContext) webGLCanvas
                .getContext("experimental-webgl");
        if (glContext == null) {
            Window.alert("Sorry, Your Browser doesn't support WebGL!");
        }
        glContext.viewport(0, 0, 640, 480);
        
        initCamera();
        
        this.add(webGLCanvas);
        this.initialize();
    }

    private void initCamera(){
        this.camera = new Camera();
        
        Vector3f lookAt = new Vector3f(0.0f,0.0f,0.0f);
        Vector3f lookFrom = new Vector3f(0.0f,0.0f,5.0f);
        
        this.camera.setLookAt(lookAt);
        this.camera.setLookFrom(lookFrom);
    }
    
    public void initialize() {
        initShaders();
        glContext.clearColor(0.0f, 0.0f, 0.0f, 1.0f);
        glContext.clearDepth(1.0f);
        glContext.enable(WebGLRenderingContext.DEPTH_TEST);
        glContext.depthFunc(WebGLRenderingContext.LEQUAL);
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
        float[] vertices = this.getVerticies();
        Float32Array arr = Float32Array.create(vertices);
        glContext.bufferData(WebGLRenderingContext.ARRAY_BUFFER,
                arr,
                WebGLRenderingContext.STATIC_DRAW);
    }

    protected abstract float[] getVerticies();
    
    public void render(){
        this.initBuffers();
        this.drawScene();
    }
    
    protected abstract void drawScene();
}
