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

//Pour afficher le bouton commentaire et les autres boutons cachés
public class ArticleCommentGUI {

    public static String getAllArticles() throws IOException, TemplateException {

        Configuration configuration = _FreeMarkerInitializer.getContext();

        Map<String, Object> input = new HashMap<>();

        input.put("articles", ArticleCore.getAllArticles());
        

        Writer output = new StringWriter();
        Template template = configuration.getTemplate("articles/articelForConnected.ftl");
        template.setOutputEncoding("UTF-8");
        template.process(input, output);

        return output.toString();
    }
}
