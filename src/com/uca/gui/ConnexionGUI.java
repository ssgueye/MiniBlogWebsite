package com.uca.gui;

import com.uca.core.ArticleCore;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

//Affiche la page de connexion
public class ConnexionGUI {

    public static String showConnexionForm() throws IOException, TemplateException {
        
        Configuration configuration = _FreeMarkerInitializer.getContext();


        Writer output = new StringWriter();
        Template template = configuration.getTemplate("articles/connexion.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(null, output);

        return output.toString();
    }

}
