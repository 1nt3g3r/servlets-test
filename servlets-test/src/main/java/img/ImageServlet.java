package img;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@WebServlet("/send-file")
public class ImageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String html = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Upload File</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<form method=\"post\" enctype=\"multipart/form-data\">\n" +
                "    <label for=\"fileToUpload\">Select file to upload:</label>\n" +
                "    <input type=\"file\" name=\"fileToUpload\" id=\"fileToUpload\">\n" +
                "    <br>\n" +
                "    <input type=\"submit\" value=\"Upload File\" name=\"submit\">\n" +
                "</form>\n" +
                "\n" +
                "</body>\n" +
                "</html>\n";


        resp.getWriter().write(html);

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Check if the request is multipart
        if (!ServletFileUpload.isMultipartContent(request)) {
            // Not a file upload request
            response.getWriter().println("Not a multipart request");
            return;
        }

        // Configure a repository (to ensure a secure temp location is used)
        File repository = (File) this.getServletContext().getAttribute("javax.servlet.context.tempdir");
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setRepository(repository);

        ServletFileUpload upload = new ServletFileUpload(factory);

        try {
            List<FileItem> items = upload.parseRequest(request);
            for (FileItem item : items) {
                if (item.isFormField()) {
                    // Process regular form fields here (non-file fields)
                    String fieldName = item.getFieldName();
                    String fieldValue = item.getString();
                    System.out.println(fieldName + ": " + fieldValue);
                } else {
                    // Process uploaded file
                    String fileName = item.getName();
                    if (fileName != null && !fileName.isEmpty()) {
                        File uploadedFile = new File("./images", new File(fileName).getName());
                        item.write(uploadedFile);
                        response.getWriter().println(uploadedFile.getAbsolutePath());
                    }
                }
            }
            response.getWriter().println("Upload success!");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Upload failed!");
        }
    }
}
