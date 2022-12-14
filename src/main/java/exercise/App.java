package exercise;

import exercise.servlet.WelcomeServlet;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

public class App {

    private static int getPort() {
        String port = System.getenv("PORT");
        if (port != null) {
            return Integer.parseInt(port);
        }
        return 8091;
    }

    public static Tomcat getApp(int port) throws LifecycleException {
        Tomcat app = new Tomcat();

        app.setBaseDir(System.getProperty("java.io.tmpdir"));
        app.setPort(port);

        //Context ctx = app.addContext("", new File(".").getAbsolutePath());

        Context ctx = app.addWebapp("", new File("src/main/webapp").getAbsolutePath());

        app.addServlet(ctx, WelcomeServlet.class.getSimpleName(), new WelcomeServlet());
        ctx.addServletMappingDecoded("", WelcomeServlet.class.getSimpleName());

        //// BEGIN
        //app.addServlet(ctx, "WelcomeServlet", new WelcomeServlet());
        //ctx.addServletMappingDecoded("/", "WelcomeServlet");
        //// END

        return app;
    }

    public static void main(String[] args) throws LifecycleException {
        Tomcat app = getApp(getPort());
        app.start();
        app.getServer().await();
    }
}
