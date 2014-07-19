/**
 * 
 */
package com.cbg.studio.client.widget.panel;



/**
 * @author vladimir.kavoun
 * @since 0.1
 */
public class StyledFormPanel extends AbstractStyledFormPanel {
    @Override
    protected void addStyles(){
        this.addStyleName("styled-form-wrapper");
        this.body.addStyleName("styled-form-body width100");
        this.buttons.addStyleName("styled-form-buttons width100");
    }
    
    @Override
    public void setWidth(String width){
        String outerWidthString = width.replaceAll("px", "");
        int outerWidth = Integer.parseInt(outerWidthString);
        outerWidth += 10;
        
        super.setWidth(outerWidth+"px");
        this.wrapper.setWidth(width);
    }
}
