/**
 * 
 */
package com.cbg.studio.server.rpc.impl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.cbg.studio.server.domain.CATModel;

/**
 * @author Siebe
 * 
 */
public class OpenFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /*
     * (non-Javadoc)
     * 
     * @see
     * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest
     * , javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest
     * , javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            List<FileItem> multiparts = new ServletFileUpload(
                    new DiskFileItemFactory()).parseRequest(req);

            for (FileItem item : multiparts) {
                if (!item.isFormField()) {
                    ObjectInputStream in = new ObjectInputStream(
                            item.getInputStream());

                    try {
                        CATModel model = (CATModel) in.readObject();
                        in.close();

                        this.getServletContext().setAttribute("model", model);

                        resp.setStatus(HttpServletResponse.SC_OK);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
