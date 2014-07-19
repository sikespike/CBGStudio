/**
 * 
 */
package com.cbg.studio.client.widget.panel;

/**
 * @author vladimir.kavoun
 *
 */
public class StyledPanel extends AbstractStyledPanel {

    /* (non-Javadoc)
     * @see com.vfmlSupportApp.client.app.widget.panel.AbstractStyledPanel#addStyles()
     */
    @Override
    protected void addStyles() {
        this.addStyleName("styled-panel-wrapper");
        this.body.addStyleName("styled-panel-body width100");
        this.buttons.addStyleName("styled-panel-buttons width100");
    }

}
