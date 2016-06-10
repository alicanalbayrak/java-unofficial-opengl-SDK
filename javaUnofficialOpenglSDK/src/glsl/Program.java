/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glsl;

import static com.jogamp.opengl.GL2ES2.GL_FRAGMENT_SHADER;
import static com.jogamp.opengl.GL2ES2.GL_VERTEX_SHADER;
import com.jogamp.opengl.GL3;
import com.jogamp.opengl.util.glsl.ShaderCode;
import com.jogamp.opengl.util.glsl.ShaderProgram;

/**
 *
 * @author GBarbieri
 */
public class Program {

    public int name;

    public Program(GL3 gl3, String shadersRoot, String vertSrc, String fragSrc) {

        ShaderCode vertShader = ShaderCode.create(gl3, GL_VERTEX_SHADER, this.getClass(), shadersRoot, null, vertSrc,
                "vert", null, true);
        ShaderCode fragShader = ShaderCode.create(gl3, GL_FRAGMENT_SHADER, this.getClass(), shadersRoot, null, fragSrc,
                "frag", null, true);

        ShaderProgram shaderProgram = new ShaderProgram();

        shaderProgram.add(vertShader);

        shaderProgram.add(fragShader);

        shaderProgram.link(gl3, System.out);

        vertShader.destroy(gl3);

        fragShader.destroy(gl3);

        name = shaderProgram.program();
    }
}
