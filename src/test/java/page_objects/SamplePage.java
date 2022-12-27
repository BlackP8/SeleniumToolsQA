package page_objects;

import framework.elements.Heading;
import framework.utilities.tab_util.TabUtil;
import framework.utilities.TextUtil;

import java.util.List;

/**
 * @author Pavel Romanov 27.12.2022
 */
public class SamplePage {
    private static Heading heading;
    private static final String NEW_TAB_TEXT_PATH = "//*[@id='sampleHeading']";

    public boolean checkPageText(List<String> data) {
        TabUtil.changeTab();
        heading = new Heading(NEW_TAB_TEXT_PATH);
        return TextUtil.checkTextContains(heading.getText(), TabUtil.getTabURL(), data) == data.size();
    }
}
