package com.automationcalling.sikuli;

import io.cucumber.datatable.DataTable;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import java.lang.reflect.Method;
import java.util.Map;

public class SikuliUtil {

    private Screen screen;
    private Pattern pattern;
    private String actionType = "Action";
    String className = "com.automationcalling.imageobjects.GoogleHomePage";
    String methodName;

    /**
     * Screen initalizaton
     */
    public SikuliUtil() {
        screen = new Screen();
    }


    /**
     * Instantiate Patern class with image so that it object available through this class
     *
     * @param imagePath supply image path
     * @return
     */
    public SikuliUtil initializeImage(String imagePath) {
        pattern = new Pattern(imagePath);
        return this;
    }

    /**
     * Image is exist or not
     *
     * @param waitTime supply waitTime
     * @return
     */
    public Boolean verifyImageExist(double waitTime) {
        boolean flag = false;
        if (screen.exists(pattern, waitTime) != null) {
            flag = true;
        }
        return flag;
    }

    /**
     * Screenwait for Imageload or sychnroization of your application loaded
     *
     * @param waitTime
     * @return
     */
    public SikuliUtil screenWait(double waitTime) {
        screen.wait(waitTime);
        return this;
    }

    /**
     * Enter text on the image
     *
     * @param text
     * @return
     * @throws FindFailed
     */
    public SikuliUtil enterText(String text) throws FindFailed {
        screen.type(pattern, text);
        return this;
    }

    /**
     * Click on the image
     *
     * @return
     * @throws FindFailed
     */
    public SikuliUtil clickAction() throws FindFailed {
        screen.click(pattern);
        return this;
    }

    /**
     * Double click on the  image
     *
     * @return
     * @throws FindFailed
     */
    public SikuliUtil doubleClickAction() throws FindFailed {
        screen.doubleClick(pattern);
        return this;
    }

    /**
     * Execute action using Datadriven approach
     * use method name for first column and its value for second column
     *
     * @param tableFields
     */
    public void sikuliOperation(DataTable tableFields) {
        try {
            for (Map<String, String> data : tableFields.asMaps()) {
                switch (data.get("MethodName")) {
                    case "initializeImage":
                        String[] name = data.get(actionType).split("\\.");
                        Class<?> imageclass = Class.forName("com.automationcalling.imageobjects." + name[0]); // convert string classname to class
                        Object imagehomepage = imageclass.newInstance();
                        methodName = name[1];
                        Method elementImage = imagehomepage.getClass().getMethod(methodName);
                        initializeImage((String) elementImage.invoke(imagehomepage));
                        break;
                    case "verifyImageExist":
                        verifyImageExist(Double.parseDouble(data.get(actionType)));
                        break;

                    case "enterText":
                        enterText(data.get(actionType));
                        break;

                    case "clickAction":
                        clickAction();
                        break;

                    case "doubleClickAction":
                        doubleClickAction();
                        break;
                    default:
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
