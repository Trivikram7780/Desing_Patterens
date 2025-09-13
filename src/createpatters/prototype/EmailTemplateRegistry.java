package createpatters.prototype;

import java.util.HashMap;
import java.util.Map;

public class EmailTemplateRegistry {

    private static final Map<String , EmailTemplate> templates = new HashMap<>();

    static{
        templates.put("welcome" , new WelcomeEmail());
    }

    public static EmailTemplate getTemplate(String type) {
        return templates.get(type).clone(); // clone to avoid modifying original
    }
}
